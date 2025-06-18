package com.example.gamesvault.domain

import com.example.gamesvault.data.JuegoDetail
import com.example.gamesvault.data.JuegoSummary

interface IGamesLocalDataSource {
    suspend fun getCachedGames(): List<JuegoSummary>
    suspend fun cacheGames(games: List<JuegoSummary>)
    suspend fun searchCachedGames(query: String): List<JuegoSummary>
    suspend fun getGameDetail(id: Int): JuegoDetail?
    suspend fun cacheGameDetail(game: JuegoDetail)
}