package com.example.weatherapp.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.weatherapp.ui.components.ActionBar
import com.example.weatherapp.ui.components.AirQuality
import com.example.weatherapp.ui.components.DailyForeCast
import com.example.weatherapp.ui.components.WeeklyForecast
import com.example.weatherapp.ui.theme.ColorBackground

@Preview
@Composable
fun WeatherScreen() {
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
            Spacer(
                modifier = Modifier
                    .height(12.dp)
            )
            DailyForeCast()
            Spacer(
                modifier = Modifier
                    .height(16.dp)
            )
            AirQuality()
            Spacer(
                modifier = Modifier
                    .height(16.dp)
            )
            WeeklyForecast()



        }
    }
}


