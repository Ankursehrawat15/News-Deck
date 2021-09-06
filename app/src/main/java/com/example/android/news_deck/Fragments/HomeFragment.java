package com.example.android.news_deck.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android.news_deck.API.ArticleModel;
import com.example.android.news_deck.API.Headlines;
import com.example.android.news_deck.ApiClient;
import com.example.android.news_deck.MainActivity;
import com.example.android.news_deck.R;
import com.example.android.news_deck.RecyclerView.Adapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {

    EditText search_inp;
    Button search_btn;
    RecyclerView recyclerView;
    Adapter adapter;
    List<ArticleModel> articles = new ArrayList<>();
  private   final String API_KEY = "Your Api Key Here";


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      View view = inflater.inflate(R.layout.home_fragment , null);
      search_btn =  view.findViewById(R.id.search_btn);
      search_inp = view.findViewById(R.id.search_input);
      recyclerView = view.findViewById(R.id.home_recyclerView);
      recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

      retriveJson("","in" , API_KEY , "general");

      search_btn.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              if(!search_inp.getText().toString().equals("")){
                  retriveJson(search_inp.getText().toString().toLowerCase(),"in" , API_KEY , "general");
              }else{
                  Toast.makeText(getContext(), "TypeOut what you want to Search", Toast.LENGTH_SHORT).show();
              }
          }
      });

      return view;
    }

    public void retriveJson(String query , String country , String apiKey , String category) {
        Call<Headlines> call;
        if(!query.equals("")){
            call = ApiClient.getInstance().getApi().getSpecificData(query, apiKey);
        }else{
            call = ApiClient.getInstance().getApi().getHeadlines(country, apiKey, category);
        }

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
