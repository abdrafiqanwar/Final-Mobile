package com.example.h071211029_finalmobile.Category.Movies;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class DataResponse1 {
    @SerializedName("results")
    private ArrayList<UserResponse1> data1;

    public ArrayList<UserResponse1> getData1(){
        return data1;
    }
}
