package com.example.myapplication.ui.theme.components

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.ui.theme.Primary
import com.example.myapplication.ui.theme.TextWhite

@Composable
fun SmallButton(modifier: Modifier = Modifier) {
    Button(onClick = {}, modifier = modifier, colors = ButtonColors(
        containerColor = Primary, contentColor = TextWhite,
        disabledContainerColor = TextWhite,
        disabledContentColor = TextWhite
    )) {
        Text("Get Started")
    }
}

@Preview
@Composable
private fun SmallButtonPreview() {
    SmallButton()
}