package com.droidcon.flavorshub.ui.viewmodels

import Recipe
import Type
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {
    // State for the UI
    var recipes by mutableStateOf<List<Recipe>>(emptyList())
        private set

    var selectedFilters by mutableStateOf<Set<Type>>(setOf())
        private set

    init {
        // Initialize with 30 sample recipes
        recipes = listOf(
            // VEGAN RECIPES
            Recipe(
                name = "Vegan Buddha Bowl",
                cookingTimeInMin = 25,
                shortDescription = "Colorful bowl with quinoa, roasted vegetables, and tahini dressing",
                type = Type.VEGAN,
                imageUrl = "https://images.unsplash.com/photo-1512621776951-a57141f2eefd",
                isFavourite = false
            ),
            Recipe(
                name = "Mushroom Risotto",
                cookingTimeInMin = 35,
                shortDescription = "Creamy arborio rice with wild mushrooms and herbs",
                type = Type.VEGAN,
                imageUrl = "https://images.unsplash.com/photo-1476124369491-e7addf5db371",
                isFavourite = true
            ),
            Recipe(
                name = "Avocado Toast",
                cookingTimeInMin = 10,
                shortDescription = "Sourdough bread with smashed avocado, cherry tomatoes, and microgreens",
                type = Type.VEGAN,
                imageUrl = "https://images.unsplash.com/photo-1541519227354-08fa5d50c44d",
                isFavourite = false
            ),
            Recipe(
                name = "Vegetable Curry",
                cookingTimeInMin = 30,
                shortDescription = "Spicy coconut curry with mixed vegetables",
                type = Type.VEGAN,
                imageUrl = "https://images.unsplash.com/photo-1565557623262-b51c2513a641",
                isFavourite = false
            ),
            Recipe(
                name = "Stuffed Bell Peppers",
                cookingTimeInMin = 45,
                shortDescription = "Bell peppers filled with quinoa, black beans, and corn",
                type = Type.VEGAN,
                imageUrl = "https://images.unsplash.com/photo-1600335895229-6e75511892c8",
                isFavourite = true
            ),
            Recipe(
                name = "Sweet Potato Tacos",
                cookingTimeInMin = 25,
                shortDescription = "Corn tortillas with roasted sweet potatoes, black beans, and avocado",
                type = Type.VEGAN,
                imageUrl = "https://images.unsplash.com/photo-1552332386-f8dd00dc2f85",
                isFavourite = false
            ),
            Recipe(
                name = "Chickpea Masala",
                cookingTimeInMin = 30,
                shortDescription = "Spiced chickpeas in tomato curry sauce with fragrant rice",
                type = Type.VEGAN,
                imageUrl = "https://images.unsplash.com/photo-1511690743698-d9d85f2fbf38",
                isFavourite = true
            ),
            Recipe(
                name = "Lentil Soup",
                cookingTimeInMin = 40,
                shortDescription = "Hearty lentil soup with carrots, celery, and fresh herbs",
                type = Type.VEGAN,
                imageUrl = "https://images.unsplash.com/photo-1547592180-85f173990554",
                isFavourite = false
            ),
            Recipe(
                name = "Roasted Vegetable Salad",
                cookingTimeInMin = 35,
                shortDescription = "Mixed roasted vegetables with quinoa and balsamic glaze",
                type = Type.VEGAN,
                imageUrl = "https://images.unsplash.com/photo-1512621776951-a57141f2eefd",
                isFavourite = false
            ),
            Recipe(
                name = "Quinoa Salad",
                cookingTimeInMin = 20,
                shortDescription = "Fresh salad with quinoa, cucumber, tomatoes, and lemon dressing",
                type = Type.VEGAN,
                imageUrl = "https://images.unsplash.com/photo-1505576399279-565b52d4ac71",
                isFavourite = true
            ),
            
            // FISH RECIPES
            Recipe(
                name = "Grilled Salmon",
                cookingTimeInMin = 20,
                shortDescription = "Perfectly grilled salmon with lemon and herbs",
                type = Type.FISH,
                imageUrl = "https://images.unsplash.com/photo-1519708227418-c8fd9a32b7a2",
                isFavourite = true
            ),
            Recipe(
                name = "Tuna Poke Bowl",
                cookingTimeInMin = 15,
                shortDescription = "Raw tuna cubes with rice, avocado, and soy-sesame dressing",
                type = Type.FISH,
                imageUrl = "https://images.unsplash.com/photo-1546069901-ba9599a7e63c",
                isFavourite = false
            ),
            Recipe(
                name = "Fish Tacos",
                cookingTimeInMin = 25,
                shortDescription = "Battered white fish with cabbage slaw and lime crema in tortillas",
                type = Type.FISH,
                imageUrl = "https://images.unsplash.com/photo-1551504734-5ee1c4a1479b",
                isFavourite = true
            ),
            Recipe(
                name = "Lemon Herb Fish",
                cookingTimeInMin = 30,
                shortDescription = "Tender white fish baked with lemon, garlic and fresh herbs",
                type = Type.FISH,
                imageUrl = "https://images.unsplash.com/photo-1485921325833-c519f76c4927",
                isFavourite = false
            ),
            Recipe(
                name = "Garlic Butter Shrimp",
                cookingTimeInMin = 20,
                shortDescription = "Succulent shrimp in garlic butter sauce",
                type = Type.FISH,
                imageUrl = "https://images.unsplash.com/photo-1565557623262-b51c2513a641",
                isFavourite = false
            ),
            Recipe(
                name = "Seafood Pasta",
                cookingTimeInMin = 35,
                shortDescription = "Pasta with mixed seafood in a light tomato sauce",
                type = Type.FISH,
                imageUrl = "https://images.unsplash.com/photo-1563379926898-05f4575a45d8",
                isFavourite = true
            ),
            Recipe(
                name = "Miso Glazed Salmon",
                cookingTimeInMin = 30,
                shortDescription = "Salmon fillets with sweet and savory miso glaze",
                type = Type.FISH,
                imageUrl = "https://images.unsplash.com/photo-1467003909585-2f8a72700288",
                isFavourite = false
            ),
            Recipe(
                name = "Mediterranean Seafood Stew",
                cookingTimeInMin = 45,
                shortDescription = "Hearty seafood stew with tomatoes, herbs, and white wine",
                type = Type.FISH,
                imageUrl = "https://images.unsplash.com/photo-1589227365533-cee630bd59bd",
                isFavourite = true
            ),
            Recipe(
                name = "Lemon Garlic Tilapia",
                cookingTimeInMin = 25,
                shortDescription = "Light and flaky tilapia with lemon and garlic",
                type = Type.FISH,
                imageUrl = "https://images.unsplash.com/photo-1501595091296-3aa970afb3ff",
                isFavourite = false
            ),
            Recipe(
                name = "Seared Ahi Tuna",
                cookingTimeInMin = 15,
                shortDescription = "Seared rare tuna with sesame crust and wasabi sauce",
                type = Type.FISH,
                imageUrl = "https://images.unsplash.com/photo-1579631542720-3a87824fff86",
                isFavourite = false
            ),
            
            // MEAT RECIPES
            Recipe(
                name = "Beef Steak",
                cookingTimeInMin = 30,
                shortDescription = "Juicy beef steak with roasted potatoes and vegetables",
                type = Type.MEAT,
                imageUrl = "https://images.unsplash.com/photo-1558030006-450675393462",
                isFavourite = false
            ),
            Recipe(
                name = "Chicken Parmesan",
                cookingTimeInMin = 45,
                shortDescription = "Breaded chicken cutlets with marinara sauce and melted mozzarella",
                type = Type.MEAT,
                imageUrl = "https://images.unsplash.com/photo-1632778149955-e80f8ceca2e8",
                isFavourite = true
            ),
            Recipe(
                name = "Pork Chops",
                cookingTimeInMin = 35,
                shortDescription = "Juicy pork chops with apple and sage sauce",
                type = Type.MEAT,
                imageUrl = "https://images.unsplash.com/photo-1432139555190-58524dae6a55",
                isFavourite = false
            ),
            Recipe(
                name = "Beef Stroganoff",
                cookingTimeInMin = 40,
                shortDescription = "Tender beef strips in creamy mushroom sauce over egg noodles",
                type = Type.MEAT,
                imageUrl = "https://images.unsplash.com/photo-1504973960431-1c467e159aa4",
                isFavourite = false
            ),
            Recipe(
                name = "Lamb Curry",
                cookingTimeInMin = 60,
                shortDescription = "Tender lamb pieces simmered in rich aromatic curry sauce",
                type = Type.MEAT,
                imageUrl = "https://images.unsplash.com/photo-1574484284002-952d92456975",
                isFavourite = true
            ),
            Recipe(
                name = "Beef Burritos",
                cookingTimeInMin = 25,
                shortDescription = "Flour tortillas with seasoned beef, rice, beans and cheese",
                type = Type.MEAT,
                imageUrl = "https://images.unsplash.com/photo-1584208632869-05fa2b2a5934",
                isFavourite = false
            ),
            Recipe(
                name = "BBQ Ribs",
                cookingTimeInMin = 180,
                shortDescription = "Slow-cooked pork ribs with smoky BBQ sauce glaze",
                type = Type.MEAT,
                imageUrl = "https://images.unsplash.com/photo-1544025162-d76694265947",
                isFavourite = true
            ),
            Recipe(
                name = "Beef Burger",
                cookingTimeInMin = 20,
                shortDescription = "Juicy beef patty on a brioche bun with all the fixings",
                type = Type.MEAT,
                imageUrl = "https://images.unsplash.com/photo-1568901346375-23c9450c58cd",
                isFavourite = false
            ),
            Recipe(
                name = "Roast Chicken",
                cookingTimeInMin = 90,
                shortDescription = "Whole roasted chicken with herbs, garlic, and lemon",
                type = Type.MEAT,
                imageUrl = "https://images.unsplash.com/photo-1598103442097-8b74394b95c6",
                isFavourite = true
            ),
            Recipe(
                name = "Beef Stir Fry",
                cookingTimeInMin = 20,
                shortDescription = "Thin sliced beef with vegetables in savory stir-fry sauce",
                type = Type.MEAT,
                imageUrl = "https://images.unsplash.com/photo-1512058564366-18510be2db19",
                isFavourite = false
            )
        )
    }

    fun toggleFilter(type: Type) {
        selectedFilters = if (selectedFilters.contains(type)) {
            selectedFilters - type
        } else {
            selectedFilters + type
        }
    }

    fun toggleFavorite(recipe: Recipe) {
        recipes = recipes.map {
            if (it == recipe) it.copy(isFavourite = !it.isFavourite) else it
        }
    }

    val filteredRecipes get() =
        if (selectedFilters.isEmpty()) recipes
        else recipes.filter { selectedFilters.contains(it.type) }
}