package com.fbarrios.dev.galleries.views;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;

import com.fbarrios.dev.galleries.R;
import com.fbarrios.dev.galleries.views.fragments.BuildingsFragment;
import com.fbarrios.dev.galleries.views.fragments.FoodAndDrinkFragment;
import com.fbarrios.dev.galleries.views.fragments.NatureFragment;
import com.fbarrios.dev.galleries.views.fragments.PeopleFragment;
import com.fbarrios.dev.galleries.views.fragments.TechnologyFragment;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();

            switch (item.getItemId()) {
                case R.id.navigation_buildings:
                    ft.replace(R.id.content, new BuildingsFragment());
                    ft.commit();
                    return true;
                case R.id.navigation_nature:
                    ft.replace(R.id.content, new NatureFragment());
                    ft.commit();
                    return true;
                case R.id.navigation_food_and_drink:
                    ft.replace(R.id.content, new FoodAndDrinkFragment());
                    ft.commit();
                    return true;
                case R.id.navigation_people:
                    ft.replace(R.id.content, new PeopleFragment());
                    ft.commit();
                    return true;
                case R.id.navigation_technology:
                    ft.replace(R.id.content, new TechnologyFragment());
                    ft.commit();
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setBackgroundColor(ContextCompat.getColor(this, R.color.white));
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        ft.replace(R.id.content, new BuildingsFragment());
        ft.commit();

    }
}