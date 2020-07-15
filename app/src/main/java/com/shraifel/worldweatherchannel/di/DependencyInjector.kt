package com.shraifel.worldweatherchannel.di

import com.shraifel.worldweatherchannel.model.WeatherRepository

interface DependencyInjector {
  fun weatherRepository() : WeatherRepository
}
