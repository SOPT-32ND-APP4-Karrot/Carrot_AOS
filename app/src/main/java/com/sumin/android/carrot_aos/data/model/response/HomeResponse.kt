package com.sumin.android.carrot_aos.data.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HomeResponse(
    @SerialName("status")
    val status: Int,
    @SerialName("message")
    val message: String,
    @SerialName("data")
    val data: List<HomeData>,
) {
    @Serializable
    data class HomeData(
        @SerialName("saleId")
        val saleId: Int,
        @SerialName("title")
        val title: String,
        @SerialName("saleImgUrl")
        val saleImgUrl: String,
        @SerialName("location")
        val location: String,
        @SerialName("time")
        val time: String,
        @SerialName("isUpdated")
        val isUpdated: Boolean,
        @SerialName("price")
        val price: Int,
        @SerialName("isDiscount")
        val isDiscount: Boolean,
        @SerialName("likeCount")
        val likeCount: Int,
        @SerialName("isCheckLike")
        val isCheckLike: Boolean
    )
}
