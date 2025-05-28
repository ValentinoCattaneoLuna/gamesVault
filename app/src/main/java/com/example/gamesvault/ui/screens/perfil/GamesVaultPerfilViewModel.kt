package com.example.gamesvault.ui.screens.perfil

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth

class GamesVaultPerfilViewModel : ViewModel() {


    var uiState by mutableStateOf(GamesVaultPerfilState())
        private set
    init {
        getUserData()
    }


    private fun getUserData(){
        uiState = uiState.copy(
            username = FirebaseAuth.getInstance().currentUser?.displayName ?: "usuario desconocido",
            email = FirebaseAuth.getInstance().currentUser?.email ?: "correo@desconocido.com",
            foto_url = FirebaseAuth.getInstance().currentUser?.photoUrl.toString() ?: "",
            creacion_cuenta = FirebaseAuth.getInstance().currentUser?.metadata?.creationTimestamp ?: 0L ,
            ultimo_login = FirebaseAuth.getInstance().currentUser?.metadata?.lastSignInTimestamp ?: 0L
        )
    }


}