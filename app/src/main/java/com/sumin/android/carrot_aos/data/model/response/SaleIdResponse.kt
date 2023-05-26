package com.sumin.android.carrot_aos.data.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SaleIdResponse(
    @SerialName("data")
    val `data`: Data,
    @SerialName("message")
    val message: String,
    @SerialName("status")
    val status: Int
) {
    @Serializable
    data class Data(
        @SerialName("chatRoomId")
        val chatRoomId: Int,
        @SerialName("sale")
        val sale: Sale,
        @SerialName("user")
        val user: User
    ) {
        @Serializable
        data class Sale(
            @SerialName("category")
            val category: String,
            @SerialName("description")
            val description: String,
            @SerialName("isCheckLike")
            val isCheckLike: Boolean,
            @SerialName("isUpdated")
            val isUpdated: Boolean,
            @SerialName("likeCount")
            val likeCount: Int,
            @SerialName("price")
            val price: Int,
            @SerialName("saleId")
            val saleId: Int,
            @SerialName("saleImgUrl")
            val saleImgUrl: String,
            @SerialName("time")
            val time: String,
            @SerialName("title")
            val title: String,
            @SerialName("viewCount")
            val viewCount: Int
        )
        @Serializable
        data class User(
            @SerialName("location")
            val location: String,
            @SerialName("nickname")
            val nickname: String,
            @SerialName("profileImgUrl")
            val profileImgUrl: String,
            @SerialName("temperature")
            val temperature: Double,
            @SerialName("userId")
            val userId: Int
        )
    }
}