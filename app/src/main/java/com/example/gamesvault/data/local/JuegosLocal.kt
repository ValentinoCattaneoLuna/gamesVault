package com.example.gamesvault.data.local

import androidx.room.Entity
import com.example.gamesvault.data.ReqMin
import com.example.gamesvault.data.Screenshot
import com.google.gson.annotations.SerializedName

//@Entity("juegosLocal")
//data class JuegoSummaryLocal (
//    val id: Int = 0,
//    val title: String = "",
//    @SerializedName("thumbnail")
//    val urlImagen: String = "",
//    @SerializedName("game_url")
//    val urlJuego: String = "",
//    @SerializedName("short_description")
//    val descripcionCorta: String = "",
//    val genre: String = "",
//    val platform: String = ""
//)
//
//@Entity("juegoLocal")
//data class JuegoDetailLocal(
//    val id: Int = 0,
//    val title: String = "",
//    @SerializedName("thumbnail")
//    val urlImagen: String = "",
//    @SerializedName("game_url")
//    val urlJuego: String = "",
//    @SerializedName("description")
//    val descripcionCompleta: String = "",
//    val genre: String = "",
//    val platform: String = "",
//    @SerializedName("release_date")
//    val fechaCreacion: String = "",
//    @SerializedName("minimum_system_requirements")
//    val requerimientosMinimos: ReqMin = ReqMin(),
//    val screenshots: List<Screenshot> = emptyList()
//)