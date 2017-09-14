package com.example.android.bakingapp.modules.recipes;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.bakingapp.R;


public class RecipeRecyclerViewAdapter extends RecyclerView.Adapter<RecipeRecyclerViewAdapter.ViewHolder> {
    RecipeListViewModelInterface viewModel;

    public RecipeRecyclerViewAdapter(RecipeListViewModelInterface viewModel) {
        this.viewModel = viewModel;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View view) {
            super(view);
        }

        public void setup(RecipeViewModelInterface viewModel) {

        }
    }

    @Override
    public int getItemCount() {
        return viewModel.count();
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
        holder.setup(viewModel.get(position));
    }
}
