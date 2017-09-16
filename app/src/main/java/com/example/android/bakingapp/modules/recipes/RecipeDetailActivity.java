package com.example.android.bakingapp.modules.recipes;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import org.parceler.Parcels;

public class RecipeDetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        Intent intent = getIntent();

        if (intent.hasExtra(Intent.EXTRA_INTENT)) {
            RecipeViewModelInterface viewModel = Parcels.unwrap(intent.getParcelableExtra(Intent.EXTRA_INTENT));
            Log.i(RecipeDetailActivity.class.toString(), viewModel.getName());
        }
    }
}
