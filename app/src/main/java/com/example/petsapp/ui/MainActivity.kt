package com.example.petsapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.petsapp.R
import com.example.petsapp.domain.PetProfile
import com.example.petsapp.domain.PetprofileAdapater

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val petProfileRV =
        findViewById<RecyclerView>(R.id.rv_pet_profiles)
        petProfileRV.layoutManager =LinearLayoutManager(this)
        petProfileRV.setHasFixedSize(true)

        val adapter = PetprofileAdapater()
        petProfileRV.adapter = adapter

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
}