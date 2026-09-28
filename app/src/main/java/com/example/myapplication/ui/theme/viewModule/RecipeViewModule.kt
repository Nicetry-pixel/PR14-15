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
            val recipeis = RetrofitClient.apirecipe.postRecipe()
            for(recipe in recipeis.recipe){
                Log.d("RecipeResponse", "Название:${recipe.name},\n " +
                        "Ингредиенты:${recipe.ingredients}," +
                        "\nВремя готовки:${recipe.cookTimeMinutes}" +
                        "\nСложность:${recipe.difficulty}")
            }
        }
    }
}