package com.example.petsapp.domain

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.petsapp.R

const val TAG = "SimpleA: "
class SimpleAdapterPet (private val context: Context):
    RecyclerView.Adapter<SimpleViewHolder>() {

    private val petList: ArrayList<PetProfile> = ArrayList()
    override fun getItemCount() = petList.size

    fun addToList(item: PetProfile){
        Log.d(TAG,"add an item $item")
        petList.add(item)
        Log.d(TAG," the list $petList")
    }
    fun deleteFromList(item: Int){
        petList.removeAt(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SimpleViewHolder {
        val view = LayoutInflater.from(context)
            .inflate(R.layout.petprofilecell,parent,false)
        view.layoutParams.height =  (parent.height * 0.16).toInt()
        return SimpleViewHolder(view)
    }

    override fun onBindViewHolder(holder: SimpleViewHolder, position: Int) {
        Log.d(TAG,"${petList[position]}")
        holder.bind(petList[position])
    }
}

class SimpleViewHolder(view: View): RecyclerView.ViewHolder(view){
    var nameTV: TextView = view.findViewById(R.id.petprofile_name_cell)
    init{
        Log.d(TAG,"$nameTV")
    }
    //var ageTV: TextView = view.findViewById(R.id.petprofile_age_cell)
    fun bind(petProfile: PetProfile){
        nameTV.text = petProfile.name

      //  ageTV.text = petProfile.age
    }
}