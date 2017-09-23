package com.example.android.bakingapp.modules.step;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.bakingapp.R;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.ui.SimpleExoPlayerView;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.util.Util;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecipeStepDetailFragment extends Fragment {
    public static final String STEP_BUNDLE_KEY = "RECIPE_STEP_DATA";

    @BindView(R.id.videoContainer)
    SimpleExoPlayerView videoContainer;

    @BindView(R.id.recipeStepDescriptionTextView)
    TextView recipeStepDescriptionTextView;

    RecipeStepViewModelInterface step;

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putParcelable(STEP_BUNDLE_KEY, Parcels.wrap(step));
    }

    @Nullable
    @Override
    public View onCreateView(
        LayoutInflater inflater,
        @Nullable ViewGroup container,
        Bundle savedInstanceState
    ) {
        View view = inflater.inflate(R.layout.recipe_step_detail_fragment, container, false);
        ButterKnife.bind(this, view);

        if (savedInstanceState != null) {
            step = Parcels.unwrap(savedInstanceState.getParcelable(STEP_BUNDLE_KEY));
        }

        setup();

        return view;
    }

    public void setRecipeStep(RecipeStepViewModelInterface step) {
        this.step = step;
    }

    private void setup() {
        if (step.getVideoUri() != null) {
            setupVideoPlayer(step);
        } else {
            videoContainer.setVisibility(View.INVISIBLE);
        }

        recipeStepDescriptionTextView.setText(step.getDescription());
    }

    private void setupVideoPlayer(RecipeStepViewModelInterface step) {
        // 1. Create a default TrackSelector
        Handler mainHandler = new Handler();
        Context context = getContext();
        BandwidthMeter bandwidthMeter = new DefaultBandwidthMeter();
        TrackSelection.Factory videoTrackSelectionFactory = new AdaptiveTrackSelection.Factory(bandwidthMeter);
        TrackSelector trackSelector = new DefaultTrackSelector(videoTrackSelectionFactory);

        // 2. Create the player
        SimpleExoPlayer player = ExoPlayerFactory.newSimpleInstance(context, trackSelector);

        videoContainer.setPlayer(player);

        // Produces DataSource instances through which media data is loaded.
        DataSource.Factory dataSourceFactory = new DefaultDataSourceFactory(
                context,
                Util.getUserAgent(context, "BakingApp")
        );

        // Produces Extractor instances for parsing the media data.
        ExtractorsFactory extractorsFactory = new DefaultExtractorsFactory();
        // This is the MediaSource representing the media to be played.
        MediaSource videoSource = new ExtractorMediaSource(
            step.getVideoUri(),
            dataSourceFactory,
            extractorsFactory,
            null,
            null
        );

        player.prepare(videoSource);
    }
}
