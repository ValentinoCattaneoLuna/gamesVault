package com.example.gamesvault.ui.screens.splash

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.gamesvault.ui.screens.Screens
import kotlinx.coroutines.delay

@Composable
fun GamesVaultSplash(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    LaunchedEffect(Unit) {
        delay(3000)
        navController.navigate(Screens.GamesVaultHome.route){
            popUpTo("Splash"){inclusive = true}
        }
    }
    // Fondo completo
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF020817)),
        contentAlignment = Alignment.Center
    ) {
        // Loader + Texto en columna centrada
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Loader personalizado que simula el SVG (estilo stroke animado)
            CircularProgressIndicator(
                modifier = Modifier.size(60.dp),
                strokeWidth = 4.dp,
                color = Color(0xFF7C3AED)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Cargando juegos...",
                color = Color.White,
                fontSize = 16.sp
            )
        }
    }
}
