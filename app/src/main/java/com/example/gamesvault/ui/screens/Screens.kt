package com.example.gamesvault.ui.screens

sealed class Screens (val route: String) {
    object GamesVaultSplash: Screens("Splash")
    object GamesVaultHome: Screens("Home")
    object GamesVaultJuegoDetail: Screens("JuegoDetail")
    object GamesVaultLogin: Screens("Login")
    object GamesVaultPerfil: Screens("Perfil")
    object GamesVaultRandomGame: Screens("random")
    object GamesVaultFavorites: Screens("favorites")
}