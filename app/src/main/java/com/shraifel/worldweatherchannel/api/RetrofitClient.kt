package com.shraifel.worldweatherchannel.api
import com.shraifel.worldweatherchannel.model.CitiesWeatherItem
import com.shraifel.worldweatherchannel.model.CitiesWeatherList
import com.shraifel.worldweatherchannel.model.WeekForecastInfo
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {
    private val service: Endpoints

    companion object {
        private const val BASE_URL = "https://api.openweathermap.org"
    }

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        service = retrofit.create(Endpoints::class.java)
    }

    fun getWeeklyForecastByLocation(callback: Callback<WeekForecastInfo>,cityName: String) {
        service.retrieveWeeklyForecastPerCity(cityName).enqueue(callback)
    }

    fun getCitiesWeatherInfo(callback: Callback<CitiesWeatherList>, lon: Double, lat:Double){
        service.retrieveForecastAround(lon, lat).enqueue(callback)
    }
}