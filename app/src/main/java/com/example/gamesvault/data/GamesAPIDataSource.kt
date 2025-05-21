package com.example.gamesvault.data

import android.util.Log
import com.example.gamesvault.domain.IGamesDataSource

class GamesAPIDataSource : IGamesDataSource {



    override
    suspend fun getGamesList(): List<JuegoSummary> {
        return try {
            val apiResponse = RetrofitInstance.GamesAPI.getGamesTrending()
            apiResponse
        } catch (e: Exception) {
            Log.d("getGamesList", "Error fetching games: ${e.message}", e)
            emptyList()
        }
    }

    override
    suspend fun searchGames(query: String): List<JuegoSummary> {
        return try {
            val allGames = RetrofitInstance.GamesAPI.getGamesTrending()
            allGames.filter { it.title.contains(query, ignoreCase = true) }
        } catch (e: Exception) {
            Log.d("searchGames", "Error searching games: ${e.message}", e)
            emptyList()
        }
    }

}