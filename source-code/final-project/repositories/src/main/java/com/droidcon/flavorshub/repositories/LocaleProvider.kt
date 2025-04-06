package com.droidcon.flavorshub.repositories

import android.content.Context
import android.content.res.Configuration
import dagger.hilt.android.qualifiers.ApplicationContext
import java.util.Locale
import javax.inject.Inject
import javax.inject.Singleton

/**
 * This is used to simulate the RecipesRepo returning Recipes in different languages, based on
 * the locale of the device.
 */
@Singleton
class LocaleProvider @Inject constructor(
    @ApplicationContext private var context: Context
) {

    private var localizedContext: Context = context

    fun updateLocale(newLocale: Locale) {
        localizedContext = context.createConfigurationContext(
            Configuration(context.resources.configuration).apply { setLocale(newLocale) }
        )
    }

    fun getString(resourceId: Int): String {
        return localizedContext.getString(resourceId)
    }
}