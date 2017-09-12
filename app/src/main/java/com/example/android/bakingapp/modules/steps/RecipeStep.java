package com.example.android.bakingapp.modules.steps;

import java.net.URL;

public class RecipeStep {
    public final int id;
    public final String description;
    public final String shortDescription;
    public final URL videoUrl;
    public final URL thumbnailUrl;

    public RecipeStep(
        int id,
        String description,
        String shortDescription,
        URL videoUrl,
        URL thumbnailUrl
    ) {
        this.id = id;
        this.description = description;
        this.shortDescription = shortDescription;
        this.videoUrl = videoUrl;
        this.thumbnailUrl = thumbnailUrl;
    }
}
