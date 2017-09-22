package com.example.android.bakingapp.modules.step;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.bakingapp.R;
import com.example.android.bakingapp.modules.recipes.Recipe;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecipeStepRecyclerViewAdapter extends RecyclerView.Adapter<RecipeStepRecyclerViewAdapter.ViewHolder> {
    ArrayList<RecipeStepViewModelInterface> steps;
    RecipeStepRecyclerViewAdapter.OnClickHandler onClickHandler;

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
        holder.setup(position, steps.get(position));
    }

    @Override
    public int getItemCount() {
        return steps.size();
    }

    public void setSteps(ArrayList<RecipeStepViewModelInterface> steps) {
        this.steps = steps;
        notifyDataSetChanged();
    }

    public void setOnClickHandler(OnClickHandler onClickHandler) {
        this.onClickHandler = onClickHandler;
    }

    public interface OnClickHandler {
        public void onRecipeStepClicked(RecipeStepViewModelInterface step);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.recipeStepShortDescription)
        TextView recipeStepShortDescriptionTextView;

        RecipeStepViewModelInterface step;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);

            view.setOnClickListener(this);
        }

        public void setup(int position, RecipeStepViewModelInterface step) {
            this.step = step;
            recipeStepShortDescriptionTextView.setText(String.format(
                "%s. %s",
                position + 1,
                step.getShortDescription()
            ));
        }

        @Override
        public void onClick(View view) {
            onClickHandler.onRecipeStepClicked(step);
        }
    }
}
