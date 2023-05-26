package com.sumin.android.carrot_aos.data.service

import com.sumin.android.carrot_aos.data.model.response.HomeResponse
import retrofit2.Call
import retrofit2.http.GET

interface HomeService {
    @GET("/sale")
    fun getHomeList(): Call<HomeResponse>
}