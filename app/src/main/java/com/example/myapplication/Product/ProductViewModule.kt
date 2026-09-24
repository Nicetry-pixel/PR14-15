package com.example.myapplication.Product

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.ui.theme.RetrofitClient
import com.example.myapplication.ui.theme.RetrofitClient.apiproduct
import kotlinx.coroutines.launch

class ProductViewModule: ViewModel() {
    fun loadProduct(){
        viewModelScope.launch {
            val products = apiproduct.getProduct()
            for(product in products.products){
                Log.d("ProductResponse", "Название:${product.title},\n Описание:${product.description},\nЦена:${product.price}")
            }

        }
    }
}