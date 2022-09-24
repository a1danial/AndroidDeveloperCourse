package com.example.androiddevelopercourse.A1ABC.Unit3_Path2

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevelopercourse.R

@Composable
fun GridApp() {
//    val context = LocalContext.current
    GridList(photoList = DataSourceGrid.topics)
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun GridList(photoList: List<Topic>) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(8.dp),
    ) {
        items(photoList.size) { index ->
            GridPhoto(topic = photoList[index])
        }
    }
}

@Composable
fun GridPhoto(topic: Topic) {
    Card(elevation = 4.dp) {
        Row( // "modifier = Modifier" not needed
        ) {
            Image(
                painter = painterResource(id = topic.imageResourceId),
                contentDescription = stringResource(topic.stringResourceId), // or Null
                modifier = Modifier.size(68.dp).aspectRatio(1f), // Correct answer
//                modifier = Modifier.size(68.dp),
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier
                    .padding(start = 16.dp, end = 16.dp, top = 16.dp)
            ) {
                Text(
                    text = stringResource(topic.stringResourceId),
                    maxLines = 1,
                    style = MaterialTheme.typography.body2
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.Start),
                    modifier = Modifier.padding(top = 8.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_grain),
                        contentDescription = null,
                        modifier = Modifier
                            .size(12.dp)
//                            .size(MaterialTheme.typography.caption.fontSize.value.dp)
                            .aspectRatio(1f,true)
                    )
                    Text(
                        text = topic.courseCount.toString(),
                        style = MaterialTheme.typography.caption
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun GridPreview() {
    GridPhoto(topic = Topic(R.string.architecture, 58, R.drawable.architecture) )
}

