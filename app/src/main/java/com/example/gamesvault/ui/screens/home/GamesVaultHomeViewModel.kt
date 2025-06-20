package com.example.gamesvault.ui.screens.home

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gamesvault.data.UsersDataSource
import com.example.gamesvault.data.UsersRepository
import com.example.gamesvault.dataAdd.GamesRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import okio.IOException

class GamesVaultHomeViewModel(
    private val gamesRepository: GamesRepository = GamesRepository(),
    private val usersRepository: UsersRepository = UsersRepository()
): ViewModel() {

    var uiState by mutableStateOf(GamesVaultHomeState())
        private set

    init {
        fetchGames()
        cargarFavoritos()
    }

    private var fetchJob: Job? = null
    fun fetchGames() {
        fetchJob?.cancel()
        fetchJob = viewModelScope.launch {
            try {
                // Obtiene juegos (primero intenta API, si falla usa caché)
                val games = gamesRepository.fetchGames()
                uiState = uiState.copy(gamesList = games)
            } catch (e: IOException) {
                Log.e("GamesVault", "Error fetching games: ${e.message}")
                // El repositorio ya maneja el fallback a caché automáticamente
            }
        }
    }

    fun searchGames() {
        fetchJob?.cancel()
        fetchJob = viewModelScope.launch {
            try {
                val result = gamesRepository.searchGames(uiState.searchQuery)
                uiState = uiState.copy(gamesList = result)
            } catch (e: IOException) {
                Log.e("GamesVault", "Search error: ${e.message}")
            }
        }
    }

    fun searchChange(query: String) {
        uiState = uiState.copy(searchQuery = query)
    }


    fun favoritos(id: Int){
        fetchJob?.cancel()
        fetchJob = viewModelScope.launch {
        usersRepository.addFavorite(id)
        }
    }


    fun cargarFavoritos() {
        viewModelScope.launch {
            val favoritos = usersRepository.getFavorites()
            uiState = uiState.copy(favoritosIds = favoritos)
        }
    }

    fun toggleFavorito(id: Int) {
        viewModelScope.launch {
            val currentFavs = uiState.favoritosIds.toMutableList()
            val isFav = currentFavs.contains(id)

            if (isFav) {
                usersRepository.removeFavorite(id)
                currentFavs.remove(id)
            } else {
                usersRepository.addFavorite(id)
                currentFavs.add(id)
            }

            uiState = uiState.copy(favoritosIds = currentFavs)
        }
    }






}


