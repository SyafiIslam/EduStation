package com.syafi.edustation.features.splash

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.syafi.edustation.R
import com.syafi.edustation.ui.theme.Blue
import com.syafi.edustation.ui.theme.White
import com.syafi.edustation.util.Routes
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {

    val viewModel= viewModel(SplashViewModel::class.java)

    val alphaAnim = animateFloatAsState(
        targetValue = if (viewModel.isLoading.value) 1f else 0f,
        animationSpec = tween(
            durationMillis = 2000
        )
    )

    LaunchedEffect(key1 = true) {
        viewModel.changeLoadingState(true)
        delay(3000)
        navController.popBackStack()
        navController.navigate(Routes.LOGIN)
    }

    Box(
        Modifier
            .fillMaxSize()
            .background(Blue)
    ) {
        AsyncImage(
            model = R.drawable.doodle,
            contentDescription = "",
            contentScale = ContentScale.FillHeight,
            modifier = Modifier.graphicsLayer { alpha= .5f }
        )
        AsyncImage(
            model = R.drawable.logo_white, contentDescription = "", modifier = Modifier
                .sizeIn(maxWidth = 150.dp, maxHeight = 150.dp)
                .align(Alignment.Center)
                .alpha(alphaAnim.value)
        )
        Text(text = "Version 1.0", fontSize = 12.sp, fontWeight = FontWeight.Bold, modifier =
        Modifier
            .align(Alignment.BottomCenter)
            .alpha(alphaAnim.value)
            .padding(bottom = 20.dp), color = White
        )
    }
}