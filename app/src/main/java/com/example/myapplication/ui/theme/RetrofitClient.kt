package com.example.myapplication.ui.theme

import com.example.myapplication.Product.ProductInterface
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    val retrofit = Retrofit.Builder()
        .baseUrl("https://dummyjson.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val apiproduct: ProductInterface = retrofit.create(ProductInterface:: class.java)
}