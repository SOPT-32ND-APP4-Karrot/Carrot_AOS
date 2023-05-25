package com.sumin.android.carrot_aos.presentation.review

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
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
    }
}