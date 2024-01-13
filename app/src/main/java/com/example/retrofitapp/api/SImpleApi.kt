package com.example.retrofitapp.api

import com.example.retrofitapp.model.Post
import com.example.retrofitapp.model.Status
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
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

    @POST("/posts")
    @FormUrlEncoded
    suspend fun postStuff(
        @Field("name") name: String
    ) : Response<Status>
}