package com.droidcon.flavorshub

import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.droidcon.flavorshub.ui.theme.FlavorshubTheme
import com.droidcon.flavorshub.utils.LocaleProvider
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class FlavorshubActivity : ComponentActivity() {
    
    @Inject
    lateinit var localeProvider: LocaleProvider
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FlavorshubTheme {
                AppNavigation()
            }
        }
    }
    
    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(newBase)
    }
    
    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        localeProvider.updateLocale(newConfig.locale)
    }
}