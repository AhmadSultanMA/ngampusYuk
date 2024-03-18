package com.example.ngampusyuk.feature.main.components.homeComponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ngampusyuk.R
import com.example.ngampusyuk.feature.main.route.Screen
import com.example.ngampusyuk.ui.theme.CustLightBlue

@Composable
fun Fitur(navController: NavController, modifier: Modifier = Modifier) {
    val images = listOf(
        painterResource(R.drawable.fitur1),
        painterResource(R.drawable.fitur2),
        painterResource(R.drawable.fitur3)
    )
    val routes = listOf(
        Screen.Tes.route,
        Screen.Banding.route,
        Screen.PilihTO.route
    )

    Box(
        modifier
            .background(
                color = CustLightBlue
            )
            .padding(
                bottom = 15.dp,
                top = 15.dp
            )
    ) {
        Column {
            Text(
                text = "Fitur Menarik",
                color = Color.Black,
                style = TextStyle(fontSize = 15.sp, fontWeight = FontWeight.Medium),
                modifier = Modifier.padding(start = 15.dp, end = 15.dp)

            )
            Text(
                text = "Cek peluang masuk kuliah kamu disini dan bandingkan hasilnya !",
                color = Color.Gray,
                style = TextStyle(fontSize = 12.sp),
                modifier = Modifier.padding(start = 15.dp, end = 15.dp)
            )
            Spacer(modifier = Modifier.height(10.dp))
            FiturCarousel(navController, images, routes,modifier
                .fillMaxWidth()
                .height(100.dp)
                .padding(start = 15.dp)
            )
        }
    }
}

@Composable
fun FiturCarousel(navController: NavController,images: List<Painter>, routes: List<String>, modifier: Modifier = Modifier) {
    val screenWidth = LocalConfiguration.current.screenWidthDp.dp

    LazyRow(
        modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        itemsIndexed(images) { index, image ->
            Card(
                modifier
                    .fillParentMaxHeight()
                    .clickable {
                        navController.navigate(routes[index]) {
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
                    modifier = Modifier.width(screenWidth*0.75f),
                    contentScale = ContentScale.FillBounds,
                )

            }
        }
    }
}
