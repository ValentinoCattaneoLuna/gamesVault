package com.example.gamesvault.domain

import com.example.gamesvault.data.JuegoDetail
import com.example.gamesvault.data.JuegoSummary
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface IGamesAPI {
    @GET("games?sort-by=popularity")
    suspend fun getGamesTrending() : List<JuegoSummary>

    @GET("game")
    suspend fun getGame(
        @Query("id") juegoId : Int
    ): JuegoDetail

}