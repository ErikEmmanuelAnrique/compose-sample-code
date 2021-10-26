package com.example.myapplication.model.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.myapplication.model.PostEntity

@Dao
interface PostDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(postEntity: PostEntity)

    @Query("SELECT * FROM post_table ORDER BY postId ASC")
    fun getAllPosts() : LiveData<List<PostEntity>>

    @Query("SELECT * FROM post_table ORDER BY postId ASC")
    suspend fun getPosts() : List<PostEntity>
}