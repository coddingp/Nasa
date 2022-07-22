package com.example.nasa.apod.di

import androidx.room.Room
import com.example.nasa.apod.db.database.ApodDataBase
import com.example.nasa.apod.interactor.ApodListInteractor
import com.example.nasa.apod.repository.ApodListRemoteRepository
import com.example.nasa.apod.repository.ApodLocalRepository
import com.example.nasa.apod.repository.ApodMainLocalRepository
import com.example.nasa.apod.ui.ApodListContract
import com.example.nasa.apod.ui.ApodListPresenter
import org.koin.dsl.bind
import org.koin.dsl.module

object ApodListModule {
    fun create() = module {
        single {
            Room.databaseBuilder(get(), ApodDataBase::class.java, "apod_data")
                .build()
        }

        single { get<ApodDataBase>().apodDao() }

        single { ApodListPresenter(get()) } bind ApodListContract.Presenter::class

        single<ApodLocalRepository> { ApodMainLocalRepository(get()) }

        factory {
            ApodListInteractor(get())
        } bind ApodListInteractor::class

        single { ApodListRemoteRepository(get()) }
    }
}