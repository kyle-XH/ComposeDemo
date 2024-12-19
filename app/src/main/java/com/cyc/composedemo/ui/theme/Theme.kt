package com.cyc.composedemo.ui.theme

import android.app.Activity
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.TweenSpec
import androidx.compose.material.ripple.RippleTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.Stable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat
import com.cyc.composedemo.data.ThemeState

private val lightCyanColorPalette = ComposeColors(
    primary = cyan500,
    secondary = cyan800,
    tertiary = cyan200,
    error = volcano500,
    textPrimary = grayLight01,
    textSecondary = grayLight02,
    textTertiary = grayLight03,
    textQuaternary = grayLight04,
    surface = grayLight09,
    bgPrimary = grayLight00,
    bgSecondary = grayLight09,
    divideLine = grayLight06,
    dividerBlock = grayLight07,
    disable = grayLight05,
    input = grayLight06,
)

private val lightBambooColorPalette = ComposeColors(
    primary = bamboo500,
    secondary = bamboo800,
    tertiary = bamboo200,
    error = volcano500,
    textPrimary = grayLight01,
    textSecondary = grayLight02,
    textTertiary = grayLight03,
    textQuaternary = grayLight04,
    surface = grayLight09,
    bgPrimary = grayLight00,
    bgSecondary = grayLight09,
    divideLine = grayLight06,
    dividerBlock = grayLight07,
    disable = grayLight05,
    input = grayLight06,
)

private val lightDawnColorPalette = ComposeColors(
    primary = dawn500,
    secondary = dawn800,
    tertiary = dawn200,
    error = volcano500,
    textPrimary = grayLight01,
    textSecondary = grayLight02,
    textTertiary = grayLight03,
    textQuaternary = grayLight04,
    surface = grayLight09,
    bgPrimary = grayLight00,
    bgSecondary = grayLight09,
    divideLine = grayLight06,
    dividerBlock = grayLight07,
    disable = grayLight05,
    input = grayLight06,
)

private val lightBlueColorPalette = ComposeColors(
    primary = blue500,
    secondary = blue800,
    tertiary = blue200,
    error = volcano500,
    textPrimary = grayLight01,
    textSecondary = grayLight02,
    textTertiary = grayLight03,
    textQuaternary = grayLight04,
    surface = grayLight09,
    bgPrimary = grayLight00,
    bgSecondary = grayLight09,
    divideLine = grayLight06,
    dividerBlock = grayLight07,
    disable = grayLight05,
    input = grayLight06,
)

private val lightVioletColorPalette = ComposeColors(
    primary = violet500,
    secondary = violet800,
    tertiary = violet200,
    error = volcano500,
    textPrimary = grayLight01,
    textSecondary = grayLight02,
    textTertiary = grayLight03,
    textQuaternary = grayLight04,
    surface = grayLight09,
    bgPrimary = grayLight00,
    bgSecondary = grayLight09,
    divideLine = grayLight06,
    dividerBlock = grayLight07,
    disable = grayLight05,
    input = grayLight06,
)


private val darkCyanColorPalette = ComposeColors(
    primary = cyan500,
    secondary = cyan800,
    tertiary = cyan200,
    error = volcano500,
    textPrimary = grayDark01,
    textSecondary = grayDark02,
    textTertiary = grayDark03,
    textQuaternary = grayDark04,
    surface = grayDark10,
    bgPrimary = grayDark00,
    bgSecondary = grayDark09,
    divideLine = grayDark06,
    dividerBlock = grayDark10,
    disable = grayDark05,
    input = grayDark08,
)

private val darkBambooColorPalette = ComposeColors(
    primary = bamboo500,
    secondary = bamboo800,
    tertiary = bamboo200,
    error = volcano500,
    textPrimary = grayDark01,
    textSecondary = grayDark02,
    textTertiary = grayDark03,
    textQuaternary = grayDark04,
    surface = grayDark10,
    bgPrimary = grayDark00,
    bgSecondary = grayDark09,
    divideLine = grayDark06,
    dividerBlock = grayDark10,
    disable = grayDark05,
    input = grayDark08,
)

private val darkDawnColorPalette = ComposeColors(
    primary = dawn500,
    secondary = dawn800,
    tertiary = dawn200,
    error = volcano500,
    textPrimary = grayDark01,
    textSecondary = grayDark02,
    textTertiary = grayDark03,
    textQuaternary = grayDark04,
    surface = grayDark10,
    bgPrimary = grayDark00,
    bgSecondary = grayDark09,
    divideLine = grayDark06,
    dividerBlock = grayDark10,
    disable = grayDark05,
    input = grayDark08,
)

private val darkBlueColorPalette = ComposeColors(
    primary = blue500,
    secondary = blue800,
    tertiary = blue200,
    error = volcano500,
    textPrimary = grayDark01,
    textSecondary = grayDark02,
    textTertiary = grayDark03,
    textQuaternary = grayDark04,
    surface = grayDark10,
    bgPrimary = grayDark00,
    bgSecondary = grayDark09,
    divideLine = grayDark06,
    dividerBlock = grayDark10,
    disable = grayDark05,
    input = grayDark08,
)

private val darkVioletColorPalette = ComposeColors(
    primary = violet500,
    secondary = violet800,
    tertiary = violet200,
    error = volcano500,
    textPrimary = grayDark01,
    textSecondary = grayDark02,
    textTertiary = grayDark03,
    textQuaternary = grayDark04,
    surface = grayDark10,
    bgPrimary = grayDark00,
    bgSecondary = grayDark09,
    divideLine = grayDark06,
    dividerBlock = grayDark10,
    disable = grayDark05,
    input = grayDark08,
)

private val localComposeColors = compositionLocalOf {
    lightBambooColorPalette
}

