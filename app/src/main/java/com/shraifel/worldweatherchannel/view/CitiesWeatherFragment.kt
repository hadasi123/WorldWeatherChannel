package com.shraifel.worldweatherchannel.view
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.shraifel.worldweatherchannel.R
import com.shraifel.worldweatherchannel.model.CitiesWeatherItem
import kotlinx.android.synthetic.main.fragment_cities_weather.*

class CitiesWeatherFragment : Fragment(), CitiesRecyclerViewAdapter.OnItemClickListener {

    private lateinit var listener: CitiesRecyclerViewAdapter.OnItemClickListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_cities_weather, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        list_of_cities.layoutManager = LinearLayoutManager(activity)
        listener = this
        var resultList = (activity as MainActivity).loadCitiesList()
        list_of_cities.adapter = resultList?.let { it1 -> CitiesRecyclerViewAdapter(it1, listener) }

    }

    override fun onItemClicked(city: CitiesWeatherItem) {
        TODO("Not yet implemented")
    }
}
