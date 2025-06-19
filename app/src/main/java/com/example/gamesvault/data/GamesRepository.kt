package com.example.gamesvault.dataAdd

import com.example.gamesvault.data.GamesAPIDataSource
import com.example.gamesvault.data.JuegoDetail
import com.example.gamesvault.data.JuegoSummary


import com.example.gamesvault.domain.IGamesDataSource

import com.example.gamesvault.domain.IGamesRepository
import retrofit2.http.Query

class GamesRepository(val gamesDataSource: IGamesDataSource = GamesAPIDataSource()) : IGamesRepository {

    override
    suspend fun fetchGames(): List<JuegoSummary>{
        return gamesDataSource.getGamesList()
    }

    override
    suspend fun searchGames(query: String): List<JuegoSummary>{
        return gamesDataSource.searchGames(query)

    }

    override suspend fun fetchGame(juegoId: Int): JuegoDetail {
        return gamesDataSource.getGameById(juegoId)
        }
    }