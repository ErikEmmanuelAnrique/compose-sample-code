package com.example.myapplication.model

import java.io.Serializable

data class Post(
    val imageResId: Int? = null,
    val postId: UInt,
    val authorID: UInt,
    val authorName: String,
    val date: String,
    val content: String
    ) : Serializable
