package com.sumin.android.carrot_aos.presentation.sale

import android.os.Bundle
import android.util.Log
import com.sumin.android.carrot_aos.R
import com.sumin.android.carrot_aos.data.model.response.SaleUserIdResponse
import com.sumin.android.carrot_aos.databinding.ActivitySaleBinding
import com.sumin.android.carrot_aos.presentation.base.BindingActivity
import retrofit2.Call
import retrofit2.Response

class SaleActivity : BindingActivity<ActivitySaleBinding>(R.layout.activity_sale) {
    private val SaleUserIdService = SaleServicePool.UserIdService

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
    }


}

