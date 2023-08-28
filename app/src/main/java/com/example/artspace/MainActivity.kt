package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                ArtSpaceContainer(modifier = Modifier.fillMaxSize())
            }
        }
    }
}

@Composable
fun ArtSpaceContainer(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Image(
            painter = painterResource(R.drawable.ic_launcher_background),
            contentDescription = null,
            modifier = Modifier
                .padding(bottom = 36.dp, start = 32.dp, end = 32.dp, top = 10.dp).width(350.dp)
                .fillMaxWidth().fillMaxHeight(0.8f),
            contentScale = ContentScale.Crop
        )
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth().padding(start = 32.dp, end = 32.dp)
        ){
            Text(
                text = "Artwork Title",
                fontSize = 32.sp
            )
            Text(
                text = "Artwork Artist (Year)"
            )
        }
        Row (
            modifier = Modifier.fillMaxWidth().padding(start = 32.dp , end = 32.dp , top = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier.width(160.dp).fillMaxWidth(0.5f).padding(end = 8.dp),
                shape = RoundedCornerShape(0)
            ) {
                Text(text = "Previous")
            }
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier.width(160.dp).fillMaxWidth().padding(start = 8.dp),
                shape = RoundedCornerShape(0)
                ) {
                Text(text = "next")
            }
        }
    }
}

@Preview(showBackground = false)
@Composable
fun ArtSpaceLayout() {
    ArtSpaceTheme {
        ArtSpaceContainer()
    }
}