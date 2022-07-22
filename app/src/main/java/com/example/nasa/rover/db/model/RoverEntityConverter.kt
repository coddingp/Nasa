package com.example.nasa.rover.db.model

//import com.example.nasa.rover.model.RoverData
//
//object RoverEntityConverter {
//    fun toDataBase(response: RoverData.Curiosity) =
//        CuriosityEntityData(
//            curiosityPhotos = toDataBase(response.curiosityPhotos)
//        )
//
//    private fun toDataBase(response: List<RoverData.CuriosityPhoto>): List<CuriosityPhotoEntityData> =
//        response.map { photo ->
//            CuriosityPhotoEntityData(
//                id = photo.id,
//                sol = photo.sol,
//                camera = toDataBase(photo.camera),
//                imgSrc = photo.imgSrc,
//                earthDate = photo.earthDate,
//                rover = toDataBase(photo.rover)
//            )
//        }
//
//    private fun toDataBase(response: RoverData.CuriosityCamera): CuriosityCameraEntityData =
//        CuriosityCameraEntityData(
//            id = response.id,
//            name = response.name,
//            roverId = response.roverId,
//            fullName = response.fullName
//        )
//
//    private fun toDataBase(response: RoverData.Rover): RoverEntityData =
//        RoverEntityData(
//            id = response.id,
//            name = response.name,
//            landingDate = response.landingDate,
//            launchDate = response.launchDate,
//            status = response.status
//        )
//
//
//    fun fromDataBase(response: List<CuriosityPhotoEntityData>): List<RoverData.CuriosityPhoto> {
//        val data =
//            response.map { photo ->
//                RoverData.CuriosityPhoto(
//                    id = photo.id,
//                    sol = photo.sol,
//                    camera = fromDataBase(photo.camera),
//                    imgSrc = photo.imgSrc,
//                    earthDate = photo.earthDate,
//                    rover = fromDataBase(photo.rover)
//                )
//            }
//        return data
//    }
//
//    private fun fromDataBase(response: CuriosityCameraEntityData): RoverData.CuriosityCamera =
//        RoverData.CuriosityCamera(
//            id = response.id,
//            name = response.name,
//            roverId = response.roverId,
//            fullName = response.fullName
//        )
//
//    private fun fromDataBase(response: RoverEntityData): RoverData.Rover =
//        RoverData.Rover(
//            id = response.id,
//            name = response.name,
//            landingDate = response.landingDate,
//            launchDate = response.launchDate,
//            status = response.status
//        )
//
//}



