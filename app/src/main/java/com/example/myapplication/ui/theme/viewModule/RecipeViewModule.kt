package com.example.myapplication.ui.theme.viewModule

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.module.Recipe
import com.example.myapplication.data.service.RetrofitClient
import kotlinx.coroutines.launch

class RecipeViewModule: ViewModel() {
    fun loadRecipe(recipe: Recipe){
        viewModelScope.launch {
            val mainrecipe = RetrofitClient.apirecipe.postRecipe(recipe)
            try {
                    Log.d(
                        "RecipeResponse", "|Название:${mainrecipe.name}\n|" +
                                "|Ингредиенты:${mainrecipe.ingredients}\n|" +
                                "|Время готовки:${mainrecipe.cookTimeMinutes}\n|" +
                                "|Сложность:${mainrecipe.difficulty}\n|"
                    )
            }
            catch(Exception: Exception){
                    Log.d("Error","Error:${Exception.message}")
            }
        }
    }
}