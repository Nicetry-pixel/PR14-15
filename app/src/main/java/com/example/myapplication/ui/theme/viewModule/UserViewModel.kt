package com.example.myapplication.ui.theme.viewModule

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.module.Hair
import com.example.myapplication.data.module.User
import com.example.myapplication.data.service.RetrofitClient
import kotlinx.coroutines.launch

class UserViewModel: ViewModel(){
    fun putUsers(userId: Int){
        viewModelScope.launch {
            val geteduser = RetrofitClient.apiuser.getUser(userId)
            val newuser = geteduser.copy(
                15,
                "Ирина",
                "Воронова",
                29,
                hair = Hair("темные","кудрявые")
            )
            val updateuser = RetrofitClient.apiuser.putUser(userId,newuser )
            try{
                Log.d("GetUsers","|Id: ${geteduser.id}\n" +
                        "|Имя: ${geteduser.firstName}\n" +
                        "|Фамилия: ${geteduser.lastName}\n" +
                        "|Возраст: ${geteduser.age}\n" +
                        "|Цвет волос: ${geteduser.hair.color}\n" +
                        "|Тип волос: ${geteduser.hair.type}.")
                Log.d("UpdatedUser","|Id: ${updateuser.id}\n" +
                        "|Имя: ${updateuser.firstName}\n" +
                        "|Фамилия: ${updateuser.lastName}\n" +
                        "|Возраст: ${updateuser.age}\n" +
                        "|Цвет волос: ${updateuser.hair.color}\n" +
                        "|Тип волос: ${updateuser.hair.type}.")
            } catch(ex: Exception) {
                Log.d("UserViewModel","Error: ${ex.message}")
            }
        }
    }
}