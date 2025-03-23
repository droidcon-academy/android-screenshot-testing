package com.droidcon.flavorshub.di

import com.droidcon.flavorshub.viewmodels.RecipesRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRecipesRepo(): RecipesRepo {
        return RecipesRepo()
    }
}