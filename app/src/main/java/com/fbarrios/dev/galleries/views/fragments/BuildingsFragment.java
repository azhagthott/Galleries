package com.fbarrios.dev.galleries.views.fragments;


import com.fbarrios.dev.galleries.background.GetPhotoByCategory;
import com.fbarrios.dev.galleries.models.Unsplash;

import java.util.List;

import static com.fbarrios.dev.galleries.network.AppBase.CATEGORY_BUILDING;

public class BuildingsFragment extends UnsplahFragment {

    public BuildingsFragment() {
    }

    @Override
    public void onStart() {
        super.onStart();
        new BuildingsPhoto().execute(CATEGORY_BUILDING);
    }

    private class BuildingsPhoto extends GetPhotoByCategory {
        @Override
        protected void onPostExecute(List<Unsplash> unsplashes) {
            updateAdapter(unsplashes);
        }
    }
}
