package com.example.myapplication.ui.features.home

import android.os.Bundle
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
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
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.myapplication.BaseComposableFragment
import com.example.myapplication.R
import com.example.myapplication.model.Post
import com.example.myapplication.utils.DataMocks

class ItemListFragment : BaseComposableFragment() {

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
            Modifier.wrapContentHeight()
        ) {
            item {
                Spacer(modifier = Modifier.height(16.dp))
            }
            items(items = postsList) {
                post ->
                Column {
                    ItemBody(post)
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
            item {
                Spacer(modifier = Modifier.height(64.dp))
            }
        }
    }

    @Composable
    private fun ItemBody(post: Post) {
        Box(
            modifier = Modifier
                .requiredHeight(96.dp)
                .fillMaxWidth()
                .clickable {
                    findNavController().run {
                        val args = Bundle().apply { putSerializable("POST", post) }
                        navigate(R.id.goToItemDetail, args)
                    }
                }
        ) {
            Card(
                border = BorderStroke(1.dp, Color.LightGray)
            ) {
                Row() {
                    Image(
                        painter = painterResource(id = R.drawable.placeholder_profile_pic),
                        contentDescription = "Author image",
                        modifier = Modifier.size(96.dp),
                        contentScale = ContentScale.FillWidth,
                        alignment = Alignment.TopCenter
                    )
                    Column(
                        modifier = Modifier
                            .fillMaxHeight()
                            .padding(vertical = 4.dp, horizontal = 8.dp),
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(text = post.authorName)
                            Text(text = post.date)
                        }
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            text = post.content,
                            textAlign = TextAlign.Start,
                            maxLines = 3,
                            overflow = TextOverflow.Ellipsis,
                            lineHeight = 16.sp
                        )
                    }
                }
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    override fun DefaultPreview() {
        MainComposableLayout()
    }
}