package com.example.android.bakingapp.modules.ingredients;

public class IngredientViewModel implements IngredientViewModelInterface {
    private Ingredient ingredient;

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
