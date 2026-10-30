package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myapplication.data.module.LoginQuest
import com.example.myapplication.ui.theme.viewModule.ProductViewModule
import com.example.myapplication.data.module.ProductsResponse
import com.example.myapplication.data.module.Recipe
import com.example.myapplication.ui.theme.MyApplicationTheme
import com.example.myapplication.ui.theme.viewModule.AuthViewModel
import com.example.myapplication.ui.theme.viewModule.PostsViewModule
import com.example.myapplication.ui.theme.viewModule.RecipeViewModule
import com.example.myapplication.ui.theme.viewModule.TodoViewModel
import com.example.myapplication.ui.theme.viewModule.UserViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
//            val product: ProductViewModule = viewModel()
//            product.loadProduct()

//            val ingredient = listOf("Куриное филе","сливки","чеснок","сливочное масло","растительное масло","твердый сыр","соль","черный перец","итальянские травы")
//            val WRe_cip = Recipe("Куриное филе в сливочно-чесночном соусе",
//                ingredient,
//                25, "Легкая")
//            val rec: RecipeViewModule = viewModel()
//            rec.loadRecipe(WRe_cip)
//                val upUser: UserViewModel = viewModel()
//                upuser.putUsers(userId = 67)

//              val delPost: PostsViewModule = viewModel()
//                delpost.deletePosts(30)

//                val user = UserRecord("Kirill", "Kozlov", "user@example.com", "admin123", "admin123")
                val login = LoginQuest("user@example.com", "admin123")

//                val authViewModel: AuthViewModel = viewModel()
//                authViewModel.createUser(user)
                val getTodosViewModel: TodoViewModel = viewModel()
                getTodosViewModel.getTodo(login)
        }
    }
}