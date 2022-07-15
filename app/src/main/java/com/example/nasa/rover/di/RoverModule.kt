package com.example.nasa.rover.di

import com.example.nasa.rover.interactor.RoverInteractor
import com.example.nasa.rover.repository.RoverRemoteRepository
import com.example.nasa.rover.ui.RoverContract
import com.example.nasa.rover.ui.RoverPresenter
import org.koin.dsl.bind
import org.koin.dsl.module

object RoverModule {
    fun create() = module {
        single { RoverPresenter(get()) } bind RoverContract.Presenter::class
        factory {
            RoverInteractor(get())
        } bind RoverInteractor::class
        single { RoverRemoteRepository(get()) }
    }
}