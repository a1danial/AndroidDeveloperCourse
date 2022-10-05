package com.example.androiddevelopercourse.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = Purple200,
    primaryVariant = Purple700,
    secondary = Teal200
)

private val LightColorPalette = lightColors(
    primary = Purple500,
    primaryVariant = Purple700,
    secondary = Teal200

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun AndroidDeveloperCourseTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}

private val WoofDarkColorPalette = darkColors(
    background = Cyan900,
    surface = Cyan700,
    onSurface = White,
    primary = Grey900,
    onPrimary = White,
    secondary = Grey100
)

private val WoofLightColorPalette = lightColors(
    background = Green100,
    surface = Green50,
    onSurface = Grey900,
    primary = Grey50,
    onPrimary = Grey900,
    secondary = Grey700
)

@Composable
fun WoofTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        WoofDarkColorPalette
    } else {
        WoofLightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}

// ABC; Unit 3; Pathway 3; Module 5
private val SuperheroesDarkColorPalette = darkColors(
    background = md_theme_dark_background,
    surface = md_theme_dark_surface,
    onSurface = md_theme_dark_onSurface,
    primary = md_theme_dark_primary,
    onPrimary = md_theme_dark_onPrimary,
    secondary = md_theme_dark_secondary
)

private val SuperheroesLightColorPalette = lightColors(
    background = md_theme_light_background,
    surface = md_theme_light_surface,
    onSurface = md_theme_light_onSurface,
    primary = md_theme_light_primary,
    onPrimary = md_theme_light_onPrimary,
    secondary = md_theme_light_secondary
)

@Composable
fun SuperheroesTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        SuperheroesDarkColorPalette
    } else {
        SuperheroesLightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = SuperheroesTypography,
        shapes = SuperheroesShapes,
        content = content
    )
}

private val DessertDarkColorPalette = darkColors(
    primary = DessertPurple200,
    primaryVariant = DessertPurple700,
    secondary = DessertPink600
)

private val DessertLightColorPalette = lightColors(
    primary = DessertGreen600,
    primaryVariant = DessertPurple700,
    secondary = DessertPink600
)

@Composable
fun DessertClickerTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DessertDarkColorPalette
    } else {
        DessertLightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = DessertTypography,
        shapes = DessertShapes,
        content = content
    )
}