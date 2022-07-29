package com.example.nasa.rover.repository

import com.example.nasa.rover.db.dao.RoverDataDao
import com.example.nasa.rover.db.model.RoverEntityConverter
import com.example.nasa.rover.model.RoverData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import timber.log.Timber

class MainRoverLocalRepository(
    private val dao: RoverDataDao
) : RoverLocalRepository {
    override suspend fun getRoverDataFromDb(): Flow<List<RoverData.CuriosityPhoto>> {
        val data = dao.getRoverDataFromDb()
        Timber.i("MainRoverLocalRepository getRoverDataFromDb $data")
        return data.map { RoverEntityConverter.fromDataBase(it) }
    }

    override suspend fun insertRoverDataToDb(list: List<RoverData.CuriosityPhoto>) {
        val data = RoverEntityConverter.toDataBase(list)
        Timber.i("MainRoverLocalRepository insertRoverDataToDb $data")
        dao.insertRoverData(data)
    }

    override suspend fun deleteRoverData() {
        dao.deleteRoverData()
    }
}