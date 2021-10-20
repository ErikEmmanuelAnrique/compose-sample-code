package com.example.myapplication.ui.features.home.details

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.BaseComposableFragment
import com.example.myapplication.model.Post

class ItemDetailFragment : BaseComposableFragment() {

    @Composable
    override fun MainComposableLayout() {
        PostDetail(post = arguments?.getSerializable("POST")!! as Post)
    }

    @Composable
    private fun PostDetail(post: Post) {
        Text(text = post.authorName + post.date + post.content)
    }

    @Preview(showBackground = true)
    @Composable
    override fun DefaultPreview() {
        MainComposableLayout()
    }
}