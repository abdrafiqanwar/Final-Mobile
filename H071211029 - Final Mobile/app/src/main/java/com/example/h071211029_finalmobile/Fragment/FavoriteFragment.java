package com.example.h071211029_finalmobile.Fragment;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.h071211029_finalmobile.Category.Favorite.Adapter3;
import com.example.h071211029_finalmobile.Category.Favorite.Adapter4;
import com.example.h071211029_finalmobile.Category.Movies.UserResponse1;
import com.example.h071211029_finalmobile.Category.Shows.UserResponse2;
import com.example.h071211029_finalmobile.Database.DatabaseContract;
import com.example.h071211029_finalmobile.Database.DatabaseHelper;
import com.example.h071211029_finalmobile.MainActivity;
import com.example.h071211029_finalmobile.R;

import java.util.ArrayList;

public class FavoriteFragment extends Fragment {
    RecyclerView rv1, rv2;
    DatabaseHelper databaseHelper;
    ArrayList<UserResponse1> userResponse1s;
    ArrayList<UserResponse2> userResponse2s;
    Adapter3 adapter3;
    Adapter4 adapter4;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favorite, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rv1 = view.findViewById(R.id.rv1);
        rv2 = view.findViewById(R.id.rv2);

        databaseHelper = new DatabaseHelper(getContext());
        userResponse1s = new ArrayList<>();
        userResponse2s = new ArrayList<>();

        storeData1();
        storeData2();

        adapter3 = new Adapter3(getContext(), userResponse1s);
        rv1.setAdapter(adapter3);
        rv1.setLayoutManager(new LinearLayoutManager(getContext()));

        adapter4 = new Adapter4(getContext(), userResponse2s);
        rv2.setAdapter(adapter4);
        rv2.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    void storeData1() {
        Cursor cursor = databaseHelper.readAllData();
        if (cursor.getCount() == 0) {
            Toast.makeText(getContext(), "No Data", Toast.LENGTH_SHORT).show();
        } else {
            while (cursor.moveToNext()) {
                int id = cursor.getInt(cursor.getColumnIndexOrThrow(DatabaseContract.TaskColumns._ID));
                String title = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseContract.TaskColumns.TITLE));
                float vote = cursor.getFloat(cursor.getColumnIndexOrThrow(DatabaseContract.TaskColumns.VOTE_AVERAGE));
                String overview = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseContract.TaskColumns.OVERVIEW));
                String date1 = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseContract.TaskColumns.RELEASE_DATE));
                String date2 = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseContract.TaskColumns.FIRST_AIR_DATE));
                String poster = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseContract.TaskColumns.POSTER_PATH));
                String backdrop = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseContract.TaskColumns.BACKDROP_PATH));
                userResponse1s.add(new UserResponse1(id, title, vote, overview, date1, poster, backdrop));
            }
        }
    }

    void storeData2() {
        Cursor cursor = databaseHelper.readAllData();
        if (cursor.getCount() == 0) {
            Toast.makeText(getContext(), "No Data", Toast.LENGTH_SHORT).show();
        } else {
            while (cursor.moveToNext()) {
                int id = cursor.getInt(cursor.getColumnIndexOrThrow(DatabaseContract.TaskColumns._ID));
                String name = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseContract.TaskColumns.NAME));
                float vote = cursor.getFloat(cursor.getColumnIndexOrThrow(DatabaseContract.TaskColumns.VOTE_AVERAGE));
                String overview = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseContract.TaskColumns.OVERVIEW));
                String date2 = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseContract.TaskColumns.FIRST_AIR_DATE));
                String poster = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseContract.TaskColumns.POSTER_PATH));
                String backdrop = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseContract.TaskColumns.BACKDROP_PATH));
                userResponse2s.add(new UserResponse2(id, name, vote, overview, date2, poster, backdrop));
            }
        }
    }
}