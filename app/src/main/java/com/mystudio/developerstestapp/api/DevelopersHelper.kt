package com.mystudio.developerstestapp.api

class DevelopersHelper(private val apiService:DevelopersApi ) {

    suspend fun getAllDevelopers() = apiService.getAllDevelopers()
}