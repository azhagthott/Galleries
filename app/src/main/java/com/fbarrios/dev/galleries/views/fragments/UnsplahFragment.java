package com.fbarrios.dev.galleries.views.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fbarrios.dev.galleries.R;
import com.fbarrios.dev.galleries.adapter.PhotosByCategoriesAdapter;
import com.fbarrios.dev.galleries.models.Unsplash;

import java.util.List;

/**
 * Created by fbarrios80 on 21-04-17.
 */

public class UnsplahFragment extends Fragment {

    private PhotosByCategoriesAdapter adapter;

    public UnsplahFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_unsplash, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = (RecyclerView) view;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new PhotosByCategoriesAdapter();
        recyclerView.setAdapter(adapter);
    }

    protected void updateAdapter(List<Unsplash> unsplashes) {
        adapter.update(unsplashes);
    }
}
