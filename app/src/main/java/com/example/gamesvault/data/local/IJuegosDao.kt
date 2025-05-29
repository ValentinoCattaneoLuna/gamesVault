package com.example.gamesvault.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.REPLACE
import androidx.room.Query
import com.example.gamesvault.data.JuegoDetail


//@Dao
//interface IJuegosDao {
//
//
//    @Query("SELECT * FROM JUEGOSLOCAL")
//    suspend fun getAll(): List<JuegoSummaryLocal>
//
//    @Query("SELECT * FROM juegosLocal where id = :id Limit 1")
//    suspend fun findById(id: Int): JuegoDetailLocal
//
//    @Insert(onConflict = REPLACE)
//    suspend fun insert(vararg juego: JuegoSummaryLocal)
//
//    @Delete
//    suspend fun delete(juego: JuegoSummaryLocal)
//}