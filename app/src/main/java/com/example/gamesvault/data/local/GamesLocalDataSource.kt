package com.example.gamesvault.data.local

import com.example.gamesvault.data.JuegoDetail
import com.example.gamesvault.data.JuegoSummary
import com.example.gamesvault.data.ReqMin
import com.example.gamesvault.data.Screenshot
import com.example.gamesvault.domain.IGamesLocalDataSource
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class GamesLocalDataSource(
    private val gameDao: IJuegosDao,
    private val gson: Gson = Gson()
) : IGamesLocalDataSource {


    override suspend fun getCachedGames(): List<JuegoSummary> {
        return gameDao.getAllSummaries()
            .map { it.toJuegoSummary() }
    }

    override suspend fun cacheGames(games: List<JuegoSummary>) {
        gameDao.insertAllSummaries(
            games.map { it.toJuegoSummaryLocal() }
        )
    }

    override suspend fun searchCachedGames(query: String): List<JuegoSummary> {
        return gameDao.searchSummaries("%$query%")
            .map { it.toJuegoSummary() }
    }

    override suspend fun getGameDetail(id: Int): JuegoDetail? {
        return gameDao.getDetail(id)?.let { local ->
            JuegoDetail(
                id = local.id,
                title = local.title,
                urlImagen = local.urlImagen,
                urlJuego = local.urlJuego,
                descripcionCompleta = local.descripcionCompleta,
                genre = local.genre,
                platform = local.platform,
                fechaCreacion = local.fechaCreacion,
                requerimientosMinimos = gson.fromJson(
                    local.requerimientosMinimos,
                    ReqMin::class.java
                ),
                screenshots = gson.fromJson(
                    local.screenshots,
                    object : TypeToken<List<Screenshot>>() {}.type
                )
            )
        }
    }

    override suspend fun cacheGameDetail(game: JuegoDetail) {
        gameDao.insertDetail(
            JuegoDetailLocal(
                id = game.id,
                title = game.title,
                urlImagen = game.urlImagen,
                urlJuego = game.urlJuego,
                descripcionCompleta = game.descripcionCompleta,
                genre = game.genre,
                platform = game.platform,
                fechaCreacion = game.fechaCreacion,
                requerimientosMinimos = gson.toJson(game.requerimientosMinimos),
                screenshots = gson.toJson(game.screenshots)
            )
        )
    }
}