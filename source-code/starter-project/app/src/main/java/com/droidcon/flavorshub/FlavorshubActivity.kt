package com.droidcon.flavorshub

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.droidcon.flavorshub.ui.HomeScreenViewModel
import com.droidcon.flavorshub.ui.theme.FlavorshubTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FlavorshubActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FlavorshubTheme {
                HomeScreenViewModel()
            }
        }
    }
}