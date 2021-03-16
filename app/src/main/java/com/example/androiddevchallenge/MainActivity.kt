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

import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.AlignmentLine
import androidx.compose.ui.layout.ContentScale.Companion.FillHeight
import androidx.compose.ui.layout.FirstBaseline
import androidx.compose.ui.layout.layout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.NavGraph
import com.example.androiddevchallenge.ui.theme.WelcomeTheme
import com.example.androiddevchallenge.ui.theme.appTypography
import com.example.androiddevchallenge.ui.theme.pink900
import com.example.androiddevchallenge.ui.theme.shapes
import com.example.androiddevchallenge.ui.theme.white

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        window.apply {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                setDecorFitsSystemWindows(false)
            } else {
                @Suppress("DEPRECATION")
                decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
            }
        }
        super.onCreate(savedInstanceState)
        setContent {
            NavGraph()
        }
    }
}

// Start building your app here!
@Composable
fun MyApp(onClick: () -> Unit) {
    WelcomeTheme {
        val bgId = if (isSystemInDarkTheme()) {
            R.drawable.dark_welcome_bg
        } else {
            R.drawable.light_welcome_bg
        }

        Image(
            painter = painterResource(id = bgId),
            contentDescription = null,
            modifier = Modifier
                .background(colors.primary)
                .fillMaxWidth()
                .fillMaxHeight()
        )
        Column {
            Spacer(Modifier.size(72.dp))
            Row {
                Spacer(Modifier.size(88.dp))
                Box {
                    val logoId = if (isSystemInDarkTheme()) {
                        R.drawable.dark_welcome_illos
                    } else {
                        R.drawable.light_welcome_illos
                    }
                    Image(
                        painter = painterResource(id = logoId),
                        contentDescription = null,
                        contentScale = FillHeight,
                        alignment = Alignment.CenterStart,
                        modifier = Modifier
                            .height((35 * 8).dp)
                    )
                }
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                val logoId = if (isSystemInDarkTheme()) {
                    R.drawable.dark_logo
                } else {
                    R.drawable.light_logo
                }

                Spacer(Modifier.size(48.dp))
                Image(
                    painter = painterResource(id = logoId),
                    contentDescription = null,
                    modifier = Modifier.padding()
                )
                Text(
                    "Beautiful home garden solutions",
                    style = appTypography.subtitle1,
                    fontWeight = FontWeight.Light,
                    color = colors.onPrimary,
                    modifier = Modifier
                        .firstBaselineToTop(
                            24.dp,
                            40.dp
                        )
                        .padding()
                )
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.Top,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Button(
                        shape = shapes.medium,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(48.dp)
                            .padding(
                                vertical = 0.dp,
                                horizontal = 16.dp
                            ),
                        colors = ButtonDefaults.buttonColors(backgroundColor = colors.secondary),
                        onClick = { /*TODO*/ }
                    ) {
                        Text(
                            "Create account",
                            style = appTypography.button,
                            fontWeight = FontWeight.SemiBold,
                            color = colors.onSecondary
                        )
                    }
                }
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .height(64.dp)
                        .fillMaxWidth()
                        .padding(
                            vertical = 8.dp,
                            horizontal = 16.dp
                        )
                        .clickable(onClick = onClick)
                ) {
                    Text(
                        "Log in",
                        style = appTypography.button,
                        fontWeight = FontWeight.SemiBold,
                        color = if (isSystemInDarkTheme()) {
                            white
                        } else {
                            pink900
                        },
                        modifier = Modifier
                            .padding()
                    )
                }
            }
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    WelcomeTheme {
        MyApp(
            onClick = { /*TODO*/ }
        )
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    WelcomeTheme(darkTheme = true) {
        MyApp(
            onClick = { /*TODO*/ }
        )
    }
}

fun Modifier.firstBaselineToTop(
    firstBaselineToTop: Dp,
    bottomToFirstBaseline: Dp = 0.dp
) = Modifier.layout { measurable, constraints ->
    // Measure the composable
    val placeable = measurable.measure(constraints)

    // Check the composable has a first baseline
    check(placeable[FirstBaseline] != AlignmentLine.Unspecified)
    val firstBaseline = placeable[FirstBaseline]

    // Height of the composable with padding - first baseline
    val placeableY = firstBaselineToTop.toPx() - firstBaseline
    var height = placeable.height + placeableY

    if (bottomToFirstBaseline > 0.dp) {
        height = height + bottomToFirstBaseline.toPx() - placeableY
    }
    layout(placeable.width, height.toInt()) {
        // Where the composable gets placed
        placeable.place(0, placeableY.toInt(), 0F)
    }
}
