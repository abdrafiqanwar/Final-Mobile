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
import com.example.h071211029_finalmobile.Category.Shows.DetailActivcity2;
import com.example.h071211029_finalmobile.Category.Shows.UserResponse2;
import com.example.h071211029_finalmobile.R;

import java.util.ArrayList;

public class Adapter4 extends RecyclerView.Adapter<Adapter4.ViewHolder> {
    Context context;
    ArrayList<UserResponse2> userResponse2s;
    public Adapter4(Context context, ArrayList<UserResponse2> userResponse2s){
        this.context = context;
        this.userResponse2s = userResponse2s;
    }
    @NonNull
    @Override
    public Adapter4.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_shows, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter4.ViewHolder holder, int position) {
        UserResponse2 userResponse = userResponse2s.get(position);
        holder.tv_title.setText(userResponse.getName());
        holder.tv_date.setText(userResponse.getFirst_air_date());
        String poster = "https://image.tmdb.org/t/p/original" + userResponse.getPoster_path();
        String backdrop = "https://image.tmdb.org/t/p/original" + userResponse.getBackdrop_path();
        Glide.with(holder.iv_poster.getContext()).load(poster).apply(new RequestOptions())
                .override(350, 550).into(holder.iv_poster);
        holder.itemView.setOnClickListener(v -> {
            String data = Float.toString(userResponse.getVote_average());
            Intent intent = new Intent(holder.itemView.getContext(), DetailActivcity2.class);
            intent.putExtra("title", userResponse.getName());
            intent.putExtra("date", userResponse.getFirst_air_date());
            intent.putExtra("popular", data);
            intent.putExtra("synopsis", userResponse.getOverview());
            intent.putExtra("poster", poster);
            intent.putExtra("backdrop", backdrop);
            holder.itemView.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return userResponse2s.size();
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
