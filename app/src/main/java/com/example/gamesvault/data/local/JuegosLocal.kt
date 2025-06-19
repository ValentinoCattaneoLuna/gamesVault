package com.example.gamesvault.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey


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