package com.example.petsapp.data

import android.app.Application

class App:Application() {
    companion object{
        lateinit var user: String
    }
}