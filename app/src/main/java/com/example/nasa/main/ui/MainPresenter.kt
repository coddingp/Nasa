package com.example.nasa.main.ui

import com.example.nasa.common.mvp.BasePresenter
import com.example.nasa.main.interactor.MainInteractor
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import timber.log.Timber

class MainPresenter(
    private val interactor: MainInteractor
) : BasePresenter<MainContract.View>(),
    MainContract.Presenter {

    private val presenterScope = CoroutineScope(Dispatchers.Main.immediate)
    private val defaultScope = CoroutineScope(Dispatchers.Default)

    override fun refresh() {
        presenterScope.launch {
            try {
                view?.showRefreshing(isRefreshing = true)
                getApodData()
                collectFlowApodData()
            } catch (e: Exception) {
                view?.failure(e)
            } finally {
                view?.showRefreshing(isRefreshing = false)
            }
        }
    }

    override fun getApodData() {
        presenterScope.launch {
            try {
                interactor.insertApodDataToDb()
            } catch (t: Throwable) {
                Timber.e("Error no games data -> ${t.message}")
            }
        }
    }

    override fun collectFlowApodData() {
        presenterScope.launch {
            interactor.getApodDataFromDb().collect {
                view?.showApodData(it)
            }
        }
    }
}