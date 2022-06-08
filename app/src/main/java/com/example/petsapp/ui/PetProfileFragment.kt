package com.example.petsapp.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.SimpleAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.preference.PreferenceFragmentCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.petsapp.R
import com.example.petsapp.domain.PetProfile
import com.example.petsapp.domain.SimpleAdapterPet

const private val TAG = "PetProfileF"
class PetProfileFragment  : Fragment(R.layout.activity_pet_profile){
    lateinit var nameEV: EditText
    lateinit var ageEV: EditText
    lateinit var addPetBtn: Button
    lateinit var petProfileRecyclerView: RecyclerView
    lateinit var simpleAdapter: SimpleAdapterPet

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initVariables(view)
        addPetBtn.setOnClickListener {
            setElement()
        }
    }
    private fun initVariables(view: View){
        nameEV = view.findViewById(R.id.petProfileName_ev)
        ageEV = view.findViewById(R.id.petProfileAge_ev)
        addPetBtn = view.findViewById(R.id.petProfileAdd_btn)
        //petProfileRecyclerView = view.findViewById(R.id.rv_pet_profiles)
    //    petProfileRecyclerView.layoutManager = GridLayoutManager(requireContext(),1)
        simpleAdapter = SimpleAdapterPet(requireContext())
    //    petProfileRecyclerView.adapter = simpleAdapter
    }
    private fun setElement(){
        var test = PetProfile(nameEV.text.toString())
        val directions = PetProfileFragmentDirections.actionPetprofileFragmentToHomepageFragment()
        Log.d(TAG, "Set Element: $test")
        simpleAdapter.addToList(test)
        findNavController().navigate(directions)

    }

}



    /*: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pet_profile)
        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.species_entries,
            android.R.layout.simple_spinner_item
        )

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item)
    }
}*/