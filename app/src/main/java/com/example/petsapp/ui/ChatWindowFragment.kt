package com.example.petsapp.ui

import android.os.Bundle
import android.os.Message
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.petsapp.R

private const val TAG = "ChatActivity"
private const val PUSHER_APP_ID = "1410249"
private const val PUSHER_APP_KEY = "9ab7dccd3f9b7bea3dde"
private const val PUSHER_APP_SECRET = "c4847aac1939d99919d6"
private const val PUSHER_APP_CLUSTER = "us3"

class ChatWindowFragment : Fragment(R.layout.chatwindow) {
    private lateinit var messageList: RecyclerView
    //private lateinit var adapter: MessageAdapter
    private lateinit var btnSend: Button
    private lateinit var txtMessage: EditText

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        messageList = view.findViewById(R.id.messageList)
        btnSend = view.findViewById(R.id.btnSend)
        txtMessage = view.findViewById(R.id.textMessage)


    }
}