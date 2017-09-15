package com.example.android.bakingapp.modules.recipes;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.bakingapp.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;


public class RecipeRecyclerViewAdapter extends RecyclerView.Adapter<RecipeRecyclerViewAdapter.ViewHolder> {
    private ArrayList<Recipe> recipes;

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.recipeNameTextView)
        TextView recipeNameTextView;

        public ViewHolder(View view) {
            super(view);

            ButterKnife.bind(this, view);
        }

        public void setup(RecipeViewModelInterface viewModel) {
            recipeNameTextView.setText(viewModel.getName());
        }
    }

    @Override
    public int getItemCount() {
        return recipes == null ? 0 : recipes.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater
            .from(parent.getContext())
            .inflate(R.layout.recipe, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.setup(new RecipeViewModel(recipes.get(position)));
    }

    public void setRecipes(ArrayList<Recipe> recipes) {
        this.recipes = recipes;
        notifyDataSetChanged();
    }
}
