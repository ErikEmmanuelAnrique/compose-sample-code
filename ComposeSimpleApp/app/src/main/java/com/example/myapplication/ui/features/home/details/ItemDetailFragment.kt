package com.example.myapplication.ui.features.home.details

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.BaseComposableFragment
import com.example.myapplication.R
import com.example.myapplication.model.Post
import com.example.myapplication.ui.InteractButton
import com.example.myapplication.ui.ProfileImage
import com.example.myapplication.ui.UserName
import com.example.myapplication.utils.DataMocks

class ItemDetailFragment : BaseComposableFragment() {

    @Composable
    override fun MainComposableLayout() {
        PostDetail(post = arguments?.getSerializable("POST")!! as Post)
    }

    @Composable
    private fun PostDetail(post: Post) {
        Column(
            Modifier
                .padding(horizontal = 16.dp)
                .fillMaxSize()
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                ProfileImage(
                    imageResource = R.drawable.placeholder_profile_pic,
                    imageSize = 60.dp
                )
                Spacer(modifier = Modifier.width(32.dp))
                UserName(
                    name = post.authorName,
                    modifier = Modifier.align(Alignment.CenterVertically)
                )
            }
            Spacer(modifier = Modifier.height(12.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Post#${post.postId}",
                    style = MaterialTheme.typography.caption
                )
                Text(
                    text = post.date,
                    style = MaterialTheme.typography.caption
                )
            }
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .requiredHeight(height = 256.dp)
                    .border(
                        width = 1.dp,
                        color = Color.DarkGray,
                        shape = MaterialTheme.shapes.medium
                    )
                    .padding(8.dp)
                    .verticalScroll(
                        state = rememberScrollState(0)
                    ),
                text = post.content,
                style = MaterialTheme.typography.body1
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                InteractButton(
                    onClick = {},
                    imageResourceId = R.drawable.ic_like,
                    buttonLabel = "Like",
                    widthPercent = 0.5f
                )
                InteractButton(
                    onClick = {},
                    imageResourceId = R.drawable.ic_comment,
                    buttonLabel = "Comment",
                    widthPercent = 1f
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
        }
    }

    @Preview(showBackground = true)
    @Composable
    override fun DefaultPreview() {
        PostDetail(post = DataMocks.postsList[0])
    }
}