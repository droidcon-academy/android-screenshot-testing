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
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.droidcon.flavorshub.R
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

    val initialTopAppBarAlpha = 0.8f
    val initialTopAppBarOpacity = 1 - initialTopAppBarAlpha
    val alphaFactor = scrollState.value / (imageHeight.value - topAppBarHeight.value)
    val overlayAlpha =
        (initialTopAppBarAlpha + initialTopAppBarOpacity * alphaFactor).coerceIn(0.5f, 1f)

    val topAppBarAlpha = when (overlayAlpha == 1f) {
        true -> 1f
        false -> overlayAlpha - 0.8f
    }

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.surface)
                .verticalScroll(scrollState)
        ) {
            // Overlay matching the Top app bar color with the SAME alpha
            RecipeImageWithOverlay(
                imageHeight = imageHeight,
                recipeName = recipe.name,
                recipeImageUrl = recipe.imageUrl,
                topBarAlpha = overlayAlpha
            )
            RecipePreparation(
                recipeIngredients = recipe.ingredients,
                recipeInstructions = recipe.instructions
            )
        }

        AlphaTopAppBar(
            recipeName = recipe.name,
            topBarAlpha = topAppBarAlpha,
            onBackPressed = onBackPressed
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AlphaTopAppBar(
    recipeName: String,
    topBarAlpha: Float,
    onBackPressed: () -> Unit,
) {
    TopAppBar(
        title = { Text(recipeName) },
        navigationIcon = {
            IconButton(onClick = onBackPressed) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Navigate Back"
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary.copy(topBarAlpha),
            titleContentColor = MaterialTheme.colorScheme.onPrimary,
            navigationIconContentColor = MaterialTheme.colorScheme.onPrimary
        ),
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun RecipeImageWithOverlay(
    imageHeight: Dp,
    recipeName: String,
    recipeImageUrl: String,
    topBarAlpha: Float
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(imageHeight)
    ) {
        Image(
            painter = rememberAsyncImagePainter(model = recipeImageUrl),
            contentDescription = stringResource(
                id = R.string.recipe_image_content_description,
                formatArgs = arrayOf(recipeName)
            ),
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        // Overlay
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.primary.copy(alpha = topBarAlpha))
        )
    }
}

@Composable
fun RecipePreparation(
    recipeIngredients: List<String>,
    recipeInstructions: List<String>,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.surface)
            .padding(16.dp)
    ) {
        Text(
            "Ingredients",
            style = typography.titleLarge,
            color = MaterialTheme.colorScheme.onSurface
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            recipeIngredients.joinToString("\n"),
            style = typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurface
        )

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            stringResource(R.string.details_screen_instructions_title),
            style = typography.titleLarge,
            color = MaterialTheme.colorScheme.onSurface
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            recipeInstructions.joinToString("\n\n"),
            style = typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurface
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