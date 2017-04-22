package com.fbarrios.dev.galleries.views.fragments;


import com.fbarrios.dev.galleries.background.GetPhotoByCategory;
import com.fbarrios.dev.galleries.models.Unsplash;

import java.util.List;

import static com.fbarrios.dev.galleries.network.AppBase.CATEGORY_PEOPLE;

public class PeopleFragment extends UnsplahFragment {

    public PeopleFragment() {
    }

    @Override
    public void onStart() {
        super.onStart();
        new PeoplePhoto().execute(CATEGORY_PEOPLE);
    }

    private class PeoplePhoto extends GetPhotoByCategory {
        @Override
        protected void onPostExecute(List<Unsplash> unsplashes) {
            updateAdapter(unsplashes);
        }
    }
}