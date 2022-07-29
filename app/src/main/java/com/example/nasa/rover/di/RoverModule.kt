package com.example.nasa.rover.di

import androidx.room.Room
import com.example.nasa.rover.db.database.RoverDataBase
import com.example.nasa.rover.interactor.RoverInteractor
import com.example.nasa.rover.repository.MainRoverLocalRepository
import com.example.nasa.rover.repository.RoverRemoteRepository
import com.example.nasa.rover.ui.RoverContract
import com.example.nasa.rover.ui.RoverPresenter
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

object RoverModule {
    fun create() = module {

        single { get<RoverDataBase>().roverDao() }

        singleOf(::MainRoverLocalRepository)

        singleOf(::RoverRemoteRepository)

        single { RoverPresenter(get()) } bind RoverContract.Presenter::class

        factory {
            RoverInteractor(get(), get())
        } bind RoverInteractor::class

        single {
            Room.databaseBuilder(get(), RoverDataBase::class.java, "rover_data")
                .build()
        }
    }
}