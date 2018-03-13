package com.example.hp.recyclerviewgrid;

import android.content.Context;
import android.net.ConnectivityManager;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Result> resultList;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter recyclerViewAdapter;
    private LinearLayoutManager recyclerViewLayoutManager;
    private int limit = 10, offset = 0;
    int visibleItemCount, totalItemCount, pastVisibleItems;
    boolean loading = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultList = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerViewLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(recyclerViewLayoutManager);
        recyclerViewAdapter = new Adapter(resultList, getApplicationContext());
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if(dy > 0){
                    visibleItemCount = recyclerViewLayoutManager.getChildCount();
                    totalItemCount = recyclerViewLayoutManager.getItemCount();
                    pastVisibleItems = recyclerViewLayoutManager.findFirstVisibleItemPosition();
                    if(loading){
                        if(visibleItemCount + pastVisibleItems >= totalItemCount){
                            loading = false;
                            offset += limit;
                            getData("popular", limit, offset);
                        }
                    }
                }
            }
        });
        if(checkInternet(getApplicationContext())){
            getData("popular", limit, offset);
        }
    }

    boolean checkInternet(@NonNull Context context){
        return ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo() != null;
    }

    void getData(String orderName, final int limit, int offset){
        ApiService apiService = RetrofitClient.getApiService();
        Call<Response> responseCall = apiService.getData(orderName, limit, offset);
        Log.d("BBB", String.valueOf(limit)+ " " + String.valueOf(offset));
        responseCall.enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                resultList.addAll(response.body().getResult());
                if(resultList.size() <= limit) {
                    recyclerView.setAdapter(recyclerViewAdapter);
                }
                else{
                    recyclerViewAdapter.notifyDataSetChanged();
                }
                loading = true;
            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {
                System.out.println(t.toString());
            }
        });
    }
}