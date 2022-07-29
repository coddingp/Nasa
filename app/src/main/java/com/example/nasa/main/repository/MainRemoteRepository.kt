package com.example.nasa.main.repository

import com.example.nasa.main.api.NasaApi
import com.example.nasa.main.db.dao.MainDataDao
import com.example.nasa.main.model.ApodConverter
import com.example.nasa.main.model.ApodData
import com.example.nasa.utils.Utils.API_KEY
import timber.log.Timber

class MainRemoteRepository(
    private val api: NasaApi
) : MainRepository {

    override suspend fun getApodData(): ApodData {
        val apodData = api.getApodData(API_KEY)
        return ApodConverter.fromNetWork(apodData)
    }
}