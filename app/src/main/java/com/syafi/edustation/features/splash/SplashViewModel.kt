package com.syafi.edustation.features.splash

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class SplashViewModel: ViewModel() {

    private var _isLoading= mutableStateOf(false)
    var isLoading: State<Boolean> = _isLoading

    fun changeLoadingState(state: Boolean) {
        _isLoading.value= state
    }
}