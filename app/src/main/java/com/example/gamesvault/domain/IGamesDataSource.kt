package com.example.gamesvault.domain

import com.example.gamesvault.data.JuegoSummary

interface IGamesDataSource {
    suspend fun getGamesList(): List<JuegoSummary>
}