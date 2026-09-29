package com.example.myapplication.data.service

import com.example.myapplication.data.module.ProductsResponse
import com.example.myapplication.data.module.Recipe
import com.example.myapplication.data.module.RecipeResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface RecipeService {
    @POST("recipe/add")
    suspend fun postRecipe(@Body greatrecipe: Recipe): Recipe
}