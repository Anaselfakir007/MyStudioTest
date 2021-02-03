package com.mystudio.developerstestapp.api.builder

import com.mystudio.developerstestapp.api.DevelopersApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiBuilder {

    private const val BASE_URL = "https://dev.mystudiofactory.com/"

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val apiService: DevelopersApi = getRetrofit().create(DevelopersApi::class.java)
}