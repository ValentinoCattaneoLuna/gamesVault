package com.example.gamesvault.domain

import com.example.gamesvault.data.Usuario

interface IUserRepository {
    suspend fun fetchUser() :Usuario
    suspend fun addFavorite(id:Int)
    suspend fun removeFavorite(id: Int)
    suspend fun getFavorites(): List<Int>
}