package com.example.weatherapp.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.weatherapp.R
import com.example.weatherapp.ui.theme.ColorGradient1
import com.example.weatherapp.ui.theme.ColorGradient2
import com.example.weatherapp.ui.theme.ColorGradient3
import com.example.weatherapp.ui.theme.ColorImageShadow
import com.example.weatherapp.ui.theme.ColorSurface
import com.example.weatherapp.ui.theme.ColorTextPrimary
import com.example.weatherapp.ui.theme.ColorTextSecondaryVariant

@Composable
fun ActionBar() {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth()
    ) {

        ControlButton()
        LocationInfo(
            modifier = Modifier
                .padding(top = 10.dp)
        )
        ProfileButton()
    }
}


@Composable
fun ControlButton() {

    Surface(
        modifier = Modifier
            .size(48.dp)
            .customShadow(
                alpha = 0.15f,
                shadowRadius = 16.dp,
                borderRadius = 48.dp,
                offsetY = 4.dp
            ),
        color = ColorSurface,
        shape = CircleShape
    ) {

        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {

            Image(painter = painterResource(R.drawable.ic_control), contentDescription = null)

        }

    }

}

@Composable
fun ProfileButton(modifier: Modifier = Modifier) {

    Box(
        modifier = Modifier
            .size(48.dp)
            .border(
                width = 1.5.dp,
                color = ColorSurface,
                shape = CircleShape
            )
            .customShadow(
                color = ColorImageShadow,
                alpha = 0.7f,
                offsetY = 6.dp,
                shadowRadius = 12.dp,
                borderRadius = 48.dp
            )
    ) {
        Image(
            painter = painterResource(R.drawable.img_profile),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
                .clip(
                    CircleShape
                )
        )

    }
}

@Composable
fun LocationInfo(modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Image(
                painter = painterResource(R.drawable.ic_location_pin), contentDescription = null,
                contentScale = ContentScale.FillHeight,
                modifier = Modifier
                    .height(18.dp)
            )
            Spacer(
                modifier = Modifier
                    .width(8.dp)
            )
            Text(
                text = "Rome",
                style = MaterialTheme.typography.titleLarge,
                color = ColorTextPrimary,
                fontWeight = FontWeight.Bold
            )
        }

        ProgressPlace()


    }
}


@Composable
fun ProgressPlace(modifier: Modifier = Modifier) {

    Box(
        modifier = Modifier
            .background(
                brush = Brush.linearGradient(
                    0f to ColorGradient1,
                    0.25f to ColorGradient2,
                    1f to ColorGradient3
                ), shape = RoundedCornerShape(8.dp)

            )
            .padding(vertical = 2.dp, horizontal = 10.dp)

    ) {
        Text(
            text = "Updating...",
            color = ColorTextSecondaryVariant,
            style = MaterialTheme.typography.labelSmall
        )

    }

}

