package com.example.petsapp.data

import androidx.room.*

// Vertebrate Data Access Object

@Dao
interface vertebrate_dao {
    @Insert
    fun inVerte( vertebrate: Vertebrate )
    @Update
    fun updateVerte(vertebrate: Vertebrate)
    @Delete
    fun deleteVerte(vertebrate: Vertebrate)

   // @Query("SELECT * FROM vertebrate")
    //fun retrieVerte() : Array<Vertebrate>
}