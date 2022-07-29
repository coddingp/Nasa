package com.example.nasa.main.ui

import com.example.nasa.common.mvp.BaseFragmentContract
import com.example.nasa.common.mvp.MvpPresenter
import com.example.nasa.common.mvp.MvpView
import com.example.nasa.main.model.ApodData

interface MainContract : BaseFragmentContract {
    interface View : MvpView {
        fun showRefreshing(isRefreshing: Boolean)
        fun showApodData(apodData: ApodData)
        fun failure(t: Throwable)
    }

    interface Presenter : MvpPresenter<View> {
        fun refresh()
        fun insertApodData()
        fun collectFlowApodData()
        fun deleteData()
    }
}