package com.mas.sampleweather.repository

import com.mas.sampleweather.ui.model.ApiResponse
import retrofit2.Response

interface MainRepository{
    suspend fun getWeather(
        id: String?,
        appId: String?,
        units: String?
    ):Response<ApiResponse>
}