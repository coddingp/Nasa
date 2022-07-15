package com.example.nasa.search.api.model.search

import com.google.gson.annotations.SerializedName

data class ItemResponse(
    @SerializedName("href")
    val hrefResponse: String?,
    @SerializedName("data")
    val dataResponse: List<DataResponse>?,
    @SerializedName("links")
    val linkResponse: List<LinkResponse>?
)
