package com.example.myapplication.ui.features.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
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
                    .padding(start = 16.dp, end = 16.dp)
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
                .padding(top = 24.dp, bottom = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            ProfileImage(user.profilePictureId, 120.dp)
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
            Statistic(valueName = "Posts", value = postsCount)
            Statistic(valueName = "Likes", value = likesCount)
            Statistic(valueName = "Interactions", value = interactionsCount)
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