package com.example.nasa.main.di

import androidx.room.Room
import com.example.nasa.main.db.database.AppDataBase
import com.example.nasa.main.interactor.MainInteractor
import com.example.nasa.main.repository.MainLocalRepository
import com.example.nasa.main.repository.MainRemoteRepository
import com.example.nasa.main.ui.MainContract
import com.example.nasa.main.ui.MainPresenter
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

object MainModule {
    fun create() = module {

        single { get<AppDataBase>().mainDao() }

        singleOf(::MainLocalRepository)

        single { MainRemoteRepository(get()) }

        singleOf(::MainPresenter) bind MainContract.Presenter::class

        factoryOf(::MainInteractor) bind MainInteractor::class

        single {
            Room.databaseBuilder(
                get(),
                AppDataBase::class.java, "main_data"
            ).build()
        }
    }
}