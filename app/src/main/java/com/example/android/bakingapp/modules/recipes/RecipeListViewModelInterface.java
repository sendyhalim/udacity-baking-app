package com.example.android.bakingapp.modules.recipes;

public interface RecipeListViewModelInterface {
    int count();
    RecipeViewModelInterface get(int index);
}
