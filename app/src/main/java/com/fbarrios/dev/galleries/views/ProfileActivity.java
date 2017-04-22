package com.fbarrios.dev.galleries.views;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.fbarrios.dev.galleries.R;
import com.fbarrios.dev.galleries.background.GetUnsplashUserProfile;
import com.fbarrios.dev.galleries.models.UnsplashUser;
import com.google.firebase.crash.FirebaseCrash;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileActivity extends AppCompatActivity {

    private String userName;

    private ImageView mainImageView, profileImage;
    private TextView locationTextView, likesTextView, downloadsTextView, bioTextView, nameTextView, userNameTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);

        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            userName = extras.getString("USERNAME");
            new GetProfile().execute(userName);
        }

        findViews();

        final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (fab.getDrawable().getCurrent() == ContextCompat.getDrawable(ProfileActivity.this, R.drawable.ic_favorite_white)) {
                    fab.setImageDrawable(ContextCompat.getDrawable(ProfileActivity.this, R.drawable.ic_favorite_border_white));
                } else {
                    fab.setImageDrawable(ContextCompat.getDrawable(ProfileActivity.this, R.drawable.ic_favorite_white));
                }
            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


    private void findViews() {

        mainImageView = (ImageView) findViewById(R.id.mainImageView);
        profileImage = (CircleImageView) findViewById(R.id.profileImage);
        userNameTextView = (TextView) findViewById(R.id.userNameTextView);
        locationTextView = (TextView) findViewById(R.id.locationTextView);
        likesTextView = (TextView) findViewById(R.id.likesTextView);
        downloadsTextView = (TextView) findViewById(R.id.downloadsTextView);
        bioTextView = (TextView) findViewById(R.id.bioTextView);
        nameTextView = (TextView) findViewById(R.id.nameTextView);
    }

    private class GetProfile extends GetUnsplashUserProfile {

        @Override
        protected void onPostExecute(UnsplashUser unsplashUser) {
            super.onPostExecute(unsplashUser);

            try {
                userNameTextView.setText(userName);

                if (unsplashUser.getLocation() != null && unsplashUser.getLocation().trim().length() > 0) {
                    locationTextView.setText(unsplashUser.getLocation());
                } else {
                    locationTextView.setText(" -- ");
                }

                likesTextView.setText(String.valueOf(unsplashUser.getTotal_likes()));
                downloadsTextView.setText(String.valueOf(unsplashUser.getDownloads()));

                if (unsplashUser.getBio() != null && unsplashUser.getBio().trim().length() > 0) {
                    bioTextView.setText(unsplashUser.getBio());
                } else {
                    bioTextView.setText(" -- ");
                }

                if (unsplashUser.getName() != null && unsplashUser.getName().trim().length() > 0) {
                    nameTextView.setText(unsplashUser.getName());
                } else {
                    nameTextView.setText(" -- ");
                }


                if (unsplashUser.getProfile_image().getLarge() != null && unsplashUser.getProfile_image().getLarge().trim().length() > 0) {
                    Glide.with(ProfileActivity.this)
                            .load(unsplashUser.getProfile_image().getLarge())
                            .diskCacheStrategy(DiskCacheStrategy.ALL)
                            .fitCenter()
                            .centerCrop()
                            .into(profileImage);
                }

                if (unsplashUser.getProfile_image().getLarge() != null && unsplashUser.getProfile_image().getLarge().trim().length() > 0) {
                    Glide.with(ProfileActivity.this)
                            .load(unsplashUser.getProfile_image().getLarge())
                            .diskCacheStrategy(DiskCacheStrategy.ALL)
                            .fitCenter()
                            .centerCrop()
                            .into(mainImageView);
                }
            } catch (Exception e) {
                FirebaseCrash.log("Exception" + e);
            }
        }
    }
}
