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
package com.example.androiddevchallenge

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.VectorPainter
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat
import androidx.core.view.WindowCompat.setDecorFitsSystemWindows
import com.example.androiddevchallenge.ui.theme.BloomTheme
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.theme.pink100
import com.example.androiddevchallenge.ui.theme.pink900
import com.example.androiddevchallenge.ui.theme.welcomeAssets
import com.example.androiddevchallenge.ui.theme.white

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setDecorFitsSystemWindows(window, false)
        getWindow().setStatusBarColor(Color.Transparent.value.toInt())
        setContent {
            BloomTheme(false) {
                WelcomePage()
            }
        }
    }
}

@Composable
fun WelcomePage(){
    Box(modifier = Modifier
        .fillMaxSize()
        .background(MaterialTheme.colors.primary)) {
        Image(
            painter = rememberVectorPainter(image = ImageVector.vectorResource(id = MaterialTheme.welcomeAssets.background)),
            contentDescription = "weclome_bg",
            modifier = Modifier.fillMaxSize()
        )
        Column(modifier = Modifier.fillMaxSize()) {
            Image(
                painter = rememberVectorPainter(image = ImageVector.vectorResource(id = MaterialTheme.welcomeAssets.illos)),
                contentDescription = "weclome_illos",
                modifier = Modifier
                    .wrapContentSize()
                    .padding(top = 72.dp, start = 88.dp)
            )
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 48.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = rememberVectorPainter(image = ImageVector.vectorResource(id = MaterialTheme.welcomeAssets.logo)),
                    contentDescription = "weclome_logo",
                    modifier = Modifier.wrapContentSize()
                )
                Box(modifier = Modifier
                    .fillMaxWidth()
                    .height(32.dp),
                    contentAlignment = Alignment.BottomCenter) {
                    Text(
                        text = "Beautiful home garden solutions",
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.subtitle1,
                        color = MaterialTheme.colors.onPrimary
                    )
                }
                Spacer(modifier = Modifier.height(40.dp))
                Button(
                    onClick = { },
                    modifier = Modifier
                        .height(48.dp)
                        .fillMaxWidth()
                        .padding(start = 16.dp, end = 16.dp)
                        .clip(RoundedCornerShape(50)),
                    colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.secondary)
                ) {
                    Text(
                        text = "Create account",
                        style = MaterialTheme.typography.button,
                        color = MaterialTheme.colors.onSecondary
                    )
                }
                TextButton(
                    onClick = {},
                    modifier = Modifier
                        .padding(top = 8.dp)
                        .height(48.dp),
                ) {
                    Text(
                        text = "Log in",
                        style = MaterialTheme.typography.button,
                        color = MaterialTheme.colors.secondary,
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WelcomePagePreview() {
    BloomTheme(true) {
        WelcomePage()
    }
}