package com.example.android.bakingapp.modules.ingredients;

import com.google.gson.annotations.SerializedName;

public class Ingredient {
    @SerializedName("ingredient")
    public final String name;
    public final int quantity;
    public final String measure;

    public Ingredient(String name, int quantity, String measure) {
        this.name = name;
        this.quantity = quantity;
        this.measure = measure;
    }
}
