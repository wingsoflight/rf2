package com.example.hp.recyclerviewgrid.ApiConnectivity;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient{
    private static final String ROOT_URL = "https://xn--80ac9aeh6f.xn--p1ai";

    private static Retrofit getRetrofitInstance(){
        OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(15, TimeUnit.SECONDS).readTimeout(15, TimeUnit.SECONDS).build();
        return new Retrofit.Builder().baseUrl(ROOT_URL).client(okHttpClient).addConverterFactory(GsonConverterFactory.create()).build();
    }

    public static ApiService getApiService(){
        return getRetrofitInstance().create(ApiService.class);
    }
}
