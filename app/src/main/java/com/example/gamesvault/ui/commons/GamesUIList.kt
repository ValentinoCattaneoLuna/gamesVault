package com.example.gamesvault.ui.commons

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.gamesvault.data.JuegoSummary
import androidx.compose.foundation.lazy.items

@Composable
fun GamesUIList(
    gamesList: List<JuegoSummary>,
    modifier : Modifier = Modifier,
    onClick : (juegoId: Int) -> Unit
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(gamesList) { juego ->
            GameCard(juego, onClick = onClick)
        }
    }
}
