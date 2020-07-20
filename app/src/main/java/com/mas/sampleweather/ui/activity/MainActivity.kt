package com.mas.sampleweather.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.mas.sampleweather.R
import com.mas.sampleweather.ui.adapter.ListDayAdapter
import com.mas.sampleweather.ui.adapter.ListHourAdapter
import com.mas.sampleweather.ui.model.ListItem
import com.mas.sampleweather.ui.viewModel.MainViewModel
import com.mas.sampleweather.untils.formatDate
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val listHour: MutableList<ListItem> = mutableListOf()
    private val listDay: MutableList<ListItem> = mutableListOf()
    private lateinit var listHourAdapter: ListHourAdapter
    private lateinit var listDayAdapter: ListDayAdapter

    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        srHome.post{
            loadData()
        }

        srHome.setOnRefreshListener{
            loadData()
        }
    }

    private fun loadData(){
        with(viewModel) {
            state.observe(this@MainActivity, Observer {
                srHome.isRefreshing = it
            })

            itemHour.observe(this@MainActivity, Observer {
                listHour.clear()
                it?.let {
                    listHour.addAll(it)
                }
                listHourAdapter.notifyDataSetChanged()
            })

            item.observe(this@MainActivity, Observer {
                it?.let {
                    tvDate.text = it[0].dtTxt?.formatDate()
                    tvTemperature.text = String.format("%s\u00B0", it[0].main?.temp.toString())
                    tvWeather.text = it[0].weather?.get(0)?.main.toString()

                    when (it[0].weather?.get(0)?.main.toString()){
                        "Clear" -> {
                            ivImageTemperature.setImageResource(R.drawable.ic_sun)
                        }

                        "Rain" -> {
                            ivImageTemperature.setImageResource(R.drawable.ic_rain)
                        }

                        "Clouds" -> {
                            ivImageTemperature.setImageResource(R.drawable.ic_lightning)
                        }
                    }
                }

                listDay.clear()
                it?.let {
                    listDay.addAll(it)
                }
                listDayAdapter.notifyDataSetChanged()
            })

            thePlace.observe(this@MainActivity, Observer {
                tvLocation.text = it
            })

            error.observe(this@MainActivity, Observer {
                Toast.makeText(applicationContext, it, Toast.LENGTH_SHORT).show()
            })
        }

        listHourAdapter = ListHourAdapter(listHour)
        rvTemperatureHour.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvTemperatureHour.adapter = listHourAdapter

        listDayAdapter = ListDayAdapter(listDay)
        rvTemperatureDay.layoutManager = LinearLayoutManager(this)
        rvTemperatureDay.adapter = listDayAdapter
    }
}