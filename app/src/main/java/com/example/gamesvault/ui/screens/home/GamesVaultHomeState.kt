package com.example.gamesvault.ui.screens.home

import com.example.gamesvault.data.JuegoSummary

data class GamesVaultHomeState (
    val gamesList: List<JuegoSummary> = emptyList(),
    val searchQuery: String = ""
)