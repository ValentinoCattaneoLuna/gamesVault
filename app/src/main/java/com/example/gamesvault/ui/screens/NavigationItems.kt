package com.example.gamesvault.ui.screens

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Shuffle

val navigationItems = listOf(
    NavigationItem(
        titulo = "Inicio",
        icono = Icons.Default.Home,
        route = Screens.GamesVaultHome.route
    ),
    NavigationItem(
        titulo = "Favoritos",
        icono = Icons.Default.FavoriteBorder,
        route = ""
    ),
    NavigationItem(
        titulo = "Aleatorio",
        icono = Icons.Default.Shuffle,
        route = Screens.GamesVaultRandomGame.route
    ),
    NavigationItem(
        titulo = "Perfil",
        icono = Icons.Default.Person,
        route = Screens.GamesVaultPerfil.route
    )
)