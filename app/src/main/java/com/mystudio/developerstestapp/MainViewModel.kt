package com.mystudio.developerstestapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.mystudio.developerstestapp.api.DevelopersHelper
import com.mystudio.developerstestapp.api.builder.ApiBuilder
import com.mystudio.developerstestapp.data.Resource

import com.mystudio.developerstestapp.repository.DevelopersRepository

class MainViewModel(private val developersRepository: DevelopersRepository) : ViewModel() {


    fun getDevelopers() = liveData {
            emit(Resource.loading(null))
        try {
            emit(Resource.success(data = developersRepository.getDevelopers()))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }
}