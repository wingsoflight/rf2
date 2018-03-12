package com.example.hp.recyclerviewgrid;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient{
    private static final String ROOT_URL = "https://ранобэ.рф";

    private static Retrofit getRetrofitInstance(){
        return new Retrofit.Builder().baseUrl(ROOT_URL).addConverterFactory(GsonConverterFactory.create()).build();
    }

    public static ApiService getApiService(){
        return getRetrofitInstance().create(ApiService.class);
    }
}
