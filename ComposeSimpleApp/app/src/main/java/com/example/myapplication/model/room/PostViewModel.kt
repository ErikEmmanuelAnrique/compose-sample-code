package com.example.myapplication.model.room

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.myapplication.model.PostEntity
import com.example.myapplication.utils.DataMocks
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PostViewModel(application: Application) : AndroidViewModel(application) {

    private val readAllData: LiveData<List<PostEntity>>
    private val repository: PostRepository

    init {
        val postDao = PostDatabase.getDataBase(application).postDao()
        repository = PostRepository(postDao)
        readAllData = repository.getAllPosts
    }

    fun addPost(post: PostEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addPost(post)
        }
    }

    fun createNewPost(content: String) {
        val post = PostEntity(
            0,
            DataMocks.currentUser.id,
            null,
            DataMocks.currentUser.name,
            "today",
            content
        )
        addPost(post)
    }

}