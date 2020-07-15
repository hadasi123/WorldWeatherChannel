package com.shraifel.worldweatherchannel.model
import android.util.Log
import com.shraifel.worldweatherchannel.api.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class WeatherRepositoryImpl : WeatherRepository {

  private val client = RetrofitClient()

  override fun loadWeatherForCities(): CitiesWeatherList?
  {
    var resultList : CitiesWeatherList? = null

    val citiesCallback = object : Callback<CitiesWeatherList> {

      override fun onFailure(call: Call<CitiesWeatherList>?, t: Throwable?) {
        Log.e("WeatherRepoImpl", "Problem calling API ${t?.message}")
      }

      override fun onResponse(call: Call<CitiesWeatherList>?, response: Response<CitiesWeatherList>?) {
        response?.isSuccessful.let {
          resultList = response?.body()
        }
      }
    }

    client.getCitiesWeatherInfo(citiesCallback, 55.5, 37.5)

    return resultList
  }


  override fun loadWeatherForecastByCityName(cityName: String): WeekForecastInfo? {
    var resultList : WeekForecastInfo? = null
    val cityWeatherCallback = object : Callback<WeekForecastInfo> {

      override fun onFailure(call: Call<WeekForecastInfo>?, t: Throwable?) {
        Log.e("WeatherRepoImpl", "Problem calling API ${t?.message}")
      }

      override fun onResponse(call: Call<WeekForecastInfo>?, response: Response<WeekForecastInfo>?) {
        response?.isSuccessful.let {
          resultList = response?.body()
        }
      }
    }
    client.getWeeklyForecastByLocation(cityWeatherCallback,cityName)
    return resultList
  }
}