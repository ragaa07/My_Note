package com.example.mynote.ui.theme

import android.R.id
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import android.R.id.primary
import androidx.compose.ui.graphics.BlendMode.Companion.Color


private val DarkColorPalette = darkColors(
    primary = androidx.compose.ui.graphics.Color.White,
    background = DarkGray,
    onBackground = androidx.compose.ui.graphics.Color.White,
    surface = LightBlue,
    onSurface = DarkGray
)


@Composable
fun MyNoteTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable() () -> Unit) {

    MaterialTheme(
        colors = DarkColorPalette,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}