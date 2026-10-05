package com.example.myapplication.data.service

import com.example.myapplication.data.module.Recipe
import com.example.myapplication.data.module.User
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface UserService {
    @GET("users/{id}")
    suspend fun  getUser(@Path("id") userId: Int):User
    @PUT("users/{id}")
    suspend fun putUser(@Path("id") userId: Int, @Body users: User): User
}