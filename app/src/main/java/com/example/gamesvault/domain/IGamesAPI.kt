package com.example.gamesvault.domain

import com.example.gamesvault.data.JuegoSummary
import retrofit2.http.GET

interface IGamesAPI {
    @GET("games?sort-by=popularity")
    suspend fun getGamesTrending() : List<JuegoSummary>


}