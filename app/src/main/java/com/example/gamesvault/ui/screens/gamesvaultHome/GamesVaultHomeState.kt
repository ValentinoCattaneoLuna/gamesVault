package com.example.gamesvault.ui.screens.gamesvaultHome

import com.example.gamesvault.data.JuegoSummary

data class GamesVaultHomeState (
    val gamesList: List<JuegoSummary> = emptyList(),
    val searchQuery: String = ""
)