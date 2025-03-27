package com.droidcon.flavorshub.ui.screens.main.ui

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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
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
import com.droidcon.flavorshub.model.FavoriteState
import com.droidcon.flavorshub.ui.screens.main.model.MainScreenRecipeItem
import com.droidcon.flavorshub.ui.shared.RecipeCookingInfo

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
                FavouriteIconButton(
                    isFavorite = recipe.isFavorite,
                    onClick = { onFavouriteClick(recipe.id) }
                )
            }

            RecipeImage(
                modifier = Modifier.padding(bottom = 12.dp),
                recipeName = recipe.name,
                imageUrl = recipe.imageUrl
            )

            RecipeCookingInfo(
                modifier = Modifier.fillMaxWidth(),
                cookingTimeInMin = recipe.cookingTimeInMin,
                recipeIcon = recipe.type.icon,
                recipeText = recipe.type.text
            )

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
private fun FavouriteIconButton(
    modifier: Modifier = Modifier,
    isFavorite: FavoriteState,
    onClick: () -> Unit
) {
    
    Icon(
        modifier = modifier.clickable(
            interactionSource = remember { MutableInteractionSource() },
            indication = rememberRipple(bounded = false),
            onClick = onClick
        ),
        imageVector = ImageVector.vectorResource(id = isFavorite.iconRes),
        contentDescription = stringResource(isFavorite.contentDescriptionRes),
        tint = MaterialTheme.colorScheme.error
    )
}

@Composable
private fun RecipeImage(
    modifier: Modifier = Modifier,
    recipeName: String,
    imageUrl: String,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(150.dp)
            .border(
                border = BorderStroke(
                    width = 1.dp,
                    color = MaterialTheme.colorScheme.outline
                ),
                shape = RoundedCornerShape(12.dp)
            )
    ) {

        Image(
            painter = when (LocalInspectionMode.current) {
                true -> painterResource(id = R.drawable.empty_recipes)
                false -> rememberAsyncImagePainter(model = imageUrl)
            },
            contentDescription =  stringResource(
                id = R.string.recipe_image_content_description,
                formatArgs = arrayOf(recipeName)
            ),
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(12.dp))
        )
    }
}