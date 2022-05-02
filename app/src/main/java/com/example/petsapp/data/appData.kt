package com.example.petsapp.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


const val DATABASE_NAME = "pets-db"

@Database(entities = [Vertebrate::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getvertebratedao() : vertebrate_dao

    companion object {
        @Volatile
        private var instance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also {
                    instance = it
                }
            }
        }


        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(context, AppDatabase::class.java, DATABASE_NAME)
                .createFromAsset("test.sql")
                .build()

    }
}