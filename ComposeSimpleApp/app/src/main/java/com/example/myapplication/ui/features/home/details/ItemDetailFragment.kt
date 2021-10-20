package com.example.myapplication.ui.features.home.details

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.BaseComposableFragment

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