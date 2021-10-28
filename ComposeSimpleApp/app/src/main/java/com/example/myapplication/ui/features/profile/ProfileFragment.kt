package com.example.myapplication.ui.features.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import com.example.myapplication.R
import com.example.myapplication.ui.BaseComposableFragment
import com.example.myapplication.model.User
import com.example.myapplication.ui.ProfileImage
import com.example.myapplication.ui.Statistic
import com.example.myapplication.ui.UserDescription
import com.example.myapplication.ui.UserName
import com.example.myapplication.ui.theme.MyApplicationTheme
import com.example.myapplication.utils.DataMocks

class ProfileFragment : BaseComposableFragment() {

    @Composable
    override fun MainComposableLayout() {
        MyApplicationTheme() {
            Surface(
                modifier = Modifier
                    .background(color = MaterialTheme.colors.background)
                    .fillMaxSize()
            ) {
                Column(
                    modifier = Modifier
                    .padding(
                        start = dimensionResource(id = R.dimen.regular_margin),
                        end = dimensionResource(id = R.dimen.regular_margin))
                ) {
                    ProfileBanner(DataMocks.currentUser)
                    ProfileDescription(
                        name = DataMocks.currentUser.name,
                        description = DataMocks.currentUser.description
                    )
                }
            }
        }
    }

    @Composable
    private fun ProfileBanner(user: User) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = dimensionResource(id = R.dimen.big_margin),
                    bottom = dimensionResource(id = R.dimen.regular_margin)
                ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            ProfileImage(
                imageResource = user.profilePictureId,
                imageSize = dimensionResource(id = R.dimen.big_image_size)
            )
            ProfileStats(
                postsCount = user.postsCount,
                likesCount = user.likesCount,
                interactionsCount = user.interactionsCount
            )
        }
    }

    @Composable
    private fun ProfileStats(postsCount: Int, likesCount: Int, interactionsCount: Int) {
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly
            )
        {
            Statistic(
                valueName = stringResource(R.string.posts_label),
                value = postsCount
            )
            Statistic(
                valueName = stringResource(R.string.likes_label),
                value = likesCount
            )
            Statistic(
                valueName = stringResource(R.string.interactions_label),
                value = interactionsCount
            )
        }
    }

    @Composable
    private fun ProfileDescription(name: String, description: String) {
        Column {
            UserName(name = name)
            UserDescription(description = description)
        }
    }

    @Preview
    @Composable
    override fun DefaultPreview() {
        MainComposableLayout()
    }

}