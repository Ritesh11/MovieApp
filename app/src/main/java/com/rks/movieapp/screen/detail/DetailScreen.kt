package com.rks.movieapp.screen.detail

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.rks.movieapp.model.Movie
import com.rks.movieapp.model.getMovies
import com.rks.movieapp.screen.home.MovieItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(
    navController: NavController,
    movieId: String?
) {

    val movie = getMovies().filter { movie ->
        movie.id == movieId
    }

    Scaffold(modifier = Modifier,
        topBar = {
            TopAppBar(
                title = {

                    Row {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back",
                            modifier = Modifier
                                .clickable {
                                    navController.popBackStack()
                                })
                    }

                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Blue,
                    titleContentColor = Color.White
                )
            )
        }) { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues)) {
            Content(movie[0])
        }

    }




}

@Composable
fun Content(movieData: Movie, modifier: Modifier = Modifier){
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {

        Column(
            modifier = modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            MovieItem(modifier, movieData){}

            /*Text(text = movieData.toString(),
                style = MaterialTheme.typography.headlineMedium,
                modifier = modifier
                    .clickable {

                    })*/

        }

    }
}