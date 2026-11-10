package com.example.myapplication.ui.theme.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CartTodo(
    productsCount: String,
    totalPrice: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .width(335.dp)  // Ширина из Figma
            .height(80.dp)  // Высота из Figma
            // Тень: Y: 8, Blur: 40, цвет #8A959E 20%
            .shadow(
                elevation = 8.dp,
                shape = RoundedCornerShape(8.dp),
                ambientColor = Color(0xFF8A959E).copy(alpha = 0.20f),
                spotColor = Color(0xFF8A959E).copy(alpha = 0.20f)
            )
            .background(color = Color.White, shape = RoundedCornerShape(8.dp))
            // Отступы из Figma: Left: 20px, Top: 15px (и симметрично снизу)
            .padding(horizontal = 20.dp, vertical = 15.dp),
        verticalArrangement = Arrangement.SpaceBetween // Распределяет строки по высоте
    ) {
        // Первая строка (Products)
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Todo:",
                color = Color(0xFF808080),
                fontSize = 18.sp,
                lineHeight = 18.sp, // 100% от 18px
                fontWeight = FontWeight(400),
                // fontFamily = FontFamily(Font(R.font.nunito_sans_regular))
            )
            Text(
                text = productsCount,
                color = Color(0xFF242424),
                fontSize = 18.sp,
                lineHeight = 18.sp,
                fontWeight = FontWeight(600),
                textAlign = TextAlign.End,
                // fontFamily = FontFamily(Font(R.font.nunito_sans_semibold))
            )
        }

        // Вторая строка (Total)
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Completed:",
                color = Color(0xFF808080),
                fontSize = 18.sp,
                lineHeight = 18.sp,
                fontWeight = FontWeight(400),
                // fontFamily = FontFamily(Font(R.font.nunito_sans_regular))
            )
            Text(
                text = totalPrice,
                color = Color(0xFF242424),
                fontSize = 18.sp,
                lineHeight = 18.sp,
                fontWeight = FontWeight(700),
                textAlign = TextAlign.End,
                // fontFamily = FontFamily(Font(R.font.nunito_sans_bold))
            )
        }
    }
}


@Preview
@Composable
private fun CartTodoPreview() {
    CartTodo(productsCount = "",
        totalPrice = "")
}