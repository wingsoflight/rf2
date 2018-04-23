package com.example.hp.recyclerviewgrid;

import android.content.Context;
import android.net.ConnectivityManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.example.hp.recyclerviewgrid.Adapters.Adapter;
import com.example.hp.recyclerviewgrid.ApiConnectivity.ApiService;
import com.example.hp.recyclerviewgrid.ApiConnectivity.RetrofitClient;
import com.example.hp.recyclerviewgrid.Entities.Response;
import com.example.hp.recyclerviewgrid.Entities.Result;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;

public class MainActivity extends AppCompatActivity {
    HashMap<String, Integer> genres;
    private ArrayList<Result> resultList;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter recyclerViewAdapter;
    private LinearLayoutManager recyclerViewLayoutManager;
    private ProgressBar progressBar;
    private int limit = 15, offset = 0, threshold = 3;
    int visibleItemCount, totalItemCount, pastVisibleItems;
    boolean loading = false;
    private String orderName = "popular";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        if(checkInternet(getApplicationContext())){
            getData(orderName, limit, offset);
        }
    }

    boolean checkInternet(@NonNull Context context){
        return ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo() != null;
    }

    void getData(String orderName, final int limit, final int offset){
        ApiService apiService = RetrofitClient.getApiService();
        Call<Response> responseCall = apiService.getData(orderName, limit, offset);
        responseCall.enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                onLoad(response);
            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {
                onError(t);
            }
        });
    }


    void init(){
        resultList = new ArrayList<>();
        genres = new HashMap<>();
        recyclerView = findViewById(R.id.recyclerView);
        progressBar = findViewById(R.id.mainListProgressBar);
        recyclerView.setHasFixedSize(true);
        recyclerViewLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(recyclerViewLayoutManager);
        recyclerViewAdapter = new Adapter(resultList, getApplicationContext());
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.addOnScrollListener(onScrollListener);
    }

    void onLoad(retrofit2.Response<Response> response){
        resultList.addAll(response.body().getResult());
        if(resultList.size() <= limit) {
            recyclerView.setAdapter(recyclerViewAdapter);
        }
        else{
            recyclerViewAdapter.notifyDataSetChanged();
        }
    }

    void onError(Throwable t){
        t.printStackTrace();

    }

    private RecyclerView.OnScrollListener onScrollListener = new RecyclerView.OnScrollListener() {
        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
            if(dy > 0){
                visibleItemCount = recyclerViewLayoutManager.getChildCount();
                totalItemCount = recyclerViewLayoutManager.getItemCount();
                pastVisibleItems = recyclerViewLayoutManager.findFirstVisibleItemPosition();
                if(!loading){
                    if(visibleItemCount + pastVisibleItems >= totalItemCount - threshold){
                        loading = true;
                        offset += limit;
                        getData(orderName, limit, offset);
                    }
                }
            }
        }
    };
}