package com.example.nasa.apod.repository

import com.example.nasa.apod.db.dao.ApodDataDao
import com.example.nasa.apod.db.model.ApodEntityConverter
import com.example.nasa.apod.model.ApodListOfAllData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ApodMainLocalRepository(val dao: ApodDataDao) : ApodLocalRepository {
    override suspend fun getApodDataFromDb():
            Flow<List<ApodListOfAllData.ApodAllData>> {
        val data = dao.getApodData()
        return data.map { ApodEntityConverter.fromDataBase(it) }
    }

    override suspend fun insertApodDataToDb(list: List<ApodListOfAllData.ApodAllData>) {
        val data = ApodEntityConverter.toDataBase(list)
        dao.insertApodData(data)
    }
}