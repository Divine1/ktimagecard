package com.myf.food


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.myf.food.ui.theme.FoodTheme



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            /*FoodTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Greeting("dave")
                }
            }*/
            val painter = painterResource(id = R.drawable.eagle)

            Box(
                modifier = Modifier.fillMaxSize(0.5f)
                    .padding(16.dp)

            ){
                ImageCard(
                    painter,
                    contentDescription = "Kermit is playing in the snowl",
                    title = "Kermit is playing in the snow"
                )
            }
        }
    }
}


@Composable
fun ImageCard(
    painter : Painter,
    contentDescription : String,
    title : String
){
    Card(
        modifier = Modifier.fillMaxWidth().background(Color.Yellow),
        shape = RoundedCornerShape(15.dp),
        elevation = 15.dp
    ) {
        Box(
            modifier = Modifier.height(250.dp)
        ){
            Image(
                painter = painter,
                contentDescription = contentDescription,
                contentScale = ContentScale.Crop
            )
            Box(modifier = Modifier.fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color.Black
                        ),
                    startY = 300f
                    ),
                )
            )
            Box(
                modifier= Modifier
                    .fillMaxSize().padding(12.dp),
                contentAlignment = Alignment.BottomStart
            ){
                Text(
                    title,
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 16.sp
                    )
                )
            }
        }


    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    FoodTheme {
        Greeting("Android")
    }
}