package com.example.myapplication.model

data class Post(
    val imageResId: Int? = null,
    val postId: UInt,
    val authorID: UInt,
    val authorName: String,
    val date: String,
    val content: String
    )
