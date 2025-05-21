package com.example.gamesvault.ui.screens.GamesVaultJuegoDetail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gamesvault.data.GamesAPIDataSource
import com.example.gamesvault.data.GamesRepository
import com.example.gamesvault.data.JuegoDetail
import com.example.gamesvault.domain.IGamesRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class GamesVaultJuegoDetailViewModel(
    private val gamesRepository: IGamesRepository = GamesRepository()
): ViewModel() {

    var uiState by mutableStateOf(GamesVaultJuegoDetailState())
        private set



    fun setJuegoId(JuegoId: Int): Unit{
        uiState = uiState.copy(juegoId = JuegoId, juegoDetail = uiState.juegoDetail  )
        fetchGame()
    }

    private var fetchJob: Job? = null

    fun fetchGame(){
        fetchJob?.cancel()
        fetchJob = viewModelScope.launch {
            uiState = uiState.copy(juegoId = uiState.juegoId, juegoDetail = gamesRepository.fetchGame(uiState.juegoId))

        }
    }


}