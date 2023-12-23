package com.syafi.edustation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import androidx.navigation.compose.rememberNavController
import com.syafi.edustation.features.navigation.Navigation
import com.syafi.edustation.features.theme.PurpleGrey40

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val navController = rememberNavController()
            WindowCompat.setDecorFitsSystemWindows(window, false)

            Surface(modifier = Modifier.windowInsetsPadding(WindowInsets(bottom = 40.dp))) {
                Navigation(navHostController = navController)
            }
        }
    }
}