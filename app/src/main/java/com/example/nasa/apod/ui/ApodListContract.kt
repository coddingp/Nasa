package com.example.nasa.apod.ui

import com.example.nasa.apod.model.ApodListOfAllData
import com.example.nasa.common.mvp.BaseFragmentContract
import com.example.nasa.common.mvp.MvpPresenter
import com.example.nasa.common.mvp.MvpView

interface ApodListContract : BaseFragmentContract {
    interface View : MvpView {
        fun showApodListData(apodData: List<ApodListOfAllData.ApodAllData>)
    }

    interface Presenter : MvpPresenter<View> {
        fun getApodListData()
    }
}