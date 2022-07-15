package com.example.nasa.apod.repository

import com.example.nasa.apod.api.ApodListApi
import com.example.nasa.apod.model.ApodListConverter
import com.example.nasa.apod.model.ApodListOfAllData
import com.example.nasa.utils.Utils.API_KEY
import com.example.nasa.utils.Utils.endDate
import com.example.nasa.utils.Utils.startDate

class ApodListRemoteRepository(
    private val apodApi: ApodListApi
) : ApodListRepository {
    override suspend fun getApodListData(): List<ApodListOfAllData.ApodAllData> {
        val apodListData = apodApi.getApodListData(startDate, endDate, API_KEY)
        return ApodListConverter.fromNetWork(apodListData)
    }
}