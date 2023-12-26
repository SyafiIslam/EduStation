package com.syafi.edustation.features.login

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.syafi.edustation.R
import com.syafi.edustation.features.component.CustomButton
import com.syafi.edustation.features.component.CustomOutlinedTextField
import com.syafi.edustation.features.component.CustomTextButton
import com.syafi.edustation.util.Resource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun LoginForm(
    navController: NavController, viewModel: LoginViewModel, scope: CoroutineScope,
    context: Context
) {

    Column {
        Text(text = "Email", fontSize = 14.sp, color = Color(0xFF8B8B8B))
        Spacer(modifier = Modifier.height(2.dp))
        CustomOutlinedTextField(
            value = viewModel.email.value,
            onChange = {
                viewModel.onEmailChange(it)
            },
            trailIcon = R.drawable.message,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(text = "Password", fontSize = 14.sp, color = Color(0xFF8B8B8B))
        Spacer(modifier = Modifier.height(2.dp))
        CustomOutlinedTextField(
            value = viewModel.password.value,
            onChange = {
                viewModel.onPasswordChange(it)
            },
            trailIcon = R.drawable.show,
            modifier = Modifier.fillMaxWidth(),
            isPassword = true,
            isPasswordVisible = viewModel.isPasswordVisible.value,
            onIconClick = {
                viewModel.setPasswordVisibility(!(viewModel.isPasswordVisible.value))
            }
        )

        Spacer(modifier = Modifier.height(16.dp))

        CustomButton(
            text = "Masuk",
            onClick = {
                if (viewModel.email.value.isEmpty() || viewModel.password.value.isEmpty()) {
                    Toast.makeText(context, "Pastikan tidak kosong", Toast.LENGTH_SHORT).show()
                } else {
                    scope.launch {
                        viewModel.buttonClick().collect {
                            when (it) {
                                is Resource.Error -> {
                                    viewModel.setLoading(false)
                                    Toast.makeText(context, it.message, Toast.LENGTH_SHORT).show()
                                }

                                is Resource.Loading -> viewModel.setLoading(true)
                                is Resource.Success -> {
                                    viewModel.setLoading(false)
                                    Toast.makeText(context, it.data, Toast.LENGTH_SHORT).show()
                                }
                            }
                        }
                    }
                }
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(20.dp))

        CustomTextButton(
            text = "Lupa Password",
            onClick = {
                Toast.makeText(context, "Silahkan cek email anda", Toast.LENGTH_SHORT).show()
            })
    }
}