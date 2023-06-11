package com.example.h071211029_finalmobile.Category.Favorite;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.h071211029_finalmobile.Category.Movies.DetailActivity1;
import com.example.h071211029_finalmobile.Category.Movies.UserResponse1;
import com.example.h071211029_finalmobile.Category.Shows.UserResponse2;
import com.example.h071211029_finalmobile.R;

import java.util.ArrayList;

public class Adapter3 extends RecyclerView.Adapter<Adapter3.ViewHolder> {
    Context context;
    ArrayList<UserResponse1> userResponse1s;
    public Adapter3(Context context, ArrayList<UserResponse1> userResponse1s) {
        this.context = context;
        this.userResponse1s = userResponse1s;
    }

    @NonNull
    @Override
    public Adapter3.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter3.ViewHolder holder, int position) {
        UserResponse1 userResponse = userResponse1s.get(position);
        holder.tv_title.setText(userResponse.getTitle());
        holder.tv_date.setText(userResponse.getRelease_date());
        String poster = "https://image.tmdb.org/t/p/original" + userResponse.getPoster_path();
        String backdrop = "https://image.tmdb.org/t/p/original" + userResponse.getBackdrop_path();
        Glide.with(holder.iv_poster.getContext()).load(poster).apply(new RequestOptions())
                .override(350, 550).into(holder.iv_poster);
        holder.itemView.setOnClickListener(v -> {
            String data = Float.toString(userResponse.getVote_average());
            Intent intent = new Intent(holder.itemView.getContext(), DetailActivity1.class);
            intent.putExtra("title", userResponse.getTitle());
            intent.putExtra("date", userResponse.getRelease_date());
            intent.putExtra("popular", data);
            intent.putExtra("synopsis", userResponse.getOverview());
            intent.putExtra("poster", poster);
            intent.putExtra("backdrop", backdrop);
            holder.itemView.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return userResponse1s.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView iv_poster;
        TextView tv_title, tv_date;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_poster = itemView.findViewById(R.id.iv_poster);
            tv_title = itemView.findViewById(R.id.tv_title);
            tv_date = itemView.findViewById(R.id.tv_date);
        }
    }
}
