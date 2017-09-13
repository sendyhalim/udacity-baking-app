package com.example.android.bakingapp.modules.recipes;

public class RecipeListViewModel implements RecipeListViewModelInterface {
    @Override
    public void fetch() {

    }

    @Override
    public int count() {
        return 10;
    }

    @Override
    public RecipeViewModelInterface get(int index) {
        return null;
    }
}
