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
    @Query("SELECT * FROM juegos_detail")
    suspend fun getAllDetails(): List<JuegoDetailLocal>

    // Operaciones para JuegoDetail
    @Query("SELECT * FROM juegos_detail WHERE id = :id")
    suspend fun getDetail(id: Int): JuegoDetailLocal?

    @Insert(onConflict = REPLACE)
    suspend fun insertDetail(detail: JuegoDetailLocal)

    // Operaciones de limpieza
    @Query("DELETE FROM juegos_detail")
    suspend fun clearAllDetails()

    @Query("DELETE FROM juegos_detail where id = :id")
    suspend fun clearDetail(id: Int)
}