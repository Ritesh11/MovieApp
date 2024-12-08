package com.rks.movieapp.screen.home

import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil3.compose.AsyncImage
import coil3.compose.LocalPlatformContext
import coil3.compose.rememberAsyncImagePainter
import coil3.compose.rememberConstraintsSizeResolver
import coil3.request.ImageRequest
import com.rks.movieapp.R
import com.rks.movieapp.model.Movie
import com.rks.movieapp.model.getMovies
import com.rks.movieapp.navigation.MovieScreens


@Composable
fun HomeScreen(
    navController: NavController

) {

    Toolbar() {
        MovieListScreen(navController = navController)
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Toolbar(content: @Composable () -> Unit) {
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
fun MovieListScreen(modifier: Modifier = Modifier, navController: NavController) {
    val movieList: List<Movie> = getMovies()
    // Body
    LazyColumn(
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        items(items = movieList) { movieName ->

            MovieItem(modifier, movieName) {
                Log.d("MovieListScreen", "Item clicked -> $movieName")
                navController.navigate(MovieScreens.DetailScreen.name + "/${movieName.id}")
            }

        }
    }
}


@Composable
fun MovieItem(
    modifier: Modifier = Modifier,
    item: Movie,
    onItemClicked: (String) -> Unit
) {

    var expended by remember {
        mutableStateOf(false)
    }

    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 10.dp, start = 16.dp, end = 16.dp)
            .clickable {
                onItemClicked(item.id)
            },
        elevation = CardDefaults.cardElevation(5.dp),
        shape = RoundedCornerShape(10.dp)
    ) {

        Row(
            modifier = modifier
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Surface(
                modifier = Modifier.size(80.dp),
                shape = CircleShape
            ) {
                Image(
                    painter = rememberAsyncImagePainter(model = item.images[0]),
                    contentDescription = "Movie poster",
                    contentScale = ContentScale.Crop,
                )
            }

            Column(
                modifier = modifier
                    .padding(start = 16.dp)
                    .weight(1f),
            ) {
                Text(
                    text = item.title,
                    style = MaterialTheme.typography.headlineSmall
                )

                Text(
                    text = "Director - ${item.director}",
                    style = MaterialTheme.typography.bodyMedium
                )

                Text(
                    text = "Release - ${item.year}",
                    style = MaterialTheme.typography.bodyMedium
                )

                AnimatedVisibility(visible = expended) {
                    Column() {
                        Text(
                            text = "Actors - ${item.actors}",
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }

                }

                Icon(imageVector = if (expended)
                    Icons.Default.KeyboardArrowUp
                else
                    Icons.Default.KeyboardArrowDown,
                    contentDescription = "Down Arrow",
                    modifier = modifier.clickable {
                        expended = !expended
                    })
            }


        }


    }

}