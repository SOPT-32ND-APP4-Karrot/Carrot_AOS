package com.sumin.android.carrot_aos.data.model.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ReviewRequest(
    @SerialName("reviewId")
    val reviewId: Long,
)