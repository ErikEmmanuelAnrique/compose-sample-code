package com.example.myapplication.model

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

data class Post(
    val postId: Int,
    val authorID: Int,
    val imageResId: Int? = null,
    val authorName: String,
    val date: String,
    val content: String
    ) : Serializable

@Entity(tableName = "post_table")
data class PostEntity(
    @PrimaryKey(autoGenerate = true)
    @NonNull
    var postId: Int,
    var authorID: Int,
    var imageResId: Int?,
    var authorName: String,
    var date: String,
    var content: String
) {
}