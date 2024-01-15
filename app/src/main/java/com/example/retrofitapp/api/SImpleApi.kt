package com.example.retrofitapp.api

import com.example.retrofitapp.model.Post
import com.example.retrofitapp.model.Status
import okhttp3.MultipartBody
import retrofit2.Response
import retrofit2.http.DELETE
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.Path
import retrofit2.http.Query

interface SimpleApi {
    @GET("/search/getpost")
    suspend fun getPost(): Response<Post>

    @GET("/search/getpost/{postNumber}")
    suspend fun getPost2(
        @Path("postNumber") number: Int
    ): Response<Post>

    @GET("/search/getpost")
    suspend fun getPosts3(
        @Query("search") name: String
    ): Response<Post>

    @GET("/search/getpost")
    suspend fun getPosts4(
        @Query("name") name: String,
        @Query("age") age: String
    ): Response<List<Post>>

    @POST("/search/poststuff")
    @FormUrlEncoded
    suspend fun postStuff(
        @Field("name") name: String
    ) : Response<Status>

    @Multipart
    @POST("/search/upload")
    suspend fun uploadImage(
        @Part image: MultipartBody.Part
    ) : Response<Status>

    @Multipart
    @POST("/search/upload")
    suspend fun uploadMultipleImages(
        @Part image: List<MultipartBody.Part>
    ) : Response<Status>

    @DELETE("search/remove/{slug}")
    suspend fun deletePicture(
        @Path("slug")slug: String
    ) : Response<Status>
}