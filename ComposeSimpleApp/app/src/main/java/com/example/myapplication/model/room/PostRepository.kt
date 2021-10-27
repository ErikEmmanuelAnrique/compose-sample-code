package com.example.myapplication.model.room

import com.example.myapplication.model.PostEntity

class PostRepository(private val dao: PostDao) {

    suspend fun addPost(postEntity: PostEntity) {
        dao.insert(postEntity)
    }

    suspend fun getPosts() = dao.getPosts()
}