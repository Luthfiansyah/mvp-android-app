package com.jalanesia.mytrip.service

import com.jalanesia.mytrip.Constants
import com.jalanesia.mytrip.data.auth.LoginRequest
import com.jalanesia.mytrip.data.auth.LoginResponse
import com.jalanesia.mytrip.data.auth.OTPRequest
import com.jalanesia.mytrip.data.common.GeneralResponse
import com.jalanesia.mytrip.data.user.UserItem
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

class NetworkConfig {
    // set interceptor
    fun getInterceptor(): OkHttpClient {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()
        return okHttpClient
    }

    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .client(getInterceptor())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun getService() = getRetrofit().create(ApiServices::class.java)
}

interface ApiServices {
    @GET("users")
    fun getUsers(): Call<List<UserItem>>

    @POST("/v1/auth/otp")
    fun authOTP(@Body request: OTPRequest): Call<LoginResponse>

    @POST("/v1/auth/login")
    fun login(@Body request: LoginRequest): Call<LoginResponse>
}