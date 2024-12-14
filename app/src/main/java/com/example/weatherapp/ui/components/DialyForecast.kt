package com.example.weatherapp.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.example.weatherapp.R
import com.example.weatherapp.ui.theme.ColorGradient1
import com.example.weatherapp.ui.theme.ColorGradient2
import com.example.weatherapp.ui.theme.ColorGradient3
import com.example.weatherapp.ui.theme.ColorTextSecondary
import com.example.weatherapp.ui.theme.ColorTextSecondaryVariant
import com.example.weatherapp.ui.theme.ColorWindForecast

@Preview
@Composable
fun DailyForeCast(
    modifier: Modifier = Modifier,
    foreCast: String = "Rain showers",
    date: String = "Feb 12 Monday"
) {

    ConstraintLayout {
        val (foreCastImage, foreCastValue, windImage, title, description, background) = createRefs()

        CardBackground(modifier = Modifier
            .fillMaxWidth()
            .constrainAs(background) {
                top.linkTo(anchor = parent.top, margin = 24.dp)
                bottom.linkTo(anchor = parent.bottom)
                start.linkTo(anchor = parent.start)
                end.linkTo(anchor = parent.end)
                height = Dimension.fillToConstraints
            }
        )

        Image(
            painter = painterResource(R.drawable.img_sub_rain),
            contentDescription = null,
            contentScale = ContentScale.FillHeight,
            modifier = Modifier
                .height(175.dp)
                .constrainAs(foreCastImage) {
                    start.linkTo(anchor = parent.start, margin = 4.dp)
                    top.linkTo(anchor = parent.top, margin = 4.dp)
                }

        )

        Text(style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Medium,
            color = ColorTextSecondary,
            text = foreCast,
            modifier = Modifier
                .constrainAs(title) {
                    top.linkTo(anchor = foreCastImage.bottom, margin = 8.dp)
                    start.linkTo(anchor = parent.start, margin = 24.dp)
                }
        )

        Text(style = MaterialTheme.typography.bodyMedium,
            color = ColorTextSecondaryVariant,
            text = date,
            modifier = Modifier
                .constrainAs(description) {
                    top.linkTo(anchor = title.bottom, margin = 4.dp)
                    start.linkTo(anchor = title.start, margin = 4.dp)
                }
                .padding(bottom = 24.dp))

        ForeCastValue(
            modifier = Modifier
                .constrainAs(foreCastValue) {
                    end.linkTo(parent.end, margin = 24.dp)
                    top.linkTo(foreCastImage.top)
                    bottom.linkTo(foreCastImage.bottom)
                }
        )
        ForecastImageResource(modifier = Modifier
            .constrainAs(windImage) {
                linkTo(
                    top = title.top,
                    bottom = title.bottom
                )
                end.linkTo(parent.end, margin = 24.dp)
            })

    }

}

@Composable
fun CardBackground(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .background(

                brush = Brush.linearGradient(
                    0f to ColorGradient1,
                    0.5f to ColorGradient2,
                    1f to ColorGradient3
                ),
                shape = RoundedCornerShape(32.dp)

            )

    )


}

@Composable
fun ForeCastValue(
    modifier: Modifier = Modifier,
    degree: String = "21",
    description: String = "Feels like 22"
) {

    Column(
        horizontalAlignment = Alignment.Start,
        modifier = modifier
    ) {
        Box(contentAlignment = Alignment.TopEnd) {
            Text(
                text = degree,
                color = ColorTextSecondaryVariant,
                style = TextStyle(
                    brush = Brush.linearGradient(
                        0f to Color.White,
                        1f to Color.White.copy(alpha = 0.3f)
                    )
                ),
                fontSize = 80.sp,
                fontWeight = FontWeight.Black,
                modifier = Modifier
                    .padding(end = 16.dp, top = 12.dp)
            )
            Text(
                text = "°",
                color = ColorTextSecondaryVariant,
                style = TextStyle(
                    brush = Brush.linearGradient(
                        0f to Color.White,
                        1f to Color.White.copy(alpha = 0.3f)
                    )
                ),
                fontSize = 80.sp,
                fontWeight = FontWeight.Light
            )
        }
        Text(
            text = description,
            color = ColorTextSecondaryVariant,
            style = MaterialTheme.typography.bodyMedium
        )
    }


}

@Composable
fun ForecastImageResource(
    modifier: Modifier = Modifier,
    ic1: Int = R.drawable.ic_wind,
    ic2: Int = R.drawable.ic_frosty
) {

    Row (verticalAlignment = Alignment.CenterVertically,modifier = modifier
        ){
        Icon(painter = painterResource(ic2) , contentDescription = null , modifier = Modifier.size(60.dp) , tint = ColorWindForecast)
        Icon(painter = painterResource(ic1) , contentDescription = null,modifier = Modifier.size(60.dp) , tint = ColorWindForecast)
    }

}