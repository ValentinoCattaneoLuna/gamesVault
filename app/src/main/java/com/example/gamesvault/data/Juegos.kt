package com.example.gamesvault.data

import com.google.gson.annotations.SerializedName
import java.time.LocalDate
import java.util.Date

data class JuegoSummary(
    val id: Int,
    val title: String,
    @SerializedName("thumbnail")
    val urlImagen: String,
    @SerializedName("game_url")
    val urlJuego: String,
    @SerializedName("short_description")
    val descripcionCorta: String,
    val genre: String,
    val platform: String
)

data class JuegoDetail(
    val id: Int,
    val title: String,
    @SerializedName("thumbnail")
    val urlImagen: String,
    @SerializedName("game_url")
    val urlJuego: String,
    @SerializedName("description")
    val descripcionCompleta: String,
    val genre: String,
    val platform: String,
    @SerializedName("release_date")
    val fechaCreacion : String,
    @SerializedName("minimum_system_requirements")
    val requerimientosMinimos: ReqMin,
    val screenshots: List<Screenshot>

)

data class ReqMin(
    val os: String,
    val processor: String,
    val memory: String,
    val graphics: String,
    val storage: String
)

data class Screenshot(
    val id: Int,
    val image: String
)


fun emptyJuegoDetail(): JuegoDetail{
    return JuegoDetail(0,"","","","","","",LocalDate.now().toString(), ReqMin("","","","",""), emptyList() )
}