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

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Card
import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxDefaults
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.data.Item
import com.example.androiddevchallenge.ui.theme.BloomTheme

val plantList = listOf(
    Item("Desert chic", R.drawable.desert_chic),
    Item("Tiny terrariums", R.drawable.tiny_terrariums),
    Item("Jungle Vibes", R.drawable.jungle_vibes)
)

val designList = listOf(
    Item("Monstera", R.drawable.monstera),
    Item("Aglaonema", R.drawable.aglaonema),
    Item("Peace lily", R.drawable.peace_lily),
    Item("Fiddle leaf tree", R.drawable.fiddle_leaf)
)

val navList = listOf(
    Item("Home", R.drawable.ic_home),
    Item("Favorites", R.drawable.ic_favorite_border),
    Item("Profile", R.drawable.ic_account_circle),
    Item("Cart", R.drawable.ic_shopping_cart)
)

@Composable
fun HomePage() {
    Scaffold(
        bottomBar = {
            BottomBar()
        }
    ) {
        Column(
            Modifier
                .fillMaxSize()
                .background(MaterialTheme.colors.background)
        ) {
            OutlinedTextField(
                value = "",
                onValueChange = {},
                modifier = Modifier
                    .padding(top = 16.dp, start = 16.dp, end = 16.dp)
                    .fillMaxWidth()
                    .height(56.dp)
                    .clip(RoundedCornerShape(4.dp)),
                placeholder = {
                    Row {
                        Icon(
                            painter = rememberVectorPainter(image = ImageVector.vectorResource(id = R.drawable.ic_search)),
                            contentDescription = "search",
                            modifier = Modifier.size(18.dp)
                        )
                        Text(
                            text = "Search",
                            style = MaterialTheme.typography.body1,
                            color = MaterialTheme.colors.onPrimary
                        )
                    }
                }
            )
            Box(
                Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp)
            ) {
                Text(
                    text = "Browse themes",
                    style = MaterialTheme.typography.h1,
                    color = MaterialTheme.colors.onPrimary,
                    modifier = Modifier
                        .fillMaxWidth()
                        .paddingFromBaseline(top = 32.dp, bottom = 16.dp)
                )
            }
            LazyRow(
                modifier = Modifier.height(136.dp),
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 0.dp)
            ) {
                items(plantList.size) {
                    if (it != 0) {
                        Spacer(modifier = Modifier.width(8.dp))
                    }
                    PlantCard(plantList[it])
                }
            }
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Design your home garden",
                    style = MaterialTheme.typography.h1,
                    color = MaterialTheme.colors.onPrimary,
                    modifier = Modifier
                        .paddingFromBaseline(top = 40.dp)
                )
                Icon(
                    painterResource(id = R.drawable.ic_filter_list),
                    "filter",
                    modifier = Modifier
                        .padding(top = 24.dp)
                        .size(24.dp)
                )
            }
            LazyColumn(
                modifier = Modifier
                    .padding(top = 16.dp)
                    .fillMaxWidth()
            ) {
                items(designList.size) {
                    if (it != 0) {
                        Spacer(modifier = Modifier.height(8.dp))
                    }
                    DesignCard(designList[it])
                }
            }
        }
    }
}

@Composable
fun DesignCard(plant: Item) {
    Row(
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp)
            .fillMaxWidth()
    ) {
        Image(
            painterResource(id = plant.resId),
            contentScale = ContentScale.Crop,
            contentDescription = "image",
            modifier = Modifier
                .padding(end = 16.dp)
                .size(64.dp)
        )
        Column {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Column {
                    Text(
                        text = plant.name,
                        style = MaterialTheme.typography.h2,
                        color = MaterialTheme.colors.onPrimary,
                        modifier = Modifier
                            .paddingFromBaseline(top = 24.dp)
                    )
                    Text(
                        text = "This is a description",
                        style = MaterialTheme.typography.body1,
                        color = MaterialTheme.colors.onPrimary,
                        modifier = Modifier
                    )
                }
                Checkbox(
                    checked = plant.name == "Monstera",
                    onCheckedChange = {},
                    colors = CheckboxDefaults.colors(
                        checkmarkColor = MaterialTheme.colors.background
                    ),
                    modifier = Modifier
                        .size(24.dp)
                        .padding(top = 24.dp)
                )
            }
            Divider(color = MaterialTheme.colors.onPrimary, modifier = Modifier.padding(top = 16.dp), thickness = 0.5.dp)
        }
    }
}

@Composable
fun PlantCard(plant: Item) {
    Card(
        modifier = Modifier
            .size(136.dp)
            .clip(RoundedCornerShape(4.dp))
    ) {
        Column {
            Image(
                painterResource(id = plant.resId),
                contentScale = ContentScale.Crop,
                contentDescription = "image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(96.dp)
            )
            Box(
                Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp)
            ) {
                Text(
                    text = plant.name,
                    style = MaterialTheme.typography.h2,
                    color = MaterialTheme.colors.onPrimary,
                    modifier = Modifier
                        .fillMaxWidth()
                        .paddingFromBaseline(top = 24.dp, bottom = 16.dp)
                )
            }
        }
    }
}

@Composable
fun BottomBar() {
    BottomNavigation(
        elevation = 16.dp,
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .background(MaterialTheme.colors.primary)
    ) {
        navList.forEach {
            BottomNavigationItem(
                onClick = {},
                icon = {
                    Icon(
                        painterResource(id = it.resId),
                        contentDescription = null,
                        modifier = Modifier.size(24.dp),
                    )
                },
                label = {
                    Text(
                        it.name,
                        style = MaterialTheme.typography.caption,
                        color = MaterialTheme.colors.onPrimary,
                    )
                },
                selected = ("Home" == it.name)
            )
        }
    }
}

// @Preview
// @Composable
// fun BottomBarPreview() {
//    BloomTheme(false) {
//        BottomBar()
//    }
// }
//
// @Preview
// @Composable
// fun DesignCardPreview() {
//    BloomTheme(false) {
//        DesignCard(designList[0])
//    }
// }
//
// @Preview
// @Composable
// fun PlantCardPreview() {
//    BloomTheme(false) {
//        PlantCard(plantList[0])
//    }
// }

@Preview
@Composable
fun HomePageLightPreview() {
    BloomTheme(false) {
        HomePage()
    }
}

@Preview
@Composable
fun HomePageDarkPreview() {
    BloomTheme(true) {
        HomePage()
    }
}
