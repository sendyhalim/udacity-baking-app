package com.example.android.bakingapp.modules.recipes;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

import com.example.android.bakingapp.R;
import com.example.android.bakingapp.modules.ingredients.IngredientListFragment;
import com.example.android.bakingapp.modules.ingredients.IngredientViewModelInterface;
import com.example.android.bakingapp.modules.step.RecipeStepDetailFragment;
import com.example.android.bakingapp.modules.step.RecipeStepListFragment;
import com.example.android.bakingapp.modules.step.RecipeStepRecyclerViewAdapter;
import com.example.android.bakingapp.modules.step.RecipeStepViewModelInterface;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecipeDetailActivity extends AppCompatActivity
    implements RecipeStepRecyclerViewAdapter.OnClickHandler {

    RecipeStepDetailFragment recipeStepDetailFragment;
    RecipeViewModelInterface recipeViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recipe_detail);

        Intent intent = getIntent();

        if (intent.hasExtra(Intent.EXTRA_INTENT) && savedInstanceState == null) {
            recipeViewModel = Parcels.unwrap(intent.getParcelableExtra(Intent.EXTRA_INTENT));
            FragmentManager fragmentManager = getFragmentManager();

            // Setup ingredient list fragment
            ArrayList<IngredientViewModelInterface> ingredients = (ArrayList<IngredientViewModelInterface>) recipeViewModel.getIngredients();

            IngredientListFragment ingredientListFragment = new IngredientListFragment();

            getFragmentManager()
                    .beginTransaction()
                    .replace(R.id.ingredientListFragmentContainer, ingredientListFragment, IngredientListFragment.class.toString())
                    .commit();

            ingredientListFragment.setIngredients(ingredients);

            // Setup recipe step list fragment
            ArrayList<RecipeStepViewModelInterface> steps = (ArrayList<RecipeStepViewModelInterface>) recipeViewModel.getSteps();
            RecipeStepListFragment recipeStepListFragment = new RecipeStepListFragment();
            recipeStepListFragment.setOnRecipeStepClickHandler(this);

            getFragmentManager()
                    .beginTransaction()
                    .replace(R.id.recipeStepListFragmentContainer, recipeStepListFragment)
                    .commit();

            recipeStepListFragment.setSteps(steps);

            if (findViewById(R.id.recipeStepDetailFragmentContainer)  != null) {
                 setupRecipeStepDetailFragment(steps.get(0));
            }
        }
    }

    private void setupRecipeStepDetailFragment(RecipeStepViewModelInterface step) {
        recipeStepDetailFragment = new RecipeStepDetailFragment();
        recipeStepDetailFragment.setRecipeStep(step);

        getFragmentManager()
                .beginTransaction()
                .replace(R.id.recipeStepDetailFragmentContainer, recipeStepDetailFragment)
                .commit();
    }

    @Override
    public void onRecipeStepClicked(RecipeStepViewModelInterface step) {
        if (recipeStepDetailFragment != null) {
            setupRecipeStepDetailFragment(step);
        } else {
            // We're on mobile, let's start new activity
        }
    }
}
