package com.example.gamesvault.data

import com.example.gamesvault.domain.IGamesDataSource
import com.example.gamesvault.domain.IGamesRepository

class GamesRepository(val gamesDataSource: IGamesDataSource = GamesDataSource()) : IGamesRepository {

    override
    suspend fun fetchGames(): List<JuegoSummary>{
        return gamesDataSource.getGamesList()
    }
}