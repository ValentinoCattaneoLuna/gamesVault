package com.example.gamesvault.ui.screens

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.gamesvault.ui.screens.gamesVaultJuegoDetail.GamesVaultJuegoDetail
import com.example.gamesvault.ui.screens.gamesvaultHome.GamesVaultHome
import com.example.gamesvault.ui.screens.splash.GamesVaultSplash

@Composable
fun NavigationStack(){

    val navController = rememberNavController()


    NavHost(
        navController = navController,
        startDestination = Screens.GamesVaultSplash.route
    ){

        composable(route = Screens.GamesVaultSplash.route) {
            GamesVaultSplash(navController = navController)
        }
        composable(route = Screens.GamesVaultHome.route) {
            GamesVaultHome(navController = navController)
        }
        composable(route = Screens.GamesVaultJuegoDetail.route + "/{juegoId}") { it ->
            var id = it.arguments?.getString("juegoId")
            val juegoId = id?.toIntOrNull()
            GamesVaultJuegoDetail(juegoId ?: 0)
        }
    }

}