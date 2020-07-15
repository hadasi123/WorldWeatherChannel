package com.shraifel.worldweatherchannel.view
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.shraifel.worldweatherchannel.R
import com.shraifel.worldweatherchannel.di.DependencyInjectorImpl
import com.shraifel.worldweatherchannel.model.CitiesWeatherItem
import com.shraifel.worldweatherchannel.model.CitiesWeatherList
import com.shraifel.worldweatherchannel.model.WeekForecastInfo
import com.shraifel.worldweatherchannel.presenter.MainContract
import com.shraifel.worldweatherchannel.presenter.MainPresenter

class MainActivity : AppCompatActivity(), MainContract.View  {

    private lateinit var presenter: MainContract.Presenter
    var citiesFragment = CitiesWeatherFragment()
    var cityWeatherForecastFragment = CityWeatherInfoFragment()

    private lateinit var citiesList: CitiesWeatherList
    lateinit var cityForecastInfo: WeekForecastInfo

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setPresenter(MainPresenter(this, DependencyInjectorImpl()))
        presenter.onViewCreated()
    }

    override fun displayCitiesWeatherList(citiesWeatherList: CitiesWeatherList) {

        citiesList = citiesWeatherList

        supportFragmentManager.beginTransaction().
        replace(R.id.main_frame, citiesFragment).addToBackStack(null).commit()
    }

    override fun displayCityWeatherForecast(weatherForecast: WeekForecastInfo) {

        cityForecastInfo = weatherForecast

        supportFragmentManager.beginTransaction().
        replace(R.id.main_frame, cityWeatherForecastFragment).addToBackStack(null).commit()
    }

    override fun setPresenter(presenter: MainContract.Presenter) {
        this.presenter = presenter
    }

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }

    fun loadCitiesList(): CitiesWeatherList
    {
        return citiesList
    }
}