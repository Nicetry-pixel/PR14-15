package com.example.myapplication.data.module

data class LoginRequest(
    val identity: String,
    val password: String
)

data class LoginResponse(
    val access_token: String
)
