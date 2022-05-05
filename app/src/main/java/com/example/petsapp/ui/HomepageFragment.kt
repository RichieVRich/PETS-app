package com.example.petsapp.ui

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.petsapp.R
import com.example.petsapp.data.Vertebrate
import com.example.petsapp.domain.PetprofileAdapater


class HomepageFragment : Fragment(R.layout.homepage) {
    private val profileAdapter = PetprofileAdapater(::onChatClick)
    private lateinit var profilePet: RecyclerView

    private val  viewModel: VertebrateViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        profilePet = view.findViewById(R.id.rv_pet_profiles)
        profilePet.layoutManager = LinearLayoutManager(requireContext())
        profilePet.setHasFixedSize(true)
        profilePet.adapter = this.profileAdapter

        val chatBtn: Button = view.findViewById(R.id.button_chat)
        val calendarBtn : Button = view.findViewById(R.id.btn_calendar)
        val petBtn : Button = view.findViewById(R.id.btn_add_pet)
/*
        chatBtn.setOnClickListener{
            onChatClick()
        }*/
        calendarBtn.setOnClickListener{
            onCalendarClick()
        }
        petBtn.setOnClickListener {
            onAddClick()
        }
        viewModel.getDatabase.observe(viewLifecycleOwner){ test ->
            profileAdapter.updatePetProfile(test)
        }
        //adapter.addPetProfile(PetProfile("Sally",11))
    }

    private fun onChatClick(profile: Vertebrate){
        val directions = HomepageFragmentDirections.actionHomepageFragmentToChatwindowFragment()
        findNavController().navigate(directions)

    }

    private fun onCalendarClick(){
        val directions = HomepageFragmentDirections.actionHomepageFragmentToCalendarFragment()
        findNavController().navigate(directions)
    }
    private fun onAddClick(){
        val directions = HomepageFragmentDirections.actionHomepageFragmentToPetprofileFragment()
        findNavController().navigate(directions)
    }
}