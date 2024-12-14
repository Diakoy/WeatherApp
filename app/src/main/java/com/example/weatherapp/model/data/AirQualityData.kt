import androidx.annotation.DrawableRes
import com.example.weatherapp.R

data class AirQualityData(
    @DrawableRes val icon: Int,
    val title: String,
    val value: String
)

val AirQualityDataList = listOf(
    AirQualityData(
        title = "Real Feel",
        value = "23.8",
        icon = R.drawable.ic_real_feel
    ),
    AirQualityData(
        title = "Wind",
        value = "9km/h",
        icon = R.drawable.ic_wind_qality,
    ),
    AirQualityData(
        title = "SO2",
        value = "0.9",
        icon = R.drawable.ic_so2
    ),
    AirQualityData(
        title = "Rain",
        value = "68%",
        icon = R.drawable.ic_rain_chance
    ),
    AirQualityData(
        title = "UV Index",
        value = "3",
        icon = R.drawable.ic_uv_index
    ),
    AirQualityData(
        title = "OЗ",
        value = "50",
        icon = R.drawable.ic_o3
    )
)