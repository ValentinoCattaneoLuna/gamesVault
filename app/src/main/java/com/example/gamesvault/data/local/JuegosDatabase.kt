package com.example.gamesvault.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

@Database(
    entities = [JuegoDetailLocal::class],
    version = 1,
    exportSchema = false
)
abstract class JuegosDatabase : RoomDatabase() {
    abstract fun juegosDao(): IJuegosDao

    companion object {
        @Volatile
        private var instance: JuegosDatabase? = null

        fun getInstance(context: Context): JuegosDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context): JuegosDatabase {
            return Room.databaseBuilder(
                context.applicationContext,
                JuegosDatabase::class.java,
                "juegos.db"
            )
                .fallbackToDestructiveMigration()
                .build()
        }
    }
}