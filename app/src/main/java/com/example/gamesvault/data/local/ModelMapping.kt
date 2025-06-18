package com.example.gamesvault.data.local

import com.example.gamesvault.data.JuegoSummary
import com.google.gson.annotations.SerializedName
import kotlin.Int

fun JuegoSummary.toJuegoSummaryLocal(): JuegoSummaryLocal {
    return JuegoSummaryLocal(
        id = this.id,
        title = this.title,
        urlImagen = this.urlImagen,
        urlJuego = this.urlJuego,
        descripcionCorta = this.descripcionCorta,
        genre = this.genre,
        platform = this.platform
    )
}

fun JuegoSummaryLocal.toJuegoSummary(): JuegoSummary {
    return JuegoSummary(
        id = this.id,
        title = this.title,
        urlImagen = this.urlImagen,
        urlJuego = this.urlJuego,
        descripcionCorta = this.descripcionCorta,
        genre = this.genre,
        platform = this.platform
    )
}