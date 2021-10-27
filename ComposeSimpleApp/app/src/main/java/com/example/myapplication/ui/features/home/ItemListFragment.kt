package com.example.myapplication.ui.features.home

import android.os.Bundle
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.navigation.fragment.findNavController
import com.example.myapplication.ui.BaseComposableFragment
import com.example.myapplication.R
import com.example.myapplication.model.Post
import com.example.myapplication.model.PostEntity
import com.example.myapplication.model.room.PostViewModel
import com.example.myapplication.ui.PostListItem

class ItemListFragment : BaseComposableFragment() {

    private lateinit var postViewModel: PostViewModel

    override fun initFragment() {
        postViewModel = ViewModelProvider(requireActivity()).get()
    }

    @Composable
    override fun MainComposableLayout() {
        Row(
            modifier = Modifier
                .padding(
                    horizontal = dimensionResource(id = R.dimen.regular_margin)
                ),
            verticalAlignment = Alignment.Top
        ) {
            Feed()
        }
    }

    @Composable
    private fun Feed() {
        val postList = postViewModel.posts.value
        LazyColumn(
            modifier = Modifier.wrapContentHeight(),
            verticalArrangement = Arrangement.spacedBy(
                dimensionResource(id = R.dimen.small_margin)
            )
        ) {
            item {
                Spacer(modifier = Modifier.height(
                    dimensionResource(id = R.dimen.small_margin)
                ))
            }
            postList.forEach { post ->
                item {
                    Column {
                        PostListItem(post) {
                                currentPost -> navigateToPostDetails(currentPost)
                        }
                    }
                }
            }
            item {
                Spacer(modifier = Modifier.height(
                    dimensionResource(id = R.dimen.huge_margin)
                ))
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    override fun DefaultPreview() {
        MainComposableLayout()
    }

    private fun navigateToPostDetails(post: PostEntity) {
        val serializablePost = with(post) {
            Post(
                postId,
                authorID,
                imageResId,
                authorName,
                date,
                content
            )
        }
        findNavController().run {
            val args = Bundle().apply { putSerializable(POST_KEY, serializablePost) }
            navigate(R.id.goToItemDetail, args)
        }
    }

    companion object {
        const val POST_KEY = "POST"
    }
}