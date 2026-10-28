package com.example.myapplication.data.service

import com.example.myapplication.data.module.LoginResponse
import retrofit2.http.Field
import retrofit2.http.POST

interface AuthApiService {
    @POST("users/auth-with-password")
    suspend fun login(
        @Field("identity") username: String,
        @Field("password") password: String
    ): LoginResponse
}