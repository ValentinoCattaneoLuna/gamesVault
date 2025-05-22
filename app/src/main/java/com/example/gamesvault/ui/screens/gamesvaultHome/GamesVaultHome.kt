package com.example.gamesvault.ui.screens.gamesvaultHome

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.unit.dp
import com.example.gamesvault.ui.commons.GamesUIList
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.gamesvault.ui.commons.SearchBarWithButton
import com.example.gamesvault.ui.screens.Screens

@Composable
fun GamesVaultHome(
    vm: GamesVaultHomeViewModel = viewModel(),
    modifier: Modifier = Modifier,
    navController: NavHostController
){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background( Color(0xFF020817))
    ){
        Column(modifier = Modifier.fillMaxSize().padding(16.dp)){

            SearchBarWithButton(
                query = vm.uiState.searchQuery,
                onQueryChange = { newQuery -> vm.searchChange(newQuery) },
                onSearchClick = { vm.searchGames() }
            )
            Text(
                modifier = Modifier.padding(1.dp, bottom = 16.dp),
                text = "Juegos en tendencia",
                style = MaterialTheme.typography.titleLarge,
                color = White,
            )

            if (vm.uiState.gamesList.isEmpty()) {
                Text(
                    text = "Juegos no encontrados...",
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.align(Alignment.CenterHorizontally).padding(top = 16.dp)
                )
            } else {
                // Si hay juegos en la lista, se muestran
                GamesUIList(vm.uiState.gamesList, Modifier.fillMaxSize(),
                    onClick = {
                            id -> Log.d("test",id.toString())
                        navController.navigate(Screens.GamesVaultJuegoDetail.route + "/${id}")
                    })}

        }
    }


}


