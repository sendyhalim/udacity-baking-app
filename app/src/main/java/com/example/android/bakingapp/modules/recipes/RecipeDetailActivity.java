package com.example.android.bakingapp.modules.recipes;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.android.bakingapp.R;
import com.example.android.bakingapp.modules.ingredients.IngredientListFragment;
import com.example.android.bakingapp.modules.ingredients.IngredientViewModelInterface;

import org.parceler.Parcels;

import java.util.ArrayList;

public class RecipeDetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recipe_detail);


        Intent intent = getIntent();

        if (intent.hasExtra(Intent.EXTRA_INTENT)) {
            RecipeViewModelInterface viewModel = Parcels.unwrap(intent.getParcelableExtra(Intent.EXTRA_INTENT));
            ArrayList<IngredientViewModelInterface> ingredients = (ArrayList<IngredientViewModelInterface>) viewModel.getIngredients();
            IngredientListFragment ingredientListFragment = new IngredientListFragment(ingredients);

            getFragmentManager()
                .beginTransaction()
                .add(R.id.ingredientListFragmentContainer, ingredientListFragment)
                .commit();
        }
    }
}
