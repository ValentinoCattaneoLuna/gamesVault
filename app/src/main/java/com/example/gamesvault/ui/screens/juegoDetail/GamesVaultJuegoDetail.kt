package com.example.gamesvault.ui.screens.juegoDetail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.gamesvault.ui.commons.BarraDeNavegacion
import com.example.gamesvault.ui.commons.GameCardDetail


@Composable
fun GamesVaultJuegoDetail(
    juegoId: Int,
    navController: NavHostController,
    modifier: Modifier = Modifier,
    vm: GamesVaultJuegoDetailViewModel = viewModel()
) {
    vm.setJuegoId(juegoId)

    Scaffold(
        bottomBar = {
            BarraDeNavegacion(navController = navController)
        },
        containerColor = androidx.compose.ui.graphics.Color(0xFF020817)
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentAlignment = Alignment.Center
        ) {
            if (vm.uiState.juegoDetail.id == 0) {
                CircularProgressIndicator()
            } else {
                GameCardDetail(vm.uiState.juegoDetail)
            }
        }
    }
}