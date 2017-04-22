package com.fbarrios.dev.galleries.network;

import com.fbarrios.dev.galleries.models.Unsplash;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by fbarrios80 on 11-04-17.
 */

public interface Collections {

    @GET("collections/featured")
    Call<List<Unsplash>> get();
}
