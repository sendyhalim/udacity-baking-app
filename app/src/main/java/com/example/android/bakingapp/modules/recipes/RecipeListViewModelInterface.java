package com.example.android.bakingapp.modules.recipes;

public interface RecipeListViewModelInterface {
    void fetch();
    int count();
    RecipeViewModelInterface get(int index);
}
