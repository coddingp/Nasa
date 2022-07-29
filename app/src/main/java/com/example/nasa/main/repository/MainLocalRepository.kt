package com.example.nasa.main.repository

import com.example.nasa.main.db.dao.MainDataDao
import com.example.nasa.main.db.model.MainEntityConverter
import com.example.nasa.main.model.ApodData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import timber.log.Timber

class MainLocalRepository(
    private val dao: MainDataDao
    ) : LocalRepository {
    override suspend fun getDataFromDb(): Flow<ApodData> {
        val data = dao.getAllData()
        return data.map { MainEntityConverter.fromDataBase(it) }
    }

    override suspend fun insertAllDataToDb(list: ApodData) {
        val data = MainEntityConverter.toDataBase(list)
        dao.insertAllData(data)
    }

    override suspend fun deleteData() {
        dao.deleteData()
    }

}