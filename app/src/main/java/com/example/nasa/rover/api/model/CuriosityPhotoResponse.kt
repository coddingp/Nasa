package com.example.nasa.rover.api.model

import com.google.gson.annotations.SerializedName

data class CuriosityPhotoResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("sol")
    val sol: Int,
    @SerializedName("camera")
    val camera: CuriosityCameraResponse,
    @SerializedName("img_src")
    val imgSrc: String,
    @SerializedName("earth_date")
    val earthDate: String,
    @SerializedName("rover")
    val rover: RoverResponse
)
