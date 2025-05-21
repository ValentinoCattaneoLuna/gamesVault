package com.example.gamesvault.ui.screens

sealed class Screens (val route: String) {
    object GamesVaultSplash: Screens("Splash")
    object GamesVaultHome: Screens("Home")

}