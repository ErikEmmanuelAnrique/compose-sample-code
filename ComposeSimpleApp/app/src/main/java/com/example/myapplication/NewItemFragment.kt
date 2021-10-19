package com.example.myapplication

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

class NewItemFragment : BaseComposableFragment() {

    @Composable
    override fun MainComposableLayout() {
        Text(text = "NEW")
    }

    @Preview(showBackground = true)
    @Composable
    override fun DefaultPreview() {
        MainComposableLayout()
    }
}