package com.example.myapplication.ui.theme.viewModule

import com.example.myapplication.data.module.Todos
import com.example.myapplication.data.service.RetrofitClient
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class TodoViewModule {
    private val _todos = MutableStateFlow<List<Todos>>(emptyList())
    val todos: StateFlow<List<Todos>> = _todos

    fun loadTodos(){
        viewModelScope.launch{
            try{
                val result = RetrofitClient.apitodos.getTodos()
                _todos.value = result
            }
        }
    }
}