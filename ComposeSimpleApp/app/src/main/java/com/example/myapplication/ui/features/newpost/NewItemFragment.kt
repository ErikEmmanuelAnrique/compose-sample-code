package com.example.myapplication.ui.features.newpost

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.BaseComposableFragment

class NewItemFragment : BaseComposableFragment() {

    @Composable
    override fun MainComposableLayout() {
        Surface(color = Color.Cyan, modifier = Modifier.fillMaxSize()) {
            Text(text = "NEW")
        }
    }

    @Preview(showBackground = true)
    @Composable
    override fun DefaultPreview() {
        MainComposableLayout()
    }
}