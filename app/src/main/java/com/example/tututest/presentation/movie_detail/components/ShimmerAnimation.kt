package com.example.tututest.presentation.movie_detail.components

import android.app.Activity
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.tututest.ui.theme.BackgroundColor
import com.example.tututest.ui.theme.ShimmerColorShades

@Composable
fun ShimmerAnimation() {

    val activity = (LocalContext.current as? Activity)

    val transition = rememberInfiniteTransition()
    val translateAnim by transition.animateFloat(

        initialValue = 0f,
        targetValue = 1000f,
        animationSpec = infiniteRepeatable(
            tween(durationMillis = 1200, easing = FastOutSlowInEasing),
            RepeatMode.Reverse
        )
    )

    val brush = Brush.linearGradient(
        colors = ShimmerColorShades,
        start = Offset(10f, 10f),
        end = Offset(translateAnim, translateAnim)
    )

    Box(modifier = Modifier
        .background(BackgroundColor.copy(alpha = 0.95f))
        .fillMaxSize()){
        ShimmerComponents(brush = brush)
        TopAppBar(
            backgroundColor = Color.Transparent,
            elevation = 0.dp,
        ) {
            IconButton(onClick = {
                activity?.finish()
            }) {
                Icon(Icons.Filled.ArrowBack, contentDescription = "Меню", tint = Color.White)
            }
        }
    }
}