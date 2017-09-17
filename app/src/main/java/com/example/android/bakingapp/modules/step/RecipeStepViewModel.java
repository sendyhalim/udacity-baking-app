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

    public String getDescription() {
        return recipeStep.description;
    }

    @Override
    public String getShortDescription() {
        return recipeStep.shortDescription;
    }
}
