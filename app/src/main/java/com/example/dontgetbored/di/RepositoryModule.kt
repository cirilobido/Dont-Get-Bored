package com.example.dontgetbored.di

import com.example.dontgetbored.data.repository.BoredActivityRepositoryImpl
import com.example.dontgetbored.domain.repository.BoredActivityRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindBoredActivityRepository(
        boredActivityRepositoryImpl: BoredActivityRepositoryImpl
    ): BoredActivityRepository
}