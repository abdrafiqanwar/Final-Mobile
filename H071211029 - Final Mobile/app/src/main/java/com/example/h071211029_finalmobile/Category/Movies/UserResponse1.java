package com.example.h071211029_finalmobile.Category.Movies;

import com.google.gson.annotations.SerializedName;

public class UserResponse1 {
    public UserResponse1(int id, String title, float vote, String overview, String date,
                          String poster, String backdrop){
        this.id = id;
        this.title = title;
        this.vote_average = vote;
        this.overview = overview;
        this.release_date = date;
        this.poster_path = poster;
        this.backdrop_path = backdrop;
    }
    @SerializedName("id")
    private int id;

    @SerializedName("backdrop_path")
    private String backdrop_path;

    public String getBackdrop_path() {
        return backdrop_path;
    }

    @SerializedName("title")
    private String title;

    @SerializedName("overview")
    private String overview;

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getOverview() {
        return overview;
    }

    public float getVote_average() {
        return vote_average;
    }

    public String getRelease_date() {
        return release_date;
    }

    @SerializedName("vote_average")
    private float vote_average;

    @SerializedName("release_date")
    private String release_date;

    public String getPoster_path() {
        return poster_path;
    }

    @SerializedName("poster_path")
    private String poster_path;

}
