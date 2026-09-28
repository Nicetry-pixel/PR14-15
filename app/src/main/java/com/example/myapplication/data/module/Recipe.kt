package com.example.myapplication.data.module

data class Recipe(
    val name: String,
    val ingredients: List<String>,
    val cookTimeMinutes: Int,
    val difficulty: String
)
