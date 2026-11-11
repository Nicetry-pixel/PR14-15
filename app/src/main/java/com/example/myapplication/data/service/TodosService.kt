package com.example.myapplication.data.service

import com.example.myapplication.data.module.TodosResponse
import retrofit2.http.GET
import retrofit2.http.Header

interface TodosService {
    @GET("todos/records")
    suspend fun getTodos(@Header("Authorization")authHeader: String): TodosResponse
}