package com.shraifel.worldweatherchannel.api
import com.shraifel.worldweatherchannel.model.CitiesWeatherItem
import com.shraifel.worldweatherchannel.model.CitiesWeatherList
import com.shraifel.worldweatherchannel.model.HoursWeatherInfo
import com.shraifel.worldweatherchannel.model.WeekForecastInfo
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Endpoints {

    @GET("/data/2.5/onecall?APPID=951d4feb81c2590cb294ed8e9ebaec87&units=metric&cnt=7&exclude=minutely,hourly")
    fun retrieveWeeklyForecastPerCity(@Query("q") q: String): Call<WeekForecastInfo>

    @GET("/data/2.5/forecast?APPID=951d4feb81c2590cb294ed8e9ebaec87&units=metric")
    fun retrieveHourlyForecastPerCity(@Query("q") q: String): Call<HoursWeatherInfo>

    @GET("/data/2.5/forecast?APPID=951d4feb81c2590cb294ed8e9ebaec87&units=metric")
    fun retrieveForecastAround(@Query("lon") lon: Double, @Query("lat") lat: Double): Call<CitiesWeatherList>
}