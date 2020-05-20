package com.example.retrofitlist.RestApi;

import com.example.retrofitlist.Models.Data;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RestApi {
    @GET("/demos/marvel/")
    Call<List<Data>> dataGetter();
}
