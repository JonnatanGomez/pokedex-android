package com.example.pokeapi.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.material.Shapes
import androidx.compose.material.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.pokeapi.R

// Define paleta de colores para modo claro y oscuro
private val DarkColorPalette = darkColors(
    primary = Color(0xFF1C1B1F),
    primaryVariant = Color(0xFF1C1B1F),
    secondary = Color(0xFF03DAC5)
)

private val LightColorPalette = lightColors(
    primary = Color(0xFFFFFBFE),
    primaryVariant = Color(0xFFFFFBFE),
    secondary = Color.White
    // Puedes definir otros colores si es necesario
)

// Define la familia de fuentes Montserrat
val Montserrat = FontFamily(
    Font(R.font.montserrat_regular, FontWeight.Normal),
    Font(R.font.montserrat_bold, FontWeight.Bold)
)

val AppTypography = Typography(
    h6 = TextStyle(
        fontFamily = Montserrat,
        fontWeight = FontWeight.Normal,
        fontSize = 20.sp,
        color = Color(0xFF01243A)
    )
)

val Typography.titleRegular: TextStyle
    get() = TextStyle(
        fontFamily = Montserrat,
        fontWeight = FontWeight.Normal,
        fontSize = 25.sp,
        color = Color(0xFF01243A)
    )

val Typography.titleBold: TextStyle
    get() = TextStyle(
        fontFamily = Montserrat,
        fontWeight = FontWeight.Bold,
        fontSize = 25.sp,
        color = Color(0xFF01243A)
    )

val Typography.subTitleBold: TextStyle
    get() = TextStyle(
        fontFamily = Montserrat,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp,
        color = Color(0xFF01426A)
    )

@Composable
fun PokeApiTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) DarkColorPalette else LightColorPalette

    MaterialTheme(
        colors = colors,
        typography = AppTypography,
        content = content
    )
}
