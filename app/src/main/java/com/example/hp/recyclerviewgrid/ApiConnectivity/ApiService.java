package com.example.hp.recyclerviewgrid.ApiConnectivity;

import com.example.hp.recyclerviewgrid.Entities.Response;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by HP on 07.03.2018.
 */

public interface ApiService {
    @GET("v1/book/list")
    Call<Response> getData(@Query("order") String orderName, @Query("limit") int limit, @Query("offset") int offset);
}
