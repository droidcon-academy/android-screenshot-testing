package com.droidcon.flavorshub.di

import com.droidcon.flavorshub.utils.LocaleProvider
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
    fun provideRecipesRepo(
        localeProvider: LocaleProvider
    ): RecipesRepo {
        return RecipesRepo(localeProvider)
    }
}