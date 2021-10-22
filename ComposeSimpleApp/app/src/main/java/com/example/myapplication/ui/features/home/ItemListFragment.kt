package com.example.myapplication.ui.features.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.navigation.fragment.findNavController
import com.example.myapplication.BaseComposableFragment
import com.example.myapplication.R
import com.example.myapplication.model.Post
import com.example.myapplication.model.room.PostViewModel
import com.example.myapplication.ui.PostListItem
import com.example.myapplication.ui.ProfileImage
import com.example.myapplication.utils.DataMocks

class ItemListFragment : BaseComposableFragment() {

    private lateinit var postViewModel: PostViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        postViewModel = ViewModelProvider(requireActivity(), ViewModelProvider.AndroidViewModelFactory.getInstance(requireActivity().application)).get(PostViewModel::class.java)
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    @Composable
    override fun MainComposableLayout() {
        Row(
            modifier = Modifier
                .padding(
                    horizontal = 16.dp
                ),
            verticalAlignment = Alignment.Top
        ) {
            Feed(DataMocks.postsList)
        }
    }

    @Composable
    private fun Feed(postsList: List<Post>) {
        LazyColumn(
            modifier = Modifier.wrapContentHeight(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            item {
                Spacer(modifier = Modifier.height(8.dp))
            }
            postsList.forEach { post ->
                item {
                    Column {
                        PostListItem(post) {
                                currentPost -> navigateToPostDetails(currentPost)
                        }
                    }
                }
            }
            item {
                Spacer(modifier = Modifier.height(56.dp))
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    override fun DefaultPreview() {
        MainComposableLayout()
    }

    private fun navigateToPostDetails(post: Post) {
        findNavController().run {
            val args = Bundle().apply { putSerializable("POST", post) }
            navigate(R.id.goToItemDetail, args)
        }
    }
}