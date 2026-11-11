package com.example.myapplication.ui.theme.viewModule

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.module.LoginQuest
import com.example.myapplication.data.service.RetrofitClient
import kotlinx.coroutines.launch

class TodoViewModel: ViewModel() {
    fun getTodo(loginRequest: LoginQuest){
        viewModelScope.launch {
            try {

            val auth = RetrofitClient.auth.login(loginRequest)

            val todos = RetrofitClient.todos.getTodos(auth.token)

            for(todo in todos.items)
                    Log.d("TodosViewModel", "id - ${todo.id}\n " +
                            "todo - ${todo.todo}\n " +
                            "completed -${todo.completed}\n " +
                            "created - ${todo.created}\n " +
                            "updated - ${todo.updated}")
                }catch (ex: Exception){
                    Log.e("viewModelScope", "${ex.message}")
                }
        }
    }
}