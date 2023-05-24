package com.sumin.android.carrot_aos.data.service

import com.sumin.android.carrot_aos.data.model.request.ChatRequest
import com.sumin.android.carrot_aos.data.model.response.ChatResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

interface ChatService {
    //@Header("Content-Type: application/json")
    @GET("/chat/{chatRoomId}")
    fun connectChatOnline(
        @Path("chatRoomId") chatRoomId: Long,
        @Query("request") request: ChatRequest,
    ): Call<ChatResponse>
}