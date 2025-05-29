package com.example.gamesvault.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

//@Database(entities = [JuegoSummaryLocal::class],version = 1)
//abstract class JuegosDatabase : RoomDatabase() {
//
//    abstract fun juegosDao(): IJuegosDao
//
//    companion object{
//
//        @Volatile
//        private var _instance: JuegosDatabase? = null
//
//
//        fun createInstance(contetx: Context): JuegosDatabase = _instance ?: synchronized(this) {
//            _instance ?: buildDatabase(contetx)
//        }
//
//        fun getInstance(): JuegosDatabase {
//            return _instance!!
//        }
//
//        private fun buildDatabase(context : Context): JuegosDatabase = Room.databaseBuilder(context,
//            JuegosDatabase::class.java, "Juegos_Database")
//            .fallbackToDestructiveMigration()
//            .build()
//
//        suspend fun clean() = coroutineScope {
//            launch(Dispatchers.IO) {
//                getInstance().clearAllTables()
//            }
//        }
//
//    }
//
//
//}