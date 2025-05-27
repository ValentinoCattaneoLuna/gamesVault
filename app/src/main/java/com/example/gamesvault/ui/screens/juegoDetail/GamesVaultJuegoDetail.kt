package com.example.gamesvault.ui.screens.juegoDetail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.gamesvault.ui.commons.GameCardDetail

@Composable
fun GamesVaultJuegoDetail(
    juegoId: Int,
    modifier: Modifier = Modifier,
    vm: GamesVaultJuegoDetailViewModel = viewModel()
){

    vm.setJuegoId(juegoId)

    if (vm.uiState.juegoDetail.id == 0){
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
            CircularProgressIndicator()
        }
    }
    else{
        GameCardDetail(vm.uiState.juegoDetail)
    }

}