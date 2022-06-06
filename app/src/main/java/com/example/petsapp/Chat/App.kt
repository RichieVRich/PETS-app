package com.example.petsapp.Chat

import android.app.Application

class App:Application() {
    companion object{
         var user: String? = null
    }
    init{
        if(user == null) user = String()
    }
}