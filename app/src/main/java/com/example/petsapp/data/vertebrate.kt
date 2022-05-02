package com.example.petsapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Vertebrate(
    @PrimaryKey(autoGenerate = true) val id: Int
)
