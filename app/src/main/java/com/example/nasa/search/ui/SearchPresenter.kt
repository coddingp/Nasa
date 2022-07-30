package com.example.nasa.search.ui

import com.example.nasa.common.mvp.BasePresenter
import com.example.nasa.search.interactor.SearchInteractor
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import timber.log.Timber

class SearchPresenter(
    private val interactor: SearchInteractor
) : BasePresenter<SearchContract.View>(),
    SearchContract.Presenter {

    private val presenterScope = CoroutineScope(Dispatchers.Main.immediate + SupervisorJob())

    override fun refresh() {
        presenterScope.launch {
            try {
                view?.showRefreshing(isRefreshing = true)
                getSearchData(1)
            } catch (e: Exception) {
                view?.failure(e)
            } finally {
                view?.showRefreshing(isRefreshing = false)
            }
        }
    }

    override fun getSearchData(page: Int) {
        presenterScope.launch {
            try {
                val data = interactor.getSearchData(page)
                Timber.tag("$$$").i("data:  $data")
                view?.showSearchData(data)
            } catch (t: Throwable) {
                Timber.e("Error no games data -> ${t.message}")
            }
        }
    }
}