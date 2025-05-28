package com.example.gamesvault.ui.screens.randomGame

data class GamesVaultRandomGameState(
    val isLoading: Boolean = false,
    val selectedGameId: Int? = null,
    val errorMessage: String? = null
)