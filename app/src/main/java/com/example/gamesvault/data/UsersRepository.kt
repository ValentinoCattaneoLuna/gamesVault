package com.example.gamesvault.data

import com.example.gamesvault.domain.IUserRepository

class UsersRepository(
    val usersDataSource: UsersDataSource = UsersDataSource())
    : IUserRepository{

    override
    suspend fun fetchUser() :Usuario{
        return usersDataSource.getUser()
    }

    override
    suspend fun addFavorite(id:Int){
        return usersDataSource.agregarFavorito(id)
    }

    override
    suspend fun removeFavorite(id: Int){
        return usersDataSource.eliminarFavorito(id)
    }
}