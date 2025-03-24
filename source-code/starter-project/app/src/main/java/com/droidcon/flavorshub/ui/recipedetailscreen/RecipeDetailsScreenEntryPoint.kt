package com.droidcon.flavorshub.ui.recipedetailscreen

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.droidcon.flavorshub.model.Type
import com.droidcon.flavorshub.model.screens.RecipeDetailsItem
import com.droidcon.flavorshub.ui.theme.FlavorshubTheme
import com.droidcon.flavorshub.viewmodels.RecipeDetailsScreenViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecipeDetailsScreenEntryPoint(
    viewModel: RecipeDetailsScreenViewModel = hiltViewModel(),
    recipeId: Int,
    onBackPressed: () -> Unit
) {
    val recipe = viewModel.fetchRecipeInCurrentLocaleById(recipeId)
    val scrollState = rememberScrollState()

    RecipeDetailsScreen(
        scrollState = scrollState,
        recipe = recipe,
        onBackPressed = onBackPressed
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecipeDetailsScreen(
    scrollState: ScrollState,
    recipe: RecipeDetailsItem,
    onBackPressed: () -> Unit
) {
    val imageHeight = 200.dp
    val topAppBarHeight = 56.dp

    val startingTopBarAlpha = 0.8f
    val topBarAlpha = remember {
        derivedStateOf {
            (startingTopBarAlpha + (1 - startingTopBarAlpha) * 
            (scrollState.value / (imageHeight.value - topAppBarHeight.value))).coerceIn(0.5f, 1f)
        }
    }

    val primaryColor = MaterialTheme.colorScheme.primary
    val surfaceColor = MaterialTheme.colorScheme.surface

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(surfaceColor)  
                .verticalScroll(scrollState)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(imageHeight) // Image height
            ) {
                Image(
                    painter = rememberAsyncImagePainter(model = recipe.imageUrl),
                    contentDescription = "Recipe image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )

                // Color overlay matching the app bar color with the SAME alpha
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(primaryColor.copy(alpha = topBarAlpha.value))
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(surfaceColor)  
                    .padding(16.dp)
            ) {
                Text(
                    "Ingredients", 
                    style = typography.titleLarge,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    recipe.ingredients.joinToString("\n"),
                    style = typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurface
                )

                Spacer(modifier = Modifier.height(32.dp))

                Text(
                    "Instructions", 
                    style = typography.titleLarge,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    recipe.instructions.joinToString("\n\n"),
                    style = typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurface
                )
            }
        }

        TopAppBar(
            title = { Text(recipe.name) },
            navigationIcon = {
                IconButton(onClick = onBackPressed) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "Back"
                    )
                }
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = primaryColor.copy(
                    when (topBarAlpha.value == 1f) {
                        true -> 1f
                        false -> topBarAlpha.value - 0.8f
                    }
                ),
                titleContentColor = MaterialTheme.colorScheme.onPrimary,
                navigationIconContentColor = MaterialTheme.colorScheme.onPrimary
            ),
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Preview(showBackground = true)
@Composable
fun MyPreview() {
    FlavorshubTheme {
        RecipeDetailsScreen(
            scrollState = rememberScrollState(),
            recipe = RecipeDetailsItem(
                id = 1,
                name = "Test Recipe",
                cookingTimeInMin = 15,
                type = Type.MEAT,
                imageUrl = "",
                ingredients = listOf(
                    "1 cup quinoa, rinsed",
                    "1 sweet potato, diced",
                    "1 cup broccoli florets",
                    "1 red bell pepper, sliced",
                    "1 cup chickpeas, drained and rinsed",
                    "2 tbsp olive oil",
                    "1 avocado, sliced",
                    "2 tbsp tahini",
                    "1 tbsp lemon juice",
                    "1 tsp maple syrup",
                    "Salt and pepper to taste"
                ),
                instructions = listOf(
                    "1. Preheat oven to 425°F (220°C)",
                    "2. Cook quinoa according to package instructions",
                    "3. Toss sweet potato, broccoli and bell pepper with olive oil, salt and pepper",
                    "4. Roast vegetables for 20-25 minutes until tender",
                    "5. Mix tahini, lemon juice, maple syrup and 2-3 tbsp water to make dressing",
                    "6. Assemble bowl with quinoa, roasted vegetables, chickpeas and avocado",
                    "7. Drizzle with tahini dressing and serve"
                )
            ),
            onBackPressed = {}
        )
    }
}