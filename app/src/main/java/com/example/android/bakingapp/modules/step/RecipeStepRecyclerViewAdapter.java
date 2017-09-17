package com.example.android.bakingapp.modules.step;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.bakingapp.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecipeStepRecyclerViewAdapter extends RecyclerView.Adapter<RecipeStepRecyclerViewAdapter.ViewHolder> {
    ArrayList<RecipeStepViewModelInterface> steps;

    public RecipeStepRecyclerViewAdapter() {
        this.steps = new ArrayList<>();
    }

    @Override
    public RecipeStepRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.recipe_step, parent, false);

        return new RecipeStepRecyclerViewAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecipeStepRecyclerViewAdapter.ViewHolder holder, int position) {
        holder.setup(steps.get(position));
    }

    @Override
    public int getItemCount() {
        return steps.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.recipeStepShortDescription)
        TextView recipeStepShortDescriptionTextView;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        public void setup(RecipeStepViewModelInterface step) {
            recipeStepShortDescriptionTextView.setText(step.getShortDescription());
        }
    }

    public void setSteps(ArrayList<RecipeStepViewModelInterface> steps) {
        this.steps = steps;
        notifyDataSetChanged();
    }
}
