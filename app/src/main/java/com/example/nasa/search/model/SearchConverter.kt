package com.example.nasa.search.model


import com.example.nasa.search.api.model.search.DataResponse
import com.example.nasa.search.api.model.search.LinkResponse
import com.example.nasa.search.api.model.search.SearchResponse

object SearchConverter {

    fun fromNetWork(response: SearchResponse) =
        response.collection?.itemsResponse?.map { item ->
            SearchData.ItemParsed(
                href = item?.hrefResponse,
                link = fromNetWorkLink(item?.linkResponse),
                data = fromNetWorkData(item?.dataResponse)
            )
        }

    private fun fromNetWorkLink(response: List<LinkResponse>?): List<SearchData.LinkParsed>? {
        return response?.map { link ->
            SearchData.LinkParsed(
                href = link?.hrefResponse,
                rel = link?.relResponse,
                render = link?.renderResponse
            )
        }
    }

    private fun fromNetWorkData(response: List<DataResponse>?): List<SearchData.DataParsed>? {
        return response?.map { data ->
            SearchData.DataParsed(
                album = data.albumResponse,
                center = data.centerResponse,
                dateCreated = data.dateCreatedResponse,
                description = data.descriptionResponse,
                description508 = data.description508Response,
                keywords = data.keywordsResponse,
                location = data.locationResponse,
                mediaType = data.mediaTypeResponse,
                nasaId = data.nasaIdResponse,
                photographer = data.photographerResponse,
                secondaryCreator = data.secondaryCreatorResponse,
                title = data.titleResponse
            )
        }
    }
}