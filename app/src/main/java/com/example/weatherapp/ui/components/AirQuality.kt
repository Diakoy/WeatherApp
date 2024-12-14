package com.example.weatherapp.ui.components

import AirQualityData
import AirQualityDataList
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapp.R
import com.example.weatherapp.ui.theme.ColorAirQualityIconTitle
import com.example.weatherapp.ui.theme.ColorSurface
import com.example.weatherapp.ui.theme.ColorTextPrimary
import com.example.weatherapp.ui.theme.ColorTextPrimaryVariant


@OptIn(ExperimentalLayoutApi::class)
@Preview
@Composable
fun AirQuality(
    modifier: Modifier = Modifier,
    data: List<AirQualityData> = AirQualityDataList
) {

    Surface(
        modifier = modifier
            .fillMaxWidth(), color = ColorSurface,
        shape = RoundedCornerShape(36.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(horizontal = 24.dp, vertical = 18.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            AirQualityHeader()

            FlowRow(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp),
                maxItemsInEachRow = 3
            ) {
                data.onEach { item ->

                    AirQualityInfo(modifier = Modifier.weight(1f), item)

                }


            }

        }

    }
}


@Composable
fun AirQualityHeader(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {


            Icon(
                painter = painterResource(R.drawable.ic_air_quality_header),
                contentDescription = null,
                tint = ColorAirQualityIconTitle,
                modifier = Modifier
                    .size(32.dp)
            )
            Text(
                text = "Air quality",
                style = MaterialTheme.typography.titleMedium.copy(fontSize = 18.sp),
                modifier = Modifier.padding(start = 8.dp)
            )

        }
        RefreshButton()
    }

}

@Composable
fun RefreshButton(modifier: Modifier = Modifier) {
    Surface(
        modifier = Modifier
            .size(48.dp)
            .customShadow(
                alpha = 0.15f,
                shadowRadius = 16.dp,
                borderRadius = 32.dp,
                offsetY = 4.dp
            ),
        color = ColorSurface,
        shape = CircleShape
    ) {

        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {

            Image(painter = painterResource(R.drawable.ic_refresh), contentDescription = null)

        }

    }

}

@Composable
fun AirQualityInfo(modifier: Modifier = Modifier, data: AirQualityData) {

    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Icon(
            painter = painterResource(data.icon),
            contentDescription = null,
            tint = ColorAirQualityIconTitle,
            modifier = Modifier
                .size(24.dp)
        )

        Column(horizontalAlignment = Alignment.Start) {
            Text(
                text = data.title,
                color = ColorTextPrimaryVariant,
                style = MaterialTheme.typography.labelSmall
            )
            Text(
                text = data.value,
                color = ColorTextPrimary,
                style = MaterialTheme.typography.labelSmall
            )
        }

    }

}