package com.example.myapplication.ui.theme.viewModule

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.myapplication.data.module.Todos
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.service.AuthState
import com.example.myapplication.data.service.RetrofitClient
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.security.Identity

class TodoViewModule: ViewModel() {
    private val _todos = MutableStateFlow<List<Todos>>(emptyList())
    val todos: StateFlow<List<Todos>> = _todos

    private val _isLoggedIn = MutableStateFlow(false)
    val isLoggedIn: StateFlow<Boolean> = _isLoggedIn

    fun login(identity: String, password: String) = viewModelScope.launch {
        try{
            //val response = RetrofitClient.swagger(identity,password)
           // AuthState.token = response.access_token
            _isLoggedIn.value = true
            loadTodos()
        }catch(Exception: Exception){
            Log.d("Error","Error:${Exception.message}")
        }
    }

    fun loadTodos(){
        viewModelScope.launch{
            val token = AuthState.token
            if(token.isNullOrBlank()){
                _todos.value = emptyList()
                return@launch
            }
            try {
                val list = RetrofitClient.apitodos.getTodos("Bearer $token")
                _todos.value = list
                Log.d("GetTodos","ID: ")
            }
            catch(Exception: Exception){
                Log.d("Error","Error:${Exception.message}")
            }
        }
    }
}