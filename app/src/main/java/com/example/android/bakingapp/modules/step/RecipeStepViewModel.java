package com.example.android.bakingapp.modules.step;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;

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

    @Override
    public Uri getVideoUri() {
        if (TextUtils.isEmpty(recipeStep.videoURL)) {
            return null;
        }

        return Uri.parse(recipeStep.videoURL);
    }
}
