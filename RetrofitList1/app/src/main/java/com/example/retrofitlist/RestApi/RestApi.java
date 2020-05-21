package com.example.retrofitlist.RestApi;

import com.example.retrofitlist.Models.Data;
import com.example.retrofitlist.Models.Result;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RestApi {
    @GET("/demos/marvel/")
    Call<List<Data>> dataGetter();

    @GET("/demos/marvel/") Call<List<Result>> getResult(@Query("name")String name);


}
