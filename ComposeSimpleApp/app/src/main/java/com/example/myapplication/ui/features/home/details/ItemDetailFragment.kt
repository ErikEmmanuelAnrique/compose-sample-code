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
                SmallProfileImage()
                Spacer(modifier = Modifier.width(32.dp))
                AuthorName(
                    modifier = Modifier.align(Alignment.CenterVertically),
                    name = post.authorName
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
                    )
                ,
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

    @Composable
    private fun InteractButton(
        onClick: () -> Unit,
        imageResourceId: Int,
        buttonLabel: String,
        widthPercent: Float
    ) {
        Button(
            onClick = onClick,
            modifier = Modifier.fillMaxWidth(widthPercent),
            border = BorderStroke(1.dp, Color.Black)
        ) {
            Row(
                horizontalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = imageResourceId),
                    contentDescription = null
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    modifier = Modifier.align(Alignment.CenterVertically),
                    text = buttonLabel,
                    style = MaterialTheme.typography.caption,
                )
            }
        }
    }

    @Composable
    private fun SmallProfileImage() {
        Card(
            shape = CircleShape,
            border = BorderStroke(1.dp, Color.LightGray)
        ) {
            Image(
                painter = painterResource(id = R.drawable.placeholder_profile_pic),
                contentDescription = "ProfilePicture",
                modifier = Modifier.size(60.dp),
                contentScale = ContentScale.FillWidth,
                alignment = Alignment.TopCenter
            )
        }
    }

    @Composable
    private fun AuthorName(name: String, modifier: Modifier) {
        Text(
            modifier = modifier,
            text = name,
            style = MaterialTheme.typography.h5,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }

    @Preview(showBackground = true)
    @Composable
    override fun DefaultPreview() {
        PostDetail(post = DataMocks.postsList[0])
    }
}