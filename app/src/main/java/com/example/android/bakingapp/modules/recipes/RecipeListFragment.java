package com.example.android.bakingapp.modules.recipes;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.telecom.Call;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.bakingapp.R;

import java.util.ArrayList;

import butterknife.BindDimen;
import butterknife.BindInt;
import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Callback;
import retrofit2.Response;

import static android.support.v7.widget.RecyclerView.*;

public class RecipeListFragment extends Fragment implements RecipeRecyclerViewAdapter.OnClickHandler {
    @BindInt(R.integer.recipeListSpanCount)
    int spanCount;

    RecipeAPI api;

    public RecipeListFragment() {
        api = new RecipeAPI();
    }

    @Nullable
    @Override
    public View onCreateView(
        LayoutInflater inflater,
        @Nullable ViewGroup container,
        Bundle savedInstanceState
    ) {
        final RecyclerView rootView = (RecyclerView) inflater.inflate(R.layout.recipe_list_fragment, container, false);
        ButterKnife.bind(this, rootView);

        final RecipeRecyclerViewAdapter adapter = new RecipeRecyclerViewAdapter();
        final GridLayoutManager layoutManager = new GridLayoutManager(getContext(), spanCount);

        adapter.setOnClickHandler(this);
        rootView.setAdapter(adapter);
        rootView.setLayoutManager(layoutManager);

        api.recipes().enqueue(new Callback<ArrayList<Recipe>>() {
            @Override
            public void onResponse(retrofit2.Call<ArrayList<Recipe>> call, Response<ArrayList<Recipe>> response) {
                adapter.setRecipes(response.body());
            }

            @Override
            public void onFailure(retrofit2.Call<ArrayList<Recipe>> call, Throwable t) {
                Log.e(getClass().toString(), t.getMessage());
            }
        });

        return rootView;
    }

    @Override
    public void onRecipeClicked(RecipeViewModelInterface viewModel) {
        Log.i(getClass().toString(), viewModel.getName());
    }
}
