package com.example.nasa.apod.di

import com.example.nasa.apod.interactor.ApodListInteractor
import com.example.nasa.apod.repository.ApodListRemoteRepository
import com.example.nasa.apod.ui.ApodListContract
import com.example.nasa.apod.ui.ApodListPresenter
import org.koin.dsl.bind
import org.koin.dsl.module

object ApodListModule {
    fun create() = module {
        single { ApodListPresenter(get()) } bind ApodListContract.Presenter::class
        factory {
            ApodListInteractor(get())
        } bind ApodListInteractor::class
        single { ApodListRemoteRepository(get()) }
    }
}