package com.example.androiddevelopercourse.A1ABC.Unit4_Path1

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.androiddevelopercourse.R
import com.example.androiddevelopercourse.ui.theme.DessertClickerTheme

@Composable
fun DessertClickerApp(
    dessertViewModel: DessertViewModel = viewModel()
) {
     // ABC; Unit 4; Pathway 1; Module 2
//    var revenue by rememberSaveable { mutableStateOf(0) }
//    var dessertsSold by rememberSaveable { mutableStateOf(0) }
//
//    val currentDessertIndex by rememberSaveable { mutableStateOf(0) }
//
//    var currentDessertPrice by rememberSaveable {
//        mutableStateOf(desserts[currentDessertIndex].price)
//    }
//    var currentDessertImageId by rememberSaveable {
//        mutableStateOf(desserts[currentDessertIndex].imageId)
//    }

     // ABC; Unit 4; Pathway 1; Module 7
    val gameUiState by dessertViewModel.uiState.collectAsState()

    Scaffold(
        topBar = {
            val intentContext = LocalContext.current
            AppBar(
                // ABC; Unit 4; Pathway 1; Module 2
//                onShareButtonClicked = {
//                    shareSoldDessertsInformation(
//                        intentContext = intentContext,
//                        dessertsSold = gameUiState.dessertsSold,
//                        revenue = gameUiState.revenue
//                    )
//                }
                onShareButtonClicked = { // ABC; Unit 4; Pathway 1; Module 7
                    dessertViewModel.shareSoldDessertsInformation(
                        intentContext = intentContext
                    )
                }
            )
        }
    ) { contentPadding ->
        DessertClickerScreen(
            revenue = gameUiState.revenue,
            dessertsSold = gameUiState.dessertsSold,
            dessertImageId = gameUiState.currentDessertImageId,
            // ABC; Unit 4; Pathway 1; Module 2
//            onDessertClicked = {
//
//                // Update the revenue
//                revenue += currentDessertPrice
//                dessertsSold++
//
//                // Show the next dessert
//                val dessertToShow = determineDessertToShow(desserts, dessertsSold)
//                currentDessertImageId = dessertToShow.imageId
//                currentDessertPrice = dessertToShow.price
//            },
            onDessertClicked = { dessertViewModel.onDessertClicked() },
            modifier = Modifier.padding(contentPadding)
        )
    }
}

@Composable
private fun AppBar(
    onShareButtonClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(MaterialTheme.colors.primary),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = stringResource(R.string.app_name),
            modifier = Modifier.padding(start = 16.dp),
            color = MaterialTheme.colors.onPrimary,
            style = MaterialTheme.typography.h6,
        )
        IconButton(
            onClick = onShareButtonClicked,
            modifier = Modifier.padding(end = 16.dp),
        ) {
            Icon(
                imageVector = Icons.Filled.Share,
                contentDescription = stringResource(R.string.share),
                tint = MaterialTheme.colors.onPrimary
            )
        }
    }
}

@Composable
fun DessertClickerScreen(
    revenue: Int,
    dessertsSold: Int,
    @DrawableRes dessertImageId: Int,
    onDessertClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier) {
        Image(
            painter = painterResource(R.drawable.bakery_back),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Column {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
            ) {
                Image(
                    painter = painterResource(dessertImageId),
                    contentDescription = null,
                    modifier = Modifier
                        .width(150.dp)
                        .height(150.dp)
                        .align(Alignment.Center)
                        .clickable { onDessertClicked() },
                    contentScale = ContentScale.Crop,
                )
            }
            TransactionInfo(revenue = revenue, dessertsSold = dessertsSold)
        }
    }
}

@Composable
private fun TransactionInfo(
    revenue: Int,
    dessertsSold: Int,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .background(Color.White),
    ) {
        DessertsSoldInfo(dessertsSold)
        RevenueInfo(revenue)
    }
}

@Composable
private fun RevenueInfo(revenue: Int, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Text(
            text = stringResource(R.string.total_revenue),
            style = MaterialTheme.typography.h4
        )
        Text(
            text = "$${revenue}",
            textAlign = TextAlign.Right,
            style = MaterialTheme.typography.h4
        )
    }
}

@Composable
private fun DessertsSoldInfo(dessertsSold: Int, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Text(
            text = stringResource(R.string.dessert_sold),
            style = MaterialTheme.typography.h6
        )
        Text(
            text = dessertsSold.toString(),
            style = MaterialTheme.typography.h6
        )
    }
}

@Preview
@Composable
fun MyDessertClickerAppPreview() {
    DessertClickerTheme {
//        DessertClickerApp(listOf(DessertU4P1(R.drawable.cupcake, 5, 0)))
    }
}