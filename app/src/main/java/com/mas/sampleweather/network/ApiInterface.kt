package com.mas.sampleweather.network

import com.mas.sampleweather.ui.model.ApiResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("data/2.5/forecast")
    suspend fun getWeather(
        @Query("id")  id: String?,
        @Query("appid") appid: String?,
        @Query("units") units: String?
    ): Response<ApiResponse>
}