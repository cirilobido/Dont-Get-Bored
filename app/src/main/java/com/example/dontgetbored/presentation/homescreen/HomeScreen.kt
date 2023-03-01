package com.example.dontgetbored.presentation.homescreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.dontgetbored.R
import com.example.dontgetbored.presentation.theme.Primary
import com.example.dontgetbored.presentation.theme.Secondary
import com.example.dontgetbored.presentation.theme.Shapes
import com.example.dontgetbored.presentation.theme.TextColor
import com.example.dontgetbored.util.Util

@Composable
fun HomeScreen(viewModel: HomeScreenViewModel = hiltViewModel()) {
    val homeState = viewModel.homeState
    Box(
        modifier = Modifier
            .background(Secondary)
    ) {
        Image(
            painter = painterResource(id = R.drawable.background_purple),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .align(Alignment.Center)
                .fillMaxSize()
        )
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(32.dp)
                    .defaultMinSize(minHeight = 210.dp)
                    .shadow(
                        elevation = 6.dp,
                        shape = Shapes.medium,
                    ),
                backgroundColor = Color.White,
                shape = Shapes.medium
            ) {
                Column(
                    Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Text(
                        text = "Activity For You",
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = Primary
                        )
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    if (homeState.isLoading) {
                        Box(
                            contentAlignment = Alignment.Center,
                            modifier = Modifier
                                .fillMaxWidth()
                        ) {
                            CircularProgressIndicator(
                                color = Secondary, modifier = Modifier.padding(20.dp)
                            )
                        }
                    }
                    if (homeState.boredActivity != null) {
                        Column(
                            Modifier
                                .fillMaxWidth(),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = "${homeState.boredActivity.activity}!",
                                style = TextStyle(
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.W400,
                                    color = TextColor,
                                    textAlign = TextAlign.Center,
                                )
                            )
                            Spacer(modifier = Modifier.height(10.dp))
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Column(
                                    verticalArrangement = Arrangement.Center,
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Icon(
                                        modifier = Modifier
                                            .size(38.dp),
                                        tint = Primary,
                                        painter = painterResource(id = R.drawable.ic_users),
                                        contentDescription = "Participants"
                                    )
                                    Text(
                                        text = "${homeState.boredActivity.participants}",
                                        style = TextStyle(
                                            fontSize = 18.sp,
                                            fontWeight = FontWeight.W400,
                                            color = TextColor,
                                            textAlign = TextAlign.Center,
                                        )
                                    )
                                }
                                Column(
                                    verticalArrangement = Arrangement.Center,
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Icon(
                                        modifier = Modifier
                                            .size(38.dp),
                                        tint = Primary,
                                        painter = painterResource(id = R.drawable.ic_price),
                                        contentDescription = "Price"
                                    )
                                    Text(
                                        text = Util.boredPriceToString(homeState.boredActivity.price),
                                        style = TextStyle(
                                            fontSize = 18.sp,
                                            fontWeight = FontWeight.W400,
                                            color = TextColor,
                                            textAlign = TextAlign.Center,
                                        )
                                    )
                                }
                                Column(
                                    verticalArrangement = Arrangement.Center,
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Icon(
                                        modifier = Modifier
                                            .size(38.dp),
                                        tint = Primary,
                                        painter = painterResource(id = R.drawable.ic_access),
                                        contentDescription = "Probability to do the activity"
                                    )
                                    Text(
                                        text = Util.boredAccessibilityFormatter(homeState.boredActivity.accessibility),
                                        style = TextStyle(
                                            fontSize = 18.sp,
                                            fontWeight = FontWeight.W400,
                                            color = TextColor,
                                            textAlign = TextAlign.Center,
                                        )
                                    )
                                }
                            }
                            Spacer(modifier = Modifier.height(10.dp))
                            Text(
                                text = "#${homeState.boredActivity.type}",
                                style = TextStyle(
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.W400,
                                    color = Primary.copy(alpha = 0.7f),
                                    textAlign = TextAlign.Center,
                                )
                            )
                        }
                    }
                }
            }
            Button(
                onClick = {
                    viewModel.getNewActivity()
                },
                Modifier
                    .shadow(
                        elevation = 16.dp,
                        shape = Shapes.large,
                        ambientColor = Secondary,
                        spotColor = Secondary,
                    ),
                shape = Shapes.large,
                colors = ButtonDefaults.buttonColors(
                    contentColor = TextColor,
                    backgroundColor = Secondary
                )
            ) {
                Text(
                    text = "Don't Get Bored",
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = TextColor
                    ),
                    modifier = Modifier
                        .padding(
                            horizontal = 20.dp,
                            vertical = 2.dp
                        ),
                )
            }
        }
    }
}