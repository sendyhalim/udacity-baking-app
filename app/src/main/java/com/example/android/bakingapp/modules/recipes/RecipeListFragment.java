package com.example.android.bakingapp.modules.recipes;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.android.bakingapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class RecipeListFragment extends Fragment {
    @BindView(R.id.recipeListGridView)
    GridView recipeGridView;

    public RecipeListFragment() { }

    @Nullable
    @Override
    public View onCreateView(
        LayoutInflater inflater,
        @Nullable ViewGroup container,
        Bundle savedInstanceState
    ) {
        final GridView rootView = (GridView) inflater.inflate(R.layout.recipe_list_fragment, container, false);
        final RecipeListGridViewAdapter adapter = new RecipeListGridViewAdapter(
                rootView.getContext(),
                new RecipeListViewModel()
        );

        ButterKnife.bind(this, rootView);
        rootView.setAdapter(adapter);

        return rootView;
    }
}
