package com.example.petsapp.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.petsapp.R
import com.example.petsapp.calendar.CalendarAdapter
import com.example.petsapp.data.Vertebrate
import java.time.LocalDate
import java.util.*
import java.util.Calendar.*
import kotlin.collections.ArrayList

private const val TAG = "CalendarFragment"

class CalendarFragment : Fragment(R.layout.calendar) {

    lateinit var monthYearText: TextView
    lateinit var calendarRecyclerView: RecyclerView
    lateinit var selectedDate: Calendar
    lateinit var previousBtn: TextView
    lateinit var nextBtn: TextView
    lateinit var calendarAdapter: CalendarAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

       initVariables(view)
        // Get an instance of Calendar
        setDisplayCalendar()
        // Functionality to "buttons"
        nextBtn.setOnClickListener{
            nextCalendar(selectedDate)
            setDisplayCalendar()
        }
        previousBtn.setOnClickListener {
            prevCalendar(selectedDate)
            setDisplayCalendar()
        }

    }
    private fun initVariables(view: View){
        monthYearText = view.findViewById(R.id.monthYearTV)
        calendarRecyclerView = view.findViewById(R.id.calendar_recycle)
        nextBtn = view.findViewById(R.id.month_navigation_next)
        previousBtn = view.findViewById(R.id.month_navigation_previous)
        selectedDate = getInstance()
        calendarRecyclerView.layoutManager = GridLayoutManager(requireContext(),7)
        calendarAdapter = CalendarAdapter(requireContext())
        calendarRecyclerView.adapter = calendarAdapter

    }

    private fun setDisplayCalendar(){
      val c: Calendar = selectedDate
        val month =  c.get(MONTH)
        val year =  c.get(Calendar.YEAR)
        val dom = c.get(Calendar.DAY_OF_WEEK)
        val month_name = c.getDisplayName(MONTH , LONG, Locale.US)
        val minDays = DAY_OF_WEEK_IN_MONTH
        c.set(year,month,1)
        val maxium: Int = c.getActualMaximum(DAY_OF_MONTH)// = c.getActualMaximum(month)


        //Next step format  M Y
        monthYearText.text = "${month_name} ${year}"


        var daysInMonth = daysInMonthArray(selectedDate)
        calendarAdapter.deleteDays(daysInMonth)
        Log.d(TAG, "Days in month checck\n$daysInMonth")
        calendarAdapter.addDays(daysInMonth)
    }

    private fun daysInMonthArray(collection: Calendar): (ArrayList<String>){
        val daysInMonthArray = ArrayList<String>()
        val month = collection.get(MONTH)
        val year = collection.get(YEAR)
        val maxium = collection.getActualMaximum(DAY_OF_MONTH)
        val max = collection.get(DAY_OF_WEEK_IN_MONTH)
        val date = 1

        val dayOfWeek = collection.get(Calendar.DAY_OF_WEEK) - 1
        Log.d(TAG,"\nMonth =  $month")
        Log.d(TAG,"MAx = $max")
        Log.d(TAG,"Year = $year")
        Log.d(TAG,"DofW = $dayOfWeek")
        Log.d(TAG,"Max Days = $maxium\n")
        //collection.get()

        for( i in 1..42){
            if( i <= dayOfWeek || i > maxium + dayOfWeek ){
                daysInMonthArray.add("")
            }else
                daysInMonthArray.add((i - dayOfWeek).toString())
        }
        return daysInMonthArray
    }



    private fun prevCalendar(c:Calendar){
        var month =  c.get(Calendar.MONTH)
        val year =  c.get(Calendar.YEAR)
        val dom = c.get(Calendar.DAY_OF_MONTH)

        month -=  1
        c.set( year, month , 1)
        val month_name = c.getDisplayName(MONTH , LONG, Locale.US)
        Log.d(TAG,"MonthName = $month_name")
    }

    private fun nextCalendar(c:Calendar){
        var month =  c.get(Calendar.MONTH)
        val year =  c.get(Calendar.YEAR)
        val dom = c.get(Calendar.DAY_OF_MONTH)
        month +=  1
        c.set( year, month , 1)
        val month_name = c.getDisplayName(MONTH , LONG, Locale.US)
        Log.d(TAG,"MonthName = $month_name")
    }

}