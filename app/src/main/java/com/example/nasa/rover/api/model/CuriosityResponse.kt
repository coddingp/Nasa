package com.example.nasa.rover.api.model

import com.google.gson.annotations.SerializedName

data class CuriosityResponse(
@SerializedName("photos")
    val curiosityPhotos: List<CuriosityPhotoResponse>
)
