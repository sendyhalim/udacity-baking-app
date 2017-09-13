package com.example.android.bakingapp.modules.recipes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.android.bakingapp.R;


public class RecipeListGridViewAdapter extends BaseAdapter {
    RecipeListViewModelInterface viewModel;
    LayoutInflater layoutInflater;

    public RecipeListGridViewAdapter(Context context, RecipeListViewModelInterface viewModel) {
        this.viewModel = viewModel;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return viewModel.count();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        RecipeView recipeView;

        if (view != null) {
            recipeView = (RecipeView) view;
        } else {
            recipeView = (RecipeView) layoutInflater.inflate(R.layout.recipe, null);
        }

        recipeView.setup(viewModel.get(i));

        return recipeView;
    }
}
