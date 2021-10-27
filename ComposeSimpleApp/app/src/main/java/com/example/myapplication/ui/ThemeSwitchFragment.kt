package com.example.myapplication.ui

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.ui.BaseComposableFragment

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