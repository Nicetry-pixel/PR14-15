package com.example.myapplication.Product

import retrofit2.http.GET

interface ProductInterface {
    @GET("products")
    suspend fun getProduct(): Product
}