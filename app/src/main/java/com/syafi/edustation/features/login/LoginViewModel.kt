package com.syafi.edustation.features.login

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.syafi.edustation.domain.usecase.auth.LoginUseCase
import com.syafi.edustation.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val userLogin: LoginUseCase
): ViewModel() {

    private val _email= mutableStateOf("")
    val email: State<String> = _email

    private val _password= mutableStateOf("")
    val password: State<String> = _password

    private val _isLoading= mutableStateOf(false)
    val isLoading: State<Boolean> = _isLoading

    private val _isPasswordVisible= mutableStateOf(false)
    val isPasswordVisible: State<Boolean> = _isPasswordVisible

    fun onEmailChange(email: String) {
        _email.value= email
    }

    fun onPasswordChange(password: String) {
        _password.value= password
    }

    fun setLoading(state: Boolean) {
        _isLoading.value= state
    }

    fun setPasswordVisibility(visibility: Boolean) {
        _isPasswordVisible.value = visibility
    }

    fun buttonClick(): Flow<Resource<String>> {

        var result: Flow<Resource<String>>? = null
        viewModelScope.launch {
            result= userLogin(_email.value, _password.value)
        }
        return result!!
    }
}