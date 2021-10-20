package com.example.myapplication

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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.fragment.findNavController

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
            Feed(List(60) {})
        }
    }

    @Composable
    private fun Feed(postsList: List<Any>) {
        LazyColumn(
            Modifier.wrapContentHeight()
        ) {
            item {
                Spacer(modifier = Modifier.height(16.dp))
            }
            items(items = postsList) {
                post ->
                Column {
                    ItemBody()
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
            item {
                Spacer(modifier = Modifier.height(64.dp))
            }
        }
    }

    @Composable
    private fun ItemBody() {
        Box(
            modifier = Modifier
                .requiredHeight(96.dp)
                .fillMaxWidth()
                .clickable {
                    findNavController().navigate(R.id.goToItemDetail)
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
                    Spacer(modifier = Modifier.width(8.dp))
                    Column(
                        modifier = Modifier
                            .fillMaxHeight()
                            .padding(4.dp),
                        verticalArrangement = Arrangement.SpaceBetween
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(text = "This is the autor name")
                            Text(text = "19 nov 2021")
                        }
                        Text(text = "This is a placeholder text description this should never be longer than three lines of text on this part of the app")
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