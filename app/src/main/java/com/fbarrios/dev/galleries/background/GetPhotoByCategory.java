package com.fbarrios.dev.galleries.background;

import android.os.AsyncTask;

import com.fbarrios.dev.galleries.models.Unsplash;
import com.fbarrios.dev.galleries.models.UnsplashUrls;
import com.fbarrios.dev.galleries.models.UnsplashUser;
import com.fbarrios.dev.galleries.network.PhotoByCategory;
import com.fbarrios.dev.galleries.network.PhotoByCategoryInterceptor;
import com.google.firebase.crash.FirebaseCrash;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by fbarrios80 on 11-04-17.
 */

public class GetPhotoByCategory extends AsyncTask<Integer, Integer, List<Unsplash>> {

    @Override
    protected List<Unsplash> doInBackground(Integer... params) {

        PhotoByCategory request = PhotoByCategoryInterceptor.get();
        Call<List<Unsplash>> call = request.get(params[0]);

        List<Unsplash> list = new ArrayList<>();

        try {
            Response<List<Unsplash>> response = call.execute();

            if (200 == response.code()) {
                for (int i = 0; i < response.body().size(); i++) {

                    UnsplashUrls urls = response.body().get(i).getUrls();
                    //String color = response.body().get(i).getColor();
                    UnsplashUser user = response.body().get(i).getUser();
                    list.add(i, new Unsplash(urls, user));
                }
            } else {
                FirebaseCrash.log("SOME ERROR: " + response.code());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;
    }
}