package com.example.gamesvault.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.REPLACE
import androidx.room.Query
import com.example.gamesvault.data.JuegoDetail


@Dao
interface IJuegosDao {
    // Operaciones para JuegoSummary
    @Query("SELECT * FROM juegos_summary")
    suspend fun getAllSummaries(): List<JuegoSummaryLocal>

    @Query("SELECT * FROM juegos_summary WHERE title LIKE :query")
    suspend fun searchSummaries(query: String): List<JuegoSummaryLocal>

    @Insert(onConflict = REPLACE)
    suspend fun insertSummary(vararg juego: JuegoSummaryLocal)

    @Insert(onConflict = REPLACE)
    suspend fun insertAllSummaries(juegos: List<JuegoSummaryLocal>)

    @Query("UPDATE juegos_summary SET isFavorite = :isFavorite WHERE id = :id")
    suspend fun updateFavoriteStatus(id: Int, isFavorite: Boolean)

    @Query("SELECT * FROM juegos_summary WHERE isFavorite = 1")
    suspend fun getFavorites(): List<JuegoSummaryLocal>

    // Operaciones para JuegoDetail
    @Query("SELECT * FROM juegos_detail WHERE id = :id")
    suspend fun getDetail(id: Int): JuegoDetailLocal?

    @Insert(onConflict = REPLACE)
    suspend fun insertDetail(detail: JuegoDetailLocal)

    // Operaciones de limpieza
    @Query("DELETE FROM juegos_summary")
    suspend fun clearAllSummaries()

    @Query("DELETE FROM juegos_detail")
    suspend fun clearAllDetails()
}