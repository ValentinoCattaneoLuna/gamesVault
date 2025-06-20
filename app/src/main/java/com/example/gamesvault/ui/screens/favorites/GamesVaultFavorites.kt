package com.example.gamesvault.ui.screens.favorites

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Shuffle
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign.Companion.Center
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.gamesvault.ui.commons.BarraDeNavegacion
import com.example.gamesvault.ui.commons.GamesUIList
import com.example.gamesvault.ui.screens.Screens


@Composable
fun GamesVaultFavorites(
    vm : GamesVaultFavoritesViewModel = viewModel(),
    modifier: Modifier = Modifier,
    navController: NavHostController){


    Scaffold(

        bottomBar = {
            BarraDeNavegacion(navController = navController)
        },
        containerColor = Color(0xFF020817) // Fondo general
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        ){

            if (vm.uiState.favoritosIds.isEmpty()){
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                        .background(Color.Transparent, shape = MaterialTheme.shapes.medium.copy(CornerSize(12.dp))),
                    contentAlignment = Alignment.Center

                ){
                    Column(
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement  = Arrangement.spacedBy(12.dp)
                    ){
                        Image(
                            painter = painterResource(id = com.example.gamesvault.R.drawable.games_vault_logo),
                            contentDescription = "Logo de la app",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.size(100.dp)
                        )
                        Text(
                            text = "No tenes juegos favoritos",
                            style = MaterialTheme.typography.titleLarge.copy(
                                color = Color.White,
                                fontWeight = FontWeight.Bold,
                                textAlign = Center
                            )
                        )
                        Spacer(modifier = Modifier.height(2.dp))



                        Button(
                            onClick = {

                                navController.navigate(Screens.GamesVaultHome.route)

                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(48.dp),
                            shape = RoundedCornerShape(8.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xFF7C3AED),
                                contentColor = Color.White
                            ),
                            border = BorderStroke(1.dp, Color(0xFF94A3B8))
                        ) {
                            Icon(
                                imageVector = Icons.Default.Home,
                                contentDescription = "Home icon",
                                modifier = Modifier.size(24.dp),
                                tint = Color.White
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = "Explorar Juegos",
                                fontSize = 16.sp
                            )
                        }
                    }
                }
            }
            else {
                Text(
                    modifier = Modifier.padding(1.dp, bottom = 16.dp),
                    text = "Tus Juegos favoritos",
                    style = MaterialTheme.typography.titleLarge,
                    color = White,
                )
                GamesUIList(
                    gamesList = vm.uiState.gamesList,
                    favoritosIds = vm.uiState.favoritosIds,
                    modifier = Modifier.fillMaxSize(),
                    onClick = { id ->
                        navController.navigate(Screens.GamesVaultJuegoDetail.route + "/${id}")
                    },
                    onFavClick = { id ->
                        vm.toggleFavorito(id)
                    }
                )
            }
        }





    }
}