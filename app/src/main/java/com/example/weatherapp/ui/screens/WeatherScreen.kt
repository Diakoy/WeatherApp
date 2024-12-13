package com.example.weatherapp.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.weatherapp.ui.components.ActionBar
import com.example.weatherapp.ui.theme.ColorBackground

@Preview
@Composable
fun WeatherScreenPreview() {
    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        contentColor = ColorBackground
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(
                    vertical = 24.dp,
                    horizontal = 10.dp
                )
        ) {
            ActionBar()

        }
    }
}


@Composable
fun WeatherScreen() {

}