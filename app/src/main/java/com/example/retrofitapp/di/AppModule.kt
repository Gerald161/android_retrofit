package com.example.retrofitapp.di

import com.example.retrofitapp.api.SimpleApi
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit


@OptIn(ExperimentalSerializationApi::class)
@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    fun getApi(): SimpleApi{
        val json = Json{
            ignoreUnknownKeys = true
        }

        val contentType = "application/json".toMediaType()

        return Retrofit.Builder()
            .addConverterFactory(json.asConverterFactory(contentType))
            .baseUrl("http://")
            .build()
            .create(SimpleApi::class.java)
    }
}