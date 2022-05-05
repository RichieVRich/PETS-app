package com.example.petsapp.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.petsapp.data.AppDatabase
import com.example.petsapp.data.Vertebrate
import com.example.petsapp.data.VertebrateRepository
import kotlinx.coroutines.launch

class VertebrateViewModel (application: Application): AndroidViewModel (application){

    private val repository = VertebrateRepository(
        AppDatabase.getInstance(application).vertebrateDao()
    )

    val getDatabase  = repository.getAllCommand().asLiveData()

    fun addCommand(vertebrate: Vertebrate){
        viewModelScope.launch {
            repository.insertCommand(vertebrate)
        }
    }
    fun removeCommand(vertebrate: Vertebrate){
        viewModelScope.launch {
            viewModelScope.launch {
                repository.removeCommand(vertebrate)
            }
        }
    }
}