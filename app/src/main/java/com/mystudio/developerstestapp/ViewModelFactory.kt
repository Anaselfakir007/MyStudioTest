package com.mystudio.developerstestapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mystudio.developerstestapp.api.DevelopersApi
import com.mystudio.developerstestapp.api.DevelopersHelper
import com.mystudio.developerstestapp.repository.DevelopersRepository


class ViewModelFactory(private val apiHelper: DevelopersHelper) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(DevelopersRepository(apiHelper)) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }

}