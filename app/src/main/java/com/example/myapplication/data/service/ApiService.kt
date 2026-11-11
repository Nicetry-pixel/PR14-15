package com.example.myapplication.data.service

import com.example.myapplication.data.module.PostData
import com.example.myapplication.data.module.TokenResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @GET("auth/token")
    suspend fun getToken(): TokenResponse

    @POST("data")
    suspend fun postData(@Body data: PostData): retrofit2.Response<Unit>
}