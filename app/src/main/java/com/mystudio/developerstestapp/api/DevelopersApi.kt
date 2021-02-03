package com.mystudio.developerstestapp.api

import com.mystudio.developerstestapp.data.ErrorResponse
import com.mystudio.developerstestapp.data.response.DataDevelopers
import okhttp3.MultipartBody
import retrofit2.http.*

interface DevelopersApi {
    @GET("trombi")
    suspend fun getAllDevelopers(): DataDevelopers
}