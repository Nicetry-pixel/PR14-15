package com.example.myapplication.data.service

import com.example.myapplication.data.module.Posts
import retrofit2.http.Body
import retrofit2.http.DELETE

interface PostsService {
    @DELETE (posts/30)
    suspend fun deletePost(@Body delPost : Posts): Posts
}