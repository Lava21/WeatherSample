package com.mas.sampleweather.network

import android.app.Application
import com.mas.sampleweather.network.ApiConfig.config
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Qualifier
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
object NetworkModule {
    @Qualifier
    annotation class NetworkScope

    @Singleton
    @Provides @NetworkScope
    fun providerService(): ApiInterface{
        return config()
    }
}