package com.example.nasa.search.repository

import com.example.nasa.search.api.SearchApi
import com.example.nasa.search.model.SearchConverter
import com.example.nasa.search.model.SearchData
import com.example.nasa.utils.Utils.userRequest

class SearchRemoteRepository(
    private val searchApi: SearchApi
) : SearchRepository {
    override suspend fun getSearchData(page: Int): List<SearchData.ItemParsed>? {
        val searchData = searchApi.getSearchData(userRequest, page)
        return SearchConverter.fromNetWork(searchData)
    }
}