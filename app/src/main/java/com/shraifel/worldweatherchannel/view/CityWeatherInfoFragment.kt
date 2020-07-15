package com.shraifel.worldweatherchannel.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.shraifel.worldweatherchannel.R
import com.shraifel.worldweatherchannel.model.WeekForecastInfo


class CityWeatherInfoFragment : Fragment() {

    private val key = "CityWeatherInfoFragmentKey"
    private val mForecastInfo: WeekForecastInfo? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_city_weather_info, container, false)
    }

}
