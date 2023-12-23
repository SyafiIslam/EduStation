package com.syafi.edustation.features.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.syafi.edustation.features.splash.SplashScreen
import com.syafi.edustation.ui.Routes

@Composable
fun Navigation(navHostController: NavHostController) {
    NavHost(navController = navHostController, startDestination = Routes.SPLASH) {
        composable(Routes.SPLASH) {
            SplashScreen(navHostController)
        }
    }
}