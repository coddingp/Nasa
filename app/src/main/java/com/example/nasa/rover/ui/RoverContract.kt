package com.example.nasa.rover.ui

import com.example.nasa.common.mvp.BaseFragmentContract
import com.example.nasa.common.mvp.MvpPresenter
import com.example.nasa.common.mvp.MvpView
import com.example.nasa.rover.model.RoverData

interface RoverContract : BaseFragmentContract {
    interface View : MvpView {
        fun showRefreshing(isRefreshing: Boolean)
        fun showRoverPhotosList(data: List<RoverData.CuriosityPhoto>)
        fun failure(t: Throwable)
    }

    interface Presenter : MvpPresenter<View> {
        fun refresh()
        fun insertRoverDataToDb(page: Int)
        fun collectFlowPhotoList()
        fun deleteData()
    }
}