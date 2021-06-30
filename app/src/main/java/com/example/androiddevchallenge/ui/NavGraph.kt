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
package com.example.androiddevchallenge.ui

import android.view.Window
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.toArgb
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.R

object TouristGuide {
    var navController: NavHostController? = null
        set(value) {
            field = value
        }

    fun toWelcome() {
        navController?.navigate(RouterPath.WELCOME) {
            anim {
                this.enter = R.anim.slide_in_right
                this.exit = R.anim.slide_out_left
                this.popEnter = R.anim.slide_in_left
                this.popExit = R.anim.slide_out_right
            }
        }
    }
    fun toLogin() {
        navController?.navigate(RouterPath.LOGIN) {
            anim {
                this.enter = R.anim.slide_in_right
                this.exit = R.anim.slide_out_left
                this.popEnter = R.anim.slide_in_left
                this.popExit = R.anim.slide_out_right
            }
        }
    }
    fun toHome() {
        navController?.navigate(RouterPath.HOME) {
            anim {
                this.enter = R.anim.slide_in_right
                this.exit = R.anim.slide_out_left
                this.popEnter = R.anim.slide_in_left
                this.popExit = R.anim.slide_out_right
            }
        }
    }
}

private object RouterPath {
    val WELCOME = "welcome"
    val LOGIN = "login"
    val HOME = "home"
}

@Composable
fun NavGraph(window: Window) {
    val navHostController = rememberNavController()
    TouristGuide.navController = navHostController

    NavHost(navController = navHostController, startDestination = RouterPath.WELCOME) {
        composable(RouterPath.WELCOME) {
            window.statusBarColor = MaterialTheme.colors.primary.toArgb()
            WelcomePage()
        }
        composable(RouterPath.LOGIN) {
            window.statusBarColor = MaterialTheme.colors.background.toArgb()
            LoginPage()
        }
        composable(RouterPath.HOME) {
            window.statusBarColor = MaterialTheme.colors.background.toArgb()
            HomePage()
        }
    }
}
