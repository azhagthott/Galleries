package com.fbarrios.dev.galleries.views.fragments;


import com.fbarrios.dev.galleries.background.GetPhotoByCategory;
import com.fbarrios.dev.galleries.models.Unsplash;

import java.util.List;

import static com.fbarrios.dev.galleries.network.AppBase.CATEGORY_FOOD_AND_DRINKS;

public class FoodAndDrinkFragment extends UnsplahFragment {

    public FoodAndDrinkFragment() {
    }

    @Override
    public void onStart() {
        super.onStart();
        new FoodAndDrinkPhoto().execute(CATEGORY_FOOD_AND_DRINKS);
    }

    private class FoodAndDrinkPhoto extends GetPhotoByCategory {
        @Override
        protected void onPostExecute(List<Unsplash> unsplashes) {
            updateAdapter(unsplashes);
        }
    }
}