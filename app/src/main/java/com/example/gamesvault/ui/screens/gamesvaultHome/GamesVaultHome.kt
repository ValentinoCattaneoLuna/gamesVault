package com.example.gamesvault.ui.screens.gamesvaultHome

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

        Row (
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ){
            TextField(
                value = vm.uiState.searchQuery,
                modifier = Modifier.weight(1f),
                label = {Text("Buscar juegos...")},
                singleLine = true,
                onValueChange = { vm.searchChange(it) }
            )
            Spacer(modifier = Modifier.width(8.dp))
            Button(
                onClick = { vm.searchGames()}
            ) {
                Text("Buscar")
            }
        }

        if (vm.uiState.gamesList.isEmpty()) {
            Text(
                text = "Juegos no encontrados...",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.align(Alignment.CenterHorizontally).padding(top = 16.dp)
            )
        } else {
            // Si hay juegos en la lista, se muestran
            GamesUIList(vm.uiState.gamesList, Modifier.fillMaxSize())
        }

    }

}


