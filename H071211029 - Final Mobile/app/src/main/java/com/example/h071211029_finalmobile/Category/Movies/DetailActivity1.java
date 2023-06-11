package com.example.h071211029_finalmobile.Category.Movies;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.h071211029_finalmobile.Database.DatabaseHelper;
import com.example.h071211029_finalmobile.MainActivity;
import com.example.h071211029_finalmobile.R;

public class DetailActivity1 extends AppCompatActivity {
    ImageView iv_backdrop, btn_back, btn_favorite, iv_poster, iv_star;
    TextView tv_title, tv_date, tv_popular, tv_synopsis;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail1);
        iv_backdrop = findViewById(R.id.iv_backdrop);
        btn_back = findViewById(R.id.btn_back);
        btn_favorite = findViewById(R.id.btn_favorite);
        iv_poster = findViewById(R.id.iv_poster);
        iv_star = findViewById(R.id.iv_star);
        tv_title = findViewById(R.id.tv_title);
        tv_date = findViewById(R.id.tv_date);
        tv_popular = findViewById(R.id.tv_popular);
        tv_synopsis = findViewById(R.id.tv_synopsis);

        String title = getIntent().getStringExtra("title");
        String date = getIntent().getStringExtra("date");
        String popular = getIntent().getStringExtra("popular");
        String synopsis = getIntent().getStringExtra("synopsis");
        String poster = getIntent().getStringExtra("poster");
        String backdrop = getIntent().getStringExtra("backdrop");

        tv_title.setText(title);
        tv_date.setText(date);
        tv_popular.setText(popular);
        tv_synopsis.setText(synopsis);
        Glide.with(iv_poster.getContext()).load(poster).apply(new RequestOptions())
                .override(350, 550).into(iv_poster);
        Glide.with(iv_backdrop.getContext()).load(backdrop).apply(new RequestOptions())
                .override(350, 550).into(iv_backdrop);

        btn_back.setOnClickListener(v -> {
            finish();
        });

        btn_favorite.setOnClickListener(v -> {
            DatabaseHelper databaseHelper = new DatabaseHelper(getApplicationContext());
            databaseHelper.addMovies(title, popular, synopsis, date, poster, backdrop);
            Toast.makeText(this, title + " added to favorites succesfully", Toast.LENGTH_SHORT).show();
        });
    }
}