package com.example.hp.recyclerviewgrid.ApiConnectivity;

import android.content.Context;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient{
    private static final String ROOT_URL = "https://ранобэ.рф";

    private static Retrofit getRetrofitInstance(Context context){
        int cacheSize = 10 * 1024 * 1024;
        Cache cache = new Cache(context.getCacheDir(), cacheSize);
        OkHttpClient okHttpClient = new OkHttpClient.Builder().cache(cache).build();
        return new Retrofit.Builder().baseUrl(ROOT_URL).client(okHttpClient).addConverterFactory(GsonConverterFactory.create()).build();
    }

    public static ApiService getApiService(Context context){
        return getRetrofitInstance(context).create(ApiService.class);
    }
}
