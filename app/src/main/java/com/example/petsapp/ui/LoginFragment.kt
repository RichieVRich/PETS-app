package com.example.petsapp.ui

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.petsapp.chat_pusher.App
import com.example.petsapp.R

class LoginFragment : Fragment(R.layout.activity_login) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var btnLogin: Button = view.findViewById(R.id.btn_login)
        var username: TextView = view.findViewById(R.id.username_label)

        btnLogin.setOnClickListener{
            if (username.text.isNotEmpty()){
                val user = username.text.toString()

                App.user = user
                onLoginClick()

            }else{
                val text = "Username should not be empty"
                val duration = Toast.LENGTH_SHORT
                Toast.makeText(activity,text,duration).show()

            }
        }

    }
    private fun onLoginClick(){
        val directions = LoginFragmentDirections.actionLoginToHomepageFragment()
        findNavController().navigate(directions)
    }
}