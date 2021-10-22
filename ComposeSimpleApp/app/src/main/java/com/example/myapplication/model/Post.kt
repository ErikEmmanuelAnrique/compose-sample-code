package com.example.myapplication.model

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

data class Post(
    val postId: UInt,
    val authorID: UInt,
    val imageResId: Int? = null,
    val authorName: String,
    val date: String,
    val content: String,
    val likes: List<UInt>
    ) : Serializable

@Entity(tableName = "post_table")
data class PostEntity(
    @PrimaryKey(autoGenerate = true)
    @NonNull
    var postId: Int
) {
    constructor(postId: Int, authorID: Int, imageResId: Int?, authorName: String, date: String, content: String) : this(postId)
}