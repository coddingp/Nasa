package com.example.nasa.search.di

import com.example.nasa.search.interactor.SearchInteractor
import com.example.nasa.search.repository.SearchRemoteRepository
import com.example.nasa.search.ui.SearchContract
import com.example.nasa.search.ui.SearchPresenter
import org.koin.dsl.bind
import org.koin.dsl.module

object SearchModule {
    fun create() = module {
        single { SearchPresenter(get()) } bind SearchContract.Presenter::class
        factory {
            SearchInteractor(get())
        } bind SearchInteractor::class
        single { SearchRemoteRepository(get()) }
    }
}