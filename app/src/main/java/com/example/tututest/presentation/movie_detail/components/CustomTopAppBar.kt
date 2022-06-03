package com.example.tututest.presentation.movie_detail.components

import android.app.Activity
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun CustomTopAppBar(
    scroll: Int,
    name: String,
    navController: NavController
) {

    val activity = (LocalContext.current as? Activity)

    val statusBarColor = if (scroll > 1100) {
        Color.Black
    } else {
        Color.Transparent
    }

    val text = if (scroll > 1100) {
        name
    } else {
        ""
    }

    TopAppBar(
        backgroundColor = statusBarColor,
        elevation = 0.dp,
    ) {
        IconButton(onClick = {
            navController.navigate("movie_list_screen")
        }) {
            Icon(Icons.Filled.ArrowBack, contentDescription = "Меню", tint = Color.White)
        }

        Text(
            text = text,
            color = Color.White,
            fontSize = 21.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(start = 10.dp)
        )

    }
}