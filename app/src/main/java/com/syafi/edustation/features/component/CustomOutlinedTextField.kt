package com.syafi.edustation.features.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.syafi.edustation.ui.theme.AbuLogin
import com.syafi.edustation.ui.theme.Samar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomOutlinedTextField(
    value: String,
    onChange: (String) -> Unit = {},
    isPassword: Boolean = false,
    isPasswordVisible: Boolean = false,
    isNumeric: Boolean = false,
    trailIcon: Int? = null,
    maxLine: Int= 1,
    modifier: Modifier= Modifier,
    onIconClick: () -> Unit= {}
) {
    OutlinedTextField(
        value = value,
        onValueChange = onChange,
        keyboardOptions = KeyboardOptions(
            keyboardType =
            if (isPassword) {
                if (isPasswordVisible) {
                    KeyboardType.Text
                } else {
                    KeyboardType.Password
                }
            } else if (isNumeric) {
                KeyboardType.Number
            } else {
                KeyboardType.Text
            }
        ),
        trailingIcon = {
            trailIcon?.let {
                if (isPassword) {
                    IconButton(onClick = { onIconClick() }) {
                        Icon(painter = painterResource(id = trailIcon), contentDescription = "", tint =
                        Samar, modifier = Modifier.size(24.dp))
                    }
                } else {
                    IconButton(onClick = { onIconClick() }) {
                        Icon(painter = painterResource(id = trailIcon), contentDescription = "", tint =
                        Samar, modifier = Modifier.size(24.dp))
                    }
                }
            }
        },
        visualTransformation =
        if (isPassword) {
            if (isPasswordVisible) {
                VisualTransformation.None
            } else {
                PasswordVisualTransformation()
            }
        } else {
            VisualTransformation.None
        },
        maxLines = maxLine,
        shape = RoundedCornerShape(10.dp),
        colors = TextFieldDefaults.textFieldColors(
            unfocusedIndicatorColor = AbuLogin,
            focusedIndicatorColor = AbuLogin,
            textColor = Color.Black,
            containerColor = Color.Transparent,
            focusedSupportingTextColor = Color.Transparent

        ),
        modifier = modifier
    )
}