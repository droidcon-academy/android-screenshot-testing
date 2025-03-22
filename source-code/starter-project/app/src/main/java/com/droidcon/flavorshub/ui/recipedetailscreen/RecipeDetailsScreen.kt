package com.droidcon.flavorshub.ui.recipedetailscreen

import androidx.compose.foundation.Image
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.droidcon.flavorshub.viewmodels.RecipeDetailsScreenViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecipeDetailsScreen(
    viewModel: RecipeDetailsScreenViewModel = hiltViewModel(),
    recipeId: Int,
    onBackPressed: () -> Unit = {}
) {
    val recipe = viewModel.fetchedRecipeById(recipeId)
    val scrollState = rememberScrollState()

    // Constants for dimensions
    val imageHeight = 200.dp
    val topBarHeight = 52.dp

    // Calculate the alpha for the TopBar based on scroll position - starting at 0.8f (80%)
    val topBarAlpha =
        (0.8f + 0.2f * (scrollState.value / (imageHeight.value - topBarHeight.value))).coerceIn(0.5f, 1f)

    // Get the primary color from the MaterialTheme
    val primaryColor = MaterialTheme.colorScheme.primary

    Box(modifier = Modifier.fillMaxSize()) {
        // Content with scrolling
        Column(
            modifier = Modifier
                .fillMaxSize()
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
                        .background(primaryColor.copy(alpha = topBarAlpha))
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text("Ingredients", style = typography.titleLarge)
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    recipe.ingredients.joinToString("\n"),
                    style = typography.bodyMedium
                )

                Spacer(modifier = Modifier.height(32.dp))

                Text("Instructions", style = typography.titleLarge)
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    recipe.instructions.joinToString("\n\n"),
                    style = typography.bodyMedium
                )
            }
        }

        // TopBar that changes opacity based on scroll with a back arrow
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
                    when (topBarAlpha == 1f) {
                        true -> 1f
                        false -> topBarAlpha - 0.8f
                    }
                ),
                titleContentColor = MaterialTheme.colorScheme.onPrimary,
                navigationIconContentColor = MaterialTheme.colorScheme.onPrimary
            ),
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MyPreview() {
    RecipeDetailsScreen(recipeId = 1)
}