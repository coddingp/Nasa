package com.example.nasa.rover.ui

import com.example.nasa.common.mvp.BasePresenter
import com.example.nasa.rover.interactor.RoverInteractor
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import timber.log.Timber

class RoverPresenter(
    private val interactor: RoverInteractor
) : BasePresenter<RoverContract.View>(),
    RoverContract.Presenter {

    private val presenterScope = CoroutineScope(Dispatchers.Main.immediate + SupervisorJob())
    private val defaultScope = CoroutineScope(Dispatchers.IO + SupervisorJob())

    override fun refresh() {
        presenterScope.launch {
            try {
                view?.showRefreshing(isRefreshing = true)
                insertRoverDataToDb(1)
                collectFlowPhotoList()
            } catch (e: Exception) {
                view?.failure(e)
            } finally {
                view?.showRefreshing(isRefreshing = false)
            }
        }
    }

    override fun insertRoverDataToDb(page:Int) {
        defaultScope.launch {
            try {
                interactor.insertRoverDataToDb(page)
            } catch (t: Throwable) {
                Timber.e("Error no games data -> ${t.message}")
            }
        }
    }

    override fun collectFlowPhotoList() {
        presenterScope.launch {
            interactor.getRoverDataFromDb().collect {
                view?.showRoverPhotosList(it)
            }
        }
    }

    override fun deleteData() {
        defaultScope.launch {
            interactor.deleteRoverData()
        }
    }
}