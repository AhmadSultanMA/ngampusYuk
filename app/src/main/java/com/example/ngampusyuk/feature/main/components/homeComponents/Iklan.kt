package com.example.ngampusyuk.feature.main.components.homeComponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ngampusyuk.R
import com.example.ngampusyuk.feature.main.route.Screen
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun Iklan(navController: NavController ,modifier: Modifier = Modifier) {
    Column(
        modifier
            .fillMaxSize()
            .padding(
                start = 15.dp,
                end = 15.dp
            )
    ) {
        val images = listOf(
            painterResource(R.drawable.iklan),
            painterResource(R.drawable.iklan),
            painterResource(R.drawable.iklan)
        )
        Row(modifier
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Special Offers",
                color = Color.Black,
                style = MaterialTheme.typography.bodyLarge,
            )
            Text(
                text = "See All",
                color = Color.Gray,
                style = TextStyle(fontSize = 15.sp)
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        IklanCarousel(images = images,navController ,modifier = Modifier
            .fillMaxWidth()
            .height(120.dp))
    }
}

@Composable
fun IklanCarousel(images: List<Painter>,navController: NavController , modifier: Modifier = Modifier) {
    var index by remember { mutableStateOf(0) }
    val scrollState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(key1 = true, block = {
        coroutineScope.launch {
            while (true) {
                delay(2000)
                if (index == images.size - 1) index = 0
                else index++
                scrollState.animateScrollToItem(index)
            }
        }
    })
    LazyRow(
        state = scrollState,
        modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        itemsIndexed(images) { index, image ->
            Card(
                modifier
                    .fillParentMaxHeight()
                    .clickable {
                    navController.navigate(Screen.Invoice.route) {
                        popUpTo(Screen.Home.route) {
                            inclusive = true
                        }
                    }
                },
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 8.dp
                )
            ) {
                Image(
                    painter = image, contentDescription = "imageIklan",
                    modifier = Modifier.fillParentMaxWidth(),
                    contentScale = ContentScale.FillBounds,
                )

            }
        }


    }
}


