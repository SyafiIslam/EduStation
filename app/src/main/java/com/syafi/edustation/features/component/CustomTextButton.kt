package com.syafi.edustation.features.component

import androidx.compose.foundation.clickable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.sp
import com.syafi.edustation.ui.theme.Blue

@Composable
fun CustomTextButton(text: String, onClick: () -> Unit) {
    Text(
        text = text,
        textDecoration = TextDecoration.Underline,
        color = Blue,
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.clickable { onClick() }
    )
}