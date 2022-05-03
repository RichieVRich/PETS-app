package com.example.petsapp.domain

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.petsapp.R

class PetprofileAdapater (): RecyclerView.Adapter<PetprofileAdapater.ViewHolder>(){
    val petProfiles: MutableList<PetProfile> = mutableListOf()

    override fun getItemCount() = petProfiles.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.petprofile_box,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(petProfiles[position])
    }
    // Add Function
    fun addPetProfile(petprofile: PetProfile){
       petProfiles.add(0, petprofile)
        notifyItemInserted(0)
    }
    // Delete Function
    fun deletePetProfile(position: Int){
        petProfiles.removeAt(position)
        notifyItemRemoved(position)
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        private val petProfileTV: TextView = view.findViewById(R.id.petprofile_text_tv)
        private val petProfI2TV: TextView = view.findViewById(R.id.petprofile_for_int_text_tv)

        private var currentPetProfile: PetProfile? = null


        fun bind( petprofile: PetProfile){
            currentPetProfile = petprofile
            petProfileTV.text = petprofile.text
            petProfI2TV.text =  petprofile.number.toString()
        }
    }


}