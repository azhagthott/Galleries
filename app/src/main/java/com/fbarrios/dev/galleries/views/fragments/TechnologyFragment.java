package com.fbarrios.dev.galleries.views.fragments;


import com.fbarrios.dev.galleries.background.GetPhotoByCategory;
import com.fbarrios.dev.galleries.models.Unsplash;

import java.util.List;

import static com.fbarrios.dev.galleries.network.AppBase.CATEGORY_TECHNOLOGY;

public class TechnologyFragment extends UnsplahFragment {

    public TechnologyFragment() {
    }

    @Override
    public void onStart() {
        super.onStart();
        new TechnologyPhoto().execute(CATEGORY_TECHNOLOGY);
    }

    private class TechnologyPhoto extends GetPhotoByCategory {
        @Override
        protected void onPostExecute(List<Unsplash> unsplashes) {
            updateAdapter(unsplashes);
        }
    }
}