package com.example.expandablecard

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable

fun PasswordTextField() {

    var passwordText by rememberSaveable { mutableStateOf("") }
    var passwordVisibility by remember{ mutableStateOf(false)}

    val icon_visibility = if(passwordVisibility) painterResource(id = R.drawable.visible)
          else painterResource(id = R.drawable.invisible)

    OutlinedTextField(
        value = passwordText, onValueChange = {
        passwordText = it
        },
        placeholder = {Text("Password")},
        label = {Text("Password")},
        trailingIcon = {
            IconButton(
                onClick = {
                    passwordVisibility = !passwordVisibility
                }) {
                Icon(modifier = Modifier
                    .width(32.dp)
                    .height(32.dp),painter = icon_visibility, contentDescription = "Visibility icon")
            }
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password
        ),
        visualTransformation = if(passwordVisibility) VisualTransformation.None
    else PasswordVisualTransformation()
    )
}

@Composable
@Preview

private fun PasswordTextFieldPreview(){
    PasswordTextField()
}