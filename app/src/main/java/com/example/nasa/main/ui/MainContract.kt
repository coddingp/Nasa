package com.example.nasa.main.ui

import com.example.nasa.common.mvp.BaseFragmentContract
import com.example.nasa.common.mvp.MvpPresenter
import com.example.nasa.common.mvp.MvpView
import com.example.nasa.main.model.ApodData

interface MainContract : BaseFragmentContract {
    interface View : MvpView {
        fun showApodData(apodData: ApodData)
    }

    interface Presenter : MvpPresenter<View> {
        fun getApodData()
    }
}