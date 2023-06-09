package com.sumin.android.carrot_aos.presentation.sale

import SaleServicePool
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import coil.load
import com.sumin.android.carrot_aos.R
import com.sumin.android.carrot_aos.data.model.response.*
import com.sumin.android.carrot_aos.data.service.SaleIdService
import com.sumin.android.carrot_aos.data.model.response.SaleUserIdResponse
import com.sumin.android.carrot_aos.databinding.ActivitySaleBinding
import com.sumin.android.carrot_aos.presentation.base.BindingActivity
import com.sumin.android.carrot_aos.presentation.chat.ChatActivity
import com.sumin.android.carrot_aos.presentation.home.HomeActivity
import com.sumin.android.carrot_aos.presentation.home.HomeFragment
import com.sumin.android.carrot_aos.util.binding.BindingAdapter.loadImage
import com.sumin.android.carrot_aos.util.extension.changeTimeFormat
import retrofit2.Call
import retrofit2.Response

class SaleActivity : BindingActivity<ActivitySaleBinding>(R.layout.activity_sale) {
    private val SaleUserIdService = SaleServicePool.UserIdService
    private val RecommendationService = SaleServicePool.RecommendationService
    private val SaleIdService = SaleServicePool.SaleIdService
    private val HeartService = SaleServicePool.HeartService

    private var chatRoomId: Int = 0
    private var mannerTemperature: Double = 0.0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val saleUserIdAdapter = SaleUserIdAdapter()
        binding.rvUserid.adapter = saleUserIdAdapter


        SaleUserIdService.userid(1).enqueue(object : retrofit2.Callback<SaleUserIdResponse> {
            override fun onResponse(
                call: Call<SaleUserIdResponse>,
                response: Response<SaleUserIdResponse>,
            ) {
                if (response.isSuccessful) {
                    response.body()?.data?.saleList.let {
                        saleUserIdAdapter.submitList(it)
                    }
                }
            }

            override fun onFailure(call: Call<SaleUserIdResponse>, t: Throwable) {

            }

        })


        val saleRecommendationAdapter = SaleRecommendationAdapter()
        binding.rvRecommendation.adapter = saleRecommendationAdapter
        binding.rvRecommendation.layoutManager = GridLayoutManager(this, 2)


        RecommendationService.saleidrecommendation(4)
            .enqueue(object : retrofit2.Callback<SaleRecommendationResponse> {
                override fun onResponse(
                    call: Call<SaleRecommendationResponse>,
                    response: Response<SaleRecommendationResponse>,
                ) {
                    if (response.isSuccessful) {
                        response.body()?.data?.let {
                            saleRecommendationAdapter.submitList(it)
                        }
                    }
                }

                override fun onFailure(call: Call<SaleRecommendationResponse>, t: Throwable) {

                }

            })



        SaleIdService.saleid(1).enqueue(object : retrofit2.Callback<SaleIdResponse> {
            override fun onResponse(
                call: Call<SaleIdResponse>,
                response: Response<SaleIdResponse>,
            ) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        binding.ivSaleidSaleimg.loadImage(it.data.sale.saleImgUrl)
                        binding.ivSaleidUserimg.loadImage(it.data.user.profileImgUrl)
                        binding.tvSaleidUsername.text = it.data.user.nickname
                        binding.tvSaleidUserposition.text = it.data.user.location
                        binding.tvSaleidTemperature.text =
                            "${it.data.user.temperature.toString()}°C"
                        binding.tvSaleidTitle.text = it.data.sale.title
                        binding.tvSaleidCategory.text = it.data.sale.category
                        binding.tvSaleidLikesee.text =
                            "관심 ${it.data.sale.likeCount}  ·  조회 ${it.data.sale.viewCount}"
                        binding.tvSaleidDescription.text = it.data.sale.description

                        chatRoomId = it.data.chatRoomId
                        mannerTemperature = it.data.user.temperature
                    }
                }
            }

            override fun onFailure(call: Call<SaleIdResponse>, t: Throwable) {

            }

        })

        binding.ivHaert.setOnClickListener {
            if (it.isSelected) {
                HeartService.default(1, 1, 1)
                    .enqueue(object : retrofit2.Callback<SaleDefaultResponse> {
                        override fun onResponse(
                            call: Call<SaleDefaultResponse>,
                            response: Response<SaleDefaultResponse>
                        ) {
                            it.isSelected = false

                        }

                        override fun onFailure(call: Call<SaleDefaultResponse>, t: Throwable) {
                            TODO("Not yet implemented")
                        }

                    }
                    )
            } else {
                HeartService.filled(1, 1, 1)
                    .enqueue(object : retrofit2.Callback<SaleFilledResponse> {
                        override fun onResponse(
                            call: Call<SaleFilledResponse>,
                            response: Response<SaleFilledResponse>
                        ) {
                            it.isSelected = true

                        }

                        override fun onFailure(call: Call<SaleFilledResponse>, t: Throwable) {
                            TODO("Not yet implemented")
                        }

                    }
                    )
            }
        }


        btnSaleChattingClickListener()
        icSaleBackClickListener()
        btnSaleHomeClickListener()


    }

    private fun btnSaleChattingClickListener() {
        binding.btnSaleChatting.setOnClickListener {
            val intent = Intent(this, ChatActivity::class.java)
            Log.d("ㅋㅋㅋ", chatRoomId.toString() + " " + mannerTemperature.toString())
            intent.putExtra("roomId", chatRoomId)
            intent.putExtra("temp", mannerTemperature)
            startActivity(intent)
        }
        //Log.d("ㅋㅋㅋ", chatRoomId.toString() + " " + mannerTemperature.toString())
    }

    private fun icSaleBackClickListener() {
        binding.icSaleBack.setOnClickListener {
            finish()
        }
    }

    private fun btnSaleHomeClickListener() {
        binding.icSaleHome.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
    }
}

