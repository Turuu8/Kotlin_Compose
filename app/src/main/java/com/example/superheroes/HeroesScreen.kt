package com.example.superheroes

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.superheroes.model.HeroesRepository
import com.example.superheroes.model.Hero


class HeroesScreen {
}

@Composable
fun SuperHeroesContainer () {

    LazyColumn(){
        items(HeroesRepository.heroes) {heros->
            SuperHeroCard(heros)
        }
    }
}

@Composable
fun SuperHeroCard (heroes: Hero, modifier: Modifier = Modifier) {
    Card (
        shape = RoundedCornerShape(16.dp)
    ) {
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .height(72.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Column {
                Text(
                    text = stringResource(heroes.nameRes),
                    style = MaterialTheme.typography.displaySmall
                )
                Text(
                    text = stringResource(heroes.descriptionRes),
                    style = MaterialTheme.typography.bodyLarge
                )
            }
            Image(
                painter = painterResource(heroes.imageRes),
                contentDescription = null,
                modifier = Modifier
                    .padding(start = 16.dp)
                    .clip(MaterialTheme.shapes.small),
            )
        }
    }
}

@Preview(showBackground = false)
@Composable
fun SuperHereosScreenPreview () {
    SuperHeroesContainer()
}