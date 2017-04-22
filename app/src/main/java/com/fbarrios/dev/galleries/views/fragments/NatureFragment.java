package com.fbarrios.dev.galleries.views.fragments;


import com.fbarrios.dev.galleries.background.GetPhotoByCategory;
import com.fbarrios.dev.galleries.models.Unsplash;

import java.util.List;

import static com.fbarrios.dev.galleries.network.AppBase.CATEGORY_NATURE;

public class NatureFragment extends UnsplahFragment {

    public NatureFragment() {
    }

    @Override
    public void onStart() {
        super.onStart();
        new NaturePhoto().execute(CATEGORY_NATURE);
    }

    private class NaturePhoto extends GetPhotoByCategory {
        @Override
        protected void onPostExecute(List<Unsplash> unsplashes) {
            updateAdapter(unsplashes);
        }
    }
}