package com.example.gamesvault.ui.commons

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.gamesvault.data.JuegoDetail
import com.example.gamesvault.data.Screenshot
import androidx.compose.foundation.lazy.items


@Composable
fun GameCardDetail(juego: JuegoDetail) {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF0F1116))
            .verticalScroll(scrollState)
            .padding(16.dp)
    ) {
        Text(
            text = juego.title.uppercase(),
            style = MaterialTheme.typography.titleLarge.copy(color = Color.White),
            modifier = Modifier.padding(bottom = 8.dp)
        )

        AsyncImage(
            model = juego.urlImagen,
            contentDescription = "Imagen del juego",
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
                .clip(RoundedCornerShape(8.dp)),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            InfoChip(text = juego.genre)
            InfoChip(text = juego.platform)
            InfoChip(text = juego.fechaCreacion.toString())
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Descripción",
            style = MaterialTheme.typography.titleMedium.copy(color = Color.White)
        )
        Text(
            text = juego.descripcionCompleta,
            style = MaterialTheme.typography.bodyMedium.copy(color = Color.LightGray),
            modifier = Modifier.padding(vertical = 8.dp)
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Imágenes del juego",
            style = MaterialTheme.typography.titleMedium.copy(color = Color.White)
        )

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.padding(vertical = 8.dp)
        ) {
            items(juego.screenshots) { screenshot: Screenshot ->
                AsyncImage(
                    model = screenshot.image,
                    contentDescription = "Screenshot del juego",
                    modifier = Modifier
                        .size(240.dp, 140.dp)
                        .clip(RoundedCornerShape(8.dp)),
                    contentScale = ContentScale.Crop
                )
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Requisitos Mínimos",
            style = MaterialTheme.typography.titleMedium.copy(color = Color.White)
        )
        Text(text = "SO: ${juego.requerimientosMinimos.os}", color = Color.LightGray)
        Text(text = "Procesador: ${juego.requerimientosMinimos.processor}", color = Color.LightGray)
        Text(text = "Memoria: ${juego.requerimientosMinimos.memory}", color = Color.LightGray)
        Text(text = "Gráficos: ${juego.requerimientosMinimos.graphics}", color = Color.LightGray)
        Text(text = "Almacenamiento: ${juego.requerimientosMinimos.storage}", color = Color.LightGray)

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = { juego.urlJuego },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF9146FF))
        ) {
            Text(text = "Jugar Ahora", color = Color.White)
        }
    }
}

@Composable
fun InfoChip(text: String) {
    Box(
        modifier = Modifier
            .background(Color(0xFF1F2128), RoundedCornerShape(8.dp))
            .padding(horizontal = 10.dp, vertical = 4.dp)
    ) {
        Text(text = text, color = Color.White, fontSize = 12.sp)
    }
}
