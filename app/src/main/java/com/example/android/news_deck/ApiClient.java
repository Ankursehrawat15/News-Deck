package com.example.android.news_deck;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static final String BASE_URL = "Your Base Url Here";
    private static  ApiClient apiClient;
    private static Retrofit retrofit;


    private ApiClient(){
        retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
    }

    public static synchronized ApiClient getInstance(){
        if(apiClient == null){
            apiClient = new ApiClient();
        }
        return apiClient;
    }


    public  ApiInterface getApi(){

        return retrofit.create(ApiInterface.class);
    }




}
