package com.shraifel.worldweatherchannel.presenter
import com.shraifel.worldweatherchannel.di.DependencyInjector
import com.shraifel.worldweatherchannel.model.WeatherRepository

class MainPresenter(view: MainContract.View,
                    dependencyInjector: DependencyInjector) : MainContract.Presenter {

  private val weatherRepository: WeatherRepository = dependencyInjector.weatherRepository()

  private var view: MainContract.View? = view

  override fun onDestroy() {
    this.view = null
  }

  override fun onViewCreated() {
    loadCitiesListWeather()
  }

  override fun onCityTapped(cityName: String) {
    loadWeatherForCity(cityName)
  }

  private fun loadCitiesListWeather() {
    val weather = weatherRepository.loadWeatherForCities()
    if (weather != null) {
      view?.displayCitiesWeatherList(weather)
    }
  }

  private fun loadWeatherForCity(cityName: String){
    val weather = weatherRepository.loadWeatherForecastByCityName(cityName)
    if (weather != null) {
      view?.displayCityWeatherForecast(weather)
    }
  }
}