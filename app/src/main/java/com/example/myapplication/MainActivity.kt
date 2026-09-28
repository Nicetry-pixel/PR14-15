package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.ui.theme.viewModule.ProductViewModule
import com.example.myapplication.data.module.ProductsResponse
import com.example.myapplication.data.module.Recipe
import com.example.myapplication.ui.theme.MyApplicationTheme
import com.example.myapplication.ui.theme.viewModule.RecipeViewModule

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
//    val pr = ProductViewModule()
//    pr.loadProduct()
    val ingredient = listOf("Куриное филе","сливки","чеснок","сливочное масло","растительное масло","твердый сыр","соль","черный перец","итальянские травы")
    val recipe = Recipe("Куриное филе в сливочно-чесночном соусе",
        ingredient,
        25, "Легкая")
    val rec = RecipeViewModule()
    rec.loadRecipe(recipe)
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        Greeting("")
    }
}