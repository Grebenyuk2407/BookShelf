package com.example.bookshelf.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

@Composable
fun BookShelfTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val primaryColor = if (darkTheme) Color(0xFFD0BCFF) else Color(0xFF6650a4)
    val secondaryColor = if (darkTheme) Color(0xFFCCC2DC) else Color(0xFF625b71)
    val tertiaryColor = if (darkTheme) Color(0xFFEFB8C8) else Color(0xFF7D5260)

    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = primaryColor.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
        }
    }

    MaterialTheme(
        colors = MaterialTheme.colors.copy(
            primary = primaryColor,
            secondary = secondaryColor
        ),
        typography = Typography,
        content = content
    )
}