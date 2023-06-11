package com.example.h071211029_finalmobile.Category.Shows;

import com.google.gson.annotations.SerializedName;

public class UserResponse2 {
    public UserResponse2(int id, String name, float vote, String overview, String date,
                         String poster, String backdrop){
        this.id = id;
        this.name = name;
        this.vote_average = vote;
        this.overview = overview;
        this.first_air_date = date;
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

    @SerializedName("name")
    private String name;

    @SerializedName("overview")
    private String overview;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getOverview() {
        return overview;
    }

    public float getVote_average() {
        return vote_average;
    }

    public String getFirst_air_date() {
        return first_air_date;
    }

    @SerializedName("vote_average")
    private float vote_average;

    @SerializedName("first_air_date")
    private String first_air_date;

    public String getPoster_path() {
        return poster_path;
    }

    @SerializedName("poster_path")
    private String poster_path;
}
