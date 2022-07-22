package com.example.nasa.rover.di

import androidx.room.Room
//import com.example.nasa.rover.db.database.RoverDataBase
import com.example.nasa.rover.interactor.RoverInteractor
//import com.example.nasa.rover.repository.MainRoverLocalRepository
//import com.example.nasa.rover.repository.RoverLocalRepository
import com.example.nasa.rover.repository.RoverRemoteRepository
import com.example.nasa.rover.ui.RoverContract
import com.example.nasa.rover.ui.RoverPresenter
import org.koin.dsl.bind
import org.koin.dsl.module

object RoverModule {
    fun create() = module {
//        single {
//            Room.databaseBuilder(get(), RoverDataBase::class.java, "rover_data")
//                .build()
//        }

        single { RoverPresenter(get()) } bind RoverContract.Presenter::class

//        single { get<RoverDataBase>().roverDao() }

//        single<RoverLocalRepository> { MainRoverLocalRepository(get()) }

        factory {
            RoverInteractor(get())
        } bind RoverInteractor::class

        single { RoverRemoteRepository(get()) }
    }
}