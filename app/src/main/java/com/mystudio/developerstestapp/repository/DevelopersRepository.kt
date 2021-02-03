package com.mystudio.developerstestapp.repository

import com.mystudio.developerstestapp.api.DevelopersApi
import com.mystudio.developerstestapp.api.DevelopersHelper


class DevelopersRepository(private val apiHelper: DevelopersHelper) {

    suspend fun getDevelopers() = apiHelper.getAllDevelopers()
}