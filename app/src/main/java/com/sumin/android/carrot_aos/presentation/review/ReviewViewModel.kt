package com.sumin.android.carrot_aos.presentation.review

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sumin.android.carrot_aos.data.entity.ServicePool
import com.sumin.android.carrot_aos.data.model.request.ReviewRequest
import com.sumin.android.carrot_aos.data.model.response.ReviewResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ReviewViewModel : ViewModel() {
    private val _reviewResult: MutableLiveData<ReviewResponse> = MutableLiveData()
    val reviewResult: LiveData<ReviewResponse> = _reviewResult
    private val reviewService = ServicePool.reviewService

    fun connectReviewOnline(reviewId: Long) {
        reviewService.connectReviewOnline(reviewId = reviewId, request = ReviewRequest(reviewId))
            .enqueue(object : Callback<ReviewResponse> {
                override fun onResponse(
                    call: Call<ReviewResponse>,
                    response: Response<ReviewResponse>
                ) {
                    if (response.isSuccessful) {
                        _reviewResult.value = response.body()
                    }
                }

                override fun onFailure(call: Call<ReviewResponse>, t: Throwable) {

                }

            })
    }
}