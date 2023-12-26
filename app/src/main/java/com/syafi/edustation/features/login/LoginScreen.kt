package com.syafi.edustation.features.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.syafi.edustation.R
import com.syafi.edustation.features.component.CustomTextButton
import com.syafi.edustation.features.component.Loading
import com.syafi.edustation.util.Routes

@Composable
fun LoginScreen(navController: NavController, viewModel: LoginViewModel = hiltViewModel()) {

    val scope = rememberCoroutineScope()
    val context = LocalContext.current

    if (viewModel.isLoading.value) {
        Loading()
    }

    Box(Modifier.fillMaxSize()) {
        Box() {
            AsyncImage(model = R.drawable.login_shape, contentDescription = "")
            AsyncImage(
                model = R.drawable.doodle,
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier.graphicsLayer { alpha = .5f }
            )
            AsyncImage(
                model = R.drawable.logo_white, contentDescription = "", modifier = Modifier
                    .sizeIn(maxWidth = 80.dp, maxHeight = 80.dp)
                    .align(Alignment.TopCenter)
                    .offset(y = 35.dp)
            )

            Row(
                verticalAlignment = Alignment.CenterVertically, horizontalArrangement =
                Arrangement.spacedBy(4.dp), modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .offset(y = -40.dp)
            ) {
                Text(
                    text = "Belum mempunyai akun?",
                    fontSize = 16.sp,
                    color = Color(red = 0f, green = 0f, blue = 0f, alpha = .7f)
                )
                CustomTextButton(
                    text = "Daftar",
                    onClick = { navController.navigate(Routes.REGISTER) })
            }
        }
        Column(
            Modifier
                .fillMaxWidth()
                .padding(top = 180.dp, start = 20.dp, end = 20.dp)
        ) {
            Text(
                text = "Kembangkan Ilmu \nBersama!", fontSize = 28.sp, fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(6.dp))
            Text(text = "Yuk, Gabung bersama kami!", fontSize = 16.sp)
            Spacer(modifier = Modifier.height(20.dp))
            LoginForm(navController, viewModel, scope, context)
        }
    }
}