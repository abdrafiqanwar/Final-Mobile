package com.example.h071211029_finalmobile.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.h071211029_finalmobile.API.ApiConfig;
import com.example.h071211029_finalmobile.Category.Shows.Adapter2;
import com.example.h071211029_finalmobile.Category.Shows.DataResponse2;
import com.example.h071211029_finalmobile.Category.Shows.UserResponse2;
import com.example.h071211029_finalmobile.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ShowsFragment extends Fragment {
    RecyclerView rv_shows;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_shows, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rv_shows = view.findViewById(R.id.rv_shows);

        Call<DataResponse2> client = ApiConfig.getApiServiceShows().getPopularShows("ae5cd7931f6fd9401e830cda01590e03");
        client.enqueue(new Callback<DataResponse2>() {
            @Override
            public void onResponse(Call<DataResponse2> call, Response<DataResponse2> response) {
                if (response.isSuccessful()) {
                    ArrayList<UserResponse2> userResponse = response.body().getData2();
                    Adapter2 adapter2 = new Adapter2(userResponse);
                    rv_shows.setLayoutManager(new GridLayoutManager(getActivity(), 2));
                    rv_shows.setAdapter(adapter2);
                }
            }

            @Override
            public void onFailure(Call<DataResponse2> call, Throwable t) {

            }
        });
    }
}