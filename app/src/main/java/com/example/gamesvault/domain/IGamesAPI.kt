package com.example.gamesvault.domain

import com.example.gamesvault.data.JuegoDetail
import com.example.gamesvault.data.JuegoSummary
import retrofit2.http.GET
import retrofit2.http.Path

interface IGamesAPI {
    @GET("games?sort-by=popularity")
    suspend fun getGamesTrending() : List<JuegoSummary>

    @GET("game/{juegoId}")
    suspend fun getGame(
        @Path("juegoId") juegoId : Int
    ): JuegoDetail

}