package com.example.myapplication.features.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import com.example.myapplication.BaseComposableFragment
import com.example.myapplication.ui.theme.MyApplicationTheme

class ProfileFragment : BaseComposableFragment() {

    @Composable
    override fun MainComposableLayout() {
        MyApplicationTheme() {
            Surface(modifier = Modifier.background(color = MaterialTheme.colors.background).fillMaxSize()) {
                ProfileBanner()
            }
        }
    }

    @Composable
    private fun ProfileBanner() {
        Row {
            ProfileStats()
        }
    }

    @Composable
    private fun ProfileStats() {
        Row {
            Column {
                Statistic(valueName = "Posts", value = 12)
            }
            Column {
                Statistic(valueName = "Likes", value = 66)
            }
            Column {
                Statistic(valueName = "Interactions", value = 450)
            }
        }
    }

    @Composable
    private fun Statistic(valueName: String, value: Int) {
        Column {
            Row {
                Text(
                    text = value.toString(),
                    style = TextStyle(
                        fontSize = 15.sp,
                        color = Color.Black,
                    )
                )
            }
                Spacer(modifier = Modifier.padding(top = 8.dp))
            Row {
                Text(
                    text = valueName, style = TextStyle(
                        fontSize = 13.sp,
                        color = Color.DarkGray
                    )
                )
            }
        }
    }

    @Preview
    @Composable
    override fun DefaultPreview() {
        MainComposableLayout()
    }

}