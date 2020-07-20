package com.mas.sampleweather.network

import com.mas.sampleweather.repository.MainRepository
import com.mas.sampleweather.repository.MainRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
object RepositoryModule {
    @Singleton
    @Provides
    fun providerMainRepository(
        @NetworkModule.NetworkScope apiInterface: ApiInterface
    ): MainRepository {
        return MainRepositoryImpl(apiInterface)
    }
}