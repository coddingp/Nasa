package com.example.nasa.rover.ui

import com.example.nasa.common.mvp.BasePresenter
import com.example.nasa.rover.interactor.RoverInteractor
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import timber.log.Timber

class RoverPresenter(
    private val interactor: RoverInteractor
) : BasePresenter<RoverContract.View>(),
    RoverContract.Presenter {

    private val presenterScope = CoroutineScope(Dispatchers.Main.immediate)

    override fun getRoverPhotoList() {
        presenterScope.launch {
            try {
                val photos = interactor.getRoverData()
                Timber.tag("%%%").i("data:  $photos")
                view?.showRoverPhotosList(photos)
            } catch (t: Throwable) {
                Timber.e("Error no games data -> ${t.message}")
            }
        }
    }
}