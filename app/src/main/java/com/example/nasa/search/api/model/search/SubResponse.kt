package com.example.nasa.search.api.model.search

import com.google.gson.annotations.SerializedName

data class SubResponse(
    @SerializedName("version")
    val versionResponse: String?,
    @SerializedName("href")
    val hrefResponse: String?,
    @SerializedName("items")
    val itemsResponse: List<ItemResponse>?,
    @SerializedName("metadata")
    val metadataResponse: MetadataResponse?,
    @SerializedName("links")
    val linksResponse: List<LinksResponse>?,
)
