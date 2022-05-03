package com.example.petsapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.petsapp.R
import com.example.petsapp.domain.PetProfile
import com.example.petsapp.domain.PetprofileAdapater
import com.example.petsapp.ui.chatwindow as chatwindow1
import com.example.petsapp.ui.PetProfile as PetProfile1

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val chatButton : Button = findViewById(R.id.button_chat)
        val calendarBtn: Button = findViewById(R.id.btn_calendar)
        val petBtn: Button = findViewById(R.id.btn_add_pet)

        val petProfileRV =
        findViewById<RecyclerView>(R.id.rv_pet_profiles)
        petProfileRV.layoutManager =LinearLayoutManager(this)
        petProfileRV.setHasFixedSize(true)

        val adapter = PetprofileAdapater()
        petProfileRV.adapter = adapter

        chatButton.setOnClickListener{
            onChatClick()
        }
        calendarBtn.setOnClickListener{
            onCalendarClick()
        }
        petBtn.setOnClickListener {
            onAddClick()
        }

        adapter.addPetProfile(PetProfile("Sally",11))
        adapter.addPetProfile(PetProfile("Sally",11))
        adapter.addPetProfile(PetProfile("Sally",11))
        adapter.addPetProfile(PetProfile("Sally",11))
        adapter.addPetProfile(PetProfile("Sally",11))
        adapter.addPetProfile(PetProfile("Sally",11))
        adapter.addPetProfile(PetProfile("Sally",11))
        adapter.addPetProfile(PetProfile("Sally",11))
        adapter.addPetProfile(PetProfile("Sally",11))
        adapter.addPetProfile(PetProfile("Sally",11))
        adapter.addPetProfile(PetProfile("Sally",11))
        adapter.addPetProfile(PetProfile("Sally",11))

    }

    private fun onChatClick(){
        val intent = Intent(this, chatwindow1::class.java)
        startActivity(intent)
    }
    private fun onCalendarClick(){
        val intent = Intent(this, Calendar::class.java)
        startActivity(intent)
    }
    private fun onAddClick(){
        val intent = Intent(this, PetProfile1::class.java)
        startActivity(intent)
    }
}