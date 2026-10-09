package com.example.myapplication.ui.theme.viewModule

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.module.Hair
import com.example.myapplication.data.module.User
import com.example.myapplication.data.service.RetrofitClient
import kotlinx.coroutines.launch

class UserViewModel: ViewModel(){
    fun loadUsers(userId: Int){
        viewModelScope.launch {
            val geteduser = RetrofitClient.apiusers.getUser(userId)
            val updateuser = RetrofitClient.apiusers.putUser(userId,geteduser )
            try{

                Log.d("GetUsers","|Id: ${geteduser.id}\n" +
                        "|Имя: ${geteduser.firstName}\n" +
                        "|Фамилия: ${geteduser.lastName}\n" +
                        "|Возраст: ${geteduser.age}\n" +
                        "|Цвет волос: ${geteduser.hair.color}\n" +
                        "|Тип волос: ${geteduser.hair.type}.")
                val newuser = geteduser.copy(
                    15,
                    "Ирина",
                    "Воронова",
                    29,
                    hair = Hair("темные","кудрявые")
                )
                Log.d("UpdatedUser","|Id: ${newuser.id}\n" +
                        "|Имя: ${newuser.firstName}\n" +
                        "|Фамилия: ${newuser.lastName}\n" +
                        "|Возраст: ${newuser.age}\n" +
                        "|Цвет волос: ${newuser.hair.color}\n" +
                        "|Тип волос: ${newuser.hair.type}.")
            } catch(ex: Exception) {
                Log.d("UserViewModel","Error: ${ex.message}")
            }
        }
    }
}