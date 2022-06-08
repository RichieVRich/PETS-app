package com.example.petsapp.calendar

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.petsapp.R


const val TAG = "CA: "
class CalendarAdapter (private val context: Context):
   RecyclerView.Adapter<CalendarViewHolder>()
   {
      private val daysOfMonth: ArrayList<String> = ArrayList()

      override fun getItemCount() = daysOfMonth.size

      fun addDays(text: ArrayList<String>){
         Log.d(TAG,"Add a day")
            daysOfMonth.addAll(text)

         notifyDataSetChanged()
      }
      fun deleteDays(text: ArrayList<String>){
         daysOfMonth.clear()
         notifyDataSetChanged()
      }

      override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CalendarViewHolder {
         val view = LayoutInflater.from(context)
            .inflate(R.layout.calendar_cell, parent,false)
         view.layoutParams.height =  (parent.height * 0.16).toInt()
         return CalendarViewHolder(view)
      }

      override fun onBindViewHolder(holder: CalendarViewHolder, position: Int) {
         holder.bind(daysOfMonth[position])
      }


}
 class CalendarViewHolder(view: View): RecyclerView.ViewHolder(view){
    var dayOfMonth: TextView = view.findViewById(R.id.cellDayText)
    init{
       view.setOnClickListener{
          Log.d("CA", "$dayOfMonth")
       }
    }
    fun bind(daysOfMonth: String){
       dayOfMonth.text = daysOfMonth

   }
}