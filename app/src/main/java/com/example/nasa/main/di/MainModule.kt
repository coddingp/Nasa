package com.example.nasa.main.di

import com.example.nasa.main.interactor.MainInteractor
import com.example.nasa.main.repository.MainRemoteRepository
import com.example.nasa.main.ui.MainContract
import com.example.nasa.main.ui.MainPresenter
import org.koin.dsl.bind
import org.koin.dsl.module

object MainModule {
    fun create() = module {
        single { MainPresenter(get()) } bind MainContract.Presenter::class
        factory {
            MainInteractor(get())
        } bind MainInteractor::class
        single { MainRemoteRepository(get()) }
    }
}