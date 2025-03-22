package com.droidcon.flavorshub.viewmodels

import com.droidcon.flavorshub.model.Recipe
import com.droidcon.flavorshub.model.RecipeItem
import com.droidcon.flavorshub.model.Type

class RecipesRepo {

    private val recipes: List<RecipeItem> =
        listOf(
            // VEGAN RECIPES
            RecipeItem(
                recipe = Recipe(
                    id = 0,
                    name = "Vegan Buddha Bowl",
                    cookingTimeInMin = 25,
                    shortDescription = "Colorful bowl with quinoa, roasted vegetables, and tahini dressing",
                    type = Type.VEGAN,
                    imageUrl = "https://images.unsplash.com/photo-1512621776951-a57141f2eefd",
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
                isFavourite = false
            ),
            RecipeItem(
                recipe = Recipe(
                    id = 1,
                    name = "Mushroom Risotto",
                    cookingTimeInMin = 35,
                    shortDescription = "Creamy arborio rice with wild mushrooms and herbs",
                    type = Type.VEGAN,
                    imageUrl = "https://images.unsplash.com/photo-1476124369491-e7addf5db371",
                    ingredients = listOf(
                        "1 1/2 cups arborio rice",
                        "4 cups vegetable broth, warmed",
                        "8 oz mixed mushrooms, sliced",
                        "1 onion, finely chopped",
                        "3 cloves garlic, minced",
                        "1/2 cup dry white wine (optional)",
                        "2 tbsp olive oil",
                        "2 tbsp nutritional yeast",
                        "1 tbsp fresh thyme leaves",
                        "Salt and pepper to taste"
                    ),
                    instructions = listOf(
                        "1. Heat olive oil in a large pan over medium heat",
                        "2. Sauté onions until translucent, about 5 minutes",
                        "3. Add mushrooms and garlic, cook until mushrooms release their moisture",
                        "4. Add arborio rice and stir for 2 minutes until translucent at edges",
                        "5. Pour in wine if using and cook until absorbed",
                        "6. Add warm broth 1/2 cup at a time, stirring frequently until absorbed",
                        "7. Continue adding broth until rice is creamy and al dente, about 25 minutes",
                        "8. Stir in nutritional yeast, thyme, salt and pepper",
                        "9. Let stand for 5 minutes before serving"
                    )
                ),
                isFavourite = false
            ),
            RecipeItem(
                recipe = Recipe(
                    id = 2,
                    name = "Avocado Toast",
                    cookingTimeInMin = 10,
                    shortDescription = "Sourdough bread with smashed avocado, cherry tomatoes, and microgreens",
                    type = Type.VEGAN,
                    imageUrl = "https://images.unsplash.com/photo-1546069901-ba9599a7e63c",
                    ingredients = listOf(
                        "2 slices sourdough bread",
                        "1 ripe avocado, mashed",
                        "1/2 cup cherry tomatoes, halved",
                        "1/4 cup microgreens",
                        "Salt and pepper to taste",
                        "1 tbsp olive oil"
                    ),
                    instructions = listOf(
                        "1. Toast bread until lightly browned",
                        "2. Spread mashed avocado on toast",
                        "3. Top with cherry tomatoes and microgreens",
                        "4. Season with salt and pepper to taste",
                        "5. Drizzle with olive oil and serve"
                    )
                ),
                isFavourite = false
            ),
            RecipeItem(
                recipe = Recipe(
                    id = 3,
                    name = "Vegetable Curry",
                    cookingTimeInMin = 30,
                    shortDescription = "Spicy coconut curry with mixed vegetables",
                    type = Type.VEGAN,
                    imageUrl = "https://images.unsplash.com/photo-1565557623262-b51c2513a641",
                    ingredients = listOf(
                        "2 medium onions, diced",
                        "2 medium carrots, peeled and diced",
                        "2 medium potatoes, peeled and diced",
                        "1 large red bell pepper, diced",
                        "2 cloves garlic, minced",
                        "1 tablespoon grated fresh ginger",
                        "1 tablespoon curry powder",
                        "1 teaspoon ground cumin",
                        "1/2 teaspoon ground turmeric",
                        "1/2 teaspoon cayenne pepper",
                        "1 can coconut milk",
                        "Salt and pepper to taste"
                    ),
                    instructions = listOf(
                        "1. Heat oil in a large pan over medium heat",
                        "2. Add onions and cook until they are translucent",
                        "3. Add carrots, potatoes, and bell pepper, and cook for a few minutes",
                        "4. Add garlic, ginger, curry powder, cumin, turmeric, and cayenne pepper, and cook for 1 minute",
                        "5. Pour in coconut milk and bring to a simmer",
                        "6. Reduce heat to low and let cook for 20-25 minutes or until the vegetables are tender",
                        "7. Season with salt and pepper to taste",
                        "8. Serve hot over rice or with naan bread"
                    )
                ),
                isFavourite = false
            ),
            RecipeItem(
                recipe = Recipe(
                    id = 4,
                    name = "Stuffed Bell Peppers",
                    cookingTimeInMin = 45,
                    shortDescription = "Bell peppers filled with quinoa, black beans, and corn",
                    type = Type.VEGAN,
                    imageUrl = "https://images.unsplash.com/photo-1600335895229-6e75511892c8",
                    ingredients = listOf(
                        "4 large bell peppers, any color",
                        "1 cup quinoa, rinsed",
                        "2 cups water or vegetable broth",
                        "1 can black beans, drained and rinsed",
                        "1 cup frozen corn kernels",
                        "1 small onion, diced",
                        "1 small zucchini, diced",
                        "1 small red bell pepper, diced",
                        "2 cloves garlic, minced",
                        "1 tablespoon olive oil",
                        "1 teaspoon cumin",
                        "1 teaspoon smoked paprika",
                        "Salt and pepper to taste"
                    ),
                    instructions = listOf(
                        "1. Preheat oven to 375°F (190°C)",
                        "2. Cut off the tops of the bell peppers and remove the seeds and membranes",
                        "3. In a medium saucepan, bring the quinoa and water or broth to a boil",
                        "4. Reduce the heat to low, cover, and simmer until the quinoa is tender and the water is absorbed",
                        "5. In a large skillet, heat the olive oil over medium heat",
                        "6. Add the onion, zucchini, and red bell pepper, and cook until the vegetables are tender",
                        "7. Add the garlic, cumin, and smoked paprika, and cook for 1 minute",
                        "8. Stir in the cooked quinoa, black beans, and corn kernels",
                        "9. Stuff each bell pepper with the quinoa mixture and place them in a baking dish",
                        "10. Cover the baking dish with aluminum foil and bake for 25 minutes",
                        "11. Remove the foil and bake for an additional 10-15 minutes, or until the bell peppers are tender"
                    )
                ),
                isFavourite = false
            ),
            RecipeItem(
                recipe = Recipe(
                    id = 5,
                    name = "Sweet Potato Tacos",
                    cookingTimeInMin = 25,
                    shortDescription = "Corn tortillas with roasted sweet potatoes, black beans, and avocado",
                    type = Type.VEGAN,
                    imageUrl = "https://images.unsplash.com/photo-1552332386-f8dd00dc2f85",
                    ingredients = listOf(
                        "2 large sweet potatoes, peeled and diced",
                        "1/4 cup olive oil",
                        "1 small onion, diced",
                        "1 small red bell pepper, diced",
                        "2 cloves garlic, minced",
                        "1 can black beans, drained and rinsed",
                        "1 avocado, diced",
                        "8-10 corn tortillas",
                        "Salt and pepper to taste",
                        "Optional toppings: salsa, shredded lettuce, diced tomatoes, shredded vegan cheese"
                    ),
                    instructions = listOf(
                        "1. Preheat oven to 400°F (200°C)",
                        "2. Toss the sweet potatoes with 2 tablespoons of the olive oil, salt, and pepper on a baking sheet",
                        "3. Roast the sweet potatoes for 20-25 minutes, or until they are tender",
                        "4. In a large skillet, heat the remaining 2 tablespoons of olive oil over medium heat",
                        "5. Add the onion and red bell pepper, and cook until they are tender",
                        "6. Add the garlic and cook for 1 minute",
                        "7. Add the black beans and cook for 2-3 minutes, or until they are heated through",
                        "8. Warm the tortillas by wrapping them in a damp paper towel and microwaving for 20-30 seconds",
                        "9. Assemble the tacos by spooning the sweet potato and black bean mixture onto a tortilla, and topping with avocado and any desired toppings"
                    )
                ),
                isFavourite = false
            ),
            RecipeItem(
                recipe = Recipe(
                    id = 6,
                    name = "Chickpea Masala",
                    cookingTimeInMin = 30,
                    shortDescription = "Spiced chickpeas in tomato curry sauce with fragrant rice",
                    type = Type.VEGAN,
                    imageUrl = "https://images.unsplash.com/photo-1511690743698-d9d85f2fbf38",
                    ingredients = listOf(
                        "1 can chickpeas, drained and rinsed",
                        "2 medium onions, diced",
                        "2 medium tomatoes, diced",
                        "2 cloves garlic, minced",
                        "1 tablespoon grated fresh ginger",
                        "1 tablespoon curry powder",
                        "1 teaspoon ground cumin",
                        "1/2 teaspoon ground turmeric",
                        "1/2 teaspoon cayenne pepper",
                        "1 can coconut milk",
                        "Salt and pepper to taste",
                        "Fresh cilantro, chopped (optional)"
                    ),
                    instructions = listOf(
                        "1. Heat oil in a large pan over medium heat",
                        "2. Add onions and cook until they are translucent",
                        "3. Add garlic and ginger, and cook for 1 minute",
                        "4. Add curry powder, cumin, turmeric, and cayenne pepper, and cook for 1 minute",
                        "5. Add tomatoes and cook for a few minutes",
                        "6. Add chickpeas and coconut milk, and bring to a simmer",
                        "7. Reduce heat to low and let cook for 20-25 minutes or until the sauce has thickened",
                        "8. Season with salt and pepper to taste",
                        "9. Serve hot over rice, garnished with chopped cilantro if desired"
                    )
                ),
                isFavourite = false
            ),
            RecipeItem(
                recipe = Recipe(
                    id = 7,
                    name = "Lentil Soup",
                    cookingTimeInMin = 40,
                    shortDescription = "Hearty lentil soup with carrots, celery, and fresh herbs",
                    type = Type.VEGAN,
                    imageUrl = "https://images.unsplash.com/photo-1547592180-85f173990554",
                    ingredients = listOf(
                        "1 cup dried green or brown lentils, rinsed",
                        "4 cups vegetable broth",
                        "1 medium onion, diced",
                        "2 medium carrots, peeled and diced",
                        "2 medium celery stalks, diced",
                        "2 cloves garlic, minced",
                        "1 can diced tomatoes",
                        "1 teaspoon dried thyme",
                        "1 teaspoon dried rosemary",
                        "Salt and pepper to taste"
                    ),
                    instructions = listOf(
                        "1. In a large pot, sauté the onion, carrots, and celery in a little bit of oil until they are tender",
                        "2. Add the garlic and cook for 1 minute",
                        "3. Add the lentils, vegetable broth, diced tomatoes, thyme, and rosemary",
                        "4. Bring to a boil, then reduce the heat to low and let simmer for 30-40 minutes or until the lentils are tender",
                        "5. Season with salt and pepper to taste",
                        "6. Serve hot, garnished with fresh herbs if desired"
                    )
                ),
                isFavourite = false
            ),
            RecipeItem(
                recipe = Recipe(
                    id = 8,
                    name = "Roasted Vegetable Salad",
                    cookingTimeInMin = 35,
                    shortDescription = "Mixed roasted vegetables with quinoa and balsamic glaze",
                    type = Type.VEGAN,
                    imageUrl = "https://images.unsplash.com/photo-1512621776951-a57141f2eefd",
                    ingredients = listOf(
                        "2 cups mixed vegetables (such as broccoli, carrots, bell peppers, and zucchini)",
                        "2 tablespoons olive oil",
                        "Salt and pepper to taste",
                        "1 cup quinoa, rinsed",
                        "2 cups water or vegetable broth",
                        "1/4 cup balsamic glaze",
                        "1/4 cup chopped fresh parsley"
                    ),
                    instructions = listOf(
                        "1. Preheat oven to 425°F (220°C)",
                        "2. Toss the vegetables with 1 tablespoon of the olive oil, salt, and pepper on a baking sheet",
                        "3. Roast the vegetables for 20-25 minutes, or until they are tender",
                        "4. In a medium saucepan, bring the quinoa and water or broth to a boil",
                        "5. Reduce the heat to low, cover, and simmer until the quinoa is tender and the water is absorbed",
                        "6. In a large bowl, combine the roasted vegetables, cooked quinoa, and balsamic glaze",
                        "7. Toss to combine, and top with chopped parsley"
                    )
                ),
                isFavourite = false
            ),
            RecipeItem(
                recipe = Recipe(
                    id = 9,
                    name = "Quinoa Salad",
                    cookingTimeInMin = 20,
                    shortDescription = "Fresh salad with quinoa, cucumber, tomatoes, and lemon dressing",
                    type = Type.VEGAN,
                    imageUrl = "https://images.unsplash.com/photo-1505576399279-565b52d4ac71",
                    ingredients = listOf(
                        "1 cup quinoa, rinsed",
                        "2 cups water or vegetable broth",
                        "1 medium cucumber, diced",
                        "1 medium tomato, diced",
                        "1/4 cup chopped fresh parsley",
                        "2 tablespoons lemon juice",
                        "1 tablespoon olive oil",
                        "Salt and pepper to taste"
                    ),
                    instructions = listOf(
                        "1. In a medium saucepan, bring the quinoa and water or broth to a boil",
                        "2. Reduce the heat to low, cover, and simmer until the quinoa is tender and the water is absorbed",
                        "3. In a large bowl, combine the cooked quinoa, cucumber, tomato, and parsley",
                        "4. In a small bowl, whisk together the lemon juice and olive oil",
                        "5. Pour the dressing over the quinoa mixture, and toss to combine",
                        "6. Season with salt and pepper to taste"
                    )
                ),
                isFavourite = false
            ),

            // FISH RECIPES
            RecipeItem(
                recipe = Recipe(
                    id = 10,
                    name = "Grilled Salmon",
                    cookingTimeInMin = 20,
                    shortDescription = "Perfectly grilled salmon with lemon and herbs",
                    type = Type.FISH,
                    imageUrl = "https://images.unsplash.com/photo-1519708227418-c8fd9a32b7a2",
                    ingredients = listOf(
                        "4 salmon fillets (6 ounces each)",
                        "1/4 cup olive oil",
                        "2 lemons, sliced",
                        "1/4 cup chopped fresh parsley",
                        "2 cloves garlic, minced",
                        "Salt and pepper to taste"
                    ),
                    instructions = listOf(
                        "1. Preheat grill to medium-high heat",
                        "2. In a small bowl, mix together the olive oil, lemon slices, parsley, and garlic",
                        "3. Brush the mixture on both sides of the salmon fillets",
                        "4. Season with salt and pepper to taste",
                        "5. Grill the salmon for 4-6 minutes per side, or until it is cooked through"
                    )
                ),
                isFavourite = false
            ),
            RecipeItem(
                recipe = Recipe(
                    id = 11,
                    name = "Tuna Poke Bowl",
                    cookingTimeInMin = 15,
                    shortDescription = "Raw tuna cubes with rice, avocado, and soy-sesame dressing",
                    type = Type.FISH,
                    imageUrl = "https://images.unsplash.com/photo-1546069901-ba9599a7e63c",
                    ingredients = listOf(
                        "1 pound sushi-grade tuna, cut into small cubes",
                        "1 cup cooked white rice",
                        "1 avocado, diced",
                        "1/4 cup soy sauce",
                        "1/4 cup sesame oil",
                        "2 cloves garlic, minced",
                        "1 tablespoon grated fresh ginger",
                        "Salt and pepper to taste"
                    ),
                    instructions = listOf(
                        "1. In a large bowl, combine the tuna, rice, and avocado",
                        "2. In a small bowl, whisk together the soy sauce, sesame oil, garlic, and ginger",
                        "3. Pour the dressing over the tuna mixture, and toss to combine",
                        "4. Season with salt and pepper to taste",
                        "5. Serve immediately"
                    )
                ),
                isFavourite = false
            ),
            RecipeItem(
                recipe = Recipe(
                    id = 12,
                    name = "Fish Tacos",
                    cookingTimeInMin = 25,
                    shortDescription = "Battered white fish with cabbage slaw and lime crema in tortillas",
                    type = Type.FISH,
                    imageUrl = "https://images.unsplash.com/photo-1551504734-5ee1c4a1479b",
                    ingredients = listOf(
                        "1 pound white fish (such as cod or tilapia), cut into small pieces",
                        "1 cup all-purpose flour",
                        "1/2 cup cornstarch",
                        "1/2 cup ppray",
                        "1/4 cup lime juice",
                        "1/4 cup chopped fresh cilantro",
                        "1/2 cup cabbage slaw (such as red cabbage, carrots, and onions)",
                        "4 corn tortillas",
                        "Salt and pepper to taste"
                    ),
                    instructions = listOf(
                        "1. In a large bowl, combine the flour, cornstarch, and a pinch of salt",
                        "2. Dip the fish pieces in the flour mixture, shaking off excess",
                        "3. Dip the floured fish in the beaten eggs, and then coat in the ppray",
                        "4. Heat about 1/2 inch of oil in a large skillet over medium-high heat",
                        "5. Fry the fish until golden brown and cooked through",
                        "6. Warm the tortillas by wrapping them in a damp paper towel and microwaving for 20-30 seconds",
                        "7. Assemble the tacos by placing a piece of fish on a tortilla, and topping with cabbage slaw, lime crema, and cilantro"
                    )
                ),
                isFavourite = false
            ),
            RecipeItem(
                recipe = Recipe(
                    id = 13,
                    name = "Fish Curry",
                    cookingTimeInMin = 35,
                    shortDescription = "Spicy fish curry with coconut milk and aromatic spices",
                    type = Type.FISH,
                    imageUrl = "https://images.unsplash.com/photo-1548943487-a2e4e43b4853",
                    ingredients = listOf(
                        "1 pound white fish (such as cod or tilapia), cut into small pieces",
                        "2 medium onions, diced",
                        "2 medium tomatoes, diced",
                        "2 cloves garlic, minced",
                        "1 tablespoon grated fresh ginger",
                        "1 tablespoon curry powder",
                        "1 teaspoon ground cumin",
                        "1/2 teaspoon ground turmeric",
                        "1/2 teaspoon cayenne pepper",
                        "1 can coconut milk",
                        "Salt and pepper to taste"
                    ),
                    instructions = listOf(
                        "1. Heat oil in a large pan over medium heat",
                        "2. Add onions and cook until they are translucent",
                        "3. Add garlic and ginger, and cook for 1 minute",
                        "4. Add curry powder, cumin, turmeric, and cayenne pepper, and cook for 1 minute",
                        "5. Add tomatoes and cook for a few minutes",
                        "6. Add fish and coconut milk, and bring to a simmer",
                        "7. Reduce heat to low and let cook for 10-15 minutes or until the fish is cooked through",
                        "8. Season with salt and pepper to taste",
                        "9. Serve hot over rice"
                    )
                ),
                isFavourite = false
            ),
            RecipeItem(
                recipe = Recipe(
                    id = 14,
                    name = "Lemon Herb Fish",
                    cookingTimeInMin = 30,
                    shortDescription = "Tender white fish baked with lemon, garlic and fresh herbs",
                    type = Type.FISH,
                    imageUrl = "https://images.unsplash.com/photo-1485921325833-c519f76c4927",
                    ingredients = listOf(
                        "4 white fish fillets (6 ounces each)",
                        "1/4 cup olive oil",
                        "2 lemons, sliced",
                        "1/4 cup chopped fresh parsley",
                        "2 cloves garlic, minced",
                        "Salt and pepper to taste"
                    ),
                    instructions = listOf(
                        "1. Preheat oven to 400°F (200°C)",
                        "2. In a small bowl, mix together the olive oil, lemon slices, parsley, and garlic",
                        "3. Brush the mixture on both sides of the fish fillets",
                        "4. Season with salt and pepper to taste",
                        "5. Bake the fish for 12-15 minutes or until it is cooked through"
                    )
                ),
                isFavourite = false
            ),
            RecipeItem(
                recipe = Recipe(
                    id = 15,
                    name = "Garlic Butter Shrimp",
                    cookingTimeInMin = 20,
                    shortDescription = "Succulent shrimp in garlic butter sauce",
                    type = Type.FISH,
                    imageUrl = "https://images.unsplash.com/photo-1565557623262-b51c2513a641",
                    ingredients = listOf(
                        "1 pound large shrimp, peeled",
                        "4 tablespoons unspray",
                        "2 cloves garlic, minced",
                        "1/4 cup chopped",
                        "Salt and pepper to taste"
                    ),
                    instructions = listOf(
                        "1. Heat butter in a large skillet over medium-high heat",
                        "2. Add garlic and cook for 1 minute",
                        "3. Add shrimp and cook for a few minutes",
                        "4. Serve hot"
                    )
                ),
                isFavourite = false
            ),
            RecipeItem(
                recipe = Recipe(
                    id = 16,
                    name = "Seafood Pasta",
                    cookingTimeInMin = 35,
                    shortDescription = "Pasta with mixed seafood in a light tomato sauce",
                    type = Type.FISH,
                    imageUrl = "https://images.unsplash.com/photo-1563379926898-05f4575a45d8",
                    ingredients = listOf(
                        "8 oz pasta",
                        "2 tablespoons olive oil",
                        "1 onion, diced",
                        "1 pound mixed seafood (such as shrimp, scallops, and mussels)",
                        "2 cups tomato sauce",
                        "1 cup white wine",
                        "1/4 cup chopped",
                        "Salt and pepper to taste"
                    ),
                    instructions = listOf(
                        "1. Cook pasta according to package instructions",
                        "2. Heat oil in a large skillet over medium heat",
                        "3. Add onion and cook until it is translucent",
                        "4. Add seafood and cook for a few minutes",
                        "5. Add tomato sauce and white wine, and bring to a simmer",
                        "6. Reduce heat to low and let cook for 10-15 minutes or until the seafood is cooked through",
                        "7. Serve hot over pasta"
                    )
                ),
                isFavourite = false
            ),
            RecipeItem(
                recipe = Recipe(
                    id = 17,
                    name = "Miso Glazed Salmon",
                    cookingTimeInMin = 30,
                    shortDescription = "Salmon fillets with sweet and savory miso glaze",
                    type = Type.FISH,
                    imageUrl = "https://images.unsplash.com/photo-1467003909585-2f8a72700288",
                    ingredients = listOf(
                        "4 salmon fillets (6 ounces each)",
                        "1/4 cup miso paste",
                        "1/4 cup maple syrup",
                        "2 tablespoons soy sauce",
                        "2 tablespoons rice vinegar",
                        "2 tablespoons olive oil",
                        "2 cloves garlic, minced",
                        "1 tablespoon grated fresh ginger"
                    ),
                    instructions = listOf(
                        "1. Preheat oven to 400°F (200°C)",
                        "2. In a small bowl, whisk together the miso paste, maple syrup, soy sauce, rice vinegar, and olive oil",
                        "3. Add garlic and ginger to the bowl and whisk until smooth",
                        "4. Brush the glaze on both sides of the salmon fillets",
                        "5. Bake the salmon for 12-15 minutes or until it is cooked through"
                    )
                ),
                isFavourite = false
            ),
            RecipeItem(
                recipe = Recipe(
                    id = 18,
                    name = "Mediterranean Seafood Stew",
                    cookingTimeInMin = 45,
                    shortDescription = "Hearty seafood stew with tomatoes, herbs, and white wine",
                    type = Type.FISH,
                    imageUrl = "https://images.unsplash.com/photo-1589227365533-cee630bd59bd",
                    ingredients = listOf(
                        "2 tablespoons olive oil",
                        "1 onion, diced",
                        "2 pounds mixed seafood (such as shrimp, scallops, and mussels)",
                        "2 cups diced tomatoes",
                        "2 cups white wine",
                        "1/4 cup chopped",
                        "Salt and pepper to taste"
                    ),
                    instructions = listOf(
                        "1. Heat oil in a large pot over medium heat",
                        "2. Add onion and cook until it is translucent",
                        "3. Add seafood and cook for a few minutes",
                        "4. Add diced tomatoes and white wine, and bring to a simmer",
                        "5. Reduce heat to low and let cook for 20-25 minutes or until the seafood is cooked through",
                        "6. Serve hot"
                    )
                ),
                isFavourite = false
            ),
            RecipeItem(
                recipe = Recipe(
                    id = 19,
                    name = "Lemon Garlic Tilapia",
                    cookingTimeInMin = 25,
                    shortDescription = "Light and flaky tilapia with lemon and garlic",
                    type = Type.FISH,
                    imageUrl = "https://images.unsplash.com/photo-1501595091296-3aa970afb3ff",
                    ingredients = listOf(
                        "4 tilapia fillets (6 ounces each)",
                        "1/4 cup olive oil",
                        "2 lemons, sliced",
                        "2 cloves garlic, minced",
                        "Salt and pepper to taste"
                    ),
                    instructions = listOf(
                        "1. Preheat oven to 400°F (200°C)",
                        "2. In a small bowl, mix together the olive oil, lemon slices, and garlic",
                        "3. Brush the mixture on both sides of the tilapia fillets",
                        "4. Season with salt and pepper to taste",
                        "5. Bake the tilapia for 12-15 minutes or until it is cooked through"
                    )
                ),
                isFavourite = false
            ),
            RecipeItem(
                recipe = Recipe(
                    id = 20,
                    name = "Seared Ahi Tuna",
                    cookingTimeInMin = 15,
                    shortDescription = "Seared rare tuna with sesame crust and wasabi sauce",
                    type = Type.FISH,
                    imageUrl = "https://images.unsplash.com/photo-1579631542720-3a87824fff86",
                    ingredients = listOf(
                        "4 ahi tuna steaks (6 ounces each)",
                        "1/4 cup sesame seeds",
                        "1/4 cup soy sauce",
                        "1/4 cup wasabi sauce",
                        "2 tablespoons olive oil",
                        "Salt and pepper to taste"
                    ),
                    instructions = listOf(
                        "1. Heat oil in a large skillet over high heat",
                        "2. Add tuna steaks and sear for 1-2 minutes on each side",
                        "3. Brush the tuna with soy sauce and wasabi sauce",
                        "4. Sprinkle sesame seeds on top of the tuna",
                        "5. Serve hot"
                    )
                ),
                isFavourite = false
            ),

            // MEAT RECIPES
            RecipeItem(
                recipe = Recipe(
                    id = 21,
                    name = "Beef Steak",
                    cookingTimeInMin = 30,
                    shortDescription = "Juicy beef steak with roasted potatoes and vegetables",
                    type = Type.MEAT,
                    imageUrl = "https://images.unsplash.com/photo-1558030006-450675393462",
                    ingredients = listOf(
                        "4 beef steaks (6 ounces each)",
                        "2 tablespoons olive oil",
                        "2 medium potatoes, peeled and cubed",
                        "1 medium onion, diced",
                        "1 medium",
                        "Salt and pepper to taste"
                    ),
                    instructions = listOf(
                        "1. Preheat oven to 400°F (200°C)",
                        "2. In a small bowl, mix together the olive oil, salt, and pepper",
                        "3. Brush the mixture on both sides of the beef steaks",
                        "4. Bake the beef for 15-20 minutes or until it is cooked to desired level of doneness",
                        "5. Toss the potatoes and onion with olive oil, salt, and pepper on a baking sheet",
                        "6. Roast the potatoes and onion for 20-25 minutes or until they are tender"
                    )
                ),
                isFavourite = false
            ),
            RecipeItem(
                recipe = Recipe(
                    id = 22,
                    name = "Chicken Parmesan",
                    cookingTimeInMin = 45,
                    shortDescription = "Breaded chicken cutlets with marinara sauce and melted mozzarella",
                    type = Type.MEAT,
                    imageUrl = "https://images.unsplash.com/photo-1632778149955-e80f8ceca2e8",
                    ingredients = listOf(
                        "4 chicken breasts (6 ounces each)",
                        "1 cup all-purpose flour",
                        "1 cup breadcrumbs",
                        "1 cup grated mozzarella cheese",
                        "1 cup marinara sauce",
                        "1/4 cup chopped",
                        "Salt and pepper to taste"
                    ),
                    instructions = listOf(
                        "1. Preheat oven to 400°F (200°C)",
                        "2. In a shallow dish, mix together the flour, breadcrumbs, and a pinch of salt",
                        "3. Dip the chicken breasts in the flour mixture, shaking off excess",
                        "4. Dip the floured chicken in the beaten eggs, and then coat in the breadcrumbs",
                        "5. Heat about 1/2 inch of oil in a large skillet over medium-high heat",
                        "6. Fry the chicken until golden brown and cooked through",
                        "7. Transfer the chicken to a baking dish and top with marinara sauce and mozzarella cheese",
                        "8. Bake the chicken for 15-20 minutes or until the cheese is melted and bubbly"
                    )
                ),
                isFavourite = false
            ),
            RecipeItem(
                recipe = Recipe(
                    id = 23,
                    name = "Pork Chops",
                    cookingTimeInMin = 35,
                    shortDescription = "Juicy pork chops with apple and sage sauce",
                    type = Type.MEAT,
                    imageUrl = "https://images.unsplash.com/photo-1432139555190-58524dae6a55",
                    ingredients = listOf(
                        "4 pork chops (6 ounces each)",
                        "2 tablespoons olive oil",
                        "1 medium onion, diced",
                        "1 medium",
                        "1/4 cup chopped",
                        "Salt and pepper to taste"
                    ),
                    instructions = listOf(
                        "1. Preheat oven to 400°F (200°C)",
                        "2. In a small bowl, mix together the olive oil, salt, and pepper",
                        "3. Brush the mixture on both sides of the pork chops",
                        "4. Bake the pork for 15-20 minutes or until it is cooked to desired level of doneness",
                        "5. Toss the onion and apple with olive oil, salt, and pepper on a baking sheet",
                        "6. Roast the onion and apple for 20-25 minutes or until they are tender"
                    )
                ),
                isFavourite = false
            ),
            RecipeItem(
                recipe = Recipe(
                    id = 24,
                    name = "Beef Stroganoff",
                    cookingTimeInMin = 40,
                    shortDescription = "Tender beef strips in creamy mushroom sauce over egg noodles",
                    type = Type.MEAT,
                    imageUrl = "https://images.unsplash.com/photo-1504973960431-1c467e159aa4",
                    ingredients = listOf(
                        "1 pound beef strips (such as sirloin or ribeye)",
                        "1 medium onion, diced",
                        "1 medium",
                        "1/4 cup chopped",
                        "1/4 cup all-purpose flour",
                        "1/4 cup",
                        "Salt and pepper to taste"
                    ),
                    instructions = listOf(
                        "1. Cook egg noodles according to package instructions",
                        "2. Heat oil in a large skillet over medium-high heat",
                        "3. Add beef and cook until browned",
                        "4. Add onion and mushrooms and cook until they are tender",
                        "5. Add flour and cook for a few minutes",
                        "6. Add broth and bring to a simmer",
                        "7. Reduce heat to low and let cook for 10-15 minutes or until the sauce has thickened",
                        "8. Serve hot over egg noodles"
                    )
                ),
                isFavourite = false
            ),
            RecipeItem(
                recipe = Recipe(
                    id = 25,
                    name = "Lamb Curry",
                    cookingTimeInMin = 60,
                    shortDescription = "Tender lamb pieces simmered in rich aromatic curry sauce",
                    type = Type.MEAT,
                    imageUrl = "https://images.unsplash.com/photo-1574484284002-952d92456975",
                    ingredients = listOf(
                        "1 pound lamb pieces (such as shoulder or leg)",
                        "2 medium onions, diced",
                        "2 medium",
                        "2 cloves garlic, minced",
                        "1 tablespoon grated fresh ginger",
                        "1 tablespoon curry powder",
                        "1 teaspoon ground cumin",
                        "1/2 teaspoon ground turmeric",
                        "1/2 teaspoon cayenne pepper",
                        "1 can coconut milk",
                        "Salt and pepper to taste"
                    ),
                    instructions = listOf(
                        "1. Heat oil in a large pot over medium heat",
                        "2. Add onions and cook until they are translucent",
                        "3. Add garlic and ginger, and cook for 1 minute",
                        "4. Add curry powder, cumin, turmeric, and cayenne pepper, and cook for 1 minute",
                        "5. Add lamb and cook for a few minutes",
                        "6. Add coconut milk and bring to a simmer",
                        "7. Reduce heat to low and let cook for 30-40 minutes or until the lamb is tender",
                        "8. Season with salt and pepper to taste",
                        "9. Serve hot over rice"
                    )
                ),
                isFavourite = false
            ),
            RecipeItem(
                recipe = Recipe(
                    id = 26,
                    name = "Beef Burritos",
                    cookingTimeInMin = 25,
                    shortDescription = "Flour tortillas with seasoned beef, rice, beans and cheese",
                    type = Type.MEAT,
                    imageUrl = "https://images.unsplash.com/photo-1584208632869-05fa2b2a5934",
                    ingredients = listOf(
                        "1 pound ground beef",
                        "1 medium onion, diced",
                        "1 medium",
                        "1/4 cup chopped",
                        "1/4 cup all-purpose flour",
                        "1/4 cup",
                        "Salt and pepper to taste",
                        "8-10 flour tortillas",
                        "Shredded cheese, for serving"
                    ),
                    instructions = listOf(
                        "1. Cook rice and beans according to package instructions",
                        "2. Heat oil in a large skillet over medium-high heat",
                        "3. Add beef and cook until browned",
                        "4. Add onion and cook until it is tender",
                        "5. Add flour and cook for a few minutes",
                        "6. Add broth and bring to a simmer",
                        "7. Reduce heat to low and let cook for 10-15 minutes or until the sauce has thickened",
                        "8. Warm the tortillas by wrapping them in a damp paper towel and microwaving for 20-30 seconds",
                        "9. Assemble the burritos by spooning the beef mixture onto a tortilla, and topping with rice, beans, and cheese"
                    )
                ),
                isFavourite = false
            ),
            RecipeItem(
                recipe = Recipe(
                    id = 27,
                    name = "BBQ Ribs",
                    cookingTimeInMin = 180,
                    shortDescription = "Slow-cooked pork ribs with smoky BBQ sauce glaze",
                    type = Type.MEAT,
                    imageUrl = "https://images.unsplash.com/photo-1544025162-d76694265947",
                    ingredients = listOf(
                        "2 pounds pork ribs",
                        "1/4 cup BBQ sauce",
                        "1/4 cup honey",
                        "2 tablespoons apple cider vinegar",
                        "1 teaspoon smoked paprika",
                        "1 teaspoon garlic powder",
                        "Salt and pepper to taste"
                    ),
                    instructions = listOf(
                        "1. Preheat oven to 275°F (135°C)",
                        "2. In a small bowl, mix together the BBQ sauce, honey, apple cider vinegar, smoked paprika, and garlic powder",
                        "3. Brush the mixture on both sides of the pork ribs",
                        "4. Place the ribs on a baking sheet and bake for 2-3 hours or until they are tender",
                        "5. Brush the ribs with additional BBQ sauce during the last 10 minutes of cooking"
                    )
                ),
                isFavourite = false
            ),
            RecipeItem(
                recipe = Recipe(
                    id = 28,
                    name = "Beef Burger",
                    cookingTimeInMin = 20,
                    shortDescription = "Juicy beef patty on a brioche bun with all the fixings",
                    type = Type.MEAT,
                    imageUrl = "https://images.unsplash.com/photo-1568901346375-23c9450c58cd",
                    ingredients = listOf(
                        "4 beef patties (6 ounces each)",
                        "4 brioche buns",
                        "2 medium onions, diced",
                        "2 medium",
                        "2 cloves garlic, minced",
                        "1/4 cup chopped",
                        "Salt and pepper to taste"
                    ),
                    instructions = listOf(
                        "1. Preheat grill or grill pan to medium-high heat",
                        "2. Form the beef patties and season with salt and pepper",
                        "3. Grill the patties for 4-6 minutes per side or until they are cooked to desired level of doneness",
                        "4. Assemble the burgers by spreading mayonnaise or ketchup on the bottom bun, followed by a cooked patty, lettuce, tomato, onion, and top bun"
                    )
                ),
                isFavourite = false
            ),
            RecipeItem(
                recipe = Recipe(
                    id = 29,
                    name = "Roast Chicken",
                    cookingTimeInMin = 90,
                    shortDescription = "Whole roasted chicken with herbs, garlic, and lemon",
                    type = Type.MEAT,
                    imageUrl = "https://images.unsplash.com/photo-1598103442097-8b74394b95c6",
                    ingredients = listOf(
                        "1 whole chicken (3-4 pounds)",
                        "2 tablespoons olive oil",
                        "2 cloves garlic, minced",
                        "1 lemon, sliced",
                        "1/4 cup chopped",
                        "Salt and pepper to taste"
                    ),
                    instructions = listOf(
                        "1. Preheat oven to 425°F (220°C)",
                        "2. In a small bowl, mix together the olive oil, garlic, and lemon slices",
                        "3. Rub the mixture on the chicken, making sure to get some under the skin as well",
                        "4. Season with salt and pepper to taste",
                        "5. Place the chicken in a roasting pan and roast for 45-50 minutes or until it is cooked through"
                    )
                ),
                isFavourite = false
            ),
            RecipeItem(
                recipe = Recipe(
                    id = 30,
                    name = "Beef Stir Fry",
                    cookingTimeInMin = 20,
                    shortDescription = "Thin sliced beef with vegetables in savory stir-fry sauce",
                    type = Type.MEAT,
                    imageUrl = "https://images.unsplash.com/photo-1512058564366-18510be2db19",
                    ingredients = listOf(
                        "1 pound beef strips (such as sirloin or ribeye)",
                        "2 medium onions, diced",
                        "2 medium",
                        "2 cloves garlic, minced",
                        "1 tablespoon soy sauce",
                        "1 tablespoon oyster sauce",
                        "1 tablespoon honey",
                        "1 teaspoon grated fresh ginger",
                        "Salt and pepper to taste"
                    ),
                    instructions = listOf(
                        "1. Heat oil in a large skillet or wok over medium-high heat",
                        "2. Add beef and cook until browned",
                        "3. Add onion and cook until it is tender",
                        "4. Add garlic and cook for 1 minute",
                        "5. Add soy sauce, oyster sauce, honey, and ginger, and stir to combine",
                        "6. Cook for an additional 2-3 minutes or until the sauce has thickened",
                        "7. Serve hot over rice"
                    )
                ),
                isFavourite = false
            )
        )

    fun fetchRecipes(): List<RecipeItem> = recipes

    fun fetchRecipeById(id: Int): RecipeItem =
        requireNotNull(recipes.find { it.recipe.id == id })
}