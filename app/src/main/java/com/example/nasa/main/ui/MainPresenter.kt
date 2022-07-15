package com.example.nasa.main.ui

import com.example.nasa.common.mvp.BasePresenter
import com.example.nasa.main.interactor.MainInteractor
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import timber.log.Timber

class MainPresenter(
    private val interactor: MainInteractor
) : BasePresenter<MainContract.View>(),
    MainContract.Presenter {

    private val presenterScope = CoroutineScope(Dispatchers.Main.immediate)

    override fun getApodData() {
        presenterScope.launch {
            try {
                val apodData = interactor.getApodData()
                Timber.tag("$$$").i("data:  $apodData")
                view?.showApodData(apodData)
            } catch (t: Throwable) {
                Timber.e("Error no games data -> ${t.message}")
            }
        }
    }
}