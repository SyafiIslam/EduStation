package com.syafi.edustation.features.component

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.syafi.edustation.ui.theme.Blue
import com.syafi.edustation.ui.theme.White

@Composable
fun CustomButton(text: String, onClick: () -> Unit, modifier: Modifier= Modifier) {
    Button(
        onClick = { onClick() },
        shape = RoundedCornerShape(10.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Blue),
        modifier = modifier
    ) {
        Text(text = text, fontSize = 14.sp, fontWeight = FontWeight.Bold, color = White)
    }
}