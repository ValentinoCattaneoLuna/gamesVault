package com.example.gamesvault.data

import android.util.Log
import android.util.Log.e
import com.example.gamesvault.data.local.JuegosDataBaseProvider
import com.example.gamesvault.data.local.toJuegoDetail
import com.example.gamesvault.data.local.toJuegoDetailLocal
import com.example.gamesvault.domain.IGamesDataSource
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.tasks.await

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

    override suspend fun getGameById(juegoId: Int): JuegoDetail {

        val db = JuegosDataBaseProvider.dbLocal
        var juegoLocal = db.juegosDao().getDetail(juegoId)
        if (juegoLocal != null){
            return juegoLocal.toJuegoDetail()

        }else{
            var juego = RetrofitInstance.GamesAPI.getGame(juegoId)
            db.juegosDao().insertDetail(juego.toJuegoDetailLocal())
            return juego
        }

    }

}