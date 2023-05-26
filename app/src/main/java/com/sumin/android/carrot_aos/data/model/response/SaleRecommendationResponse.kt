package com.sumin.android.carrot_aos.data.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SaleRecommendationResponse(
    @SerialName("data")
    val `data`: List<Data>,
    @SerialName("message")
    val message: String,
    @SerialName("status")
    val status: Int
) {
    @Serializable
    data class Data(
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