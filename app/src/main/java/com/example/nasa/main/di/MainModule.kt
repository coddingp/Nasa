package com.example.nasa.main.di

import androidx.room.Room
import com.example.nasa.main.db.database.AppDataBase
import com.example.nasa.main.interactor.MainInteractor
import com.example.nasa.main.repository.LocalRepository
import com.example.nasa.main.repository.MainLocalRepository
import com.example.nasa.main.repository.MainRemoteRepository
import com.example.nasa.main.ui.MainContract
import com.example.nasa.main.ui.MainPresenter
import org.koin.dsl.bind
import org.koin.dsl.module

object MainModule {
    fun create() = module {
        single {
            Room.databaseBuilder(get(), AppDataBase::class.java, "main_data")
                .build()
        }

        single { MainPresenter(get()) } bind MainContract.Presenter::class

        single { get<AppDataBase>().mainDao() }

        single<LocalRepository> { MainLocalRepository(get()) }

        factory {
            MainInteractor(get())
        } bind MainInteractor::class

        single { MainRemoteRepository(get()) }
    }
}