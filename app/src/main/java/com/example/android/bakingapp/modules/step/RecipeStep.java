package com.example.android.bakingapp.modules.step;

import org.parceler.Parcel;
import org.parceler.ParcelConstructor;

@Parcel
public class RecipeStep {
    public final int id;
    public final String description;
    public final String shortDescription;
    public final String videoUrl;
    public final String thumbnailUrl;

    @ParcelConstructor
    public RecipeStep(
        int id,
        String description,
        String shortDescription,
        String videoUrl,
        String thumbnailUrl
    ) {
        this.id = id;
        this.description = description;
        this.shortDescription = shortDescription;
        this.videoUrl = videoUrl;
        this.thumbnailUrl = thumbnailUrl;
    }
}
