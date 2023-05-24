package com.sumin.android.carrot_aos.data.model.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ChatRequest(
    @SerialName("chatRoomId")
    val chatRoomId: Long,
)