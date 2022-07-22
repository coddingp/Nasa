package com.example.nasa.rover.repository

//import com.example.nasa.rover.db.dao.RoverDataDao
//import com.example.nasa.rover.db.model.RoverEntityConverter
//import com.example.nasa.rover.model.RoverData
//import kotlinx.coroutines.flow.Flow
//import kotlinx.coroutines.flow.map
//
//class MainRoverLocalRepository(val dao: RoverDataDao) : RoverLocalRepository {
//    override suspend fun getRoverDataFromDb():
//            Flow<List<RoverData.CuriosityPhoto>> {
//        val data = dao.getRoverDataFromDb()
//        return data.map { RoverEntityConverter.fromDataBase(it) }
//    }
//
//    override suspend fun insertRoverDataToDb(list: RoverData.Curiosity) {
//        val data = RoverEntityConverter.toDataBase(list)
//        dao.insertRoverData(data)
//    }
//}