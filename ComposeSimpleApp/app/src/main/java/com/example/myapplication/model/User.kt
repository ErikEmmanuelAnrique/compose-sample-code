package com.example.myapplication.model

data class User(
    val id: Int,
    val name: String,
    val profilePictureId: Int,
    val likesCount: Int,
    val postsCount: Int,
    val interactionsCount: Int,
    val description: String
    )
