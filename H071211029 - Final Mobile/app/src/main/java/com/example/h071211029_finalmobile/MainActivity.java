package com.example.h071211029_finalmobile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.h071211029_finalmobile.Fragment.FavoriteFragment;
import com.example.h071211029_finalmobile.Fragment.MoviesFragment;
import com.example.h071211029_finalmobile.Fragment.ShowsFragment;

public class MainActivity extends AppCompatActivity {
    TextView tv_toolbar;
    LinearLayout movies, shows, favorite;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_toolbar = findViewById(R.id.tv_toolbar);
        movies = findViewById(R.id.layout_movies);
        shows = findViewById(R.id.layout_shows);
        favorite = findViewById(R.id.layout_favorite);

        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentByTag(MoviesFragment.class.getSimpleName());

        MoviesFragment moviesFragment = new MoviesFragment();
        ShowsFragment showsFragment = new ShowsFragment();
        FavoriteFragment favoriteFragment = new FavoriteFragment();

        if (!(fragment instanceof MoviesFragment)){
            fragmentManager.beginTransaction().add(R.id.frame_container, moviesFragment,
                    MoviesFragment.class.getSimpleName()).commit();
            tv_toolbar.setText("Movies");
        }

        movies.setOnClickListener(v -> {
            fragmentManager.beginTransaction().replace(R.id.frame_container, moviesFragment,
                    MoviesFragment.class.getSimpleName()).commit();
            tv_toolbar.setText("Movies");
        });

        shows.setOnClickListener(v -> {
            fragmentManager.beginTransaction().replace(R.id.frame_container, showsFragment,
                    ShowsFragment.class.getSimpleName()).commit();
            tv_toolbar.setText("TV Shows");
        });

        favorite.setOnClickListener(v -> {
            fragmentManager.beginTransaction().replace(R.id.frame_container, favoriteFragment,
                    FavoriteFragment.class.getSimpleName()).commit();
            tv_toolbar.setText("Favorites");
        });
    }
}