package com.example.nasa.common.di

import com.example.nasa.apod.api.ApodListApi
import com.example.nasa.main.api.NasaApi
import com.example.nasa.rover.api.RoverApi
import com.example.nasa.search.api.SearchApi
import com.example.nasa.utils.Utils.BASE_URL
import com.example.nasa.utils.Utils.BASE_URL_SEARCH
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object CommonModule {
    fun createMainRetrofit() = module {
        single {
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            val client = OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build()
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            retrofit.create(NasaApi::class.java)
        }
    }

    fun createSearchRetrofit() = module {
        single {
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            val client2 = OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build()
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL_SEARCH)
                .client(client2)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            retrofit.create(SearchApi::class.java)
        }
    }

    fun createApodListRetrofit() = module {
        single {
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            val client2 = OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build()
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client2)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            retrofit.create(ApodListApi::class.java)
        }
    }

    fun createRoverRetrofit() = module {
        single {
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            val client2 = OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build()
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client2)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            retrofit.create(RoverApi::class.java)
        }
    }
}