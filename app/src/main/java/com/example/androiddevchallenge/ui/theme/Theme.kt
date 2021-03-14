/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.ui.theme

import android.util.Log
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.example.androiddevchallenge.R



private val BloomLightColorPaltte = lightColors(
    primary = pink100,
    secondary = pink900,
    background = white,
    surface = white850,
    onPrimary = gray,
    onSecondary = white,
    onBackground = gray,
    onSurface = gray,
)

private val BloomDarkColorPaltte = darkColors(
    primary = green900,
    secondary = green300,
    background = gray,
    surface = white150,
    onPrimary = white,
    onSecondary = gray,
    onBackground = white,
    onSurface = white850
)



private val DarkColorPalette = darkColors(
    primary = purple200,
    primaryVariant = purple700,
    secondary = teal200
)

private val LightColorPalette = lightColors(
    primary = purple500,
    primaryVariant = purple700,
    secondary = teal200

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
fun MyTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable() () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = typography,
        shapes = shapes,
        content = content
    )
}

object WelcomeAssets {
    var background: Int = 0
    var illos: Int = 0
    var logo: Int = 0
    fun set(background: Int, illos: Int, logo: Int) {
        this.background = background
        this.illos = illos
        this.logo = logo
    }
}

val MaterialTheme.welcomeAssets: WelcomeAssets
    get() = WelcomeAssets

@Composable
fun BloomTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable() () -> Unit) {
    var colors: Colors
    if (darkTheme) {
        colors = BloomDarkColorPaltte
        WelcomeAssets.set(
            background = R.drawable.ic_dark_welcome_bg,
            illos = R.drawable.ic_dark_welcome_illos,
            logo = R.drawable.ic_dark_logo
        )
    } else {
        colors = BloomLightColorPaltte
        WelcomeAssets.set(
            background = R.drawable.ic_light_welcome_bg,
            illos = R.drawable.ic_light_welcome_illos,
            logo = R.drawable.ic_light_logo
        )
    }

    MaterialTheme(
        colors = colors,
        typography = bloomTypoGraphy,
        shapes = shapes,
        content = content
    )
}
