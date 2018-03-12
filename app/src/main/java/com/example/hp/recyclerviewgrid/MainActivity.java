package com.example.hp.recyclerviewgrid;

import android.content.Context;
import android.net.ConnectivityManager;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Result> resultList;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter recyclerViewAdapter;
    private RecyclerView.LayoutManager recyclerViewLayoutManager;
    private int limit = 10, offset = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultList = new ArrayList<>();
        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerViewLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(recyclerViewLayoutManager);
        recyclerViewAdapter = new Adapter(resultList, getApplicationContext());
        recyclerView.setAdapter(recyclerViewAdapter);
        if(checkInternet(getApplicationContext())){
            getData("popular", limit, offset);
        }
    }

    boolean checkInternet(@NonNull Context context){
        return ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo() != null;
    }

    void getData(String orderName, int limit, int offset){
        ApiService apiService = RetrofitClient.getApiService();
        Call<Response> responseCall = apiService.getData(orderName, limit, offset);
        responseCall.enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                resultList.addAll(response.body().getResult());
                recyclerView.setAdapter(recyclerViewAdapter);
            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {
                System.out.println(t.toString());
            }
        });
    }
}