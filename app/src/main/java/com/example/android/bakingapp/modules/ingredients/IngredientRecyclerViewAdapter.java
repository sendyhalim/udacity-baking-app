package com.example.android.bakingapp.modules.ingredients;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;

public class IngredientRecyclerViewAdapter extends RecyclerView.Adapter {
    private ArrayList<IngredientViewModelInterface> ingredients;

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return ingredients.size();
    }

    public void setIngredients(ArrayList<IngredientViewModelInterface> ingredients) {
        this.ingredients = ingredients;
        notifyDataSetChanged();
    }
}
