package com.example.petsapp.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "Verte")
data class Vertebrate(
    @PrimaryKey(autoGenerate = true) val id: Int,
     val name: String?,
     val text: String?,
    var number: Int?
) : Serializable
