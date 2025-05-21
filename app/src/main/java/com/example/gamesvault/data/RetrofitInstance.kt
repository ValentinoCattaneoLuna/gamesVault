package com.example.gamesvault.data

import com.example.gamesvault.domain.IGamesAPI
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private val BASE_URL : String = "https://www.freetogame.com/api/"

    private val retrofit by lazy {
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }


    val GamesAPI : IGamesAPI by lazy {
        retrofit.create(IGamesAPI::class.java)
    }
}