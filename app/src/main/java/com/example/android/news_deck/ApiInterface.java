package com.example.android.news_deck;

import com.example.android.news_deck.API.Headlines;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("top-headlines")
    Call<Headlines> getHeadlines(
          @Query("country") String country,
          @Query("apiKey") String apiKey,
          @Query("category") String category
    );

    // for searching purpose
    @GET("everything")
    Call<Headlines> getSpecificData(
            @Query("q") String query,
            @Query("apiKey") String apiKey
    );




}
