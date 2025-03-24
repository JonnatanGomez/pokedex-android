package com.example.pokeapi.presentation.component

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.pokeapi.R

@Composable
fun CustomTopAppBar() {
    TopAppBar(
        title = {
            Icon(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Logo",
                tint = Color.Unspecified,
                modifier = Modifier
                    .padding(top = 40.dp)
                    .fillMaxHeight(0.8f)
                    .fillMaxWidth(0.50f)
            )
        },
        backgroundColor = Color.White,
        modifier = Modifier.height(106.dp),
        elevation = 4.dp
    )
}
