package com.sumin.android.carrot_aos.data.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SaleUserIdResponse(
    @SerialName("data")
    val `data`: Data,
    @SerialName("message")
    val message: String,
    @SerialName("status")
    val status: Int
) {
    @Serializable
    data class Data(
        @SerialName("nickname")
        val nickname: String,
        @SerialName("saleList")
        val saleList: List<Sale>
    ) {
        @Serializable
        data class Sale(
            @SerialName("price")
            val price: Int,
            @SerialName("saleId")
            val saleId: Int,
            @SerialName("saleImgUrl")
            val saleImgUrl: String,
            @SerialName("title")
            val title: String
        )
    }
}