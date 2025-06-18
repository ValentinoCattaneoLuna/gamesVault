package com.example.gamesvault.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.gamesvault.data.ReqMin
import com.example.gamesvault.data.Screenshot
import com.google.gson.annotations.SerializedName
// JuegosLocal.kt
@Entity(tableName = "juegos_summary")
data class JuegoSummaryLocal(
    @PrimaryKey val id: Int,
    val title: String,
    val urlImagen: String,
    val urlJuego: String,
    val descripcionCorta: String,
    val genre: String,
    val platform: String,
    val isFavorite: Boolean = false,
    val lastUpdated: Long = System.currentTimeMillis()
)

@Entity(tableName = "juegos_detail")
data class JuegoDetailLocal(
    @PrimaryKey val id: Int,
    val title: String,
    val urlImagen: String,
    val urlJuego: String,
    val descripcionCompleta: String,
    val genre: String,
    val platform: String,
    val fechaCreacion: String,
    val requerimientosMinimos: String, // Serializado como JSON
    val screenshots: String // Serializado como JSON
)