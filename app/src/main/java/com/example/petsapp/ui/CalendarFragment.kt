package com.example.petsapp.ui

import android.icu.util.Calendar
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import com.example.petsapp.R

class CalendarFragment : Fragment(R.layout.calendar) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var rightnow = Calendar.getInstance()

    }
}