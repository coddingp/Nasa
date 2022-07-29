package com.example.nasa.search.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

sealed class SearchData : Parcelable {
    @Parcelize
    data class SearchParsed(
        val subParsed: SubParsed?,
        val reasonParsed: String?
    ) : SearchData()

    @Parcelize
    data class SubParsed(
        val version: String?,
        val href: String?,
        val items: List<ItemParsed>?,
        val metadataParsed: MetadataParsed?,
        val linksParsed: List<LinksParsed>?,
    ) : SearchData()

    @Parcelize
    data class MetadataParsed(
        val total_hits: Int?
    ) : SearchData()

    @Parcelize
    data class LinksParsed(
        val href: String?,
        val prompt: String?,
        val rel: String?
    ) : SearchData()

    @Parcelize
    data class LinkParsed(
        val href: String?,
        val rel: String?,
        val render: String?
    ) : SearchData()

    @Parcelize
    data class ItemParsed(
        val href: String?,
        val data: List<DataParsed>?,
        val link: List<LinkParsed>?
    ) : SearchData()

    @Parcelize
    data class DataParsed(
        val album: List<String>?,
        val center: String?,
        val dateCreated: String?,
        val description: String?,
        val description508: String?,
        val keywords: List<String>?,
        val location: String?,
        val mediaType: String?,
        val nasaId: String?,
        val photographer: String?,
        val secondaryCreator: String?,
        val title: String?
    ) : SearchData()

}
