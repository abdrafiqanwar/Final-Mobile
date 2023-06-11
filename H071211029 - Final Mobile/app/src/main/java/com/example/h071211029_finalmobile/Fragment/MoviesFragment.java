package com.example.h071211029_finalmobile.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.h071211029_finalmobile.Category.Movies.Adapter1;
import com.example.h071211029_finalmobile.API.ApiConfig;
import com.example.h071211029_finalmobile.Category.Movies.DataResponse1;
import com.example.h071211029_finalmobile.Category.Movies.UserResponse1;
import com.example.h071211029_finalmobile.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MoviesFragment extends Fragment {
    RecyclerView rv_movies;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movies, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        rv_movies = view.findViewById(R.id.rv_movies);

        Call<DataResponse1> client = ApiConfig.getApiServiceMovies().getPopularMovies("ae5cd7931f6fd9401e830cda01590e03");
        client.enqueue(new Callback<DataResponse1>() {
            @Override
            public void onResponse(Call<DataResponse1> call, Response<DataResponse1> response) {
                if (response.isSuccessful()) {
                    ArrayList<UserResponse1> userResponse = response.body().getData1();
                    Adapter1 adapter = new Adapter1(userResponse);
                    rv_movies.setLayoutManager(new GridLayoutManager(getActivity(), 2));
                    rv_movies.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<DataResponse1> call, Throwable t) {
                
            }
        });
    }
}