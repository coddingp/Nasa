package com.example.nasa.search.repository

import com.example.nasa.search.model.SearchData

interface SearchRepository {
    suspend fun getSearchData(page: Int): List<SearchData.ItemParsed>?
}