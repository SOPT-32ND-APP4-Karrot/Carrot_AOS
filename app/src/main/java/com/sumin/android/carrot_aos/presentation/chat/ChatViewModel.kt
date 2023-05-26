package com.sumin.android.carrot_aos.presentation.chat

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sumin.android.carrot_aos.data.model.request.ChatRequest
import com.sumin.android.carrot_aos.data.model.response.ChatResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ChatViewModel : ViewModel() {
    private val _chatResult: MutableLiveData<ChatResponse> = MutableLiveData()
    val chatResult: LiveData<ChatResponse> = _chatResult
    private val chatService = ServicePool.chatService
    val chatInput: MutableLiveData<String> = MutableLiveData()

    fun connectChatOnline(chatRoodId: Long) {
        chatService.connectChatOnline(
            chatRoomId = chatRoodId,
            request = ChatRequest(chatRoodId)
        ).enqueue(object : Callback<ChatResponse> {
            override fun onResponse(call: Call<ChatResponse>, response: Response<ChatResponse>) {
                if (response.isSuccessful) {
                    _chatResult.value = response.body()
                } else {

                }
            }

            override fun onFailure(call: Call<ChatResponse>, t: Throwable) {

            }

        })
    }
}