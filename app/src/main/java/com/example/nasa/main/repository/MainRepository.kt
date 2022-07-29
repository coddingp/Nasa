package com.example.nasa.main.repository

import com.example.nasa.main.model.ApodData

interface MainRepository {
    suspend fun getApodData(): ApodData
}