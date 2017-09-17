package com.example.android.bakingapp.modules.step;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.bakingapp.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecipeStepListFragment extends Fragment {
    @BindView(R.id.recipeStepRecyclerView)
    RecyclerView recipeStepRecyclerView;

    ArrayList<RecipeStepViewModelInterface> steps;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.recipe_step_list_fragment, container, false);
        ButterKnife.bind(this, rootView);

        RecipeStepRecyclerViewAdapter adapter = new RecipeStepRecyclerViewAdapter();
        adapter.setSteps(steps);
        LinearLayoutManager layoutManager = new LinearLayoutManager(
            getContext(),
            LinearLayoutManager.VERTICAL,
            false
        );

        recipeStepRecyclerView.setLayoutManager(layoutManager);
        recipeStepRecyclerView.setAdapter(adapter);

        return rootView;
    }

    public void setSteps(ArrayList<RecipeStepViewModelInterface> steps) {
        this.steps = steps;
    }
}
