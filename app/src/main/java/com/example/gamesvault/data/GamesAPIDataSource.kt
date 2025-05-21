package com.example.gamesvault.data

import com.example.gamesvault.domain.IGamesDataSource

class GamesAPIDataSource : IGamesDataSource {
    override
    suspend fun getGamesList(): List<JuegoSummary> {
        TODO("Not yet implemented")
    }
}