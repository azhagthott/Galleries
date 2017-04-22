package com.fbarrios.dev.galleries.background;

import android.os.AsyncTask;
import android.util.Log;

import com.fbarrios.dev.galleries.models.UnsplashUser;
import com.fbarrios.dev.galleries.network.GetPublicProfile;
import com.fbarrios.dev.galleries.network.UnsplashUserInterceptor;
import com.google.firebase.crash.FirebaseCrash;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by fbarrios80 on 11-04-17.
 */

public class GetUnsplashUserProfile extends AsyncTask<String, Integer, UnsplashUser> {

    @Override
    protected UnsplashUser doInBackground(String... params) {

        GetPublicProfile request = UnsplashUserInterceptor.get();
        Call<UnsplashUser> call = request.get(params[0]);

        UnsplashUser user = new UnsplashUser();

        try {
            Response<UnsplashUser> response = call.execute();

            if (200 == response.code()) {
                Log.d("TAG", "doInBackground: " + response);

                user.setId(response.body().getId());
                user.setUsername(response.body().getUsername());
                user.setName(response.body().getName());
                user.setLocation(response.body().getLocation());
                user.setBio(response.body().getBio());
                user.setProfile_image(response.body().getProfile_image());
                user.setDownloads(response.body().getDownloads());
                user.setTotal_likes(response.body().getTotal_likes());

            } else {
                FirebaseCrash.log("SOME ERROR: " + response.code());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return user;
    }
}