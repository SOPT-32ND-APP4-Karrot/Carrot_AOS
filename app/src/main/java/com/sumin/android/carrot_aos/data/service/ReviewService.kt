package com.sumin.android.carrot_aos.data.service

import com.sumin.android.carrot_aos.data.model.request.ReviewRequest
import com.sumin.android.carrot_aos.data.model.response.ReviewResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ReviewService {
    @GET(" /review/{reviewId}")
    fun connectReviewOnline(
        @Path("reviewId") reviewId: Long,
        @Query("request") request: ReviewRequest,
    ): Call<ReviewResponse>
}