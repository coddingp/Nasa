package com.example.nasa.rover.ui

import com.example.nasa.common.mvp.BaseFragmentContract
import com.example.nasa.common.mvp.MvpPresenter
import com.example.nasa.common.mvp.MvpView
import com.example.nasa.rover.model.RoverData

interface RoverContract : BaseFragmentContract {
    interface View : MvpView {
        fun showRoverPhotosList(data: List<RoverData.CuriosityPhoto>)
    }

    interface Presenter : MvpPresenter<View> {
        fun getRoverPhotoList()
    }
}