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

import androidx.compose.material.Typography
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.R

// Set of Material typography styles to start with

private val appFontFamily = FontFamily(
    fonts = listOf(
        Font(
            resId = R.font.nunito_sans_bold,
            weight = FontWeight.Bold
        ),
        Font(
            resId = R.font.nunito_sans_semi_bold,
            weight = FontWeight.SemiBold
        ),
        Font(
            resId = R.font.nunito_sans_light,
            weight = FontWeight.Light
        )
    )
)

val defaultTypography = Typography()
val appTypography = Typography(
    h1 = defaultTypography.h1.copy(
        fontSize = 18.sp,
        letterSpacing = 0.sp,
        fontFamily = appFontFamily
    ),
    h2 = defaultTypography.h2.copy(
        fontSize = 14.sp,
        letterSpacing = 0.15.sp,
        fontFamily = appFontFamily
    ),
    h3 = defaultTypography.h3.copy(fontFamily = appFontFamily),
    h4 = defaultTypography.h4.copy(fontFamily = appFontFamily),
    h5 = defaultTypography.h5.copy(fontFamily = appFontFamily),
    h6 = defaultTypography.h6.copy(fontFamily = appFontFamily),
    subtitle1 = defaultTypography.subtitle1.copy(
        letterSpacing = 0.sp,
        fontFamily = appFontFamily
    ),
    subtitle2 = defaultTypography.subtitle2.copy(fontFamily = appFontFamily),
    body1 = defaultTypography.body1.copy(
        fontSize = 14.sp,
        letterSpacing = 0.sp,
        fontFamily = appFontFamily
    ),
    body2 = defaultTypography.body2.copy(
        fontSize = 12.sp,
        letterSpacing = 0.sp,
        fontFamily = appFontFamily
    ),
    button = defaultTypography.button.copy(
        fontSize = 14.sp,
        letterSpacing = 1.sp,
        fontFamily = appFontFamily
    ),
    caption = defaultTypography.caption.copy(
        fontSize = 12.sp,
        letterSpacing = 0.sp,
        fontFamily = appFontFamily
    ),
    overline = defaultTypography.overline.copy(fontFamily = appFontFamily)
)
