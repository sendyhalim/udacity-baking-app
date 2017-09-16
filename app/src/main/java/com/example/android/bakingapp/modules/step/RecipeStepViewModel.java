package com.example.android.bakingapp.modules.step;

import org.parceler.Parcel;
import org.parceler.ParcelConstructor;

@Parcel
public class RecipeStepViewModel implements RecipeStepViewModelInterface {
    public final RecipeStep recipeStep;

    @ParcelConstructor
    public RecipeStepViewModel(RecipeStep recipeStep) {
        this.recipeStep = recipeStep;
    }
}
