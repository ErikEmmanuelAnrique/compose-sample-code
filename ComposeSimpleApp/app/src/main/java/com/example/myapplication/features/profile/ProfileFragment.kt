package com.example.myapplication.features.profile

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import com.example.myapplication.BaseComposableFragment
import com.example.myapplication.R
import com.example.myapplication.ui.theme.MyApplicationTheme

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
                    ProfileBanner()
                    ProfileDescription()
                }
            }
        }
    }

    @Composable
    private fun ProfileBanner() {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp, bottom = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            ProfileImage()
            ProfileStats()
        }
    }

    @Composable
    private fun ProfileImage() {
        Card(
            shape = CircleShape,
            border = BorderStroke(1.dp, Color.LightGray)
        ) {
            Image(
                painter = painterResource(id = R.drawable.profilepic),
                contentDescription = "ProfilePicture",
                modifier = Modifier.size(120.dp),
                contentScale = ContentScale.FillWidth,
                alignment = Alignment.TopCenter
            )
        }

    }

    @Composable
    private fun ProfileStats() {
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly
            ){
            Statistic(valueName = "Posts", value = 12)
            Statistic(valueName = "Likes", value = 66)
            Statistic(valueName = "Interactions", value = 450)
        }
    }

    @Composable
    private fun Statistic(valueName: String, value: Int) {
        Column {
            Text(
                text = value.toString(),
                style = TextStyle(
                    fontSize = 15.sp,
                    color = Color.Black,
                ),
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.padding(top = 8.dp))
            Text(
                text = valueName,
                maxLines = 1,
                style = TextStyle(
                    fontSize = 13.sp,
                    color = Color.DarkGray,
                    textAlign = TextAlign.Center,
                    lineHeight = 24.sp,
                ),
                modifier = Modifier.widthIn(min = 80.dp)
            )
        }
    }

    @Composable
    private fun ProfileDescription() {
        Column {
            UserName()
            UserDescription()
        }
    }

    @Composable
    private fun UserName() {
        Text(text = "Todd Howard")
    }

    @Composable
    private fun UserDescription() {
        Text(text = "Game developer, creator of the critical acclaimed title \"The elder scrolls V: Skyrim\". Please buy Skyrim.")
    }

    @Preview
    @Composable
    override fun DefaultPreview() {
        MainComposableLayout()
    }

}