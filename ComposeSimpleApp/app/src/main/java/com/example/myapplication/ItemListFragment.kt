package com.example.myapplication

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

class ItemListFragment : BaseComposableFragment() {

    @Composable
    override fun MainComposableLayout() {
        Text(text = "LIST")
    }

    @Preview(showBackground = true)
    @Composable
    override fun DefaultPreview() {
        MainComposableLayout()
    }
}