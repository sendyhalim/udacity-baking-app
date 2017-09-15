package com.example.android.bakingapp.modules.recipes;

import com.example.android.bakingapp.modules.ingredients.Ingredient;
import com.example.android.bakingapp.modules.step.RecipeStep;

import java.util.ArrayList;

public class Recipe {
    public final int id;
    public final String name;
    public final ArrayList<Ingredient> ingredients;
    public final ArrayList<RecipeStep> steps;

    public Recipe(
        int id,
        String name,
        ArrayList<Ingredient> ingredients,
        ArrayList<RecipeStep> steps
    ) {
        this.id = id;
        this.name = name;
        this.ingredients = ingredients;
        this.steps = steps;
    }
}
