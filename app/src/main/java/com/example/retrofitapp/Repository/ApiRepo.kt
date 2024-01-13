package com.example.retrofitapp.Repository

import com.example.retrofitapp.api.SimpleApi
import com.example.retrofitapp.model.Post
import com.example.retrofitapp.model.Status
import retrofit2.Response
import javax.inject.Inject

class ApiRepo @Inject constructor(
    private val simpleApi : SimpleApi
){
    suspend fun getPost(): Response<Post>{
        return simpleApi.getPost()
    }

    suspend fun getPost2(number: Int): Response<Post>{
        return simpleApi.getPosts(number)
    }

    suspend fun getPost3(name: String): Response<Post>{
        return simpleApi.getPosts2(name)
    }

    suspend fun getPost4(name: String, rank: String): Response<List<Post>>{
        return simpleApi.getPosts3(name, rank)
    }

    suspend fun postStuff(name: String): Response<Status>{
        return simpleApi.postStuff(name)
    }
}