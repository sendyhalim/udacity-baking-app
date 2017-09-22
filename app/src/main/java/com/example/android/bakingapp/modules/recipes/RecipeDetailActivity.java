package com.example.android.bakingapp.modules.recipes;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.example.android.bakingapp.R;
import com.example.android.bakingapp.modules.ingredients.IngredientListFragment;
import com.example.android.bakingapp.modules.ingredients.IngredientViewModelInterface;
import com.example.android.bakingapp.modules.step.RecipeStepDetailActivity;
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
    ArrayList<RecipeViewModelInterface> recipes;

    @BindView(R.id.toPreviousRecipeButton)
    Button toPreviousRecipeButton;

    @BindView(R.id.toNextRecipeButton)
    Button toNextRecipeButton;

    @BindView(R.id.recipeListScrollView)
    ScrollView recipeListScrollView;

    int currentIndex;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recipe_detail);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        currentIndex = intent.getIntExtra(Intent.EXTRA_INDEX, 0);
        recipes = Parcels.unwrap(intent.getParcelableExtra(Intent.EXTRA_INTENT));
        RecipeViewModelInterface recipeViewModel = recipes.get(currentIndex);

        if (intent.hasExtra(Intent.EXTRA_INTENT) && savedInstanceState == null) {
            setup(recipeViewModel);
        }

        toPreviousRecipeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentIndex = Math.max(0, currentIndex - 1);
                RecipeViewModelInterface recipeViewModel = recipes.get(currentIndex);
                setup(recipeViewModel);
            }
        });

        toNextRecipeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentIndex = Math.min(recipes.size() - 1, currentIndex + 1);
                Log.i("ADDING INDEX", "" + currentIndex);

                RecipeViewModelInterface recipeViewModel = recipes.get(currentIndex);
                setup(recipeViewModel);
            }
        });
    }

    private void setup(RecipeViewModelInterface recipeViewModel) {
        recipeListScrollView.scrollTo(0, 0);

        if (currentIndex > 0) {
            toPreviousRecipeButton.setText(recipes.get(currentIndex - 1).getName());
            toPreviousRecipeButton.setVisibility(View.VISIBLE);
        } else {
            toPreviousRecipeButton.setVisibility(View.INVISIBLE);
        }

        if (currentIndex < (recipes.size() - 1)) {
            toNextRecipeButton.setText(recipes.get(currentIndex + 1).getName());
            toNextRecipeButton.setVisibility(View.VISIBLE);
        } else {
            toNextRecipeButton.setVisibility(View.INVISIBLE);
        }

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
            Intent intent = new Intent(this, RecipeStepDetailActivity.class);
            intent.putExtra(Intent.EXTRA_INTENT, Parcels.wrap(step));

            startActivity(intent);
        }
    }
}
