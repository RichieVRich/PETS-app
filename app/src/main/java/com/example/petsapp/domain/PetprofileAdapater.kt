package com.example.petsapp.domain

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.petsapp.R
import com.example.petsapp.data.Vertebrate

class PetprofileAdapater (private val onPetProfileClick: (Vertebrate)-> Unit): RecyclerView.Adapter<PetprofileAdapater.PetProfileViewHolder>(){

    var petProfilesList = listOf<Vertebrate>()


    fun updatePetProfile(newPetProfile: List<Vertebrate>){
        petProfilesList = newPetProfile ?: listOf()
        notifyDataSetChanged()
    }

    override fun getItemCount() = petProfilesList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PetProfileViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.petprofile_box,parent,false)
        return PetProfileViewHolder(view, onPetProfileClick)
    }

    override fun onBindViewHolder(holder: PetProfileViewHolder, position: Int) {
        holder.bind(petProfilesList[position])
    }

    class PetProfileViewHolder(itemView: View, val onClick: (Vertebrate) -> Unit): RecyclerView.ViewHolder(itemView){
        private val petProfileTV: TextView = itemView.findViewById(R.id.petprofile_text_tv)
        private val petProfI2TV: TextView = itemView.findViewById(R.id.petprofile_for_int_text_tv)

        private var currentPetProfile: Vertebrate? = null

        init{
            itemView.setOnClickListener{
                currentPetProfile?.let(onClick)
            }
        }

        fun bind( petprofile: Vertebrate){
            currentPetProfile = petprofile
            petProfileTV.text = petprofile.text
            petProfI2TV.text =  petprofile.number.toString()
        }
    }


}