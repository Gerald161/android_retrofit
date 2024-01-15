package com.example.retrofitapp.model

import kotlinx.serialization.Serializable

data class Post (
    val name: String,
    val age: Int
)

data class Status(
    val status: String
)