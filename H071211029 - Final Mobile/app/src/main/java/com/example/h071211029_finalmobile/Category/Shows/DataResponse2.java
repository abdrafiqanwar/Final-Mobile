package com.example.h071211029_finalmobile.Category.Shows;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class DataResponse2 {
    @SerializedName("results")
    private ArrayList<UserResponse2> data2;

    public ArrayList<UserResponse2> getData2(){
        return data2;
    }
}
