package com.example.gamesvault.domain

import com.example.gamesvault.data.JuegoDetail
import com.example.gamesvault.data.JuegoSummary

interface IGamesRepository {

    suspend fun fetchGames(): List<JuegoSummary>
    suspend fun searchGames(query: String): List<JuegoSummary>
    suspend fun fetchGame(juegoId: Int): JuegoDetail
}