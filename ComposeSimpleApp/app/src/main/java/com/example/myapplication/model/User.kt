package com.example.myapplication.model

data class User(
    val id: UInt,
    val name: String,
    val profilePictureId: Int,
    val likesCount: UInt,
    val postsCount: UInt,
    val interactionsCount: UInt,
    val description: String
    )
