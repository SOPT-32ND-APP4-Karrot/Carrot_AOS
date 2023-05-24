package com.sumin.android.carrot_aos.data.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ChatResponse(
    @SerialName("status")
    val status: Int,
    @SerialName("message")
    val message: String,
    @SerialName("data")
    val data: ChatResponseData,
) {
    @Serializable
    data class ChatResponseData(
        @SerialName("chatRoomId")
        val chatRoomId: Long,
        @SerialName("chatMessageList")
        val chatMessageList: List<ChatMessage>,
        @SerialName("sale")
        val sale: Sale,
        @SerialName("seller")
        val seller: Seller,
        @SerialName("reviewId")
        val reviewId: Long
    )

    @Serializable
    data class ChatMessage(
        @SerialName("chatMessageId")
        val chatMessageId: Int,
        @SerialName("content")
        val content: String,
        @SerialName("hasKeyword")
        val hasKeyword: Boolean,
        @SerialName("time")
        val time: String,
        @SerialName("writer")
        val writer: Writer,
    )

    @Serializable
    data class Writer(
        @SerialName("userId")
        val userId: Long,
        @SerialName("nickname")
        val nickname: String,
        @SerialName("profileImgUrl")
        val profileImgUrl: String,
    )

    @Serializable
    data class Sale(
        @SerialName("saleId")
        val saleId: Long,
        @SerialName("title")
        val title: String,
        @SerialName("saleImgUrl")
        val saleImgUrl: String,
        @SerialName("price")
        val price: Int,
        @SerialName("isSuggest")
        val isSuggest: Boolean,
        @SerialName("status")
        val status: String
    )

    @Serializable
    data class Seller(
        @SerialName("userId")
        val userId: Long,
        @SerialName("nickname")
        val nickname: String,
        @SerialName("profileImgUrl")
        val profileImgUrl: String,
        @SerialName("phone")
        val phone: String,
    )
}
