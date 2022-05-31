package com.example.tututest

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import com.example.tututest.models.movieList.Doc
import com.example.tututest.ui.theme.BackgroundColor
import com.example.tututest.ui.theme.ShimmerColorShades

class ProfileActivity : ComponentActivity()  {

    private val movie: Doc by lazy {
        intent?.getSerializableExtra(MOVIE_ID) as Doc
    }

    private val movieProfileViewModel by viewModels<MovieProfileViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.window.statusBarColor = ContextCompat.getColor(this,R.color.black)
        setContent {
            val id = movie.id
            if (movieProfileViewModel.isLoading.value){
                MovieScreen(movieProfileViewModel.movieProfileResponse)
            } else{
                Box(
                    contentAlignment = Alignment.Center,
                ) {
                    ShimmerAnimation(
                    )
                }
            }
            movieProfileViewModel.getMovieProfile(id)
        }
    }

    companion object {
        private const val MOVIE_ID = "movie_id"
        fun newIntent(context: Context, movie: Doc) =
            Intent(context, ProfileActivity::class.java).apply {
                putExtra(MOVIE_ID, movie)
            }
    }
}

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
                //startActivity(Intent(mContext, MainActivity::class.java))
                activity?.finish()
            }) {
                Icon(Icons.Filled.ArrowBack, contentDescription = "Меню", tint = Color.White)
            }
        }
    }

}

@Composable
fun ShimmerComponents(
    brush: Brush
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Постер
        ShimmerItem(brush = brush, width = 200, height = 320, paddingBottom = 0, paddingTop = 93, raunded = 10)
        Column(
            modifier = Modifier
                .offset(y = (-15).dp)
                .clip(RoundedCornerShape(15.dp))
                .background(BackgroundColor)
                .fillMaxSize()
                .padding(horizontal = 20.dp, vertical = 15.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Название
            ShimmerItem(brush = brush, width = 200, height = 27, paddingBottom = 15, paddingTop = 25, raunded = 100)
            // Альтернативное название
            ShimmerItem(brush = brush, width = 100, height = 10, paddingBottom = 15, paddingTop = 0, raunded = 100)
            // Год, Страна, Жанры
            ShimmerItem(brush = brush, width = 230, height = 10, paddingBottom = 8, paddingTop = 0, raunded = 100)
            ShimmerItem(brush = brush, width = 200, height = 10, paddingBottom = 27, paddingTop = 0, raunded = 100)
            // Описание
            for(i in 1..5){
                ShimmerItem(brush = brush, width = 600, height = 11, paddingBottom = 10, paddingTop = 0, raunded = 100)
            }
        }
    }
}
@Composable
fun ShimmerItem(
    brush: Brush,
    width: Int,
    height: Int,
    paddingBottom: Int,
    paddingTop: Int,
    raunded: Int,

){
    Spacer(
        modifier = Modifier
            .padding(top = paddingTop.dp, bottom = paddingBottom.dp)
            .clip(RoundedCornerShape(raunded.dp))
            .size(height = height.dp, width = width.dp)
            .background(brush = brush)
    )
}