package com.example.myapplication.ui.theme.viewModule

import android.util.Log
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myapplication.data.module.LoginQuest
import com.example.myapplication.data.service.RetrofitClient
import com.example.myapplication.data.service.TokenDataStore
import kotlinx.coroutines.launch

class LoginViewModule: ViewModel() {

    fun loginTodo(loginRequest: LoginQuest){

        viewModelScope.launch {

            try {

                val auth = RetrofitClient.auth.login(loginRequest)

                // val todos = RetrofitClient.todos.getTodos(auth.token)
                val token = auth.token
                TokenDataStore.saveToken(token)
                Log.d("TokenManager", "Токен успешно сохранен!")

            } catch(ex: Exception){

                Log.e("LoginViewModule","${ex.message}")
            }
        }
    }
}