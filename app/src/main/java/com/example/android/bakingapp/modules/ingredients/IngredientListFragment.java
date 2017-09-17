package com.example.android.bakingapp.modules.ingredients;

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

import static android.support.v7.widget.RecyclerView.*;

public class IngredientListFragment extends Fragment {
    @BindView(R.id.ingredientRecyclerView)
    RecyclerView ingredientRecyclerView;

    ArrayList<IngredientViewModelInterface> ingredients;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(
            R.layout.ingredient_list_fragment,
            container,
            false
        );

        ButterKnife.bind(this, rootView);

        IngredientRecyclerViewAdapter adapter = new IngredientRecyclerViewAdapter();
        adapter.setIngredients(ingredients);
        LayoutManager layoutManager = new LinearLayoutManager(
            getContext(),
            LinearLayoutManager.VERTICAL,
            false
        );

        ingredientRecyclerView.setAdapter(adapter);
        ingredientRecyclerView.setLayoutManager(layoutManager);

        return rootView;
    }

    public void setIngredients(ArrayList<IngredientViewModelInterface> ingredients) {
        this.ingredients = ingredients;
    }
}
