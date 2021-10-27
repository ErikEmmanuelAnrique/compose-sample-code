package com.example.myapplication.ui.features.newpost

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.example.myapplication.ui.BaseComposableFragment
import com.example.myapplication.R
import com.example.myapplication.model.room.PostViewModel
import com.example.myapplication.ui.InteractButton

class NewItemFragment : BaseComposableFragment() {

    private lateinit var postViewModel: PostViewModel

    override fun initFragment() {
        postViewModel = ViewModelProvider(requireActivity()).get()
    }

    @Composable
    override fun MainComposableLayout() {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = dimensionResource(id = R.dimen.regular_margin))
            ,
            verticalArrangement = Arrangement.Top
        ) {
            var input by remember { mutableStateOf("")}
            Spacer(modifier = Modifier.height(
                dimensionResource(id = R.dimen.regular_margin)
            ))
            BasicTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .requiredHeight(
                        dimensionResource(id = R.dimen.post_box_size)
                    )
                    .border(
                        width = dimensionResource(id = R.dimen.minimum_margin),
                        color = Color.DarkGray,
                        shape = MaterialTheme.shapes.medium
                    )
                    .padding(
                        dimensionResource(id = R.dimen.small_margin)
                    )
                    .verticalScroll(
                        state = rememberScrollState(0)
                    )
                ,
                value = input,
                onValueChange = { input = it },
                textStyle = MaterialTheme.typography.body1,
            )
            Spacer(modifier = Modifier.height(
                dimensionResource(id = R.dimen.small_margin)
            ))
            InteractButton(
                onClick = {
                    with(input) {
                        if (isNotBlank()) postViewModel.createNewPost(this)
                    }
                    input = ""
                },
                imageResourceId = R.drawable.ic_add,
                buttonLabel = stringResource(R.string.add_post_button_label),
                widthPercent = 1f
            )
        }
    }

    @Preview(showBackground = true)
    @Composable
    override fun DefaultPreview() {
        MainComposableLayout()
    }
}