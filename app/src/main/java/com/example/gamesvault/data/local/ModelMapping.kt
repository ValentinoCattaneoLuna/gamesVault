package com.example.gamesvault.data.local

import com.example.gamesvault.data.JuegoDetail
import com.example.gamesvault.data.JuegoSummary
import com.google.gson.annotations.SerializedName
import kotlin.Int

fun JuegoDetail.toJuegoDetailLocal(): JuegoDetailLocal {
    return JuegoDetailLocal(
        id = this.id,
        title = this.title,
        urlImagen = this.urlImagen,
        urlJuego = this.urlJuego,
        descripcionCompleta = this.descripcionCompleta,
        genre = this.genre,
        platform = this.platform,
        fechaCreacion = this.fechaCreacion,
        requerimientosMinimos = fromReqMin(this.requerimientosMinimos),
        screenshots = fromScreenshots(this.screenshots)
    )
}

fun JuegoDetailLocal.toJuegoDetail(): JuegoDetail {
    return JuegoDetail(
        id = this.id,
        title = this.title,
        urlImagen = this.urlImagen,
        urlJuego = this.urlJuego,
        descripcionCompleta = this.descripcionCompleta,
        genre = this.genre,
        platform = this.platform,
        fechaCreacion = this.fechaCreacion,
        requerimientosMinimos = toReqMin(this.requerimientosMinimos),
        screenshots = toScreenshots(this.screenshots)
    )
}