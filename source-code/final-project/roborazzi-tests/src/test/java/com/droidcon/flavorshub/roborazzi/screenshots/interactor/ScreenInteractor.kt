package com.droidcon.flavorshub.roborazzi.screenshots.interactor

import com.droidcon.flavorshub.ui.R
import androidx.activity.ComponentActivity
import androidx.compose.ui.test.SemanticsNodeInteraction
import androidx.compose.ui.test.junit4.AndroidComposeTestRule
import androidx.compose.ui.test.onAllNodesWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.onRoot
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.github.takahirom.roborazzi.captureRoboImage

class ScreenInteractor<A: ComponentActivity>(
    val composeTestRule:  AndroidComposeTestRule<ActivityScenarioRule<A>, A>
) {

    fun stringRes(stringRes: Int, vararg formatArgs: Any) =
        composeTestRule.activity.getString(stringRes, *formatArgs)

    fun captureScreenshot(name: String) {
        composeTestRule.onRoot().captureRoboImage(name)
    }

    fun addToFavoritesButtonInRecipeAtIndex(index: Int): SemanticsNodeInteraction =
        composeTestRule.onAllNodesWithContentDescription(
            label = stringRes(R.string.add_to_favorites_icon),
            useUnmergedTree = true
        )[index]

    fun removeFromFavoritesButtonInRecipeAtIndex(index: Int): SemanticsNodeInteraction =
        composeTestRule.onAllNodesWithContentDescription(
            label = stringRes(R.string.remove_from_favorites_icon),
            useUnmergedTree = true
        )[index]

    fun bottomTabFavorites() : SemanticsNodeInteraction =
        composeTestRule.onNodeWithText(stringRes(R.string.bottom_nav_Favorites))

    fun recipeImageAtIndex(index: Int): SemanticsNodeInteraction =
        composeTestRule.onAllNodesWithContentDescription(
            label = stringRes(R.string.recipe_image_content_description, ""),
            substring = true,
            useUnmergedTree = true
        )[index]

    fun pressBack() {
        composeTestRule.activity.onBackPressedDispatcher.onBackPressed()
    }
}