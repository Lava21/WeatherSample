package com.mas.sampleweather.repository

import com.mas.sampleweather.network.ApiInterface
import com.mas.sampleweather.ui.model.ApiResponse
import retrofit2.Response
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(private val apiInterface: ApiInterface): MainRepository{
    override suspend fun getWeather(
        id: String?,
        appId: String?,
        units: String?
    ): Response<ApiResponse> {
        return apiInterface.getWeather(id, appId, units)
    }
}