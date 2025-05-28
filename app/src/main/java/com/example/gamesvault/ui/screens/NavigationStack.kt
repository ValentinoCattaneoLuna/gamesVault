package com.example.gamesvault.ui.screens

import GamesVaultPerfil
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.gamesvault.ui.screens.Screens.GamesVaultPerfil
import com.example.gamesvault.ui.screens.Screens.GamesVaultRandomGame
import com.example.gamesvault.ui.screens.juegoDetail.GamesVaultJuegoDetail
import com.example.gamesvault.ui.screens.home.GamesVaultHome
import com.example.gamesvault.ui.screens.login.GamesVaultLogin
import com.example.gamesvault.ui.screens.randomGame.GamesVaultRandomGame
import com.example.gamesvault.ui.screens.splash.GamesVaultSplash

@Composable
fun NavigationStack(
    onGoogleLoginClick: ()-> Unit,
    onLogOutClick: ()-> Unit,
    navController: NavHostController

){

    NavHost(
        navController = navController,
        startDestination = Screens.GamesVaultSplash.route
    ){

        //splash
        composable(route = Screens.GamesVaultSplash.route) {
            GamesVaultSplash(navController = navController)
        }
        //login
        composable (route = Screens.GamesVaultLogin.route){
            GamesVaultLogin(onGoogleLoginClick= onGoogleLoginClick, navController = navController)
        }
        //home
        composable(route = Screens.GamesVaultHome.route) {
            GamesVaultHome(navController = navController)
        }
        //juegoDetail
        composable(route = Screens.GamesVaultJuegoDetail.route + "/{juegoId}") { it ->
            var id = it.arguments?.getString("juegoId")
            val juegoId = id?.toIntOrNull()
            GamesVaultJuegoDetail(juegoId ?: 0, navController)
        }

        //perfil
        composable(route = Screens.GamesVaultPerfil.route){
            GamesVaultPerfil(navController = navController, onLogOutClick = onLogOutClick)
        }

        //random game
        composable(route = Screens.GamesVaultRandomGame.route) {
            GamesVaultRandomGame(navController = navController)
        }
    }

}