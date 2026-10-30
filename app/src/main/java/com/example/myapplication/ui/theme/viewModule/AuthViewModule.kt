package com.example.myapplication.ui.theme.viewModule

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.service.RetrofitClient
import kotlinx.coroutines.launch

class AuthViewModel: ViewModel() {
    fun createUser(userRecord: Record){
        viewModelScope.launch {
            try {
                val user = RetrofitClient.auth.createUser(userRecord)
                //Log.d("AuthViewModel","${user.email}, ${user.password}")
            }catch (ex: Exception){
                Log.e("AuthViewModel", "${ex.message}")
            }
        }
    }
}