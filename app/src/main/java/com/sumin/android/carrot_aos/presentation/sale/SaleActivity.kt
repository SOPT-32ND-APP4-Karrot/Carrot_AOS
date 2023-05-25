package com.sumin.android.carrot_aos.presentation.sale

import android.content.Intent
import android.os.Bundle
import com.sumin.android.carrot_aos.R
import com.sumin.android.carrot_aos.data.entity.ServicePool
import com.sumin.android.carrot_aos.data.model.response.SaleUserIdResponse
import com.sumin.android.carrot_aos.databinding.ActivitySaleBinding
import com.sumin.android.carrot_aos.presentation.base.BindingActivity
import com.sumin.android.carrot_aos.presentation.chat.ChatActivity
import retrofit2.Call
import retrofit2.Response

class SaleActivity : BindingActivity<ActivitySaleBinding>(R.layout.activity_sale) {
    private val SaleUserIdService = ServicePool.UserIdService

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

        btnSaleChattingClickListener()
    }

    private fun btnSaleChattingClickListener() {
        binding.btnSaleChatting.setOnClickListener {
            val intent = Intent(this, ChatActivity::class.java)
            startActivity(intent)
        }
    }
}

