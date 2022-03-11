package com.example.expandablecard

import android.graphics.drawable.Icon
import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.expandablecard.ui.theme.ExpandableCard

@Composable
fun CustomTextField() {
    var text by remember { mutableStateOf("") }
    Column(modifier = Modifier
        .padding(12.dp)
        .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        OutlinedTextField(
            value = text,
            onValueChange = {
                text = it
            },
            label = { Text("Email") },
            leadingIcon = { Icon(Icons.Filled.Email, "Icon Email") },
            maxLines = 2,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            ),
            keyboardActions = KeyboardActions(onNext = {
                Log.v("KeyboardNext","OnNext clicked")
            })
        )
    }
}

@ExperimentalMaterialApi
@Composable
@Preview
fun CustomTextFieldreview() {
    CustomTextField()
}
