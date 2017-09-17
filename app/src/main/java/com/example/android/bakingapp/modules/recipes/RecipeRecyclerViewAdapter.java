package com.example.android.bakingapp.modules.recipes;

import android.support.v4.app.LoaderManager;
import android.support.v7.widget.RecyclerView;
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
    private OnClickHandler onClickHandler;

    @Override
    public int getItemCount() {
        return recipes.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater
            .from(parent.getContext())
            .inflate(R.layout.recipe, parent, false);

        return new RecipeRecyclerViewAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecipeRecyclerViewAdapter.ViewHolder holder, int position) {
        holder.setup(new RecipeViewModel(recipes.get(position)));
    }

    public void setRecipes(ArrayList<Recipe> recipes) {
        this.recipes = recipes;
        notifyDataSetChanged();
    }

    public void setOnClickHandler(OnClickHandler handler) {
        this.onClickHandler = handler;
    }

    public interface OnClickHandler {
        void onRecipeClicked(RecipeViewModelInterface viewModel);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.recipeNameTextView)
        TextView recipeNameTextView;

        RecipeViewModelInterface viewModel;

        public ViewHolder(View view) {
            super(view);

            ButterKnife.bind(this, view);
            view.setOnClickListener(this);
        }

        public void setup(RecipeViewModelInterface viewModel) {
            this.viewModel = viewModel;
            recipeNameTextView.setText(viewModel.getName());
        }

        @Override
        public void onClick(View view) {
            onClickHandler.onRecipeClicked(viewModel);
        }
    }
}
