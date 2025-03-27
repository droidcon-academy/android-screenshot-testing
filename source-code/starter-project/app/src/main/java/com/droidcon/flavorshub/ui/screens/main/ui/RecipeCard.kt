package com.droidcon.flavorshub.ui.screens.main.ui

import android.icu.text.NumberFormat
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.droidcon.flavorshub.R
import com.droidcon.flavorshub.ui.screens.main.model.MainScreenRecipeItem

@Composable
fun RecipeCard(
    modifier: Modifier = Modifier,
    recipe: MainScreenRecipeItem,
    onFavouriteClick: (Int) -> Unit,
    onClick: () -> Unit
) {
    OutlinedCard(
        modifier = modifier
            .fillMaxWidth()
            .clickable { onClick() },
        shape = RoundedCornerShape(12.dp),
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    modifier = Modifier
                        .padding(bottom = 8.dp)
                        .weight(1f),
                    text = recipe.name,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
                FavouriteIcon(
                    isFavourite = recipe.isFavorite,
                    onClick = { onFavouriteClick(recipe.id) }
                )
            }

            RecipeImage(
                modifier = Modifier.padding(bottom = 12.dp),
                imageUrl = recipe.imageUrl
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                CookingTime(cookingTimeInMin = recipe.cookingTimeInMin)

                RecipeType(
                    icon = recipe.type.icon,
                    text = stringResource(recipe.type.text)
                )
            }

            Text(
                modifier = Modifier.padding(vertical = 8.dp),
                text = recipe.shortDescription,
                fontSize = 12.sp,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
        }
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
            contentDescription = "Time",
            tint = Color.Gray
        )
        Text(
            modifier = Modifier.padding(horizontal = 4.dp),
            text = text,
            fontSize = 14.sp,
            color = Color.Gray
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
            tint = Color.Gray
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
            color = Color.Gray
        )
    }
}

@Composable
private fun FavouriteIcon(
    modifier: Modifier = Modifier,
    isFavourite: Boolean,
    onClick: () -> Unit
) {
    val icon = when (isFavourite) {
        true -> R.drawable.ic_baseline_favorite_24
        false -> R.drawable.ic_baseline_favorite_border_24
    }
    Icon(
        modifier = modifier.clickable(
            interactionSource = remember { MutableInteractionSource() },
            indication = rememberRipple(bounded = false),
            onClick = onClick
        ),
        imageVector = ImageVector.vectorResource(id = icon),
        contentDescription = "Favourite",
        tint = MaterialTheme.colorScheme.error
    )
}

@Composable
private fun RecipeImage(
    modifier: Modifier = Modifier,
    imageUrl: String,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(150.dp)
            .border(
                border = BorderStroke(
                    width = 1.dp,
                    color = Color.LightGray
                ), // TODO -> System color custom
                shape = RoundedCornerShape(12.dp)
            )
    ) {

        Image(
            painter = when (LocalInspectionMode.current) {
                true -> painterResource(id = R.drawable.americano_small)
                false -> rememberAsyncImagePainter(model = imageUrl)
            },
            contentDescription = "Hello",
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(12.dp))
        )
    }
}