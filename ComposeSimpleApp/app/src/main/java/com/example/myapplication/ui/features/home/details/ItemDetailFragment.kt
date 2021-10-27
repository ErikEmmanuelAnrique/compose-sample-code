package com.example.myapplication.ui.features.home.details

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.ui.BaseComposableFragment
import com.example.myapplication.R
import com.example.myapplication.model.Post
import com.example.myapplication.ui.InteractButton
import com.example.myapplication.ui.ProfileImage
import com.example.myapplication.ui.UserName
import com.example.myapplication.ui.features.home.ItemListFragment.Companion.POST_KEY
import com.example.myapplication.utils.DataMocks

class ItemDetailFragment : BaseComposableFragment() {

    @Composable
    override fun MainComposableLayout() {
        PostDetail(post = arguments?.getSerializable(POST_KEY)!! as Post)
    }

    @Composable
    private fun PostDetail(post: Post) {
        Column(
            Modifier
                .padding(
                    horizontal = dimensionResource(id = R.dimen.regular_margin)
                )
                .fillMaxSize()
        ) {
            Spacer(modifier = Modifier.height(
                dimensionResource(id = R.dimen.regular_margin)
            ))
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                ProfileImage(
                    imageResource = R.drawable.placeholder_profile_pic,
                    imageSize = dimensionResource(id = R.dimen.small_image_size)
                )
                Spacer(modifier = Modifier.width(
                    dimensionResource(id = R.dimen.large_margin)
                ))
                UserName(
                    name = post.authorName,
                    modifier = Modifier.align(Alignment.CenterVertically)
                )
            }
            Spacer(modifier = Modifier.height(
                dimensionResource(id = R.dimen.medium_margin)
            ))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = stringResource(R.string.post_count_label, post.postId),
                    style = MaterialTheme.typography.caption
                )
                Text(
                    text = post.date,
                    style = MaterialTheme.typography.caption
                )
            }
            Spacer(modifier = Modifier.height(
                dimensionResource(id = R.dimen.big_margin)
            ))
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .requiredHeight(
                        height = dimensionResource(id = R.dimen.post_box_size)
                    )
                    .border(
                        width = dimensionResource(id = R.dimen.minimum_margin),
                        color = Color.DarkGray,
                        shape = MaterialTheme.shapes.medium
                    )
                    .padding(
                        dimensionResource(id = R.dimen.small_margin)
                    )
                    .verticalScroll(
                        state = rememberScrollState(0)
                    ),
                text = post.content,
                style = MaterialTheme.typography.body1
            )
            Spacer(modifier = Modifier.height(
                dimensionResource(id = R.dimen.small_margin)
            ))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                InteractButton(
                    onClick = {},
                    imageResourceId = R.drawable.ic_like,
                    buttonLabel = stringResource(R.string.like_button_label),
                    widthPercent = 0.5f
                )
                InteractButton(
                    onClick = {},
                    imageResourceId = R.drawable.ic_comment,
                    buttonLabel = stringResource(R.string.comment_button_label),
                    widthPercent = 1f
                )
            }
            Spacer(modifier = Modifier.height(
                dimensionResource(id = R.dimen.regular_margin)
            ))
        }
    }

    @Preview(showBackground = true)
    @Composable
    override fun DefaultPreview() {
        PostDetail(post =
            Post(
                postId = 0,
                authorID = 0,
                imageResId = null,
                authorName = "me",
                date = "today",
                content = "this is a post"
            )
        )
    }
}