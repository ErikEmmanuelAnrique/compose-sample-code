package com.example.myapplication.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.R
import com.example.myapplication.model.PostEntity

@Composable
fun InteractButton(
    onClick: () -> Unit,
    imageResourceId: Int,
    buttonLabel: String,
    widthPercent: Float
) {
    Button(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth(widthPercent),
        border = BorderStroke(
            dimensionResource(id = R.dimen.minimum_margin),
            Color.Black
        )
    ) {
        Row(
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = imageResourceId),
                contentDescription = null
            )
            Spacer(modifier = Modifier.width(
                dimensionResource(id = R.dimen.tiny_margin)
            ))
            Text(
                modifier = Modifier.align(Alignment.CenterVertically),
                text = buttonLabel,
                style = MaterialTheme.typography.caption,
            )
        }
    }
}

@Composable
fun Statistic(valueName: String, value: Int) {
    Column {
        Text(
            text = value.toString(),
            style = TextStyle(
                fontSize = 15.sp,
                color = Color.Black,
            ),
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.padding(
            top = dimensionResource(id = R.dimen.small_margin
            )))
        Text(
            text = valueName,
            maxLines = 1,
            style = TextStyle(
                fontSize = 13.sp,
                color = Color.DarkGray,
                textAlign = TextAlign.Center,
                lineHeight = 24.sp,
            ),
            modifier = Modifier.widthIn(
                min = dimensionResource(id = R.dimen.stats_width)
            )
        )
    }
}

@Composable
fun UserName(name: String, modifier: Modifier = Modifier) {
    Text(
        text = name,
        style = MaterialTheme.typography.h5,
        modifier = modifier
    )
}

@Composable
fun UserDescription(description: String) {
    Text(
        text = description,
        style = MaterialTheme.typography.body2
    )
}

@Composable
fun ProfileImage(imageResource: Int, imageSize: Dp) {
    Card(
        shape = CircleShape,
        border = BorderStroke(
            dimensionResource(id = R.dimen.minimum_margin),
            Color.LightGray
        )
    ) {
        Image(
            painter = painterResource(id = imageResource),
            contentDescription = stringResource(R.string.profile_picture_content_description),
            modifier = Modifier.size(size = imageSize),
            contentScale = ContentScale.FillWidth,
            alignment = Alignment.TopCenter
        )
    }
}

@Composable
fun PostListItem(post: PostEntity, onClick: (currentPost: PostEntity) -> Unit) {
    Box(
        modifier = Modifier
            .requiredHeight(
                dimensionResource(id = R.dimen.medium_image_size)
            )
            .fillMaxWidth()
            .clickable {
                onClick(post)
            }
    ) {
        Card(
            border = BorderStroke(
                dimensionResource(id = R.dimen.minimum_margin),
                Color.LightGray
            ),
        ) {
            Row {
                ProfileImage(
                    imageResource = R.drawable.placeholder_profile_pic,
                    imageSize = dimensionResource(id = R.dimen.medium_image_size)
                )
                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .padding(
                            vertical = dimensionResource(id = R.dimen.tiny_margin),
                            horizontal = dimensionResource(id = R.dimen.small_margin)
                        ),
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(text = post.authorName)
                        Text(
                            text = post.date,
                            style = MaterialTheme.typography.caption
                        )
                    }
                    Spacer(modifier = Modifier.height(
                        dimensionResource(id = R.dimen.regular_margin)
                    ))
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