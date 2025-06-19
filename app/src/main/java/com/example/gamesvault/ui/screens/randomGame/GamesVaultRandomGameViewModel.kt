package com.example.gamesvault.ui.screens.randomGame

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.example.gamesvault.dataAdd.GamesRepository
import com.example.gamesvault.domain.IGamesRepository
import kotlinx.coroutines.launch

class GamesVaultRandomGameViewModel(
    private val gamesRepository: IGamesRepository = GamesRepository()
) : ViewModel() {

    var uiState by mutableStateOf(GamesVaultRandomGameState())
        private set

    fun fetchRandomGame(onSuccess: (Int) -> Unit) {
        if (uiState.isLoading) return

        viewModelScope.launch {
            uiState = uiState.copy(isLoading = true, errorMessage = null)
            try {
                val games = gamesRepository.fetchGames()
                val randomGame = games.random()
                uiState = uiState.copy(
                    isLoading = false,
                    selectedGameId = randomGame.id
                )
                onSuccess(randomGame.id)
            } catch (e: Exception) {
                uiState = uiState.copy(
                    isLoading = false,
                    errorMessage = "Error al obtener un juego aleatorio"
                )
            }
        }
    }
}