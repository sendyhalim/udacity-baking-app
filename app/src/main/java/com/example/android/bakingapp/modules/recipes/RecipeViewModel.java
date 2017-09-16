package com.example.android.bakingapp.modules.recipes;

import org.parceler.Parcel;
import org.parceler.ParcelConstructor;

@Parcel
public class RecipeViewModel implements RecipeViewModelInterface {
    public final Recipe recipe;

    @ParcelConstructor
    public RecipeViewModel(Recipe recipe) {
        this.recipe = recipe;
    }

    public String getName() {
        return this.recipe.name;
    }
}
