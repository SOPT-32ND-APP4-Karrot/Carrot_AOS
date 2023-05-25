package com.sumin.android.carrot_aos.presentation.review

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.sumin.android.carrot_aos.data.model.response.ReviewResponse
import com.sumin.android.carrot_aos.databinding.ActivityReviewBinding

class ReviewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityReviewBinding
    private val viewModel by viewModels<ReviewViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReviewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //viewModel.connectReviewOnline(intent.getStringExtra("reviewId")?.toLong() ?: 0)
        viewModel.connectReviewOnline(2)
        setReviewResultObserver()
    }

    private fun setReviewResultObserver() {
        viewModel.reviewResult.observe(this) { reviewResponse ->
            connectReviewAdapter(reviewResponse)
        }
    }

    private fun connectReviewAdapter(reviewResponse: ReviewResponse?) {
        val reviewAdapter = ReviewAdapter(this)
        val reviewList = mutableListOf<ReviewResponse.Review>()

        if (reviewResponse != null) {
            reviewAdapter.setSellerInfo(reviewResponse.data.receiverReview.writer)
            with(reviewResponse.data) {
                reviewList.add(senderReview)
                reviewList.add(receiverReview)
                reviewList.add(receiverReview)
            }
            reviewAdapter.submitList(reviewList)
            binding.rvReviewCard.adapter = reviewAdapter
        }
    }
}