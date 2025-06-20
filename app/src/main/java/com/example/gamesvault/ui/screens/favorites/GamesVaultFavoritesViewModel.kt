package com.example.gamesvault.ui.screens.favorites

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gamesvault.data.UsersRepository
import com.example.gamesvault.dataAdd.GamesRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class GamesVaultFavoritesViewModel(
    private val gamesRepository: GamesRepository = GamesRepository(),
    private val usersRepository: UsersRepository = UsersRepository()
): ViewModel() {

    var uiState by mutableStateOf(GamesVaultFavoritesState())
        private set

    init {
        cargarFavoritos()
    }

    private var fetchJob: Job? = null
    fun favoritos(id: Int){
        fetchJob?.cancel()
        fetchJob = viewModelScope.launch {
            usersRepository.addFavorite(id)
        }
    }

    fun cargarFavoritos() {
        viewModelScope.launch {
            val favoritos = usersRepository.getFavorites()
            val juegos = gamesRepository.fetchGames()

            val juegosFavoritos = juegos.filter { juego ->
                favoritos.contains(juego.id)
            }

            uiState = uiState.copy(
                favoritosIds = favoritos,
                gamesList = juegosFavoritos
            )
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