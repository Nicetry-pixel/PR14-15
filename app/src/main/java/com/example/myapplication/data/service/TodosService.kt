package com.example.myapplication.data.service

import com.example.myapplication.data.module.Todos
import retrofit2.http.GET
import retrofit2.http.Header

interface TodosService {
    @GET("todos")
    suspend fun getTodos(): List<Todos>
}