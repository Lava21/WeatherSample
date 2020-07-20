package com.mas.sampleweather.ui.adapter

import android.annotation.SuppressLint
import android.app.LauncherActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mas.sampleweather.R
import com.mas.sampleweather.ui.model.ListItem
import com.mas.sampleweather.untils.formatDate
import com.mas.sampleweather.untils.formatDateToHour
import kotlinx.android.synthetic.main.list_day.view.*

class ListDayAdapter (private val item: List<ListItem>) :
    RecyclerView.Adapter<ListDayAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_day, parent, false))

    override fun getItemCount(): Int = item.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(item[position])
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        @SuppressLint("CheckResult")
        fun bindItem(listItem: ListItem){
            itemView.tvDay.text = listItem.dtTxt?.formatDate()
            itemView.tvHour.text = listItem.dtTxt?.formatDateToHour()
            itemView.tvTemperature.text = String.format("%s\u00B0", listItem.main?.temp.toString())

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