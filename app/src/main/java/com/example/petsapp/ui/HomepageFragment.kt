package com.example.petsapp.ui

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.petsapp.chat_pusher.App
import com.example.petsapp.R
import com.example.petsapp.domain.PetProfile
import com.example.petsapp.domain.SimpleAdapterPet


class HomepageFragment : Fragment(R.layout.homepage) {
    //private val profileAdapter = PetprofileAdapater(::onChatClick)
    private lateinit var profilePet: RecyclerView
    private lateinit var chatBtn: Button
    private lateinit var calendarBtn : Button
    private lateinit var petBtn : Button
    private lateinit var adapter: SimpleAdapterPet

    private val  viewModel: VertebrateViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initVariables(view)
        onclickListen()
        viewModel.getDatabase.observe(viewLifecycleOwner){ test ->
        //    profileAdapter.updatePetProfile(test)
        }
    }
    private fun initVariables(view: View){
        chatBtn    = view.findViewById(R.id.button_chat)
        calendarBtn = view.findViewById(R.id.btn_calendar)
        petBtn     = view.findViewById(R.id.btn_add_pet)
        profilePet = view.findViewById(R.id.rv_pet_profiles)
        profilePet.layoutManager = LinearLayoutManager(requireContext())
        adapter = SimpleAdapterPet(requireContext())
        profilePet.adapter = adapter

        adapter.addToList(PetProfile("Ottis"))
        adapter.addToList(PetProfile("aaaOttis"))

        (activity as AppCompatActivity).supportActionBar?.title = "Hello, ${App.user}"
    }
    private fun onclickListen(){
        chatBtn.setOnClickListener{
            onChatClick()
        }
        calendarBtn.setOnClickListener{
            onCalendarClick()
        }
        petBtn.setOnClickListener {
            onAddClick()
        }
    }

    private fun onChatClick(){
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