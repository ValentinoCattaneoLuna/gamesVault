package com.example.gamesvault.data

import com.example.gamesvault.domain.IGamesDataSource
import com.example.gamesvault.domain.IGamesLocalDataSource
import com.example.gamesvault.domain.IGamesRepository
import javax.inject.Inject

class GamesRepository @Inject constructor(
    private val remoteDataSource: IGamesDataSource,
    private val localDataSource: IGamesLocalDataSource
) : IGamesRepository {

    override suspend fun fetchGames(): List<JuegoSummary> {
        return try {
            // 1. Obtener de API
            val remoteGames = remoteDataSource.getGamesList()

            // 2. Guardar en caché (en segundo plano)
            localDataSource.cacheGames(remoteGames)

            // 3. Devolver datos frescos
            remoteGames
        } catch (e: Exception) {
            // Fallback a caché si hay error
            localDataSource.getCachedGames().takeIf { it.isNotEmpty() }
                ?: throw e // Relanzar si no hay caché
        }
    }

    override suspend fun fetchGame(juegoId: Int): JuegoDetail {
        return localDataSource.getGameDetail(juegoId)?.let {
            // Devolver caché si existe
            it
        } ?: run {
            // Obtener de API si no hay caché
            val remoteGame = remoteDataSource.getGameById(juegoId)
            localDataSource.cacheGameDetail(remoteGame)
            remoteGame
        }
    }

    override suspend fun searchGames(query: String): List<JuegoSummary> {
        val localResults = localDataSource.searchCachedGames(query)
        return if (localResults.isNotEmpty()) {
            localResults
        } else {
            remoteDataSource.searchGames(query).also {
                localDataSource.cacheGames(it) // cachear resultados de búsqueda
            }
        }
    }

    //Método para actualizar datos
    suspend fun refreshGames() {
        val remoteGames = remoteDataSource.getGamesList()
        localDataSource.cacheGames(remoteGames)
    }
}