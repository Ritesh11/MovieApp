package com.rks.movieapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rks.movieapp.ui.theme.MovieAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

        }
    }
}

@Preview
@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MovieListScreen(modifier: Modifier = Modifier) {
    val movieList: List<String> = listOf(
        "Kuch Na Kaho",
        "Kuch Bhi na kaho",
        "Kya Kehna Hai",
        "Kya Sunna Hai"
    )

    MovieAppTheme {
        Scaffold(modifier = modifier,
            topBar = {
                TopAppBar(
                    title = { Text(text = "Movies") },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Color.Blue,
                        titleContentColor = Color.White
                    )
                )

            }) {
            // Body
            LazyColumn(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {

            }

        }

    }


}

@Composable
fun MovieItem(modifier: Modifier = Modifier, item: String) {

    Card(modifier = modifier
        .padding(16.dp)
        .clickable { },
        elevation = CardDefaults.cardElevation(5.dp),
        shape = RoundedCornerShape(10.dp)
    ) {

        Row(modifier = modifier) {



        }

    }

}
