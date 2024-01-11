package com.example.retrofitapp.api

import com.example.retrofitapp.model.Post
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface SimpleApi {
    @GET("/")
    suspend fun getPost(): Response<Post>

    @GET("/{postNumber}")
    suspend fun getPosts(
        @Path("postNumber") number: Int
    ): Response<Post>

    @GET("/")
    suspend fun getPosts2(
        @Query("search") name: String
    ): Response<Post>

    @GET("/")
    suspend fun getPosts3(
        @Query("search") name: String,
        @Query("rank") rank: String
    ): Response<List<Post>>
}