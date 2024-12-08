package com.rks.movieapp.screen

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.rks.movieapp.R


@Composable
fun HomeScreen(
    navController: NavController

) {

    Toolbar(){
        MovieListScreen()
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Toolbar(content: @Composable () -> Unit){
    Scaffold(modifier = Modifier,
        topBar = {
            TopAppBar(
                title = { Text(text = "Movies") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Blue,
                    titleContentColor = Color.White
                )
            )
        }) { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues)) {
            content()
        }

    }
}

@Composable
fun MovieListScreen(modifier: Modifier = Modifier) {
    val movieList: List<String> = listOf(
        "Kuch Na Kaho",
        "Kuch Bhi na kaho",
        "Kya Kehna Hai",
        "Kya Sunna Hai"
    )
    // Body
    LazyColumn(
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        items(items = movieList) { movieName ->

            MovieItem(modifier, movieName) {
                Log.d("MovieListScreen", "Item clicked -> $movieName")
            }

        }
    }
}

@Composable
fun MovieItem(
    modifier: Modifier = Modifier,
    item: String = "",
    onItemClicked: (String) -> Unit
) {

    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 10.dp, start = 16.dp, end = 16.dp)
            .clickable {
                onItemClicked(item)
            },
        elevation = CardDefaults.cardElevation(5.dp),
        shape = RoundedCornerShape(10.dp)
    ) {

        Row(
            modifier = modifier
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Icon(
                painter = painterResource(id = R.drawable.movie),
                contentDescription = "Movie Icon",
                modifier = modifier
                    .height(50.dp)
                    .width(50.dp)
            )

            Text(
                text = item,
                modifier = modifier
                    .padding(start = 16.dp)
                    .weight(1f),
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }


    }

}