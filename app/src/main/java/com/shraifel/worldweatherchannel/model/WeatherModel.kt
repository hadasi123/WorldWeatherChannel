package com.shraifel.worldweatherchannel.model

data class CitiesWeatherList(val list: List<CitiesWeatherItem>)

data class CitiesWeatherItem(val name: String,
                             val daily: List<DailyWeatherInfo>?,
                             val weather: List<Weather>,
                             val description: String,
                             val min: Double,
                             val max: Double)

data class WeekForecastInfo(
    val name: String,
    val daily: List<DailyWeatherInfo>?,
    val weather: List<Weather>)

data class DailyWeatherInfo(
    val temp: Temp,
    val dt: Long,
    var expanded: Boolean,
    val weather: List<Weather>
)

data class Temp(val min: Double, val max: Double)

data class HoursWeatherInfo(val list: List<HourlyInfo>)

data class HourlyInfo(val dt: Long, val main: Main)

data class Main (val temp: Double)

data class Weather(val description: String, val icon: String)