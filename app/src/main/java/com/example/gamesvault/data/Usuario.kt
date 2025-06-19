package com.example.gamesvault.data

data class Usuario (
    val email: String = "",
    val favoritos: MutableList<Int> = mutableListOf(),
    var estadisticas: Int = 0
)