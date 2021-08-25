package com.example.appweatherkotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WeatherAdapter :

    RecyclerView.Adapter<WeatherAdapter.ViewHolder>() {
    var weatherList: List<Weather> = ArrayList<Weather>()
        set(value) {
            field = value
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_main, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(weatherList[position])
    }

    override fun getItemCount(): Int = weatherList.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(weather: Weather) {
            itemView.findViewById<TextView>(R.id.town).text = weather.town
            itemView.findViewById<TextView>(R.id.temp).text = "$(weather.temperature)"
        }
    }
}
