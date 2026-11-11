package com.example.myapplication.data.service

import com.example.myapplication.data.module.Posts
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.Path

interface PostsService {
    @DELETE ("posts/{id}")
    suspend fun deletePost(@Path("id") postId: Int): Posts
}