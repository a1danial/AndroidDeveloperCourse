package com.example.androiddevelopercourse

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
        var pictureImage by remember { mutableStateOf(R.drawable.apollo_and_daphne__bernini___cropped_) }
        var pictureDescriptionTitle by remember { mutableStateOf("Apollo and Daphne") }
        var pictureDescriptionCreator by remember { mutableStateOf("Gian Lorenzo Bernini") }
        var pictureDescriptionYear by remember { mutableStateOf("1625") }
        var step by remember { mutableStateOf(1) }

        when (step) {
            1 -> {
                pictureImage = R.drawable.apollo_and_daphne__bernini___cropped_
                pictureDescriptionTitle = "Apollo and Daphne"
                pictureDescriptionCreator = "Gian Lorenzo Bernini"
                pictureDescriptionYear = "1625"
            }
            2 -> {
                pictureImage = R.drawable._20px_ecstasy_of_saint_teresa_september_2015_2a
                pictureDescriptionTitle = "Ecstasy of Saint Teresa"
                pictureDescriptionCreator = "Gian Lorenzo Bernini"
                pictureDescriptionYear = "1652"
            }
            3 -> {
                pictureImage = R.drawable._20px_the_rape_of_proserpina__rome_
                pictureDescriptionTitle = "The Rape of Proserpina"
                pictureDescriptionCreator = "Gian Lorenzo Bernini"
                pictureDescriptionYear = "1622"
            }
            4 -> {
                pictureImage = R.drawable._75px_michelangelo_s_pieta_5450_cut_out_black
                pictureDescriptionTitle = "Pietà"
                pictureDescriptionCreator = "Michelangelo Buonarroti"
                pictureDescriptionYear = "1499"
            }
            5 -> {
                pictureImage = R.drawable.tombstone_of_pope_alexander_vii_st__peter_s_basilica_vatican
                pictureDescriptionTitle = "Tomb of Pope Alexander VII"
                pictureDescriptionCreator = "Gian Lorenzo Bernini"
                pictureDescriptionYear = "1678"
            }
            6 -> {
                pictureImage = R.drawable.monumenttopopepiusviii
                pictureDescriptionTitle = "Monument to Pius VIII"
                pictureDescriptionCreator = "Pietro Tenerani"
                pictureDescriptionYear = "1866"
            }
        }

        // Picture
        PictureGallery(pictureImage, Modifier.weight(1f)
//            .width(315.dp)
            .fillMaxWidth()
//            .width(IntrinsicSize.Min)
        )
            // To ensure that your layout is responsive to different screen sizes, use wrap_content,
            // match_parent, or 0dp (match constraint) for the width and height of most view
            // components instead of hard-coded values

        Spacer(modifier = Modifier.size(15.dp))

        // Description
        PictureDescription(pictureDescriptionTitle, pictureDescriptionCreator, pictureDescriptionYear)

        Spacer(modifier = Modifier.size(30.dp))

        // Navigation Button
        Row(verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(40.dp, Alignment.CenterHorizontally)
        ) {
            Button(onClick = {
                if (step == 1) step = 6 else step--
            }) {
                Text("Previous",
                    textAlign = TextAlign.Center,
                    modifier = Modifier.width(70.dp)
                )
            }
            Button(onClick = {
                if (step == 6) step = 1 else step++
            }) {
                Text("Next",
                    textAlign = TextAlign.Center,
                    modifier = Modifier.width(70.dp)
                )
            }
        }
        Spacer(modifier = Modifier.size(30.dp))
    }
}

@Composable
fun PictureGallery(pictureImage: Int,
                   modifier: Modifier
) {
    Row(modifier,
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Image(painter = painterResource(pictureImage),
            contentDescription = null,
//        contentScale = ContentScale.Crop,
            contentScale = ContentScale.Fit, // Enlarge picture to fit into screen
            modifier = Modifier
                .padding(25.dp)
//                .border(5.dp, Color.Gray) // Ensure border runs around picture and not boundary
                .fillMaxSize()
        )
    }
}

@Composable
fun PictureDescription(
    pictureDescriptionTitle: String,
    pictureDescriptionCreator: String,
    pictureDescriptionYear: String
) {
    Column(
        modifier = Modifier
            .border(2.dp, Color.Gray)
            .width(275.dp)
            .padding(start = 20.dp, end = 20.dp, top = 10.dp, bottom = 10.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(5.dp, Alignment.CenterVertically)
    ) {
        Text(text = pictureDescriptionTitle,
            textAlign = TextAlign.Start,
            fontSize = 30.sp
        )
        Text(
            buildAnnotatedString {
                withStyle(style = SpanStyle(
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold
                )
                ) {
                    append(pictureDescriptionCreator)
                }
                withStyle(style = SpanStyle(
                    fontSize = 15.sp,
                    color = Color.LightGray,
                    fontStyle = FontStyle.Italic
                )
                ) {
                    append("  ($pictureDescriptionYear)")
                }
            },
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun ArtSpaceDefaultPreview() {
    AndroidDeveloperCourseTheme {
        ArtSpaceScreen()
    }
}

