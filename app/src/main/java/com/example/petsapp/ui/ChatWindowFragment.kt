package com.example.petsapp.ui

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.petsapp.Chat.App
import com.example.petsapp.Chat.ChatService
import com.example.petsapp.Chat.Message
import com.example.petsapp.Chat.MessageAdapter
import com.example.petsapp.R
import com.pusher.client.Pusher
import com.pusher.client.PusherOptions
import org.json.JSONObject
import retrofit2.Call
import java.util.*
import retrofit2.Callback
import retrofit2.Response

private const val TAG = "ChatActivity"
private const val PUSHER_APP_ID = "1410249"
private const val PUSHER_APP_KEY = "9ab7dccd3f9b7bea3dde"
private const val PUSHER_APP_SECRET = "c4847aac1939d99919d6"
private const val PUSHER_APP_CLUSTER = "us3"

class ChatWindowFragment : Fragment(R.layout.chatwindow) {
    private lateinit var messageList: RecyclerView
    private lateinit var adapter: MessageAdapter
    private lateinit var btnSend: Button
    private lateinit var txtMessage: EditText

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity).supportActionBar?.title = "${App.user}"
        messageList = view.findViewById(R.id.messageList)
        btnSend = view.findViewById(R.id.btnSend)
        txtMessage = view.findViewById(R.id.textMessage)

        messageList.layoutManager = LinearLayoutManager(requireContext())
        adapter = MessageAdapter(requireContext())
        messageList.adapter = adapter
        val test: String = App.user.toString()
        btnSend.setOnClickListener{
            if(txtMessage.text.isNotEmpty()){
                val message = Message(
                    test,
                    txtMessage.text.toString(),
                    Calendar.getInstance().timeInMillis
                )
                Log.d(TAG, message.toString())
                val call = ChatService.create().postMessage(message)
                Log.d(TAG, call.toString())
                call.enqueue(object : Callback<Void> {
                    override fun onResponse(call: Call<Void>, response: Response<Void>){
                        resetInput()
                        if (!response.isSuccessful){
                            Log.e(TAG, response.code().toString())
                            Log.e(TAG, "Failure")
                            Toast.makeText(activity, "Response was not Successful", Toast.LENGTH_SHORT).show()
                        }
                    }

                    override fun onFailure(call: Call<Void>, t: Throwable) {
                        resetInput()
                        Log.e(TAG, t.toString())
                        Toast.makeText(activity, "Error when calling the service", Toast.LENGTH_SHORT).show()
                    }
                })
            }else{
                Toast.makeText(activity, "Message should not be empty", Toast.LENGTH_SHORT).show()
            }
        }
        setupPusher()


    }
    private fun setupPusher(){
        val options = PusherOptions()
        options.setCluster(PUSHER_APP_CLUSTER)

        val pusher = Pusher(PUSHER_APP_KEY, options)
        val channel = pusher.subscribe("chat")

        channel.bind("new_message"){ channelName, eventName, data ->
            val jsonObject = JSONObject(data)

            val message = Message(
                jsonObject["user"].toString(),
                jsonObject["message"].toString(),
                jsonObject["time"].toString().toLong()
            )

            activity?.runOnUiThread {
                adapter.addMessage(message)
                messageList.scrollToPosition(adapter.itemCount - 1)
            }
        }
        pusher.connect()


    }
    private fun resetInput() {
        // Clean the text box
        txtMessage.text.clear()


        val inputManager =
            activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputManager.hideSoftInputFromWindow(
            activity?.currentFocus!!.windowToken, InputMethodManager.HIDE_NOT_ALWAYS
        )


    }


}