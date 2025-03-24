package com.droidcon.flavorshub.viewmodels

import com.droidcon.flavorshub.utils.LocaleProvider
import com.droidcon.flavorshub.R
import com.droidcon.flavorshub.model.Recipe
import com.droidcon.flavorshub.model.RecipeItem
import com.droidcon.flavorshub.model.Type
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RecipesRepo @Inject constructor(
    private val localeProvider: LocaleProvider
) {

    // WARNING: It uses get() because it needs to be recomputed on every call,
    // so when the Locale changes, it returns the recipes in the correct language
    private val recipes: List<RecipeItem>
        get() =
            listOf(
                // VEGAN RECIPES
                RecipeItem(
                    recipe = Recipe(
                        id = 0,
                        name = localeProvider.getString(R.string.vegan_buddha_bowl_name),
                        cookingTimeInMin = 25,
                        shortDescription = localeProvider.getString(R.string.vegan_buddha_bowl_description),
                        type = Type.VEGAN,
                        imageUrl = "https://images.unsplash.com/photo-1512621776951-a57141f2eefd",
                        ingredients = listOf(
                            localeProvider.getString(R.string.buddha_ingredient_1),
                            localeProvider.getString(R.string.buddha_ingredient_2),
                            localeProvider.getString(R.string.buddha_ingredient_3),
                            localeProvider.getString(R.string.buddha_ingredient_4),
                            localeProvider.getString(R.string.buddha_ingredient_5),
                            localeProvider.getString(R.string.buddha_ingredient_6),
                            localeProvider.getString(R.string.buddha_ingredient_7),
                            localeProvider.getString(R.string.buddha_ingredient_8),
                            localeProvider.getString(R.string.buddha_ingredient_9),
                            localeProvider.getString(R.string.buddha_ingredient_10),
                            localeProvider.getString(R.string.buddha_ingredient_11)
                        ),
                        instructions = listOf(
                            localeProvider.getString(R.string.buddha_instruction_1),
                            localeProvider.getString(R.string.buddha_instruction_2),
                            localeProvider.getString(R.string.buddha_instruction_3),
                            localeProvider.getString(R.string.buddha_instruction_4),
                            localeProvider.getString(R.string.buddha_instruction_5),
                            localeProvider.getString(R.string.buddha_instruction_6),
                            localeProvider.getString(R.string.buddha_instruction_7)
                        )
                    ),
                    isFavourite = false
                ),
                RecipeItem(
                    recipe = Recipe(
                        id = 1,
                        name = localeProvider.getString(R.string.mushroom_risotto_name),
                        cookingTimeInMin = 35,
                        shortDescription = localeProvider.getString(R.string.mushroom_risotto_description),
                        type = Type.VEGAN,
                        imageUrl = "https://images.unsplash.com/photo-1476124369491-e7addf5db371",
                        ingredients = listOf(
                            localeProvider.getString(R.string.mushroom_risotto_ingredient_1),
                            localeProvider.getString(R.string.mushroom_risotto_ingredient_2),
                            localeProvider.getString(R.string.mushroom_risotto_ingredient_3),
                            localeProvider.getString(R.string.mushroom_risotto_ingredient_4),
                            localeProvider.getString(R.string.mushroom_risotto_ingredient_5),
                            localeProvider.getString(R.string.mushroom_risotto_ingredient_6),
                            localeProvider.getString(R.string.mushroom_risotto_ingredient_7),
                            localeProvider.getString(R.string.mushroom_risotto_ingredient_8),
                            localeProvider.getString(R.string.mushroom_risotto_ingredient_9),
                            localeProvider.getString(R.string.mushroom_risotto_ingredient_10)
                        ),
                        instructions = listOf(
                            localeProvider.getString(R.string.mushroom_risotto_instruction_1),
                            localeProvider.getString(R.string.mushroom_risotto_instruction_2),
                            localeProvider.getString(R.string.mushroom_risotto_instruction_3),
                            localeProvider.getString(R.string.mushroom_risotto_instruction_4),
                            localeProvider.getString(R.string.mushroom_risotto_instruction_5),
                            localeProvider.getString(R.string.mushroom_risotto_instruction_6),
                            localeProvider.getString(R.string.mushroom_risotto_instruction_7),
                            localeProvider.getString(R.string.mushroom_risotto_instruction_8),
                            localeProvider.getString(R.string.mushroom_risotto_instruction_9)
                        )
                    ),
                    isFavourite = false
                ),
                RecipeItem(
                    recipe = Recipe(
                        id = 2,
                        name = localeProvider.getString(R.string.avocado_toast_name),
                        cookingTimeInMin = 10,
                        shortDescription = localeProvider.getString(R.string.avocado_toast_description),
                        type = Type.VEGAN,
                        imageUrl = "https://images.unsplash.com/photo-1546069901-ba9599a7e63c",
                        ingredients = listOf(
                            localeProvider.getString(R.string.avocado_toast_ingredient_1),
                            localeProvider.getString(R.string.avocado_toast_ingredient_2),
                            localeProvider.getString(R.string.avocado_toast_ingredient_3),
                            localeProvider.getString(R.string.avocado_toast_ingredient_4),
                            localeProvider.getString(R.string.avocado_toast_ingredient_5),
                            localeProvider.getString(R.string.avocado_toast_ingredient_6)
                        ),
                        instructions = listOf(
                            localeProvider.getString(R.string.avocado_toast_instruction_1),
                            localeProvider.getString(R.string.avocado_toast_instruction_2),
                            localeProvider.getString(R.string.avocado_toast_instruction_3),
                            localeProvider.getString(R.string.avocado_toast_instruction_4),
                            localeProvider.getString(R.string.avocado_toast_instruction_5)
                        )
                    ),
                    isFavourite = false
                ),
                RecipeItem(
                    recipe = Recipe(
                        id = 3,
                        name = localeProvider.getString(R.string.vegetable_curry_name),
                        cookingTimeInMin = 30,
                        shortDescription = localeProvider.getString(R.string.vegetable_curry_description),
                        type = Type.VEGAN,
                        imageUrl = "https://images.unsplash.com/photo-1565557623262-b51c2513a641",
                        ingredients = listOf(
                            localeProvider.getString(R.string.vegetable_curry_ingredient_1),
                            localeProvider.getString(R.string.vegetable_curry_ingredient_2),
                            localeProvider.getString(R.string.vegetable_curry_ingredient_3),
                            localeProvider.getString(R.string.vegetable_curry_ingredient_4),
                            localeProvider.getString(R.string.vegetable_curry_ingredient_5),
                            localeProvider.getString(R.string.vegetable_curry_ingredient_6),
                            localeProvider.getString(R.string.vegetable_curry_ingredient_7),
                            localeProvider.getString(R.string.vegetable_curry_ingredient_8),
                            localeProvider.getString(R.string.vegetable_curry_ingredient_9),
                            localeProvider.getString(R.string.vegetable_curry_ingredient_10),
                            localeProvider.getString(R.string.vegetable_curry_ingredient_11),
                            localeProvider.getString(R.string.vegetable_curry_ingredient_12)
                        ),
                        instructions = listOf(
                            localeProvider.getString(R.string.vegetable_curry_instruction_1),
                            localeProvider.getString(R.string.vegetable_curry_instruction_2),
                            localeProvider.getString(R.string.vegetable_curry_instruction_3),
                            localeProvider.getString(R.string.vegetable_curry_instruction_4),
                            localeProvider.getString(R.string.vegetable_curry_instruction_5),
                            localeProvider.getString(R.string.vegetable_curry_instruction_6),
                            localeProvider.getString(R.string.vegetable_curry_instruction_7),
                            localeProvider.getString(R.string.vegetable_curry_instruction_8)
                        )
                    ),
                    isFavourite = false
                ),
                RecipeItem(
                    recipe = Recipe(
                        id = 4,
                        name = localeProvider.getString(R.string.stuffed_bell_peppers_name),
                        cookingTimeInMin = 45,
                        shortDescription = localeProvider.getString(R.string.stuffed_bell_peppers_description),
                        type = Type.VEGAN,
                        imageUrl = "https://images.unsplash.com/photo-1600335895229-6e75511892c8",
                        ingredients = listOf(
                            localeProvider.getString(R.string.stuffed_bell_peppers_ingredient_1),
                            localeProvider.getString(R.string.stuffed_bell_peppers_ingredient_2),
                            localeProvider.getString(R.string.stuffed_bell_peppers_ingredient_3),
                            localeProvider.getString(R.string.stuffed_bell_peppers_ingredient_4),
                            localeProvider.getString(R.string.stuffed_bell_peppers_ingredient_5),
                            localeProvider.getString(R.string.stuffed_bell_peppers_ingredient_6),
                            localeProvider.getString(R.string.stuffed_bell_peppers_ingredient_7),
                            localeProvider.getString(R.string.stuffed_bell_peppers_ingredient_8),
                            localeProvider.getString(R.string.stuffed_bell_peppers_ingredient_9),
                            localeProvider.getString(R.string.stuffed_bell_peppers_ingredient_10),
                            localeProvider.getString(R.string.stuffed_bell_peppers_ingredient_11),
                            localeProvider.getString(R.string.stuffed_bell_peppers_ingredient_12),
                            localeProvider.getString(R.string.stuffed_bell_peppers_ingredient_13)
                        ),
                        instructions = listOf(
                            localeProvider.getString(R.string.stuffed_bell_peppers_instruction_1),
                            localeProvider.getString(R.string.stuffed_bell_peppers_instruction_2),
                            localeProvider.getString(R.string.stuffed_bell_peppers_instruction_3),
                            localeProvider.getString(R.string.stuffed_bell_peppers_instruction_4),
                            localeProvider.getString(R.string.stuffed_bell_peppers_instruction_5),
                            localeProvider.getString(R.string.stuffed_bell_peppers_instruction_6),
                            localeProvider.getString(R.string.stuffed_bell_peppers_instruction_7),
                            localeProvider.getString(R.string.stuffed_bell_peppers_instruction_8),
                            localeProvider.getString(R.string.stuffed_bell_peppers_instruction_9),
                            localeProvider.getString(R.string.stuffed_bell_peppers_instruction_10),
                            localeProvider.getString(R.string.stuffed_bell_peppers_instruction_11)
                        )
                    ),
                    isFavourite = false
                ),
                RecipeItem(
                    recipe = Recipe(
                        id = 5,
                        name = localeProvider.getString(R.string.sweet_potato_tacos_name),
                        cookingTimeInMin = 25,
                        shortDescription = localeProvider.getString(R.string.sweet_potato_tacos_description),
                        type = Type.VEGAN,
                        imageUrl = "https://images.unsplash.com/photo-1552332386-f8dd00dc2f85",
                        ingredients = listOf(
                            localeProvider.getString(R.string.sweet_potato_tacos_ingredient_1),
                            localeProvider.getString(R.string.sweet_potato_tacos_ingredient_2),
                            localeProvider.getString(R.string.sweet_potato_tacos_ingredient_3),
                            localeProvider.getString(R.string.sweet_potato_tacos_ingredient_4),
                            localeProvider.getString(R.string.sweet_potato_tacos_ingredient_5),
                            localeProvider.getString(R.string.sweet_potato_tacos_ingredient_6),
                            localeProvider.getString(R.string.sweet_potato_tacos_ingredient_7),
                            localeProvider.getString(R.string.sweet_potato_tacos_ingredient_8),
                            localeProvider.getString(R.string.sweet_potato_tacos_ingredient_9),
                            localeProvider.getString(R.string.sweet_potato_tacos_ingredient_10)
                        ),
                        instructions = listOf(
                            localeProvider.getString(R.string.sweet_potato_tacos_instruction_1),
                            localeProvider.getString(R.string.sweet_potato_tacos_instruction_2),
                            localeProvider.getString(R.string.sweet_potato_tacos_instruction_3),
                            localeProvider.getString(R.string.sweet_potato_tacos_instruction_4),
                            localeProvider.getString(R.string.sweet_potato_tacos_instruction_5),
                            localeProvider.getString(R.string.sweet_potato_tacos_instruction_6),
                            localeProvider.getString(R.string.sweet_potato_tacos_instruction_7),
                            localeProvider.getString(R.string.sweet_potato_tacos_instruction_8),
                            localeProvider.getString(R.string.sweet_potato_tacos_instruction_9)
                        )
                    ),
                    isFavourite = false
                ),
                RecipeItem(
                    recipe = Recipe(
                        id = 6,
                        name = localeProvider.getString(R.string.chickpea_masala_name),
                        cookingTimeInMin = 30,
                        shortDescription = localeProvider.getString(R.string.chickpea_masala_description),
                        type = Type.VEGAN,
                        imageUrl = "https://images.unsplash.com/photo-1511690743698-d9d85f2fbf38",
                        ingredients = listOf(
                            localeProvider.getString(R.string.chickpea_masala_ingredient_1),
                            localeProvider.getString(R.string.chickpea_masala_ingredient_2),
                            localeProvider.getString(R.string.chickpea_masala_ingredient_3),
                            localeProvider.getString(R.string.chickpea_masala_ingredient_4),
                            localeProvider.getString(R.string.chickpea_masala_ingredient_5),
                            localeProvider.getString(R.string.chickpea_masala_ingredient_6),
                            localeProvider.getString(R.string.chickpea_masala_ingredient_7),
                            localeProvider.getString(R.string.chickpea_masala_ingredient_8),
                            localeProvider.getString(R.string.chickpea_masala_ingredient_9),
                            localeProvider.getString(R.string.chickpea_masala_ingredient_10),
                            localeProvider.getString(R.string.chickpea_masala_ingredient_11),
                            localeProvider.getString(R.string.chickpea_masala_ingredient_12)
                        ),
                        instructions = listOf(
                            localeProvider.getString(R.string.chickpea_masala_instruction_1),
                            localeProvider.getString(R.string.chickpea_masala_instruction_2),
                            localeProvider.getString(R.string.chickpea_masala_instruction_3),
                            localeProvider.getString(R.string.chickpea_masala_instruction_4),
                            localeProvider.getString(R.string.chickpea_masala_instruction_5),
                            localeProvider.getString(R.string.chickpea_masala_instruction_6),
                            localeProvider.getString(R.string.chickpea_masala_instruction_7),
                            localeProvider.getString(R.string.chickpea_masala_instruction_8),
                            localeProvider.getString(R.string.chickpea_masala_instruction_9)
                        )
                    ),
                    isFavourite = false
                ),
                RecipeItem(
                    recipe = Recipe(
                        id = 7,
                        name = localeProvider.getString(R.string.lentil_soup_name),
                        cookingTimeInMin = 40,
                        shortDescription = localeProvider.getString(R.string.lentil_soup_description),
                        type = Type.VEGAN,
                        imageUrl = "https://images.unsplash.com/photo-1547592180-85f173990554",
                        ingredients = listOf(
                            localeProvider.getString(R.string.lentil_soup_ingredient_1),
                            localeProvider.getString(R.string.lentil_soup_ingredient_2),
                            localeProvider.getString(R.string.lentil_soup_ingredient_3),
                            localeProvider.getString(R.string.lentil_soup_ingredient_4),
                            localeProvider.getString(R.string.lentil_soup_ingredient_5),
                            localeProvider.getString(R.string.lentil_soup_ingredient_6),
                            localeProvider.getString(R.string.lentil_soup_ingredient_7),
                            localeProvider.getString(R.string.lentil_soup_ingredient_8),
                            localeProvider.getString(R.string.lentil_soup_ingredient_9),
                            localeProvider.getString(R.string.lentil_soup_ingredient_10)
                        ),
                        instructions = listOf(
                            localeProvider.getString(R.string.lentil_soup_instruction_1),
                            localeProvider.getString(R.string.lentil_soup_instruction_2),
                            localeProvider.getString(R.string.lentil_soup_instruction_3),
                            localeProvider.getString(R.string.lentil_soup_instruction_4),
                            localeProvider.getString(R.string.lentil_soup_instruction_5),
                            localeProvider.getString(R.string.lentil_soup_instruction_6)
                        )
                    ),
                    isFavourite = false
                ),
                RecipeItem(
                    recipe = Recipe(
                        id = 8,
                        name = localeProvider.getString(R.string.roasted_vegetable_salad_name),
                        cookingTimeInMin = 35,
                        shortDescription = localeProvider.getString(R.string.roasted_vegetable_salad_description),
                        type = Type.VEGAN,
                        imageUrl = "https://images.unsplash.com/photo-1512621776951-a57141f2eefd",
                        ingredients = listOf(
                            localeProvider.getString(R.string.roasted_vegetable_salad_ingredient_1),
                            localeProvider.getString(R.string.roasted_vegetable_salad_ingredient_2),
                            localeProvider.getString(R.string.roasted_vegetable_salad_ingredient_3),
                            localeProvider.getString(R.string.roasted_vegetable_salad_ingredient_4),
                            localeProvider.getString(R.string.roasted_vegetable_salad_ingredient_5),
                            localeProvider.getString(R.string.roasted_vegetable_salad_ingredient_6),
                            localeProvider.getString(R.string.roasted_vegetable_salad_ingredient_7)
                        ),
                        instructions = listOf(
                            localeProvider.getString(R.string.roasted_vegetable_salad_instruction_1),
                            localeProvider.getString(R.string.roasted_vegetable_salad_instruction_2),
                            localeProvider.getString(R.string.roasted_vegetable_salad_instruction_3),
                            localeProvider.getString(R.string.roasted_vegetable_salad_instruction_4),
                            localeProvider.getString(R.string.roasted_vegetable_salad_instruction_5),
                            localeProvider.getString(R.string.roasted_vegetable_salad_instruction_6),
                            localeProvider.getString(R.string.roasted_vegetable_salad_instruction_7)
                        )
                    ),
                    isFavourite = false
                ),
                RecipeItem(
                    recipe = Recipe(
                        id = 9,
                        name = localeProvider.getString(R.string.quinoa_salad_name),
                        cookingTimeInMin = 20,
                        shortDescription = localeProvider.getString(R.string.quinoa_salad_description),
                        type = Type.VEGAN,
                        imageUrl = "https://images.unsplash.com/photo-1505576399279-565b52d4ac71",
                        ingredients = listOf(
                            localeProvider.getString(R.string.quinoa_salad_ingredient_1),
                            localeProvider.getString(R.string.quinoa_salad_ingredient_2),
                            localeProvider.getString(R.string.quinoa_salad_ingredient_3),
                            localeProvider.getString(R.string.quinoa_salad_ingredient_4),
                            localeProvider.getString(R.string.quinoa_salad_ingredient_5),
                            localeProvider.getString(R.string.quinoa_salad_ingredient_6),
                            localeProvider.getString(R.string.quinoa_salad_ingredient_7),
                            localeProvider.getString(R.string.quinoa_salad_ingredient_8)
                        ),
                        instructions = listOf(
                            localeProvider.getString(R.string.quinoa_salad_instruction_1),
                            localeProvider.getString(R.string.quinoa_salad_instruction_2),
                            localeProvider.getString(R.string.quinoa_salad_instruction_3),
                            localeProvider.getString(R.string.quinoa_salad_instruction_4),
                            localeProvider.getString(R.string.quinoa_salad_instruction_5),
                            localeProvider.getString(R.string.quinoa_salad_instruction_6)
                        )
                    ),
                    isFavourite = false
                ),

                // FISH RECIPES
                RecipeItem(
                    recipe = Recipe(
                        id = 10,
                        name = localeProvider.getString(R.string.fish_grilled_salmon_name),
                        cookingTimeInMin = 20,
                        shortDescription = localeProvider.getString(R.string.fish_grilled_salmon_description),
                        type = Type.FISH,
                        imageUrl = "https://images.unsplash.com/photo-1519708227418-c8fd9a32b7a2",
                        ingredients = listOf(
                            localeProvider.getString(R.string.fish_grilled_salmon_ingredient_1),
                            localeProvider.getString(R.string.fish_grilled_salmon_ingredient_2),
                            localeProvider.getString(R.string.fish_grilled_salmon_ingredient_3),
                            localeProvider.getString(R.string.fish_grilled_salmon_ingredient_4),
                            localeProvider.getString(R.string.fish_grilled_salmon_ingredient_5),
                            localeProvider.getString(R.string.fish_grilled_salmon_ingredient_6)
                        ),
                        instructions = listOf(
                            localeProvider.getString(R.string.fish_grilled_salmon_instruction_1),
                            localeProvider.getString(R.string.fish_grilled_salmon_instruction_2),
                            localeProvider.getString(R.string.fish_grilled_salmon_instruction_3),
                            localeProvider.getString(R.string.fish_grilled_salmon_instruction_4),
                            localeProvider.getString(R.string.fish_grilled_salmon_instruction_5)
                        )
                    ),
                    isFavourite = false
                ),
                RecipeItem(
                    recipe = Recipe(
                        id = 11,
                        name = localeProvider.getString(R.string.fish_tuna_poke_bowl_name),
                        cookingTimeInMin = 15,
                        shortDescription = localeProvider.getString(R.string.fish_tuna_poke_bowl_description),
                        type = Type.FISH,
                        imageUrl = "https://images.unsplash.com/photo-1546069901-ba9599a7e63c",
                        ingredients = listOf(
                            localeProvider.getString(R.string.fish_tuna_poke_bowl_ingredient_1),
                            localeProvider.getString(R.string.fish_tuna_poke_bowl_ingredient_2),
                            localeProvider.getString(R.string.fish_tuna_poke_bowl_ingredient_3),
                            localeProvider.getString(R.string.fish_tuna_poke_bowl_ingredient_4),
                            localeProvider.getString(R.string.fish_tuna_poke_bowl_ingredient_5),
                            localeProvider.getString(R.string.fish_tuna_poke_bowl_ingredient_6),
                            localeProvider.getString(R.string.fish_tuna_poke_bowl_ingredient_7),
                            localeProvider.getString(R.string.fish_tuna_poke_bowl_ingredient_8)
                        ),
                        instructions = listOf(
                            localeProvider.getString(R.string.fish_tuna_poke_bowl_instruction_1),
                            localeProvider.getString(R.string.fish_tuna_poke_bowl_instruction_2),
                            localeProvider.getString(R.string.fish_tuna_poke_bowl_instruction_3),
                            localeProvider.getString(R.string.fish_tuna_poke_bowl_instruction_4),
                            localeProvider.getString(R.string.fish_tuna_poke_bowl_instruction_5)
                        )
                    ),
                    isFavourite = false
                ),
                RecipeItem(
                    recipe = Recipe(
                        id = 12,
                        name = localeProvider.getString(R.string.fish_fish_tacos_name),
                        cookingTimeInMin = 25,
                        shortDescription = localeProvider.getString(R.string.fish_fish_tacos_description),
                        type = Type.FISH,
                        imageUrl = "https://images.unsplash.com/photo-1551504734-5ee1c4a1479b",
                        ingredients = listOf(
                            localeProvider.getString(R.string.fish_fish_tacos_ingredient_1),
                            localeProvider.getString(R.string.fish_fish_tacos_ingredient_2),
                            localeProvider.getString(R.string.fish_fish_tacos_ingredient_3),
                            localeProvider.getString(R.string.fish_fish_tacos_ingredient_4),
                            localeProvider.getString(R.string.fish_fish_tacos_ingredient_5),
                            localeProvider.getString(R.string.fish_fish_tacos_ingredient_6),
                            localeProvider.getString(R.string.fish_fish_tacos_ingredient_7),
                            localeProvider.getString(R.string.fish_fish_tacos_ingredient_8),
                            localeProvider.getString(R.string.fish_fish_tacos_ingredient_9)
                        ),
                        instructions = listOf(
                            localeProvider.getString(R.string.fish_fish_tacos_instruction_1),
                            localeProvider.getString(R.string.fish_fish_tacos_instruction_2),
                            localeProvider.getString(R.string.fish_fish_tacos_instruction_3),
                            localeProvider.getString(R.string.fish_fish_tacos_instruction_4),
                            localeProvider.getString(R.string.fish_fish_tacos_instruction_5),
                            localeProvider.getString(R.string.fish_fish_tacos_instruction_6),
                            localeProvider.getString(R.string.fish_fish_tacos_instruction_7)
                        )
                    ),
                    isFavourite = false
                ),
                RecipeItem(
                    recipe = Recipe(
                        id = 13,
                        name = localeProvider.getString(R.string.fish_fish_curry_name),
                        cookingTimeInMin = 35,
                        shortDescription = localeProvider.getString(R.string.fish_fish_curry_description),
                        type = Type.FISH,
                        imageUrl = "https://images.unsplash.com/photo-1548943487-a2e4e43b4853",
                        ingredients = listOf(
                            localeProvider.getString(R.string.fish_fish_curry_ingredient_1),
                            localeProvider.getString(R.string.fish_fish_curry_ingredient_2),
                            localeProvider.getString(R.string.fish_fish_curry_ingredient_3),
                            localeProvider.getString(R.string.fish_fish_curry_ingredient_4),
                            localeProvider.getString(R.string.fish_fish_curry_ingredient_5),
                            localeProvider.getString(R.string.fish_fish_curry_ingredient_6),
                            localeProvider.getString(R.string.fish_fish_curry_ingredient_7),
                            localeProvider.getString(R.string.fish_fish_curry_ingredient_8),
                            localeProvider.getString(R.string.fish_fish_curry_ingredient_9),
                            localeProvider.getString(R.string.fish_fish_curry_ingredient_10),
                            localeProvider.getString(R.string.fish_fish_curry_ingredient_11)
                        ),
                        instructions = listOf(
                            localeProvider.getString(R.string.fish_fish_curry_instruction_1),
                            localeProvider.getString(R.string.fish_fish_curry_instruction_2),
                            localeProvider.getString(R.string.fish_fish_curry_instruction_3),
                            localeProvider.getString(R.string.fish_fish_curry_instruction_4),
                            localeProvider.getString(R.string.fish_fish_curry_instruction_5),
                            localeProvider.getString(R.string.fish_fish_curry_instruction_6),
                            localeProvider.getString(R.string.fish_fish_curry_instruction_7),
                            localeProvider.getString(R.string.fish_fish_curry_instruction_8),
                            localeProvider.getString(R.string.fish_fish_curry_instruction_9)
                        )
                    ),
                    isFavourite = false
                ),
                RecipeItem(
                    recipe = Recipe(
                        id = 14,
                        name = localeProvider.getString(R.string.fish_lemon_herb_fish_name),
                        cookingTimeInMin = 30,
                        shortDescription = localeProvider.getString(R.string.fish_lemon_herb_fish_description),
                        type = Type.FISH,
                        imageUrl = "https://images.unsplash.com/photo-1485921325833-c519f76c4927",
                        ingredients = listOf(
                            localeProvider.getString(R.string.fish_lemon_herb_fish_ingredient_1),
                            localeProvider.getString(R.string.fish_lemon_herb_fish_ingredient_2),
                            localeProvider.getString(R.string.fish_lemon_herb_fish_ingredient_3),
                            localeProvider.getString(R.string.fish_lemon_herb_fish_ingredient_4),
                            localeProvider.getString(R.string.fish_lemon_herb_fish_ingredient_5),
                            localeProvider.getString(R.string.fish_lemon_herb_fish_ingredient_6)
                        ),
                        instructions = listOf(
                            localeProvider.getString(R.string.fish_lemon_herb_fish_instruction_1),
                            localeProvider.getString(R.string.fish_lemon_herb_fish_instruction_2),
                            localeProvider.getString(R.string.fish_lemon_herb_fish_instruction_3),
                            localeProvider.getString(R.string.fish_lemon_herb_fish_instruction_4),
                            localeProvider.getString(R.string.fish_lemon_herb_fish_instruction_5)
                        )
                    ),
                    isFavourite = false
                ),
                RecipeItem(
                    recipe = Recipe(
                        id = 15,
                        name = localeProvider.getString(R.string.fish_garlic_butter_shrimp_name),
                        cookingTimeInMin = 20,
                        shortDescription = localeProvider.getString(R.string.fish_garlic_butter_shrimp_description),
                        type = Type.FISH,
                        imageUrl = "https://images.unsplash.com/photo-1565557623262-b51c2513a641",
                        ingredients = listOf(
                            localeProvider.getString(R.string.fish_garlic_butter_shrimp_ingredient_1),
                            localeProvider.getString(R.string.fish_garlic_butter_shrimp_ingredient_2),
                            localeProvider.getString(R.string.fish_garlic_butter_shrimp_ingredient_3),
                            localeProvider.getString(R.string.fish_garlic_butter_shrimp_ingredient_4),
                            localeProvider.getString(R.string.fish_garlic_butter_shrimp_ingredient_5)
                        ),
                        instructions = listOf(
                            localeProvider.getString(R.string.fish_garlic_butter_shrimp_instruction_1),
                            localeProvider.getString(R.string.fish_garlic_butter_shrimp_instruction_2),
                            localeProvider.getString(R.string.fish_garlic_butter_shrimp_instruction_3),
                            localeProvider.getString(R.string.fish_garlic_butter_shrimp_instruction_4)
                        )
                    ),
                    isFavourite = false
                ),
                RecipeItem(
                    recipe = Recipe(
                        id = 16,
                        name = localeProvider.getString(R.string.fish_seafood_pasta_name),
                        cookingTimeInMin = 35,
                        shortDescription = localeProvider.getString(R.string.fish_seafood_pasta_description),
                        type = Type.FISH,
                        imageUrl = "https://images.unsplash.com/photo-1563379926898-05f4575a45d8",
                        ingredients = listOf(
                            localeProvider.getString(R.string.fish_seafood_pasta_ingredient_1),
                            localeProvider.getString(R.string.fish_seafood_pasta_ingredient_2),
                            localeProvider.getString(R.string.fish_seafood_pasta_ingredient_3),
                            localeProvider.getString(R.string.fish_seafood_pasta_ingredient_4),
                            localeProvider.getString(R.string.fish_seafood_pasta_ingredient_5),
                            localeProvider.getString(R.string.fish_seafood_pasta_ingredient_6),
                            localeProvider.getString(R.string.fish_seafood_pasta_ingredient_7),
                            localeProvider.getString(R.string.fish_seafood_pasta_ingredient_8)
                        ),
                        instructions = listOf(
                            localeProvider.getString(R.string.fish_seafood_pasta_instruction_1),
                            localeProvider.getString(R.string.fish_seafood_pasta_instruction_2),
                            localeProvider.getString(R.string.fish_seafood_pasta_instruction_3),
                            localeProvider.getString(R.string.fish_seafood_pasta_instruction_4),
                            localeProvider.getString(R.string.fish_seafood_pasta_instruction_5),
                            localeProvider.getString(R.string.fish_seafood_pasta_instruction_6),
                            localeProvider.getString(R.string.fish_seafood_pasta_instruction_7)
                        )
                    ),
                    isFavourite = false
                ),
                RecipeItem(
                    recipe = Recipe(
                        id = 17,
                        name = localeProvider.getString(R.string.fish_miso_glazed_salmon_name),
                        cookingTimeInMin = 30,
                        shortDescription = localeProvider.getString(R.string.fish_miso_glazed_salmon_description),
                        type = Type.FISH,
                        imageUrl = "https://images.unsplash.com/photo-1467003909585-2f8a72700288",
                        ingredients = listOf(
                            localeProvider.getString(R.string.fish_miso_glazed_salmon_ingredient_1),
                            localeProvider.getString(R.string.fish_miso_glazed_salmon_ingredient_2),
                            localeProvider.getString(R.string.fish_miso_glazed_salmon_ingredient_3),
                            localeProvider.getString(R.string.fish_miso_glazed_salmon_ingredient_4),
                            localeProvider.getString(R.string.fish_miso_glazed_salmon_ingredient_5),
                            localeProvider.getString(R.string.fish_miso_glazed_salmon_ingredient_6),
                            localeProvider.getString(R.string.fish_miso_glazed_salmon_ingredient_7),
                            localeProvider.getString(R.string.fish_miso_glazed_salmon_ingredient_8)
                        ),
                        instructions = listOf(
                            localeProvider.getString(R.string.fish_miso_glazed_salmon_instruction_1),
                            localeProvider.getString(R.string.fish_miso_glazed_salmon_instruction_2),
                            localeProvider.getString(R.string.fish_miso_glazed_salmon_instruction_3),
                            localeProvider.getString(R.string.fish_miso_glazed_salmon_instruction_4),
                            localeProvider.getString(R.string.fish_miso_glazed_salmon_instruction_5)
                        )
                    ),
                    isFavourite = false
                ),
                RecipeItem(
                    recipe = Recipe(
                        id = 18,
                        name = localeProvider.getString(R.string.fish_mediterranean_seafood_stew_name),
                        cookingTimeInMin = 45,
                        shortDescription = localeProvider.getString(R.string.fish_mediterranean_seafood_stew_description),
                        type = Type.FISH,
                        imageUrl = "https://images.unsplash.com/photo-1589227365533-cee630bd59bd",
                        ingredients = listOf(
                            localeProvider.getString(R.string.fish_mediterranean_seafood_stew_ingredient_1),
                            localeProvider.getString(R.string.fish_mediterranean_seafood_stew_ingredient_2),
                            localeProvider.getString(R.string.fish_mediterranean_seafood_stew_ingredient_3),
                            localeProvider.getString(R.string.fish_mediterranean_seafood_stew_ingredient_4),
                            localeProvider.getString(R.string.fish_mediterranean_seafood_stew_ingredient_5),
                            localeProvider.getString(R.string.fish_mediterranean_seafood_stew_ingredient_6),
                            localeProvider.getString(R.string.fish_mediterranean_seafood_stew_ingredient_7)
                        ),
                        instructions = listOf(
                            localeProvider.getString(R.string.fish_mediterranean_seafood_stew_instruction_1),
                            localeProvider.getString(R.string.fish_mediterranean_seafood_stew_instruction_2),
                            localeProvider.getString(R.string.fish_mediterranean_seafood_stew_instruction_3),
                            localeProvider.getString(R.string.fish_mediterranean_seafood_stew_instruction_4),
                            localeProvider.getString(R.string.fish_mediterranean_seafood_stew_instruction_5),
                            localeProvider.getString(R.string.fish_mediterranean_seafood_stew_instruction_6)
                        )
                    ),
                    isFavourite = false
                ),
                RecipeItem(
                    recipe = Recipe(
                        id = 19,
                        name = localeProvider.getString(R.string.fish_lemon_garlic_tilapia_name),
                        cookingTimeInMin = 25,
                        shortDescription = localeProvider.getString(R.string.fish_lemon_garlic_tilapia_description),
                        type = Type.FISH,
                        imageUrl = "https://images.unsplash.com/photo-1501595091296-3aa970afb3ff",
                        ingredients = listOf(
                            localeProvider.getString(R.string.fish_lemon_garlic_tilapia_ingredient_1),
                            localeProvider.getString(R.string.fish_lemon_garlic_tilapia_ingredient_2),
                            localeProvider.getString(R.string.fish_lemon_garlic_tilapia_ingredient_3),
                            localeProvider.getString(R.string.fish_lemon_garlic_tilapia_ingredient_4),
                            localeProvider.getString(R.string.fish_lemon_garlic_tilapia_ingredient_5)
                        ),
                        instructions = listOf(
                            localeProvider.getString(R.string.fish_lemon_garlic_tilapia_instruction_1),
                            localeProvider.getString(R.string.fish_lemon_garlic_tilapia_instruction_2),
                            localeProvider.getString(R.string.fish_lemon_garlic_tilapia_instruction_3),
                            localeProvider.getString(R.string.fish_lemon_garlic_tilapia_instruction_4),
                            localeProvider.getString(R.string.fish_lemon_garlic_tilapia_instruction_5)
                        )
                    ),
                    isFavourite = false
                ),
                RecipeItem(
                    recipe = Recipe(
                        id = 20,
                        name = localeProvider.getString(R.string.fish_seared_ahi_tuna_name),
                        cookingTimeInMin = 15,
                        shortDescription = localeProvider.getString(R.string.fish_seared_ahi_tuna_description),
                        type = Type.FISH,
                        imageUrl = "https://images.unsplash.com/photo-1579631542720-3a87824fff86",
                        ingredients = listOf(
                            localeProvider.getString(R.string.fish_seared_ahi_tuna_ingredient_1),
                            localeProvider.getString(R.string.fish_seared_ahi_tuna_ingredient_2),
                            localeProvider.getString(R.string.fish_seared_ahi_tuna_ingredient_3),
                            localeProvider.getString(R.string.fish_seared_ahi_tuna_ingredient_4),
                            localeProvider.getString(R.string.fish_seared_ahi_tuna_ingredient_5),
                            localeProvider.getString(R.string.fish_seared_ahi_tuna_ingredient_6)
                        ),
                        instructions = listOf(
                            localeProvider.getString(R.string.fish_seared_ahi_tuna_instruction_1),
                            localeProvider.getString(R.string.fish_seared_ahi_tuna_instruction_2),
                            localeProvider.getString(R.string.fish_seared_ahi_tuna_instruction_3),
                            localeProvider.getString(R.string.fish_seared_ahi_tuna_instruction_4),
                            localeProvider.getString(R.string.fish_seared_ahi_tuna_instruction_5)
                        )
                    ),
                    isFavourite = false
                ),

                // MEAT RECIPES
                RecipeItem(
                    recipe = Recipe(
                        id = 21,
                        name = localeProvider.getString(R.string.meat_beef_steak_name),
                        cookingTimeInMin = 30,
                        shortDescription = localeProvider.getString(R.string.meat_beef_steak_description),
                        type = Type.MEAT,
                        imageUrl = "https://images.unsplash.com/photo-1558030006-450675393462",
                        ingredients = listOf(
                            localeProvider.getString(R.string.meat_beef_steak_ingredient_1),
                            localeProvider.getString(R.string.meat_beef_steak_ingredient_2),
                            localeProvider.getString(R.string.meat_beef_steak_ingredient_3),
                            localeProvider.getString(R.string.meat_beef_steak_ingredient_4),
                            localeProvider.getString(R.string.meat_beef_steak_ingredient_5),
                            localeProvider.getString(R.string.meat_beef_steak_ingredient_6)
                        ),
                        instructions = listOf(
                            localeProvider.getString(R.string.meat_beef_steak_instruction_1),
                            localeProvider.getString(R.string.meat_beef_steak_instruction_2),
                            localeProvider.getString(R.string.meat_beef_steak_instruction_3),
                            localeProvider.getString(R.string.meat_beef_steak_instruction_4),
                            localeProvider.getString(R.string.meat_beef_steak_instruction_5),
                            localeProvider.getString(R.string.meat_beef_steak_instruction_6)
                        )
                    ),
                    isFavourite = false
                ),
                RecipeItem(
                    recipe = Recipe(
                        id = 22,
                        name = localeProvider.getString(R.string.meat_chicken_parmesan_name),
                        cookingTimeInMin = 45,
                        shortDescription = localeProvider.getString(R.string.meat_chicken_parmesan_description),
                        type = Type.MEAT,
                        imageUrl = "https://images.unsplash.com/photo-1632778149955-e80f8ceca2e8",
                        ingredients = listOf(
                            localeProvider.getString(R.string.meat_chicken_parmesan_ingredient_1),
                            localeProvider.getString(R.string.meat_chicken_parmesan_ingredient_2),
                            localeProvider.getString(R.string.meat_chicken_parmesan_ingredient_3),
                            localeProvider.getString(R.string.meat_chicken_parmesan_ingredient_4),
                            localeProvider.getString(R.string.meat_chicken_parmesan_ingredient_5),
                            localeProvider.getString(R.string.meat_chicken_parmesan_ingredient_6),
                            localeProvider.getString(R.string.meat_chicken_parmesan_ingredient_7),
                            localeProvider.getString(R.string.meat_chicken_parmesan_ingredient_8)
                        ),
                        instructions = listOf(
                            localeProvider.getString(R.string.meat_chicken_parmesan_instruction_1),
                            localeProvider.getString(R.string.meat_chicken_parmesan_instruction_2),
                            localeProvider.getString(R.string.meat_chicken_parmesan_instruction_3),
                            localeProvider.getString(R.string.meat_chicken_parmesan_instruction_4),
                            localeProvider.getString(R.string.meat_chicken_parmesan_instruction_5),
                            localeProvider.getString(R.string.meat_chicken_parmesan_instruction_6),
                            localeProvider.getString(R.string.meat_chicken_parmesan_instruction_7),
                            localeProvider.getString(R.string.meat_chicken_parmesan_instruction_8)
                        )
                    ),
                    isFavourite = false
                ),
                RecipeItem(
                    recipe = Recipe(
                        id = 23,
                        name = localeProvider.getString(R.string.meat_pork_chops_name),
                        cookingTimeInMin = 35,
                        shortDescription = localeProvider.getString(R.string.meat_pork_chops_description),
                        type = Type.MEAT,
                        imageUrl = "https://images.unsplash.com/photo-1432139555190-58524dae6a55",
                        ingredients = listOf(
                            localeProvider.getString(R.string.meat_pork_chops_ingredient_1),
                            localeProvider.getString(R.string.meat_pork_chops_ingredient_2),
                            localeProvider.getString(R.string.meat_pork_chops_ingredient_3),
                            localeProvider.getString(R.string.meat_pork_chops_ingredient_4),
                            localeProvider.getString(R.string.meat_pork_chops_ingredient_5),
                            localeProvider.getString(R.string.meat_pork_chops_ingredient_6),
                            localeProvider.getString(R.string.meat_pork_chops_ingredient_7),
                            localeProvider.getString(R.string.meat_pork_chops_ingredient_8)
                        ),
                        instructions = listOf(
                            localeProvider.getString(R.string.meat_pork_chops_instruction_1),
                            localeProvider.getString(R.string.meat_pork_chops_instruction_2),
                            localeProvider.getString(R.string.meat_pork_chops_instruction_3),
                            localeProvider.getString(R.string.meat_pork_chops_instruction_4),
                            localeProvider.getString(R.string.meat_pork_chops_instruction_5),
                            localeProvider.getString(R.string.meat_pork_chops_instruction_6),
                            localeProvider.getString(R.string.meat_pork_chops_instruction_7)
                        )
                    ),
                    isFavourite = false
                ),
                RecipeItem(
                    recipe = Recipe(
                        id = 24,
                        name = localeProvider.getString(R.string.meat_beef_stroganoff_name),
                        cookingTimeInMin = 40,
                        shortDescription = localeProvider.getString(R.string.meat_beef_stroganoff_description),
                        type = Type.MEAT,
                        imageUrl = "https://images.unsplash.com/photo-1504973960431-1c467e159aa4",
                        ingredients = listOf(
                            localeProvider.getString(R.string.meat_beef_stroganoff_ingredient_1),
                            localeProvider.getString(R.string.meat_beef_stroganoff_ingredient_2),
                            localeProvider.getString(R.string.meat_beef_stroganoff_ingredient_3),
                            localeProvider.getString(R.string.meat_beef_stroganoff_ingredient_4),
                            localeProvider.getString(R.string.meat_beef_stroganoff_ingredient_5),
                            localeProvider.getString(R.string.meat_beef_stroganoff_ingredient_6),
                            localeProvider.getString(R.string.meat_beef_stroganoff_ingredient_7),
                            localeProvider.getString(R.string.meat_beef_stroganoff_ingredient_8),
                            localeProvider.getString(R.string.meat_beef_stroganoff_ingredient_9)
                        ),
                        instructions = listOf(
                            localeProvider.getString(R.string.meat_beef_stroganoff_instruction_1),
                            localeProvider.getString(R.string.meat_beef_stroganoff_instruction_2),
                            localeProvider.getString(R.string.meat_beef_stroganoff_instruction_3),
                            localeProvider.getString(R.string.meat_beef_stroganoff_instruction_4),
                            localeProvider.getString(R.string.meat_beef_stroganoff_instruction_5),
                            localeProvider.getString(R.string.meat_beef_stroganoff_instruction_6),
                            localeProvider.getString(R.string.meat_beef_stroganoff_instruction_7),
                            localeProvider.getString(R.string.meat_beef_stroganoff_instruction_8),
                            localeProvider.getString(R.string.meat_beef_stroganoff_instruction_9)
                        )
                    ),
                    isFavourite = false
                ),
                RecipeItem(
                    recipe = Recipe(
                        id = 25,
                        name = localeProvider.getString(R.string.meat_lamb_curry_name),
                        cookingTimeInMin = 60,
                        shortDescription = localeProvider.getString(R.string.meat_lamb_curry_description),
                        type = Type.MEAT,
                        imageUrl = "https://images.unsplash.com/photo-1574484284002-952d92456975",
                        ingredients = listOf(
                            localeProvider.getString(R.string.meat_lamb_curry_ingredient_1),
                            localeProvider.getString(R.string.meat_lamb_curry_ingredient_2),
                            localeProvider.getString(R.string.meat_lamb_curry_ingredient_3),
                            localeProvider.getString(R.string.meat_lamb_curry_ingredient_4),
                            localeProvider.getString(R.string.meat_lamb_curry_ingredient_5),
                            localeProvider.getString(R.string.meat_lamb_curry_ingredient_6),
                            localeProvider.getString(R.string.meat_lamb_curry_ingredient_7),
                            localeProvider.getString(R.string.meat_lamb_curry_ingredient_8),
                            localeProvider.getString(R.string.meat_lamb_curry_ingredient_9),
                            localeProvider.getString(R.string.meat_lamb_curry_ingredient_10),
                            localeProvider.getString(R.string.meat_lamb_curry_ingredient_11)
                        ),
                        instructions = listOf(
                            localeProvider.getString(R.string.meat_lamb_curry_instruction_1),
                            localeProvider.getString(R.string.meat_lamb_curry_instruction_2),
                            localeProvider.getString(R.string.meat_lamb_curry_instruction_3),
                            localeProvider.getString(R.string.meat_lamb_curry_instruction_4),
                            localeProvider.getString(R.string.meat_lamb_curry_instruction_5),
                            localeProvider.getString(R.string.meat_lamb_curry_instruction_6),
                            localeProvider.getString(R.string.meat_lamb_curry_instruction_7),
                            localeProvider.getString(R.string.meat_lamb_curry_instruction_8),
                            localeProvider.getString(R.string.meat_lamb_curry_instruction_9)
                        )
                    ),
                    isFavourite = false
                ),
                RecipeItem(
                    recipe = Recipe(
                        id = 26,
                        name = localeProvider.getString(R.string.meat_beef_burritos_name),
                        cookingTimeInMin = 25,
                        shortDescription = localeProvider.getString(R.string.meat_beef_burritos_description),
                        type = Type.MEAT,
                        imageUrl = "https://images.unsplash.com/photo-1584208632869-05fa2b2a5934",
                        ingredients = listOf(
                            localeProvider.getString(R.string.meat_beef_burritos_ingredient_1),
                            localeProvider.getString(R.string.meat_beef_burritos_ingredient_2),
                            localeProvider.getString(R.string.meat_beef_burritos_ingredient_3),
                            localeProvider.getString(R.string.meat_beef_burritos_ingredient_4),
                            localeProvider.getString(R.string.meat_beef_burritos_ingredient_5),
                            localeProvider.getString(R.string.meat_beef_burritos_ingredient_6),
                            localeProvider.getString(R.string.meat_beef_burritos_ingredient_7),
                            localeProvider.getString(R.string.meat_beef_burritos_ingredient_8),
                            localeProvider.getString(R.string.meat_beef_burritos_ingredient_9),
                            localeProvider.getString(R.string.meat_beef_burritos_ingredient_10),
                            localeProvider.getString(R.string.meat_beef_burritos_ingredient_11)
                        ),
                        instructions = listOf(
                            localeProvider.getString(R.string.meat_beef_burritos_instruction_1),
                            localeProvider.getString(R.string.meat_beef_burritos_instruction_2),
                            localeProvider.getString(R.string.meat_beef_burritos_instruction_3),
                            localeProvider.getString(R.string.meat_beef_burritos_instruction_4),
                            localeProvider.getString(R.string.meat_beef_burritos_instruction_5),
                            localeProvider.getString(R.string.meat_beef_burritos_instruction_6),
                            localeProvider.getString(R.string.meat_beef_burritos_instruction_7),
                            localeProvider.getString(R.string.meat_beef_burritos_instruction_8),
                            localeProvider.getString(R.string.meat_beef_burritos_instruction_9)
                        )
                    ),
                    isFavourite = false
                ),
                RecipeItem(
                    recipe = Recipe(
                        id = 27,
                        name = localeProvider.getString(R.string.meat_bbq_ribs_name),
                        cookingTimeInMin = 180,
                        shortDescription = localeProvider.getString(R.string.meat_bbq_ribs_description),
                        type = Type.MEAT,
                        imageUrl = "https://images.unsplash.com/photo-1544025162-d76694265947",
                        ingredients = listOf(
                            localeProvider.getString(R.string.meat_bbq_ribs_ingredient_1),
                            localeProvider.getString(R.string.meat_bbq_ribs_ingredient_2),
                            localeProvider.getString(R.string.meat_bbq_ribs_ingredient_3),
                            localeProvider.getString(R.string.meat_bbq_ribs_ingredient_4),
                            localeProvider.getString(R.string.meat_bbq_ribs_ingredient_5),
                            localeProvider.getString(R.string.meat_bbq_ribs_ingredient_6),
                            localeProvider.getString(R.string.meat_bbq_ribs_ingredient_7)
                        ),
                        instructions = listOf(
                            localeProvider.getString(R.string.meat_bbq_ribs_instruction_1),
                            localeProvider.getString(R.string.meat_bbq_ribs_instruction_2),
                            localeProvider.getString(R.string.meat_bbq_ribs_instruction_3),
                            localeProvider.getString(R.string.meat_bbq_ribs_instruction_4),
                            localeProvider.getString(R.string.meat_bbq_ribs_instruction_5),
                            localeProvider.getString(R.string.meat_bbq_ribs_instruction_6)
                        )
                    ),
                    isFavourite = false
                ),
                RecipeItem(
                    recipe = Recipe(
                        id = 28,
                        name = localeProvider.getString(R.string.meat_beef_burger_name),
                        cookingTimeInMin = 20,
                        shortDescription = localeProvider.getString(R.string.meat_beef_burger_description),
                        type = Type.MEAT,
                        imageUrl = "https://images.unsplash.com/photo-1568901346375-23c9450c58cd",
                        ingredients = listOf(
                            localeProvider.getString(R.string.meat_beef_burger_ingredient_1),
                            localeProvider.getString(R.string.meat_beef_burger_ingredient_2),
                            localeProvider.getString(R.string.meat_beef_burger_ingredient_3),
                            localeProvider.getString(R.string.meat_beef_burger_ingredient_4),
                            localeProvider.getString(R.string.meat_beef_burger_ingredient_5),
                            localeProvider.getString(R.string.meat_beef_burger_ingredient_6),
                            localeProvider.getString(R.string.meat_beef_burger_ingredient_7),
                            localeProvider.getString(R.string.meat_beef_burger_ingredient_8)
                        ),
                        instructions = listOf(
                            localeProvider.getString(R.string.meat_beef_burger_instruction_1),
                            localeProvider.getString(R.string.meat_beef_burger_instruction_2),
                            localeProvider.getString(R.string.meat_beef_burger_instruction_3),
                            localeProvider.getString(R.string.meat_beef_burger_instruction_4),
                            localeProvider.getString(R.string.meat_beef_burger_instruction_5),
                            localeProvider.getString(R.string.meat_beef_burger_instruction_6),
                            localeProvider.getString(R.string.meat_beef_burger_instruction_7)
                        )
                    ),
                    isFavourite = false
                ),
                RecipeItem(
                    recipe = Recipe(
                        id = 29,
                        name = localeProvider.getString(R.string.meat_roast_chicken_name),
                        cookingTimeInMin = 90,
                        shortDescription = localeProvider.getString(R.string.meat_roast_chicken_description),
                        type = Type.MEAT,
                        imageUrl = "https://images.unsplash.com/photo-1598103442097-8b74394b95c6",
                        ingredients = listOf(
                            localeProvider.getString(R.string.meat_roast_chicken_ingredient_1),
                            localeProvider.getString(R.string.meat_roast_chicken_ingredient_2),
                            localeProvider.getString(R.string.meat_roast_chicken_ingredient_3),
                            localeProvider.getString(R.string.meat_roast_chicken_ingredient_4),
                            localeProvider.getString(R.string.meat_roast_chicken_ingredient_5),
                            localeProvider.getString(R.string.meat_roast_chicken_ingredient_6)
                        ),
                        instructions = listOf(
                            localeProvider.getString(R.string.meat_roast_chicken_instruction_1),
                            localeProvider.getString(R.string.meat_roast_chicken_instruction_2),
                            localeProvider.getString(R.string.meat_roast_chicken_instruction_3),
                            localeProvider.getString(R.string.meat_roast_chicken_instruction_4),
                            localeProvider.getString(R.string.meat_roast_chicken_instruction_5),
                            localeProvider.getString(R.string.meat_roast_chicken_instruction_6),
                            localeProvider.getString(R.string.meat_roast_chicken_instruction_7)
                        )
                    ),
                    isFavourite = false
                ),
                RecipeItem(
                    recipe = Recipe(
                        id = 30,
                        name = localeProvider.getString(R.string.meat_beef_stir_fry_name),
                        cookingTimeInMin = 20,
                        shortDescription = localeProvider.getString(R.string.meat_beef_stir_fry_description),
                        type = Type.MEAT,
                        imageUrl = "https://images.unsplash.com/photo-1512058564366-18510be2db19",
                        ingredients = listOf(
                            localeProvider.getString(R.string.meat_beef_stir_fry_ingredient_1),
                            localeProvider.getString(R.string.meat_beef_stir_fry_ingredient_2),
                            localeProvider.getString(R.string.meat_beef_stir_fry_ingredient_3),
                            localeProvider.getString(R.string.meat_beef_stir_fry_ingredient_4),
                            localeProvider.getString(R.string.meat_beef_stir_fry_ingredient_5),
                            localeProvider.getString(R.string.meat_beef_stir_fry_ingredient_6),
                            localeProvider.getString(R.string.meat_beef_stir_fry_ingredient_7),
                            localeProvider.getString(R.string.meat_beef_stir_fry_ingredient_8),
                            localeProvider.getString(R.string.meat_beef_stir_fry_ingredient_9),
                            localeProvider.getString(R.string.meat_beef_stir_fry_ingredient_10),
                            localeProvider.getString(R.string.meat_beef_stir_fry_ingredient_11)
                        ),
                        instructions = listOf(
                            localeProvider.getString(R.string.meat_beef_stir_fry_instruction_1),
                            localeProvider.getString(R.string.meat_beef_stir_fry_instruction_2),
                            localeProvider.getString(R.string.meat_beef_stir_fry_instruction_3),
                            localeProvider.getString(R.string.meat_beef_stir_fry_instruction_4),
                            localeProvider.getString(R.string.meat_beef_stir_fry_instruction_5),
                            localeProvider.getString(R.string.meat_beef_stir_fry_instruction_6),
                            localeProvider.getString(R.string.meat_beef_stir_fry_instruction_7),
                            localeProvider.getString(R.string.meat_beef_stir_fry_instruction_8)
                        )
                    ),
                    isFavourite = false
                )
            )

    fun fetchRecipesInCurrentLocale(): List<RecipeItem> = recipes

    fun fetchRecipeInCurrentLocaleById(id: Int): RecipeItem =
        requireNotNull(recipes.find { it.recipe.id == id })
}