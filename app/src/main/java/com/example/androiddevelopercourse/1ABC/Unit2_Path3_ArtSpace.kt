package com.example.androiddevelopercourse

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevelopercourse.ui.theme.AndroidDeveloperCourseTheme

@Composable
fun ArtSpaceScreen() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
    ) {
        Image(painter = painterResource(id = R.drawable.apollo_and_daphne__bernini___cropped_),
            contentDescription = null,
            contentScale = ContentScale.Crop,
//                modifier = Modifier.padding(top = 15.dp).width(300.dp)
            modifier = Modifier
                .padding(25.dp)
                .height(400.dp)
                .width(200.dp)
                .border(5.dp, Color.Gray)
        )
        Spacer(modifier = Modifier.size(30.dp))
        Column(
            modifier = Modifier
                .border(2.dp, Color.Gray)
                .width(300.dp)
                .padding(start = 30.dp, end = 30.dp, top = 10.dp, bottom = 10.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "Apollo and Daphne")
            Row() {
                Text(text = "Gian Lorenzo Bernini")
                Text(text = "(1625)")
            }
        }
        Spacer(modifier = Modifier.size(30.dp))
        Row(verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(40.dp, Alignment.CenterHorizontally)
        ) {
            Button(onClick = { /*TODO*/ }) {
                Text("Previous",
                    textAlign = TextAlign.Center,
                    modifier = Modifier.width(70.dp)
                )
            }
            Button(onClick = { /*TODO*/ }) {
                Text("Next",
                    textAlign = TextAlign.Center,
                    modifier = Modifier.width(70.dp)
                )
            }
        }
        Spacer(modifier = Modifier.size(30.dp))
    }
}

@Preview(showSystemUi = true)
@Composable
fun ArtSpaceDefaultPreview() {
    AndroidDeveloperCourseTheme {
        ArtSpaceScreen()
    }
}

