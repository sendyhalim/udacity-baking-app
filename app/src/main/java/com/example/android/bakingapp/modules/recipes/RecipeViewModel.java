package com.example.android.bakingapp.modules.recipes;

public class RecipeViewModel implements RecipeViewModelInterface {
    private Recipe recipe;

    public RecipeViewModel(Recipe recipe) {
        this.recipe = recipe;
    }
}
