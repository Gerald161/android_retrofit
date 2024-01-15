package com.example.retrofitapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofitapp.Repository.ApiRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.File
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: ApiRepo
) : ViewModel(){
    fun normalRequest(){
        viewModelScope.launch(Dispatchers.IO) {
            val response = repository.getPost()

            if(response.isSuccessful){
                println("Here it is ${response.body()}")
            }
        }
    }

    fun normalRequest2(number: Int){
        viewModelScope.launch(Dispatchers.IO) {
            val response = repository.getPost2(number)

            if(response.isSuccessful){
                println("Here it is ${response.body()}")
            }
        }
    }

    fun normalRequest3(name: String){
        viewModelScope.launch(Dispatchers.IO) {
            val response = repository.getPost3(name)

            if(response.isSuccessful){
                println("Here it is ${response.body()}")
            }
        }
    }

    fun normalRequest4(name: String, rank: String){
        viewModelScope.launch(Dispatchers.IO) {
            val response = repository.getPost4(name, rank)

            if(response.isSuccessful){
                println("Here it is ${response.body()}")
            }
        }
    }

    fun postRequest(name: String){
        viewModelScope.launch(Dispatchers.IO) {
            val response = repository.postStuff(name)

            if(response.isSuccessful){
                println("Here it is ${response.body()}")
            }
        }
    }

    fun uploadImage(file: File){
        viewModelScope.launch(Dispatchers.IO) {
            val response = repository.uploadImage(file)

            if(response.isSuccessful){
                println("Here it is ${response.body()}")
            }
        }
    }

    fun uploadMultipleImages(files: List<File>){
        viewModelScope.launch(Dispatchers.IO) {
            val response = repository.uploadMultipleImages(files)

            if(response.isSuccessful){
                println("Here it is ${response.body()}")
            }
        }
    }
}