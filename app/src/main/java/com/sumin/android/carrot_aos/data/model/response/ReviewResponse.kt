package com.sumin.android.carrot_aos.data.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ReviewResponse(
    @SerialName("status")
    val status: Int,
    @SerialName("message")
    val message: String,
    @SerialName("data")
    val data: ReviewResponseData,
) {
    @Serializable
    data class ReviewResponseData(
        @SerialName("reviewId")
        val reviewId: Long,
        @SerialName("senderReview")
        val senderReview: Review,
        @SerialName("receiverReview")
        val receiverReview: Review,
    )

    @Serializable
    data class Review(
        @SerialName("reviewContentId")
        val reviewContentId: Long,
        @SerialName("content")
        val content: List<String>,
        @SerialName("writer")
        val writer: Writer,
    )

    @Serializable
    data class Writer(
        @SerialName("userId")
        val userId: Long,
        @SerialName("nickname")
        val nickname: String,
    )
}
