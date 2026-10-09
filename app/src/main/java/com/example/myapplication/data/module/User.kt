package com.example.myapplication.data.module

data class User(
    val id: Int? = null,
    val firstName: String,
    val lastName: String,
    val age: Int,
    val hair: Hair
)
