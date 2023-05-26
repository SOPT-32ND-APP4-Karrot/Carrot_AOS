package com.sumin.android.carrot_aos.data.service

import com.sumin.android.carrot_aos.data.model.response.*
import retrofit2.Call
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query


interface UserIdService {
    @GET("/sale/user/{userId}")
    fun userid(
        @Path("userId") userId: Int

    ): Call<SaleUserIdResponse>
}

interface RecommendationService {
    @GET("/sale/{saleId}/recommendation")
    fun saleidrecommendation(
        @Path("saleId") saleId: Int

    ): Call<SaleRecommendationResponse>
}

interface SaleIdService {
    @GET("/sale/{saleId}")
    fun saleid(
        @Path("saleId") saleId: Int

    ): Call<SaleIdResponse>
}

interface HeartService {
    @POST("/sale/like/{saleId}")
    fun default(
        @Path("saleId") saleId: Int,
        @Query("saleId") param1: Int,
        @Query("userId") param2: Int
    ): Call<SaleDefaultResponse>

    @DELETE("/sale/like/{saleId}")
    fun filled(
        @Path("saleId") saleId: Int,
        @Query("saleId") param1: Int,
        @Query("userId") param2: Int
    ): Call<SaleFilledResponse>
}