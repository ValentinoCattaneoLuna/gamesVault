package com.example.gamesvault.ui.screens.gamesvaultHome

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.gamesvault.ui.commons.GamesUIList
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun GamesVaultHome(
    vm: GamesVaultHomeViewModel = viewModel(),
    modifier: Modifier = Modifier){
    
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)){
        Text(
            text = "Juegos en tendencia",
            style = MaterialTheme.typography.titleLarge
        )

        GamesUIList(vm.uiState.gamesList, Modifier.fillMaxSize())
    }

}


