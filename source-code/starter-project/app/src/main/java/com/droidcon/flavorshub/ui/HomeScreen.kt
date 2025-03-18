package com.droidcon.flavorshub.ui

import android.content.res.Configuration
import android.icu.text.NumberFormat
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.Check
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.OutlinedCard
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.droidcon.flavorshub.R
import com.droidcon.flavorshub.viewmodels.HomeViewModel
import com.droidcon.flavorshub.viewmodels.HomeViewModel.UiState.Success
import com.droidcon.flavorshub.viewmodels.model.Recipe

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreenViewModel(
    viewModel: HomeViewModel = hiltViewModel()
) {
    //val recipe = viewModel.recipes[0]

    when (viewModel.uiState) {
        is Success -> {
            val recipes = (viewModel.uiState as Success).recipes
            Scaffold(
                topBar = {
                    TopAppBar(
                        title = {
                            Text("Flavorshub")
                        },
                        colors = TopAppBarDefaults.topAppBarColors(),
                        modifier = Modifier,
                    )
                },
                bottomBar = {
                    val items = listOf("Home", "Favourites")
                    val icons = listOf(Icons.Default.Home, Icons.Default.Favorite)
                    NavigationBar {
                        items.forEachIndexed { index, item ->
                            NavigationBarItem(
                                icon = { Icon(icons[index], contentDescription = item) },
                                label = { Text(item) },
                                selected = 0 == index,
                                onClick = {}
                            )
                        }
                    }
                },
                content = { padding ->
                    Column(
                        modifier = Modifier.padding(padding)
                    ) {
                        // TODO -> convert this to LazyRow
                        Row(
                            modifier = Modifier
                                .horizontalScroll(state = rememberScrollState())
                                .padding(horizontal = 16.dp),
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            // These will be dynamically created
                            FoodFilterChip(
                                text = "Vegan",
                                isSelected = true,
                                onClick = {}
                            )
                            // These will be dynamically created
                            FoodFilterChip(
                                text = "Fish",
                                isSelected = false,
                                onClick = {}
                            )
                            FoodFilterChip(
                                text = "Meat",
                                isSelected = true,
                                onClick = {}
                            )
                        }

                        LazyColumn(
                            modifier = Modifier
                                .padding(horizontal = 16.dp)
                                .padding(top = 16.dp),
                            verticalArrangement = Arrangement.spacedBy(16.dp)
                        ) {
                            items(recipes.size) { index ->
                                val recipeUi = recipes[index]
                                RecipeCard(
                                    modifier = Modifier,
                                    recipe = recipeUi.recipe,
                                    isFavourite = recipeUi.isFavourite,
                                    onFavouriteClick = { viewModel.toggleFavorite(recipeUi.recipe.id) }
                                ) {
                                    // TODO -> Handle click on recipe
                                }
                            }

                            item { Spacer(modifier = Modifier.height(8.dp)) }
                        }
                    }
                }
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FoodFilterChip(
    modifier: Modifier = Modifier,
    text: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    FilterChip(
        modifier = modifier,
        selected = isSelected,
        onClick = onClick,
        label = { Text(text) },
        leadingIcon = if (isSelected) {
            {
                Icon(
                    modifier = Modifier.size(18.dp),
                    imageVector = Icons.Outlined.Check,
                    contentDescription = "Selected",
                    tint = MaterialTheme.colorScheme.onSurface
                )
            }
        } else null
    )
}

@Composable
fun RecipeCard(
    modifier: Modifier = Modifier,
    recipe: Recipe,
    isFavourite: Boolean,
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
                    isFavourite = isFavourite,
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
                    text = recipe.type.text
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
fun RecipeType(
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
fun CookingTime(
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
            text = "${
                NumberFormat.getInstance(LocalConfiguration.current.locale).format(cookingTimeInMin)
            } min",
            fontSize = 14.sp,
            color = Color.Gray
        )
    }
}

@Composable
fun FavouriteIcon(
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
fun RecipeImage(
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
            painter = rememberAsyncImagePainter(imageUrl),
            contentDescription = "Hello",
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(12.dp))
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Preview(locale = "es")
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
//@Preview(locale = "ar")
@Composable
fun HomeScreenPreview() {

}