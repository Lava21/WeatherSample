package com.mas.sampleweather.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mas.sampleweather.R
import com.mas.sampleweather.ui.model.ListItem
import com.mas.sampleweather.untils.formatDateToHour
import kotlinx.android.synthetic.main.list_day.view.ivImage
import kotlinx.android.synthetic.main.list_day.view.tvHour
import kotlinx.android.synthetic.main.list_hour.view.*

class ListHourAdapter (private val item: List<ListItem>) :
    RecyclerView.Adapter<ListHourAdapter.ViewHolder> (){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_hour, parent, false))

    override fun getItemCount(): Int = item.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(item[position])
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        @SuppressLint("CheckResult")
        fun bindItem(listItem: ListItem){
            itemView.tvHour.text = listItem.dtTxt?.formatDateToHour()
            itemView.tvWeather.text = String.format("%s\u00B0", listItem.main?.temp.toString())

            when(listItem.weather?.get(0)?.main.toString()) {
                "Clear" -> {
                    itemView.ivImage.setImageResource(R.drawable.ic_sun)
                }

                "Rain" -> {
                    itemView.ivImage.setImageResource(R.drawable.ic_rain)
                }

                "Clouds" -> {
                    itemView.ivImage.setImageResource(R.drawable.ic_lightning)
                }
            }
        }
    }
}