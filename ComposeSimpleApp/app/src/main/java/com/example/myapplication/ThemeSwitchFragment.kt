package com.example.myapplication

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

class ThemeSwitchFragment : BaseComposableFragment() {

    @Composable
    override fun MainComposableLayout() {
        Text(text = "Themes")
    }

    @Preview(showBackground = true)
    @Composable
    override fun DefaultPreview() {
        MainComposableLayout()
    }
}