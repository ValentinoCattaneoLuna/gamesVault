package com.example.gamesvault.data

import androidx.compose.material.ripple.rememberRipple
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.gson.Gson
import kotlinx.coroutines.tasks.await


class UsersDataSource(){

    val db = FirebaseFirestore.getInstance()

    var email : String? = null

    suspend fun getUser(): Usuario{

        if(email == null){
            email = FirebaseAuth.getInstance().currentUser?.email.toString()
        }

        var response = db.collection("Usuarios").document(email.toString()).get().await()

        if (response == null){
            var usuario  = Usuario(email!!)
            db.collection("Usuarios").document(email!!).set(usuario)
            return usuario
        }else{
             return response.toObject(Usuario::class.java)!!
        }

    }

    suspend fun getFavorites(): List<Int> {
        val usuario = getUser()
        return usuario.favoritos
    }
    suspend fun agregarFavorito(id: Int){
       var usuario =  getUser()
        usuario.favoritos.add(id)
        usuario.estadisticas = usuario.favoritos.count()
        FirebaseFirestore.getInstance().collection("Usuarios").document(email.toString()).set(usuario)
    }


    suspend fun eliminarFavorito(id: Int){
        var usuario =  getUser()
        usuario.favoritos.remove(id)
        usuario.estadisticas = usuario.favoritos.count()
        FirebaseFirestore.getInstance().collection("Usuarios").document(email.toString()).set(usuario)
    }
}