package com.example.nasa

import android.app.Application
import com.example.nasa.apod.di.ApodListModule
import com.example.nasa.common.di.CommonModule
import com.example.nasa.main.di.MainModule
import com.example.nasa.rover.di.RoverModule
import com.example.nasa.search.di.SearchModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        setupKoin()
    }

    private fun setupKoin() {
        startKoin {
            androidContext(this@App)
            modules(
                CommonModule.createMainRetrofit(),
                CommonModule.createRoverRetrofit(),
                CommonModule.createApodListRetrofit(),
                CommonModule.createSearchRetrofit(),
                MainModule.create(),
                ApodListModule.create(),
                SearchModule.create(),
                RoverModule.create()
            )
        }
    }
}