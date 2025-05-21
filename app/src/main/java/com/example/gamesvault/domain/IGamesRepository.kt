package com.example.gamesvault.domain

import com.example.gamesvault.data.JuegoSummary

interface IGamesRepository {

    suspend fun fetchGames(): List<JuegoSummary>

}