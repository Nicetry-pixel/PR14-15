package com.example.myapplication.data.service

import com.example.myapplication.data.module.ProductsResponse
import retrofit2.http.GET

interface ProductService {
    @GET("products")
    suspend fun getProduct(): ProductsResponse
}