package com.example.android.news_deck.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android.news_deck.API.ArticleModel;
import com.example.android.news_deck.API.Headlines;
import com.example.android.news_deck.ApiClient;
import com.example.android.news_deck.R;
import com.example.android.news_deck.RecyclerView.Adapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SportsFragment extends Fragment {
    RecyclerView recyclerView;
    Adapter adapter;
    List<ArticleModel> articles = new ArrayList<>();
    private final String API_KEY = "Your Api Key Here";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.sports_fragment , null);

        recyclerView = view.findViewById(R.id.sports_recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        retriveJson("in" , API_KEY , "sports");

        return view;
    }

    private void retriveJson(String country , String apiKey , String category) {
        Call<Headlines> call = ApiClient.getInstance().getApi().getHeadlines(country, apiKey, category);
        call.enqueue(new Callback<Headlines>() {
            @Override
            public void onResponse(Call<Headlines> call, Response<Headlines> response) {
                if(response.isSuccessful() && response.body().getArticles() != null){
                    articles.clear();
                    articles = response.body().getArticles();
                    adapter =  new Adapter(getContext() , articles);
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<Headlines> call, Throwable t) {
                Toast.makeText(getContext(), "Failed To Load", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
