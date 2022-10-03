package com.example.androiddevelopercourse.A1ABC.Unit3_Path3

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevelopercourse.A1ABC.Unit3_Path3.HeroesRepository.heroes
import com.example.androiddevelopercourse.R
import com.example.androiddevelopercourse.ui.theme.SuperheroesTheme
import com.example.androiddevelopercourse.ui.theme.WoofTheme

@Composable
fun SuperheroesApp() {
    Scaffold(
        topBar = {
            Text(
                text = stringResource(id = R.string.app_name_superheroes),
                modifier = Modifier
                    .background(MaterialTheme.colors.background)
                    .fillMaxWidth()
                    .height(56.dp),
                style = MaterialTheme.typography.h1,
                textAlign = TextAlign.Center
            )
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .background(MaterialTheme.colors.background)
                .padding(padding),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(heroes) {
                SuperheroItem(hero = it)
            }
        }
    }
}

@Composable
fun SuperheroItem(hero: Hero) {
    Card(
        modifier = Modifier.height(74.dp),
        elevation = 2.dp
    ) {
        Row(
            modifier = Modifier
                .padding(top = 12.dp)
                .fillMaxSize(),
//            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.weight(1f).padding(start = 12.dp)
            ) {
                Text(
                    text = stringResource(id = hero.nameRes),
                    style = MaterialTheme.typography.h3
                )
                Text(
                    text = stringResource(id = hero.descriptionRes),
                    style = MaterialTheme.typography.body1,
//                    modifier = Modifier.padding(end = 32.dp)
                )
            }
            Image(
                modifier = Modifier
                    .padding(start = 16.dp, end = 12.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .size(50.dp)
                    .align(Alignment.Top),
                contentScale = ContentScale.Crop,
                painter = painterResource(hero.imageRes),
                contentDescription = null
            )
        }
    }
}

@Preview
@Composable
fun SuperheroesPreview() {
    SuperheroesTheme { // ABC; Unit 3; Pathway 3; Module 5
        SuperheroesApp()
    }
}