package com.fbarrios.dev.galleries.network;

import com.fbarrios.dev.galleries.models.UnsplashUser;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by fbarrios80 on 10-04-17.
 */

public interface GetPublicProfile {

    @GET("users/{user}")
    Call<UnsplashUser> get(@Path("user") String user);

}
