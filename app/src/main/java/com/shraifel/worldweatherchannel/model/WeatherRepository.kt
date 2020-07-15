package com.shraifel.worldweatherchannel.model

interface WeatherRepository {

  fun loadWeatherForCities():CitiesWeatherList?

  fun loadWeatherForecastByCityName(cityName: String) : WeekForecastInfo?

}
