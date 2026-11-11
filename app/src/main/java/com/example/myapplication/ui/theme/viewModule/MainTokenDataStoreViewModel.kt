package com.example.myapplication.ui.theme.viewModule

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.module.PostData
import com.example.myapplication.data.service.DataRepository
import kotlinx.coroutines.launch

class MainTokenDataStoreViewModel (private val repository: DataRepository) : ViewModel() {

    fun authenticateAndPost() {
        viewModelScope.launch {
            repository.fetchAndSaveToken()

            val result = repository.sendSecurePost(
                PostData(title = "Hello", body = "World")
            )

            result.onSuccess {

            }.onFailure {

            }
        }
    }
}