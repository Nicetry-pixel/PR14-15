package com.example.myapplication.ui.theme.viewModule

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.service.RetrofitClient
import kotlinx.coroutines.launch

class ProductViewModule: ViewModel() {
    fun loadProduct(){
        viewModelScope.launch {
            val products = RetrofitClient.apiproduct.getProduct()
            for(product in products.products){
                Log.d("ProductResponse", "Название:${product.title}," +
                        "\nОписание:${product.description}," +
                        "\nЦена:${product.price}")
            }

        }
    }
}