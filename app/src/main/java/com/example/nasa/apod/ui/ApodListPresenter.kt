package com.example.nasa.apod.ui

import com.example.nasa.apod.interactor.ApodListInteractor
import com.example.nasa.common.mvp.BasePresenter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import timber.log.Timber

class ApodListPresenter(
    private val interactor: ApodListInteractor
) : BasePresenter<ApodListContract.View>(),
    ApodListContract.Presenter {

    private val presenterScope = CoroutineScope(Dispatchers.Main.immediate)

    override fun getApodListData() {
        presenterScope.launch {
            try {
                val apodAllData = interactor.getApodListData()
                Timber.tag("$$$").i("data:  $apodAllData")
                view?.showApodListData(apodAllData)
            } catch (t: Throwable) {
                Timber.e("Error no games data -> ${t.message}")
            }
        }
    }
}