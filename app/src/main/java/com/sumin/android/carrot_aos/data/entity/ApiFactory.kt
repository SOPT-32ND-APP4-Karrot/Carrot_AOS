package com.sumin.android.carrot_aos.data.entity

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.sumin.android.carrot_aos.BuildConfig
import com.sumin.android.carrot_aos.data.service.ChatService
import com.sumin.android.carrot_aos.data.service.ReviewService
import com.sumin.android.carrot_aos.data.service.UserIdService
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit

object ApiFactory {
    private const val BASE_URL = BuildConfig.CARROT_BASE_URL

    private val client by lazy {
        OkHttpClient.Builder().addInterceptor(HttpLoggingInterceptor().apply {
            level =
                if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
        }).build()
    }

    val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
            .build()
    }

    inline fun <reified T> create(): T = retrofit.create<T>(T::class.java)
}

object ServicePool {
    val chatService = ApiFactory.create<ChatService>()
    val UserIdService = ApiFactory.create<UserIdService>()
    val reviewService = ApiFactory.create<ReviewService>()
}