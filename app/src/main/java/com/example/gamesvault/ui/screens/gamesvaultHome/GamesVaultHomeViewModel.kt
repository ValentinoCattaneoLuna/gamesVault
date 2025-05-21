package com.example.gamesvault.ui.screens.gamesvaultHome

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gamesvault.data.GamesRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import okio.IOException

class GamesVaultHomeViewModel(
    private val gamesRepository: GamesRepository = GamesRepository()
): ViewModel() {

    var uiState by mutableStateOf(GamesVaultHomeState())
        private set

    init {
        fetchGames()
    }

    private var fetchJob: Job? = null
    fun fetchGames(){
        fetchJob?.cancel()
        fetchJob = viewModelScope.launch {
            try {
                uiState = uiState.copy(gamesList =  gamesRepository.fetchGames())
            }catch (e: IOException){
                Log.e("gamesVault", "Error recuperando la lista de juegos")
            }
        }
    }
}


