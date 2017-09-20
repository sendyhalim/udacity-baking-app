package com.example.android.bakingapp.modules.step;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.bakingapp.R;

import butterknife.ButterKnife;

public class RecipeStepDetailFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(
        LayoutInflater inflater,
        @Nullable ViewGroup container,
        Bundle savedInstanceState
    ) {
        View view = inflater.inflate(R.layout.recipe_step_detail_fragment, container, false);
        ButterKnife.bind(this, view);

        return view;
    }

    public void setRecipeStep(RecipeStepViewModelInterface step) {


    }
}
