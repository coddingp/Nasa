package com.example.nasa.search.api.model.search

import com.google.gson.annotations.SerializedName

data class DataResponse(
    @SerializedName("album")
    val albumResponse: List<String>?,
    @SerializedName("center")
    val centerResponse: String?,
    @SerializedName("date_created")
    val dateCreatedResponse: String?,
    @SerializedName("description")
    val descriptionResponse: String?,
    @SerializedName("description_508")
    val description508Response: String?,
    @SerializedName("keywords")
    val keywordsResponse: List<String>?,
    @SerializedName("location")
    val locationResponse: String?,
    @SerializedName("media_type")
    val mediaTypeResponse: String?,
    @SerializedName("nasa_id")
    val nasaIdResponse: String?,
    @SerializedName("photographer")
    val photographerResponse: String?,
    @SerializedName("secondary_creator")
    val secondaryCreatorResponse: String?,
    @SerializedName("title")
    val titleResponse: String?
)
