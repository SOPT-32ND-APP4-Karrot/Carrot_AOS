package com.sumin.android.carrot_aos.data.service

import com.sumin.android.carrot_aos.data.model.response.SaleUserIdResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface UserIdService {
    @GET("/sale/user/{userId}")
    fun userid(
        @Path("userId") userId: Int

    ): Call<SaleUserIdResponse>
}