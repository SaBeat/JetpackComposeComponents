package com.example.expandablecard

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.expandablecard.ui.theme.Shapes

@ExperimentalMaterialApi
@Composable
fun GoogleButton() {

    var clicked by remember { mutableStateOf(false) }
    Surface(modifier = Modifier
        .fillMaxWidth()
        .padding(10.dp)
        .clickable { clicked = !clicked },
        shape = Shapes.medium,
        border = BorderStroke(width = 1.dp, Color.LightGray),
        color = MaterialTheme.colors.surface) {
        Row(modifier = Modifier
            .padding(
                start = 12.dp,
                end = 16.dp,
                top = 15.dp,
                bottom = 15.dp
            )
            .animateContentSize(
                animationSpec = tween(
                    durationMillis = 300,
                    easing = LinearOutSlowInEasing
                )
            ),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.Center
        ) {

            Icon(
                painter = painterResource(id = R.drawable.google),
                tint = Color.Unspecified,
                contentDescription = "Google Icon"
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Sign Up with Google"
            )

            if (clicked) {
                Spacer(modifier = Modifier.width(20.dp))
                CircularProgressIndicator(
                    modifier = Modifier
                        .width(20.dp)
                        .height(20.dp),
                    color = MaterialTheme.colors.primary,
                    strokeWidth = 2.dp
                )
            }
        }

    }
}

@ExperimentalMaterialApi
@Composable
@Preview
private fun GoogleButtonPreview() {
    GoogleButton()
}

