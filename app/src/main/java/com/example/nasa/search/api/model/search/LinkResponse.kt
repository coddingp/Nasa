package com.example.nasa.search.api.model.search

import com.google.gson.annotations.SerializedName

data class LinkResponse(
    @SerializedName("href")
    val hrefResponse: String?,
    @SerializedName("rel")
    val relResponse: String?,
    @SerializedName("render")
    val renderResponse: String?
)
