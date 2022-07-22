package com.example.nasa.rover.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

sealed class RoverData : Parcelable {
    @Parcelize
    data class Curiosity(
        val curiosityPhotos: List<CuriosityPhoto>
    ) : RoverData()

    @Parcelize
    data class CuriosityPhoto(
        val id: Int,
        val sol: Int,
        val camera: CuriosityCamera,
        val imgSrc: String,
        val earthDate: String,
        val rover: Rover
    ) : RoverData()

    @Parcelize
    data class CuriosityCamera(
        val id: Int,
        val name: String,
        val roverId: Int,
        val fullName: String
    ) : RoverData()

    @Parcelize
    data class Rover(
        val id: Int,
        val name: String,
        val landingDate: String,
        val launchDate: String,
        val status: String
    ) : RoverData()

}
