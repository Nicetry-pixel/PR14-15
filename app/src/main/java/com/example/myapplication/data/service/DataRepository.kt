package com.example.myapplication.data.service

import com.example.myapplication.data.module.PostData

class DataRepository (
    private val apiService: ApiService,
    private val tokenManager: TokenDataStore
) {

    suspend fun fetchAndSaveToken() {
        val response = apiService.getToken()
        tokenManager.saveToken(response.token)
    }

    suspend fun sendSecurePost(data: PostData): Result<Unit> {
        return try {
            val response = apiService.postData(data)
            if (response.isSuccessful) {
                Result.success(Unit)
            } else {
                Result.failure(Exception("HTTP ${response.code()}"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}