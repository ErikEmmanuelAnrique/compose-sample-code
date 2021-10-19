package com.example.myapplication

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

class ItemDetailFragment : BaseComposableFragment() {

    @Composable
    override fun MainComposableLayout() {
        Text(text = "DETAILS")
    }

    @Preview(showBackground = true)
    @Composable
    override fun DefaultPreview() {
        MainComposableLayout()
    }
}