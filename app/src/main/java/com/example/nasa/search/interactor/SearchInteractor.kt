package com.example.nasa.search.interactor

import com.example.nasa.search.model.SearchData
import com.example.nasa.search.repository.SearchRemoteRepository

class SearchInteractor(
    private val remoteRepository: SearchRemoteRepository
) {
    suspend fun getSearchData(page: Int): List<SearchData.ItemParsed>? =
        remoteRepository.getSearchData(page)
}