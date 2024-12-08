package com.rks.movieapp.screen.detail

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun DetailScreen(
    navController: NavController,
    movieData: String?
) {
    Text(text = movieData.toString())

}