package com.example.nasa.search.ui

import com.example.nasa.common.mvp.BaseFragmentContract
import com.example.nasa.common.mvp.MvpPresenter
import com.example.nasa.common.mvp.MvpView
import com.example.nasa.rover.model.RoverData
import com.example.nasa.search.model.SearchData

interface SearchContract : BaseFragmentContract {
    interface View : MvpView {
        fun showRefreshing(isRefreshing: Boolean)
        fun showSearchData(data: List<SearchData.ItemParsed>?)
        fun failure(t: Throwable)
    }

    interface Presenter : MvpPresenter<View> {
        fun refresh()
        fun getSearchData(page: Int)
    }
}