package com.example.retrofitapp.Repository

import com.example.retrofitapp.api.SimpleApi
import com.example.retrofitapp.model.Post
import com.example.retrofitapp.model.Status
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import retrofit2.Response
import java.io.File
import javax.inject.Inject

class ApiRepo @Inject constructor(
    private val simpleApi : SimpleApi
){
    suspend fun getPost(): Response<Post>{
        return simpleApi.getPost()
    }

    suspend fun getPost2(number: Int): Response<Post>{
        return simpleApi.getPost2(number)
    }

    suspend fun getPost3(name: String): Response<Post>{
        return simpleApi.getPosts3(name)
    }

    suspend fun getPost4(name: String, age: String): Response<List<Post>>{
        return simpleApi.getPosts4(name, age)
    }

    suspend fun postStuff(name: String): Response<Status>{
        return simpleApi.postStuff(name)
    }

    suspend fun uploadImage(file: File): Response<Status>{
        return simpleApi.uploadImage(
            image = MultipartBody.Part.createFormData(
                "image",
                file.name,
                file.asRequestBody()
            )
        )
    }

    suspend fun uploadMultipleImages(files: List<File>): Response<Status>{
        val allMultipartBodies: MutableList<MultipartBody.Part> = arrayListOf()

        files.forEachIndexed { index, file ->
            allMultipartBodies.add(
                MultipartBody.Part.createFormData(
                    "image${index+1}",
                    file.name,
                    file.asRequestBody()
                )
            )
        }

        return simpleApi.uploadMultipleImages(
            image = allMultipartBodies
        )
    }

    suspend fun deletePost(slug: String): Response<Status>{
        return simpleApi.deletePicture(slug)
    }
}