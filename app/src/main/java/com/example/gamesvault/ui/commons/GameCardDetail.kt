package com.example.gamesvault.ui.commons

import android.content.Intent
import android.net.Uri
import android.widget.Toast
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.platform.LocalContext

@Composable
fun GameCardDetail(juego: JuegoDetail) {
    val scrollState = rememberScrollState()
    val context = LocalContext.current // Obtén el contexto correctamente

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF020817)) // Fondo oscuro similar al de la imagen
            .verticalScroll(scrollState)
    ) {
        // Título del juego
        Text(
            text = juego.title,
            style = MaterialTheme.typography.headlineLarge.copy(
                color = Color.White,
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier.padding(bottom = 8.dp, top = 8.dp)
        )
        // Imagen principal del juego
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center){
            AsyncImage(
                model = juego.urlImagen,
                contentDescription = "Imagen del juego",
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Fit
            )
        }


        // Contenido de la tarjeta
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {


            // Información básica (género, plataforma, fecha)
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Absolute.Left

            ) {
                Text(
                    text = juego.genre,
                    style = MaterialTheme.typography.bodyMedium.copy(color = Color.LightGray)
                )
                Spacer(modifier = Modifier.padding(10.dp))
                Text(
                    text = juego.platform,
                    style = MaterialTheme.typography.bodyMedium.copy(color = Color.LightGray)
                )
                Spacer(modifier = Modifier.padding(10.dp))
                Text(
                    text = juego.fechaCreacion.toString(),
                    style = MaterialTheme.typography.bodyMedium.copy(color = Color.LightGray)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Descripción
            Text(
                text = "Descripción",
                style = MaterialTheme.typography.titleLarge.copy(
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                ),
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = juego.descripcionCompleta,
                style = MaterialTheme.typography.bodyMedium.copy(
                    color = Color.LightGray,
                    lineHeight = 22.sp
                ),
                modifier = Modifier.padding(bottom = 16.dp)
            )

            // Imágenes del juego
            Text(
                text = "Imágenes del juego",
                style = MaterialTheme.typography.titleLarge.copy(
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                ),
                modifier = Modifier.padding(bottom = 8.dp)
            )
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.padding(bottom = 16.dp)
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

            // Requisitos mínimos
            Text(
                text = "Requisitos Mínimos",
                style = MaterialTheme.typography.titleLarge.copy(
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                ),
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Column(modifier = Modifier.padding(bottom = 16.dp)) {
                Text(
                    text = "SO: ${juego.requerimientosMinimos.os}",
                    style = MaterialTheme.typography.bodyMedium.copy(color = Color.LightGray)
                )
                Text(
                    text = "Procesador: ${juego.requerimientosMinimos.processor}",
                    style = MaterialTheme.typography.bodyMedium.copy(color = Color.LightGray)
                )
                Text(
                    text = "Memoria: ${juego.requerimientosMinimos.memory}",
                    style = MaterialTheme.typography.bodyMedium.copy(color = Color.LightGray)
                )
                Text(
                    text = "Gráficos: ${juego.requerimientosMinimos.graphics}",
                    style = MaterialTheme.typography.bodyMedium.copy(color = Color.LightGray)
                )
                Text(
                    text = "Almacenamiento: ${juego.requerimientosMinimos.storage}",
                    style = MaterialTheme.typography.bodyMedium.copy(color = Color.LightGray)
                )
            }

            // Botón "Jugar Ahora"
            Button(
                onClick = {
                    // Verifica si la URL del juego no está vacía
                    val url = juego.urlJuego
                    if (url.isNotEmpty()) {
                        try {
                            // Crea un Intent para abrir la URL en el navegador
                            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                            context.startActivity(intent) // Inicia el intent
                        } catch (e: Exception) {
                            // Si no se puede abrir la URL, muestra un mensaje
                            Toast.makeText(context, "No se pudo abrir la URL", Toast.LENGTH_SHORT).show()
                        }
                    } else {
                        // Si la URL está vacía o no disponible
                        Toast.makeText(context, "URL no disponible", Toast.LENGTH_SHORT).show()
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                shape = RoundedCornerShape(4.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF3A56F7), // Azul similar al de la imagen
                    contentColor = Color.White
                )
            ) {
                Text(
                    text = "JUGAR AHORA",
                    style = MaterialTheme.typography.labelLarge.copy(fontWeight = FontWeight.Bold)
                )
            }
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
