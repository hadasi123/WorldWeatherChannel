package com.shraifel.worldweatherchannel.presenter

import com.shraifel.worldweatherchannel.model.CitiesWeatherItem
import com.shraifel.worldweatherchannel.model.CitiesWeatherList
import com.shraifel.worldweatherchannel.model.WeekForecastInfo
import com.shraifel.worldweatherchannel.view.BaseView

interface MainContract {
  interface Presenter : BasePresenter {
    fun onViewCreated()
    fun onCityTapped(cityName: String)
  }

  interface View : BaseView<Presenter> {
    fun displayCitiesWeatherList(citiesWeatherList: CitiesWeatherList)
    fun displayCityWeatherForecast(weatherForecast: WeekForecastInfo)
  }
}
