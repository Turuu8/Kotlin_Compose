package com.example.composetest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.LocationOn
import androidx.compose.material.icons.rounded.MailOutline
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.composetest.ui.theme.ComposeTestTheme
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTestTheme {
//                ContainerText();
//                RightIcon();
//                FourText();
                ContactAs();
            }
        }
    }
}

// ----------------------- Text screen -----------------------
@Composable
fun GreetingText(text : String , modifier: Modifier) {
    Text(
        text = text,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        modifier = modifier
    )
}

@Composable
fun ContainerText(){
    val image = painterResource(R.drawable.bg_compose_background)
    Column (
        verticalArrangement = Arrangement.Center,
    ){
        Image(
            painter = image,
            contentDescription = null
        )
        Text(
            text = "Jetpack Compose tutorial",
            fontSize = 24.sp,
            lineHeight = 32.sp,
            modifier = Modifier.padding(16.dp)
        )
        GreetingText("Jetpack Compose is a modern toolkit for building native Android UI. Compose simplifies and accelerates UI development on Android with less code, powerful tools, and intuitive Kotlin APIs.", Modifier.padding(start = 16.dp , end = 16.dp))
        GreetingText("In this tutorial, you build a simple UI component with declarative functions. You call Compose functions to say what elements you want and the Compose compiler does the rest. Compose is built around Composable functions. These functions let you define your app\\'s UI programmatically because they let you describe how it should look and provide data dependencies, rather than focus on the process of the UI\\'s construction, such as initializing an element and then attaching it to a parent. To create a Composable function, you add the @Composable annotation to the function name." , Modifier.padding(16.dp))
    }
}

// ----------------------- Accept Icon -----------------------
@Composable
fun RightIcon() {
    val image = painterResource(R.drawable.ic_task_completed)
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
    ){
        Column (
            modifier = Modifier.align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Image(painter = image, contentDescription = null)
            Text(text = "All tasks completed",
                fontWeight = FontWeight.Bold ,
                modifier = Modifier.padding(top = 24.dp, bottom = 8.dp),
                textAlign = TextAlign.Center
                )
            Text(text = "Nice work!")
        }
    }
}

// ----------------------- Four Quadrant Text -----------------------
@Composable
fun FourText () {
    Box {
        Column (
            modifier = Modifier.fillMaxSize()
        ){
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.5f)
            ){
                Quadrant("Text composable", "Displays text and follows the recommended Material Design guidelines.", Color(0xFFEADDFF), 0.5f , 1f)
                Quadrant("Image composable", "Creates a composable that lays out and draws a given Painter class object.", Color(0xFFD0BCFF), 1f , 1f)
            }
            Row (
                modifier = Modifier.fillMaxSize()
            ){
                Quadrant("Row composable", "A layout composable that places its children in a horizontal sequence.", Color(0xFFB69DF8), 0.5f , 1f)
                Quadrant("Column composable", "A layout composable that places its children in a vertical sequence.", Color(0xFFF6EDFF), 1f , 1f)
            }
        }
    }
}

@Composable
fun Quadrant(title: String , description: String , color: Color , fractionW: Float, fractionH: Float) {
    Box (
        modifier = Modifier
            .background(color)
            .fillMaxWidth(fractionW)
            .fillMaxHeight(fractionH),
    ){
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.Center),
        ){
            Text(
                text = title,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 16.dp),
            )
            Text(
                text = description,
                textAlign = TextAlign.Justify
            )
        }
    }
}

// ----------------------- Contact As -----------------------
@Composable
fun Connect (icon: ImageVector, text: String) {
    Row (
        modifier = Modifier
            .fillMaxWidth(0.5f)
            .padding(bottom = 5.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        Icon(icon, contentDescription = text, modifier = Modifier
            .width(24.dp)
            .height(24.dp))
        Text(text = text, modifier = Modifier.padding(start = 15.dp))
    }

}
@Composable
fun ContactAs() {
    val phoneIcon = Icons.Rounded.Phone
    val mailIcon = Icons.Rounded.MailOutline
    val locationIcon = Icons.Rounded.LocationOn

    val logo = painterResource(R.drawable.ic_launcher_background)

    Box (
         modifier = Modifier.fillMaxSize()
    ){
        Column (
            modifier = Modifier.align(Alignment.BottomCenter),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Column (
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Image(painter = logo, contentDescription = null, modifier = Modifier
                    .width(80.dp)
                    .height(80.dp),
//                    contentScale = Content
                    )
                Text(
                    text = "Hello world",
                    fontSize = 32.sp,)
                Text(text = "Title" ,
                    fontSize = 24.sp)
            }
            Spacer(modifier = Modifier.height(50.dp))
            Column (
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Connect(phoneIcon , "+971 52 833 3033");
                Connect(mailIcon , "info@softhub.me");
                Connect(locationIcon , "Softhub – DAFZA 459 2423 345e");
            }
            Spacer(modifier = Modifier.height(30.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeTestTheme {
//        ContainerText();
//        RightIcon();
        FourText();
//        ContactAs();
    }
}


