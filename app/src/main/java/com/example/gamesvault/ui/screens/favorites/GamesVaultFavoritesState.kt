package com.example.gamesvault.ui.screens.favorites

import com.example.gamesvault.data.JuegoSummary

data class GamesVaultFavoritesState (

    val gamesList: List<JuegoSummary> = emptyList(),
    val favoritosIds: List<Int> = emptyList()
)