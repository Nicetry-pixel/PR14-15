package com.example.myapplication.data.service

import com.example.myapplication.data.module.AuthPassword
import com.example.myapplication.data.module.LoginQuest
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApiService {
    @POST("users/auth-with-password")
    suspend fun login(@Body request: LoginQuest): AuthPassword

    @POST("users/records")
    suspend fun createUser(@Body userRecord: Record): Record
}