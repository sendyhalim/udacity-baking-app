package com.example.android.bakingapp.modules.recipes;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.bakingapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.support.v7.widget.RecyclerView.*;

public class RecipeListFragment extends Fragment {
    @BindView(R.id.recipeRecyclerView)
    RecyclerView recipeRecyclerView;

    public RecipeListFragment() { }

    @Nullable
    @Override
    public View onCreateView(
        LayoutInflater inflater,
        @Nullable ViewGroup container,
        Bundle savedInstanceState
    ) {
        final RecyclerView rootView = (RecyclerView) inflater.inflate(R.layout.recipe_list_fragment, container, false);
        final RecipeListViewModelInterface viewModel = new RecipeListViewModel();
        final RecipeRecyclerViewAdapter adapter = new RecipeRecyclerViewAdapter(viewModel);
        final GridLayoutManager layoutManager = new GridLayoutManager(this.getContext(), 3);

        ButterKnife.bind(this, rootView);
        rootView.setAdapter(adapter);
        rootView.setLayoutManager(layoutManager);

        return rootView;
    }
}
