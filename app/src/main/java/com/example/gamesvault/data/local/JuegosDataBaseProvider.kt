package com.example.gamesvault.data.local
import android.content.Context

object JuegosDataBaseProvider {
    lateinit var dbLocal: JuegosDatabase
        private set

    fun createDatabase(context: Context) {
        dbLocal= JuegosDatabase.getInstance(context)
    }
}