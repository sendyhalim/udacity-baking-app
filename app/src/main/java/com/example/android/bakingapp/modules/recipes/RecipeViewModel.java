package com.example.android.bakingapp.modules.recipes;

import com.example.android.bakingapp.modules.ingredients.Ingredient;
import com.example.android.bakingapp.modules.ingredients.IngredientViewModel;
import com.example.android.bakingapp.modules.ingredients.IngredientViewModelInterface;

import org.parceler.Parcel;
import org.parceler.ParcelConstructor;

import java.util.ArrayList;

@Parcel
public class RecipeViewModel implements RecipeViewModelInterface {
    public Recipe recipe;
    public ArrayList<IngredientViewModel> ingredients;

    @ParcelConstructor
    public RecipeViewModel(Recipe recipe) {
        this.recipe = recipe;

        this.ingredients = new ArrayList<>();

        for (Ingredient ingredient: recipe.ingredients) {
            this.ingredients.add(new IngredientViewModel(ingredient));
        }
    }

    public String getName() {
        return this.recipe.name;
    }

    public ArrayList<? extends IngredientViewModelInterface> getIngredients() {
        return this.ingredients;
    }
}
