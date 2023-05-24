
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.sumin.android.carrot_aos.BuildConfig
import com.sumin.android.carrot_aos.data.service.UserIdService
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit

object SaleApiFactory {

    private val client by lazy {
        OkHttpClient.Builder().addInterceptor(HttpLoggingInterceptor().apply {
            level =
                if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
        }).build()
    }


    val retrofitForAuth: Retrofit by lazy {
        Retrofit.Builder().baseUrl(BuildConfig.AUTH_BASE_URL)
            .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
            .client(client).build()
    }

    inline fun <reified T> createAuthService(): T = retrofitForAuth.create<T>(T::class.java)

    val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BuildConfig.AUTH_BASE_URL)
            .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
            .build()
    }


    inline fun <reified T> create(): T = retrofit.create<T>(T::class.java)
}

object SaleServicePool {
    val UserIdService = SaleApiFactory.create<UserIdService>()

}


