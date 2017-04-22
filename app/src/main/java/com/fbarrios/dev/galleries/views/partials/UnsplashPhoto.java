package com.fbarrios.dev.galleries.views.partials;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.fbarrios.dev.galleries.R;
import com.google.firebase.crash.FirebaseCrash;

/**
 * Created by fbarrios80 on 12-04-17.
 */

public class UnsplashPhoto extends FrameLayout {

    private ProgressBar progressBar;
    private ImageView imageView;
    //private RelativeLayout relativeLayout;

    public UnsplashPhoto(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public void addViews() {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.partial_unsplash_photo, this, true);
        //relativeLayout = (RelativeLayout) view;
        progressBar = (ProgressBar) view.findViewById(R.id.photoProgressBar);
        imageView = (ImageView) view.findViewById(R.id.photoImageView);
    }

    /*public RelativeLayout getIt(){
        return relativeLayout;
    }*/


    public void setImageWithGlide(String url) {

        Glide.with(getContext())
                .load(url)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .fitCenter()
                .centerCrop()
                .listener(new RequestListener<String, GlideDrawable>() {
                    @Override
                    public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                        Log.d("Exception", "Exception: " + e);
                        FirebaseCrash.log("Exception loading photos");
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                        progressBar.animate().alpha(0).setDuration(200).start();
                        progressBar.setVisibility(GONE);
                        imageView.animate().alpha(1).setDuration(200).start();
                        return false;
                    }
                })
                .into(imageView);
    }
}
