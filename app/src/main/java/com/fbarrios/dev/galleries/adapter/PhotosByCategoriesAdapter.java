package com.fbarrios.dev.galleries.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.fbarrios.dev.galleries.R;
import com.fbarrios.dev.galleries.models.Unsplash;
import com.fbarrios.dev.galleries.views.ProfileActivity;
import com.fbarrios.dev.galleries.views.partials.UnsplashPhoto;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by fbarrios80 on 12-04-17.
 */

public class PhotosByCategoriesAdapter extends RecyclerView.Adapter<PhotosByCategoriesAdapter.ViewHolder> {

    private List<Unsplash> unsplashes = new ArrayList<>();

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.photo_list_items, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        final Context context = holder.mainImageView.getContext();

        Unsplash unsplash = unsplashes.get(position);

        if (unsplash.getUser().getName() != null) {
            holder.authorTextView.setText(unsplash.getUser().getName());
        }

        holder.mainImageView.addViews();
        holder.mainImageView.setImageWithGlide(unsplash.getUrls().getRegular());

        Glide.with(context)
                .load(unsplash.getUser().getProfile_image().getMedium())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .fitCenter()
                .centerCrop()
                .into(holder.profileImage);

        holder.profileImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Unsplash auxUnsplah = unsplashes.get(holder.getAdapterPosition());

                if (auxUnsplah.getUser().getUsername() != null) {
                    Intent intent = new Intent(context, ProfileActivity.class);
                    intent.putExtra("USERNAME", auxUnsplah.getUser().getUsername());
                    v.getContext().startActivity(intent);
                }
            }
        });
    }

    public void update(List<Unsplash> unsplashes) {
        this.unsplashes.addAll(unsplashes);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return unsplashes.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final UnsplashPhoto mainImageView;
        private final TextView authorTextView;
        private final CircleImageView profileImage;

        public ViewHolder(View itemView) {
            super(itemView);
            mainImageView = (UnsplashPhoto) itemView.findViewById(R.id.fullscreenPh);
            authorTextView = (TextView) itemView.findViewById(R.id.authorTextView);
            profileImage = (CircleImageView) itemView.findViewById(R.id.profileImage);
        }
    }
}
