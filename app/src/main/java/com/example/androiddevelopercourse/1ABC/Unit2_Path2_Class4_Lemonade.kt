package com.example.androiddevelopercourse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androiddevelopercourse.ui.theme.AndroidDeveloperCourseTheme

@Composable
fun LemonadeCycle(modifier: Modifier = Modifier) {

    var step by remember { mutableStateOf(1) }

    var squeeze by remember { mutableStateOf(1) }
    var squeezeLim by remember { mutableStateOf( (2..4).random()) }

    val stepText: Int = when(step) {
        1 -> R.string.step1_text
        2 -> R.string.step2_text
        3 -> R.string.step3_text
        else -> R.string.step4_text
    }
    val stepImage: Int = when(step) {
        1 -> R.drawable.lemon_tree
        2 -> R.drawable.lemon_squeeze
        3 -> R.drawable.lemon_drink
        else -> R.drawable.lemon_restart
    }

    val stepContDesc: Int = when(step) {
        1 -> R.string.step1_contentdescription
        2 -> R.string.step2_contentdescription
        3 -> R.string.step3_contentdescription
        else -> R.string.step4_contentdescription
    }

    Column(modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = stringResource(id = stepText),
            fontSize = 18.sp,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Button(onClick = {
//            if(step < 4) {
//                step++
//            } else {
//                step = 1
            if(step == 2 && squeeze < squeezeLim) {
                squeeze++
            } else if (step < 4) {
                step++
            } else {
                step = 1
                squeeze = 1
                squeezeLim = (2..4).random()
            } },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = colorResource(id = R.color.white_background)),
            border = BorderStroke(2.dp,colorResource(id = R.color.button_outline)),
            shape = RoundedCornerShape(5.dp)
        ) {
            Image(painter = painterResource(id = stepImage),
                contentDescription = stringResource(id = stepContDesc)
            )
        }
    }

}


//@Composable
//fun LemonWithImageButtonAndText(modifier: Modifier, stepText: Int, stepImage: Int, stepContDesc: Int) {
//    Column(modifier = modifier,
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        Text(text = stringResource(id = stepText),
//            fontSize = 18.sp,
//            modifier = Modifier.padding(bottom = 16.dp)
//        )
//        Button(onClick = { step = (2..4).random() },
//            colors = ButtonDefaults.buttonColors(
//                backgroundColor = colorResource(id = R.color.white_background)),
//            border = BorderStroke(2.dp,colorResource(id = R.color.button_outline)),
//            shape = RoundedCornerShape(5.dp)
//        ) {
//            Image(painter = painterResource(id = stepImage),
//                contentDescription = stringResource(id = stepContDesc)
//            )
//        }
//    }
//}

@Preview (showSystemUi = true)
@Composable
fun LemonadeApp() {
    Surface(Modifier.fillMaxSize().background(Color.White)) {}
    LemonadeCycle(
        Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
    )
}