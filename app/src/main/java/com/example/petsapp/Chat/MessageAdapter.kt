package com.example.petsapp.Chat

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.petsapp.R

private const val VIEW_TYPE_MY_MESSAGE = 1
private const val VIEW_TYPE_OTHER_MESSAGE = 2
class MessageAdapter(private val context: Context):
    RecyclerView.Adapter<MessageViewHolder>() {
    private val messages: ArrayList<Message> = ArrayList()
    // Method to add new messages to the Array List
    fun addMessage(message: Message){
        messages.add(message)
        notifyDataSetChanged()
    }
    // Method to get count
    override fun getItemCount(): Int {
        return messages.size
    }
    // Return Either Reciver or Sender Username
    override fun getItemViewType(position: Int): Int {
        val message = messages.get(position)
        return if(App.user == message.user) {
            VIEW_TYPE_MY_MESSAGE
        }else{
            VIEW_TYPE_OTHER_MESSAGE
        }
    }
    // Inflate Appropriate Layout
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        return if(viewType == VIEW_TYPE_MY_MESSAGE){
            MyMessageViewHolder(
                LayoutInflater.from(context).inflate(R.layout.my_message_layout, parent, false)
            )
        }else{
            OtherMessageViewHolder(LayoutInflater.from(context).inflate(R.layout.their_message_layout,parent,false))
        }
    }
    // Bind MessageViewHolder when it received as an argument

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        val message = messages.get(position)
        holder?.bind(message)
    }
    // Define Two subclasses that represent the views defined in the layouts
    // DateUtils fromMillisToTimeString is user defined object
    inner class MyMessageViewHolder(view: View) : MessageViewHolder(view) {
        private var messageText: TextView = view.findViewById(R.id.txtMyMessage)
        private var timeText: TextView = view.findViewById(R.id.txtMyMessageTime)

        override fun bind(message: Message) {
            messageText.text = message.message
            timeText.text = DateUtils.fromMillisToTimeString(message.time);
        }
    }

    inner class OtherMessageViewHolder(view: View) : MessageViewHolder(view) {
        private var messageText: TextView = view.findViewById(R.id.txtOtherMessage)
        private var userText: TextView = view.findViewById(R.id.txtOtherUser)
        private var timeText: TextView = view.findViewById(R.id.txtOtherMessageTime)

        override fun bind(message: Message){
            messageText.text = message.message
            userText.text = message.user
            timeText.text = DateUtils.fromMillisToTimeString(message.time)
        }
    }
}

open class MessageViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    open fun bind(message: Message) {}
}