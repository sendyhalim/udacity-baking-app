package com.example.android.bakingapp.modules.step;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.example.android.bakingapp.R;

import org.parceler.Parcels;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecipeStepDetailActivity extends AppCompatActivity {
    @BindView(R.id.recipeStepDetailFragmentContainer)
    View recipeStepDetailFragmentContainer;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recipe_step_detail_activity);

        ButterKnife.bind(this);

        Intent intent = getIntent();

        if (intent.hasExtra(Intent.EXTRA_INTENT) && savedInstanceState == null) {
            RecipeStepViewModelInterface step = Parcels.unwrap(intent.getParcelableExtra(Intent.EXTRA_INTENT));

            RecipeStepDetailFragment recipeStepDetailFragment = new RecipeStepDetailFragment();
            recipeStepDetailFragment.setRecipeStep(step);

            getFragmentManager()
                .beginTransaction()
                .replace(R.id.recipeStepDetailFragmentContainer, recipeStepDetailFragment)
                .commit();
        }
    }
}
