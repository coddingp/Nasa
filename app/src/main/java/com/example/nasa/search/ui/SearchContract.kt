package com.example.nasa.search.ui

import com.example.nasa.common.mvp.BaseFragmentContract
import com.example.nasa.common.mvp.MvpPresenter
import com.example.nasa.common.mvp.MvpView
import com.example.nasa.search.model.SearchData

interface SearchContract : BaseFragmentContract {
    interface View : MvpView {
        fun showSearchData(data: List<SearchData.ItemParsed>?)
    }

    interface Presenter : MvpPresenter<View> {
        fun getSearchData()
    }
}