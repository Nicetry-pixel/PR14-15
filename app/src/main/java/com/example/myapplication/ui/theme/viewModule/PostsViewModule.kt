package com.example.myapplication.ui.theme.viewModule

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.service.RetrofitClient
import kotlinx.coroutines.launch

class PostsViewModule: ViewModel() {
    fun deletePosts(postId: Int){
        viewModelScope.launch {
            val deletepost = RetrofitClient.apipostsdelete.deletePost(postId)
            try{

                Log.d("DeletePosts" ,"|Id: ${deletepost.Id}\n" +
                        "|isDeleted: ${deletepost.isDeleted}\n" +
                        "|deletedOn: ${deletepost.deletedOn}\n")

            } catch(ex: Exception) {
                Log.d("UserViewModel","Error: ${ex.message}")
            }
        }
    }
}