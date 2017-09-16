package com.example.android.bakingapp.modules.ingredients;

import org.parceler.Parcel;
import org.parceler.ParcelConstructor;

@Parcel
public class IngredientViewModel implements IngredientViewModelInterface {
    public final Ingredient ingredient;

    @ParcelConstructor
    public IngredientViewModel(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    @Override
    public String getName() {
        return this.ingredient.name;
    }

    @Override
    public String getQuantity() {
        return Double.toString(this.ingredient.quantity);
    }

    @Override
    public String getMeasure() {
        return this.ingredient.measure;
    }
}
