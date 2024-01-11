package com.example.retrofitapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofitapp.Repository.ApiRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: ApiRepo
) : ViewModel(){
    fun normalRequest(){
        viewModelScope.launch(Dispatchers.IO) {
            val response = repository.getPost()

            if(response.isSuccessful){
                println("Here it is ${response.body()?.name}")
            }
        }
    }

    fun normalRequest2(number: Int){
        viewModelScope.launch(Dispatchers.IO) {
            val response = repository.getPost2(number)

            if(response.isSuccessful){
                println("Here it is ${response.body()?.name}")
            }
        }
    }

    fun normalRequest3(name: String){
        viewModelScope.launch(Dispatchers.IO) {
            val response = repository.getPost3(name)

            if(response.isSuccessful){
                println("Here it is ${response.body()?.name}")
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
}