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

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Card
import androidx.compose.material.Checkbox
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.FilterList
import androidx.compose.material.icons.rounded.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.theme.WelcomeTheme
import com.example.androiddevchallenge.ui.theme.appTypography
import com.example.androiddevchallenge.ui.theme.shapes

@Composable
fun HomeScreen() {
    WelcomeTheme {
        Column {
            Spacer(modifier = Modifier.height(40.dp))
            OutlinedTextField(
                value = "",
                onValueChange = { },
                label = {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            Icons.Rounded.Search,
                            contentDescription = "Localized description",
                            tint = colors.onPrimary,
                            modifier = Modifier.size(18.dp)
                        )
                        Text(
                            "Search",
                            style = appTypography.body1,
                            color = colors.onPrimary,
                            modifier = Modifier.padding(8.dp)
                        )
                    }
                },
                modifier = Modifier
                    .height(64.dp)
                    .fillMaxWidth()
                    .padding(
                        horizontal = 16.dp,
                        vertical = 0.dp
                    )
            )

            Text(
                "Browse themes",
                style = appTypography.h1,
                fontWeight = FontWeight.Bold,
                color = colors.onPrimary,
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .paddingFromBaseline(
                        top = 32.dp,
                        bottom = 16.dp
                    )
            )

            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 0.dp),
            ) {
                // Add 5 items
                items(5) { index ->
                    Card(
                        shape = shapes.small,
                        elevation = 1.dp,
                        modifier = Modifier
                            .size(136.dp)
                    ) {
                        Column {
                            Image(
                                painter = painterResource(id = rowsItems[index].imageId),
                                contentDescription = null,
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .background(colors.primary)
                                    .fillMaxWidth()
                                    .height(96.dp)
                            )
                            Text(
                                text = rowsItems[index].title,
                                style = appTypography.h2,
                                fontWeight = FontWeight.Bold,
                                color = colors.onPrimary,
                                modifier = Modifier
                                    .padding(16.dp, 8.dp)
                            )
                        }
                    }
                }
            }

            ImageList()

            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(8.dp),
                contentPadding = PaddingValues(horizontal = 0.dp, vertical = 8.dp),
                content = {
                    items(6) { index ->
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(
                                    horizontal = 16.dp,
                                    vertical = 0.dp
                                )
                        ) {
                            Card(
                                shape = shapes.small,
                                modifier = Modifier
                                    .background(colors.primary)
                                    .padding()
                                    .width(64.dp)
                                    .height(64.dp)
                            ) {
                                Image(
                                    painter = painterResource(id = listItems[index].imageId),
                                    contentDescription = null,
                                    contentScale = ContentScale.Crop
                                )
                            }
                            Column {
                                Text(
                                    text = listItems[index].title,
                                    style = appTypography.h2,
                                    fontWeight = FontWeight.Bold,
                                    color = colors.onPrimary,
                                    modifier = Modifier
                                        .padding(horizontal = 8.dp)
                                        .paddingFromBaseline(
                                            top = 24.dp
                                        )
                                )
                                Text(
                                    text = "This is a description",
                                    style = appTypography.body1,
                                    fontWeight = FontWeight.Normal,
                                    color = colors.onPrimary,
                                    modifier = Modifier
                                        .padding(horizontal = 8.dp)
                                        .paddingFromBaseline(
                                            bottom = 24.dp
                                        )
                                )
                            }
                            Box(
                                Modifier.padding(16.dp)
                                    .weight(1f)
                                    .wrapContentWidth(Alignment.End)
                            ) {
                                Checkbox(checked = false, onCheckedChange = { /*TODO*/ })
                            }
                        }
                        Divider(
                            color = colors.onPrimary,
                            thickness = 1.dp,
                            startIndent = 80.dp,
                            modifier = Modifier
                                .padding(
                                    end = 16.dp
                                )
                        )
                    }
                }
            )
        }
    }
}

@Composable
fun ImageList() {
    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            "Design your home garden",
            style = appTypography.h1,
            fontWeight = FontWeight.Bold,
            color = colors.onPrimary,
            modifier = Modifier
                .padding(horizontal = 8.dp)
                .paddingFromBaseline(
                    top = 40.dp,
                    bottom = 16.dp
                )
        )
        Row(
            horizontalArrangement = Arrangement.End,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Column(verticalArrangement = Arrangement.Bottom) {
                Icon(
                    Icons.Rounded.FilterList,
                    contentDescription = "Localized description",
                    tint = colors.onPrimary,
                    modifier = Modifier
                        .size(24.dp)
                )
            }
        }
    }
}

@Composable
fun ImageListColumn() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        Card(
            shape = shapes.small,
            modifier = Modifier
                .background(colors.primary)
                .padding()
                .width(64.dp)
                .height(64.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.card_rows_image0),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
        }
        Column {
            Text(
                text = "rowsItems[index].title",
                style = appTypography.h2,
                fontWeight = FontWeight.Bold,
                color = colors.onPrimary,
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .paddingFromBaseline(
                        top = 24.dp
                    )
            )
            Text(
                text = "rowsItems[index].title",
                style = appTypography.body1,
                fontWeight = FontWeight.Normal,
                color = colors.onPrimary,
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .paddingFromBaseline(
                        bottom = 24.dp
                    )
            )
        }
        Box(
            Modifier.padding(16.dp)
                .weight(1f)
                .wrapContentWidth(Alignment.End)
        ) {
            Checkbox(checked = false, onCheckedChange = { /*TODO*/ })
        }
    }
    Divider(
        color = colors.onPrimary,
        thickness = 1.dp,
        startIndent = 80.dp,
        modifier = Modifier
            .padding(
                end = 16.dp
            )
    )
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightHomePreview() {
    WelcomeTheme {
        ImageListColumn()
    }
}
