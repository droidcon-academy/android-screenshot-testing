package com.droidcon.flavorshub.ui.shared

import android.icu.text.NumberFormat
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.droidcon.flavorshub.ui.R


@Composable
fun RecipeCookingInfo(
    modifier: Modifier = Modifier,
    cookingTimeInMin: Int,
    recipeIcon: Int,
    recipeText: Int
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        CookingTime(cookingTimeInMin = cookingTimeInMin)

        RecipeType(
            icon = recipeIcon,
            text = stringResource(recipeText)
        )
    }
}

@Composable
private fun RecipeType(
    modifier: Modifier = Modifier,
    icon: Int,
    text: String
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            modifier = Modifier.size(20.dp),
            painter = painterResource(icon),
            contentDescription = stringResource(R.string.cooking_time_content_description),
            tint = MaterialTheme.colorScheme.outline
        )
        Text(
            modifier = Modifier.padding(horizontal = 4.dp),
            text = text,
            fontSize = 14.sp,
            color = MaterialTheme.colorScheme.outline
        )
    }
}

@Composable
private fun CookingTime(
    modifier: Modifier = Modifier,
    cookingTimeInMin: Int
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            modifier = Modifier.size(20.dp),
            painter = painterResource(R.drawable.ic_timer_50),
            contentDescription = "Time",
            tint = MaterialTheme.colorScheme.outline
        )
        Text(
            modifier = Modifier.padding(horizontal = 4.dp),
            text = stringResource(
                id = R.string.cooking_time_in_minutes,
                formatArgs = arrayOf(
                    NumberFormat.getInstance(LocalConfiguration.current.locale).format(cookingTimeInMin)
                )
            ),
            fontSize = 14.sp,
            color = MaterialTheme.colorScheme.outline
        )
    }
}