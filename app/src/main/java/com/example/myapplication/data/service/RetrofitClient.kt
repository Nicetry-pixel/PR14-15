package com.example.myapplication.data.service

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.net.InetSocketAddress
import java.net.Proxy

object RetrofitClient {
    private const val BASE_URL = "http://10.207.106.59:8090/api/collections/"

    val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }
    val proxy = Proxy(Proxy.Type.HTTP, InetSocketAddress("10.207.106.59",3128))
    val okHttpClient = OkHttpClient.Builder()
        .proxy(proxy)
        .addInterceptor(loggingInterceptor)
        .build()
    val retrofit = Retrofit.Builder()
        .baseUrl("https://dummyjson.com/")
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val swagger = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val auth: AuthApiService = swagger.create(AuthApiService::class.java)
    val todos: TodosService = swagger.create(TodosService::class.java)
    val apiproduct: ProductService = retrofit.create(ProductService:: class.java)
    val apirecipe: RecipeService = retrofit.create(RecipeService:: class.java)
    val apiuser: UserService = retrofit.create(UserService:: class.java)
    val apipostsdelete = retrofit.create(PostsService:: class.java)
    val apitodos = retrofit.create(TodosService:: class.java)
}