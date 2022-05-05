package com.example.petsapp.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

// Vertebrate Data Access Object

@Dao
interface VertebrateDao {
    @Insert
    suspend fun insert( vertebrate: Vertebrate )
    @Update
    suspend fun update(vertebrate: Vertebrate)
    @Delete
    suspend fun delete(vertebrate: Vertebrate)

   @Query("SELECT * FROM Verte")
    fun getall() : Flow<List<Vertebrate>>
}