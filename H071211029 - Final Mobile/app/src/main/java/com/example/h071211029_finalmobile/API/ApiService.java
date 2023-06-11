package com.example.h071211029_finalmobile.API;

import com.example.h071211029_finalmobile.Category.Movies.DataResponse1;
import com.example.h071211029_finalmobile.Category.Shows.DataResponse2;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {
    @GET("movie/popular")
    Call<DataResponse1> getPopularMovies(@Query("api_key") String apiKey);

    @GET("tv/popular")
    Call<DataResponse2> getPopularShows(@Query("api_key") String apiKey);
}
