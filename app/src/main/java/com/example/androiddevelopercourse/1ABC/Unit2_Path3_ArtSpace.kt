package com.example.androiddevelopercourse

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevelopercourse.ui.theme.AndroidDeveloperCourseTheme

@Composable
fun ArtSpaceScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White).border(5.dp, Color.Gray),
    ) {

    }

}

@Preview(showSystemUi = true)
@Composable
fun ArtSpaceDefaultPreview() {
    AndroidDeveloperCourseTheme {
        ArtSpaceScreen()
    }
}

