package com.droidcon.flavorshub.viewmodels

import com.droidcon.flavorshub.viewmodels.HomeViewModel.RecipeUi
import com.droidcon.flavorshub.viewmodels.model.Recipe
import com.droidcon.flavorshub.viewmodels.model.Type

class RecipesRepo {

    fun fetchRecipes(): List<RecipeUi> =
        listOf(
            // VEGAN RECIPES
            RecipeUi(
                recipe = Recipe(
                    id = 0,
                    name = "Vegan Buddha Bowl",
                    cookingTimeInMin = 25,
                    shortDescription = "Colorful bowl with quinoa, roasted vegetables, and tahini dressing",
                    type = Type.VEGAN,
                    imageUrl = "https://images.unsplash.com/photo-1512621776951-a57141f2eefd",
                ),
                isFavourite = false
            ),
            RecipeUi(
                recipe = Recipe(
                    id = 1,
                    name = "Mushroom Risotto",
                    cookingTimeInMin = 35,
                    shortDescription = "Creamy arborio rice with wild mushrooms and herbs",
                    type = Type.VEGAN,
                    imageUrl = "https://images.unsplash.com/photo-1476124369491-e7addf5db371",
                ),
                isFavourite = false
            ),
            RecipeUi(
                recipe = Recipe(
                    id = 2,
                    name = "Avocado Toast",
                    cookingTimeInMin = 10,
                    shortDescription = "Sourdough bread with smashed avocado, cherry tomatoes, and microgreens",
                    type = Type.VEGAN,
                    imageUrl = "https://images.unsplash.com/photo-1541519227354-08fa5d50c44d",
                ),
                isFavourite = false
            ),
            RecipeUi(
                recipe = Recipe(
                    id = 3,
                    name = "Vegetable Curry",
                    cookingTimeInMin = 30,
                    shortDescription = "Spicy coconut curry with mixed vegetables",
                    type = Type.VEGAN,
                    imageUrl = "https://images.unsplash.com/photo-1565557623262-b51c2513a641",
                ),
                isFavourite = false
            ),
            RecipeUi(
                recipe = Recipe(
                    id = 4,
                    name = "Stuffed Bell Peppers",
                    cookingTimeInMin = 45,
                    shortDescription = "Bell peppers filled with quinoa, black beans, and corn",
                    type = Type.VEGAN,
                    imageUrl = "https://images.unsplash.com/photo-1600335895229-6e75511892c8",
                ),
                isFavourite = false
            ),
            RecipeUi(
                recipe = Recipe(
                    id = 5,
                    name = "Sweet Potato Tacos",
                    cookingTimeInMin = 25,
                    shortDescription = "Corn tortillas with roasted sweet potatoes, black beans, and avocado",
                    type = Type.VEGAN,
                    imageUrl = "https://images.unsplash.com/photo-1552332386-f8dd00dc2f85",
                ),
                isFavourite = false
            ),
            RecipeUi(
                recipe = Recipe(
                    id = 6,
                    name = "Chickpea Masala",
                    cookingTimeInMin = 30,
                    shortDescription = "Spiced chickpeas in tomato curry sauce with fragrant rice",
                    type = Type.VEGAN,
                    imageUrl = "https://images.unsplash.com/photo-1511690743698-d9d85f2fbf38",
                ),
                isFavourite = false
            ),
            RecipeUi(
                recipe = Recipe(
                    id = 7,
                    name = "Lentil Soup",
                    cookingTimeInMin = 40,
                    shortDescription = "Hearty lentil soup with carrots, celery, and fresh herbs",
                    type = Type.VEGAN,
                    imageUrl = "https://images.unsplash.com/photo-1547592180-85f173990554",
                ),
                isFavourite = false
            ),
            RecipeUi(
                recipe = Recipe(
                    id = 8,
                    name = "Roasted Vegetable Salad",
                    cookingTimeInMin = 35,
                    shortDescription = "Mixed roasted vegetables with quinoa and balsamic glaze",
                    type = Type.VEGAN,
                    imageUrl = "https://images.unsplash.com/photo-1512621776951-a57141f2eefd",
                ),
                isFavourite = false
            ),
            RecipeUi(
                recipe = Recipe(
                    id = 9,
                    name = "Quinoa Salad",
                    cookingTimeInMin = 20,
                    shortDescription = "Fresh salad with quinoa, cucumber, tomatoes, and lemon dressing",
                    type = Type.VEGAN,
                    imageUrl = "https://images.unsplash.com/photo-1505576399279-565b52d4ac71",
                ),
                isFavourite = false
            ),

            // FISH RECIPES
            RecipeUi(
                recipe = Recipe(
                    id = 10,
                    name = "Grilled Salmon",
                    cookingTimeInMin = 20,
                    shortDescription = "Perfectly grilled salmon with lemon and herbs",
                    type = Type.FISH,
                    imageUrl = "https://images.unsplash.com/photo-1519708227418-c8fd9a32b7a2",
                ),
                isFavourite = false
            ),
            RecipeUi(
                recipe = Recipe(
                    id = 11,
                    name = "Tuna Poke Bowl",
                    cookingTimeInMin = 15,
                    shortDescription = "Raw tuna cubes with rice, avocado, and soy-sesame dressing",
                    type = Type.FISH,
                    imageUrl = "https://images.unsplash.com/photo-1546069901-ba9599a7e63c",
                ),
                isFavourite = false
            ),
            RecipeUi(
                recipe = Recipe(
                    id = 12,
                    name = "Fish Tacos",
                    cookingTimeInMin = 25,
                    shortDescription = "Battered white fish with cabbage slaw and lime crema in tortillas",
                    type = Type.FISH,
                    imageUrl = "https://images.unsplash.com/photo-1551504734-5ee1c4a1479b",
                ),
                isFavourite = false
            ),
            RecipeUi(
                recipe = Recipe(
                    id = 13,
                    name = "Fish Curry",
                    cookingTimeInMin = 35,
                    shortDescription = "Spicy fish curry with coconut milk and aromatic spices",
                    type = Type.FISH,
                    imageUrl = "https://images.unsplash.com/photo-1548943487-a2e4e43b4853",
                ),
                isFavourite = false
            ),
            RecipeUi(
                recipe = Recipe(
                    id = 14,
                    name = "Lemon Herb Fish",
                    cookingTimeInMin = 30,
                    shortDescription = "Tender white fish baked with lemon, garlic and fresh herbs",
                    type = Type.FISH,
                    imageUrl = "https://images.unsplash.com/photo-1485921325833-c519f76c4927",
                ),
                isFavourite = false
            ),
            RecipeUi(
                recipe = Recipe(
                    id = 15,
                    name = "Garlic Butter Shrimp",
                    cookingTimeInMin = 20,
                    shortDescription = "Succulent shrimp in garlic butter sauce",
                    type = Type.FISH,
                    imageUrl = "https://images.unsplash.com/photo-1565557623262-b51c2513a641",
                ),
                isFavourite = false
            ),
            RecipeUi(
                recipe = Recipe(
                    id = 16,
                    name = "Seafood Pasta",
                    cookingTimeInMin = 35,
                    shortDescription = "Pasta with mixed seafood in a light tomato sauce",
                    type = Type.FISH,
                    imageUrl = "https://images.unsplash.com/photo-1563379926898-05f4575a45d8",
                ),
                isFavourite = false
            ),
            RecipeUi(
                recipe = Recipe(
                    id = 17,
                    name = "Miso Glazed Salmon",
                    cookingTimeInMin = 30,
                    shortDescription = "Salmon fillets with sweet and savory miso glaze",
                    type = Type.FISH,
                    imageUrl = "https://images.unsplash.com/photo-1467003909585-2f8a72700288",
                ),
                isFavourite = false
            ),
            RecipeUi(
                recipe = Recipe(
                    id = 18,
                    name = "Mediterranean Seafood Stew",
                    cookingTimeInMin = 45,
                    shortDescription = "Hearty seafood stew with tomatoes, herbs, and white wine",
                    type = Type.FISH,
                    imageUrl = "https://images.unsplash.com/photo-1589227365533-cee630bd59bd",
                ),
                isFavourite = false
            ),
            RecipeUi(
                recipe = Recipe(
                    id = 19,
                    name = "Lemon Garlic Tilapia",
                    cookingTimeInMin = 25,
                    shortDescription = "Light and flaky tilapia with lemon and garlic",
                    type = Type.FISH,
                    imageUrl = "https://images.unsplash.com/photo-1501595091296-3aa970afb3ff",
                ),
                isFavourite = false
            ),
            RecipeUi(
                recipe = Recipe(
                    id = 20,
                    name = "Seared Ahi Tuna",
                    cookingTimeInMin = 15,
                    shortDescription = "Seared rare tuna with sesame crust and wasabi sauce",
                    type = Type.FISH,
                    imageUrl = "https://images.unsplash.com/photo-1579631542720-3a87824fff86",
                ),
                isFavourite = false

            ),

            // MEAT RECIPES
            RecipeUi(
                recipe = Recipe(
                    id = 21,
                    name = "Beef Steak",
                    cookingTimeInMin = 30,
                    shortDescription = "Juicy beef steak with roasted potatoes and vegetables",
                    type = Type.MEAT,
                    imageUrl = "https://images.unsplash.com/photo-1558030006-450675393462",
                ),
                isFavourite = false

            ),
            RecipeUi(
                recipe = Recipe(
                    id = 22,
                    name = "Chicken Parmesan",
                    cookingTimeInMin = 45,
                    shortDescription = "Breaded chicken cutlets with marinara sauce and melted mozzarella",
                    type = Type.MEAT,
                    imageUrl = "https://images.unsplash.com/photo-1632778149955-e80f8ceca2e8",
                ),
                isFavourite = false

            ),
            RecipeUi(
                recipe = Recipe(
                    id = 23,
                    name = "Pork Chops",
                    cookingTimeInMin = 35,
                    shortDescription = "Juicy pork chops with apple and sage sauce",
                    type = Type.MEAT,
                    imageUrl = "https://images.unsplash.com/photo-1432139555190-58524dae6a55",
                ),
                isFavourite = false
            ),
            RecipeUi(
                recipe = Recipe(
                    id = 24,
                    name = "Beef Stroganoff",
                    cookingTimeInMin = 40,
                    shortDescription = "Tender beef strips in creamy mushroom sauce over egg noodles",
                    type = Type.MEAT,
                    imageUrl = "https://images.unsplash.com/photo-1504973960431-1c467e159aa4",
                ),
                isFavourite = false
            ),
            RecipeUi(
                recipe = Recipe(
                    id = 25,
                    name = "Lamb Curry",
                    cookingTimeInMin = 60,
                    shortDescription = "Tender lamb pieces simmered in rich aromatic curry sauce",
                    type = Type.MEAT,
                    imageUrl = "https://images.unsplash.com/photo-1574484284002-952d92456975",
                ),
                isFavourite = false
            ),
            RecipeUi(
                recipe = Recipe(
                    id = 26,
                    name = "Beef Burritos",
                    cookingTimeInMin = 25,
                    shortDescription = "Flour tortillas with seasoned beef, rice, beans and cheese",
                    type = Type.MEAT,
                    imageUrl = "https://images.unsplash.com/photo-1584208632869-05fa2b2a5934",
                ),
                isFavourite = false
            ),
            RecipeUi(
                recipe = Recipe(
                    id = 27,
                    name = "BBQ Ribs",
                    cookingTimeInMin = 180,
                    shortDescription = "Slow-cooked pork ribs with smoky BBQ sauce glaze",
                    type = Type.MEAT,
                    imageUrl = "https://images.unsplash.com/photo-1544025162-d76694265947",
                ),
                isFavourite = false
            ),
            RecipeUi(
                recipe = Recipe(
                    id = 28,
                    name = "Beef Burger",
                    cookingTimeInMin = 20,
                    shortDescription = "Juicy beef patty on a brioche bun with all the fixings",
                    type = Type.MEAT,
                    imageUrl = "https://images.unsplash.com/photo-1568901346375-23c9450c58cd",
                ),
                isFavourite = false
            ),
            RecipeUi(
                recipe = Recipe(
                    id = 29,
                    name = "Roast Chicken",
                    cookingTimeInMin = 90,
                    shortDescription = "Whole roasted chicken with herbs, garlic, and lemon",
                    type = Type.MEAT,
                    imageUrl = "https://images.unsplash.com/photo-1598103442097-8b74394b95c6",
                ),
                isFavourite = false
            ),
            RecipeUi(
                recipe = Recipe(
                    id = 30,
                    name = "Beef Stir Fry",
                    cookingTimeInMin = 20,
                    shortDescription = "Thin sliced beef with vegetables in savory stir-fry sauce",
                    type = Type.MEAT,
                    imageUrl = "https://images.unsplash.com/photo-1512058564366-18510be2db19",
                ),
                isFavourite = false
            )
        )

}
