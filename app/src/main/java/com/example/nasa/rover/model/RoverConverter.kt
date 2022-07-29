package com.example.nasa.rover.model

import com.example.nasa.rover.api.model.CuriosityCameraResponse
import com.example.nasa.rover.api.model.CuriosityResponse
import com.example.nasa.rover.api.model.RoverResponse

object RoverConverter {

    fun fromNetWork(response: CuriosityResponse): List<RoverData.CuriosityPhoto> =
        response.curiosityPhotos.map { photo ->
            RoverData.CuriosityPhoto(
                id = photo.id,
                sol = photo.sol,
                camera = fromNetWork(photo.camera),
                imgSrc = photo.imgSrc,
                earthDate = photo.earthDate,
                rover = fromNetWork(photo.rover)
            )
        }

    private fun fromNetWork(response: CuriosityCameraResponse): RoverData.CuriosityCamera =
        RoverData.CuriosityCamera(
            id = response.id,
            name = response.name,
            roverId = response.roverId,
            fullName = response.fullName
        )

    private fun fromNetWork(response: RoverResponse): RoverData.Rover =
        RoverData.Rover(
            id = response.id,
            name = response.name,
            landingDate = response.landingDate,
            launchDate = response.launchDate,
            status = response.status
        )
}