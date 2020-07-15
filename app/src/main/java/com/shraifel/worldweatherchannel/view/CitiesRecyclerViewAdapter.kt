package com.shraifel.worldweatherchannel.view
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.shraifel.worldweatherchannel.R
import com.shraifel.worldweatherchannel.model.CitiesWeatherItem
import com.shraifel.worldweatherchannel.model.CitiesWeatherList
import kotlinx.android.synthetic.main.cities_list_item.view.*

class CitiesRecyclerViewAdapter(private val resultList: CitiesWeatherList,
                                private val itemClickListener: OnItemClickListener?) :
    RecyclerView.Adapter<CitiesRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cities_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int)
    {
        holder.bind(resultList.list[position],itemClickListener)
    }

    override fun getItemCount(): Int = resultList.list.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bind(city: CitiesWeatherItem, clickListener: OnItemClickListener?) {
            with(city) {
                itemView.city_name.text = city.name
                //itemView.weather_icon.
                itemView.weather_description.text = city.description
                itemView.min_temp.text = city.min.toString()
                itemView.max_temp.text = city.max.toString()
            }

            itemView.setOnClickListener {
                clickListener?.onItemClicked(city)
            }
        }
    }

    interface OnItemClickListener{
        fun onItemClicked(city: CitiesWeatherItem)
    }
}