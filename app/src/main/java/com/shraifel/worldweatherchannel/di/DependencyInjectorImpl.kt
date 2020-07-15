package com.shraifel.worldweatherchannel.di

import com.shraifel.worldweatherchannel.di.DependencyInjector
import com.shraifel.worldweatherchannel.model.WeatherRepository
import com.shraifel.worldweatherchannel.model.WeatherRepositoryImpl

class DependencyInjectorImpl : DependencyInjector {
  override fun weatherRepository() : WeatherRepository {
    return WeatherRepositoryImpl()
  }
}