private val localComposeRippleTheme = compositionLocalOf {
    RippleTheme
}

object ComposeTheme {
    val typography: Typography
        get() = ComposeTypography

    val colors: ComposeColors
        @Composable
        get() = localComposeColors.current
}

@Stable
class ComposeColors(
    primary: Color,
    secondary: Color,
    tertiary: Color,
    error: Color,
    textPrimary: Color,
    textSecondary: Color,
    textTertiary: Color,
    textQuaternary: Color,
    surface: Color,
    bgPrimary: Color,
    bgSecondary: Color,
    divideLine: Color,
    dividerBlock: Color,
    disable: Color,
    input: Color,
) {
    /** 主色 */
    var primary: Color by mutableStateOf(primary)
        private set
    var secondary: Color by mutableStateOf(secondary)
        private set
    var tertiary: Color by mutableStateOf(tertiary)
        private set

    /** 错误颜色 */
    var error: Color by mutableStateOf(error)
        private set

    /** 文字色 */
    var textPrimary: Color by mutableStateOf(textPrimary)
        private set
    var textSecondary: Color by mutableStateOf(textSecondary)
        private set
    var textTertiary: Color by mutableStateOf(textTertiary)
        private set
    var textQuaternary: Color by mutableStateOf(textQuaternary)
        private set

    /** 整个窗口背景色 */
    var surface: Color by mutableStateOf(surface)
        private set

    /** 主背景色 */
    var bgPrimary: Color by mutableStateOf(bgPrimary)
        private set

    /** 次级背景色 */
    var bgSecondary: Color by mutableStateOf(bgSecondary)
        private set

    /** 分割线颜色 */
    var divideLine: Color by mutableStateOf(divideLine)
        private set

    /** 分割块颜色 */
    var dividerBlock: Color by mutableStateOf(dividerBlock)
        private set

    /** 禁用色 */
    var disable: Color by mutableStateOf(disable)
        private set

    /** 输入框色 */
    var input: Color by mutableStateOf(input)
        private set
}

@Composable
fun ComposeTheme(
    themeState: ThemeState = ThemeState(),
    content: @Composable () -> Unit
) {

    val targetColors = when (themeState.pallet) {
        ThemeState.ColorPallet.CYAN -> {
            if (themeState.mode == ThemeState.Mode.Light) {
                lightCyanColorPalette
            } else {
                darkCyanColorPalette
            }
        }

        ThemeState.ColorPallet.BAMBOO -> {
            if (themeState.mode == ThemeState.Mode.Light) {
                lightBambooColorPalette
            } else {
                darkBambooColorPalette
            }
        }

        ThemeState.ColorPallet.DAWN -> {
            if (themeState.mode == ThemeState.Mode.Light) {
                lightDawnColorPalette
            } else {
                darkDawnColorPalette
            }
        }

        ThemeState.ColorPallet.BLUE -> {
            if (themeState.mode == ThemeState.Mode.Light) {
                lightBlueColorPalette
            } else {
                darkBlueColorPalette
            }
        }

        ThemeState.ColorPallet.VIOLET -> {
            if (themeState.mode == ThemeState.Mode.Light) {
                lightVioletColorPalette
            } else {
                darkVioletColorPalette
            }
        }
    }

    val primary = animateColorAsState(targetColors.primary, TweenSpec(600), label = "")
    val secondary = animateColorAsState(targetColors.secondary, TweenSpec(600), label = "")
    val tertiary = animateColorAsState(targetColors.tertiary, TweenSpec(600), label = "")
    val error = animateColorAsState(targetColors.error, TweenSpec(600), label = "")
    val textPrimary = animateColorAsState(targetColors.textPrimary, TweenSpec(600), label = "")
    val textSecondary = animateColorAsState(targetColors.textSecondary, TweenSpec(600), label = "")
    val textTertiary = animateColorAsState(targetColors.textTertiary, TweenSpec(600), label = "")
    val textQuaternary =
        animateColorAsState(targetColors.textQuaternary, TweenSpec(600), label = "")
    val surface = animateColorAsState(targetColors.surface, TweenSpec(600), label = "")
    val bgPrimary = animateColorAsState(targetColors.bgPrimary, TweenSpec(600), label = "")
    val bgSecondary = animateColorAsState(targetColors.bgSecondary, TweenSpec(600), label = "")
    val divideLine = animateColorAsState(targetColors.divideLine, TweenSpec(600), label = "")
    val dividerBlock = animateColorAsState(targetColors.dividerBlock, TweenSpec(600), label = "")
    val disable = animateColorAsState(targetColors.disable, TweenSpec(600), label = "")
    val input = animateColorAsState(targetColors.input, TweenSpec(600), label = "")


    val colors = ComposeColors(
        primary = primary.value,
        secondary = secondary.value,
        tertiary = tertiary.value,
        error = error.value,
        textPrimary = textPrimary.value,
        textSecondary = textSecondary.value,
        textTertiary = textTertiary.value,
        textQuaternary = textQuaternary.value,
        surface = surface.value,
        bgPrimary = bgPrimary.value,
        bgSecondary = bgSecondary.value,
        divideLine = divideLine.value,
        dividerBlock = dividerBlock.value,
        disable = disable.value,
        input = input.value,
    )

    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = Color.Transparent.toArgb()
            WindowCompat.getInsetsController(window, view)
                .isAppearanceLightStatusBars = themeState.mode == ThemeState.Mode.Light
        }
    }

    MaterialTheme(
        shapes = MaterialTheme.shapes,
        typography = ComposeTypography,
    ) {
        CompositionLocalProvider(
            localComposeColors provides colors,
        ) {
            ProvideTextStyle(value = ComposeTypography.labelLarge, content = content)
        }
    }

}
