package com.sumin.android.carrot_aos.data.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SaleDefaultResponse (
    @SerialName("data")
    val data: Data,
    @SerialName("message")
    val message: String,
    @SerialName("status")
    val status: Int,
    @SerialName("success")
    val success: Boolean,
){
    @Serializable
    data class Data(
        val saleId: Int,
        val isCheckLike: Boolean,
        val likeCount: Int,
    )
}