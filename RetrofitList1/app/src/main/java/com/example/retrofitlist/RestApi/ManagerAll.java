package com.example.retrofitlist.RestApi;

import com.example.retrofitlist.Models.Data;
import com.example.retrofitlist.Models.Result;

import java.util.List;

import retrofit2.Call;

public class ManagerAll extends BaseManager {
    private static ManagerAll ourInstance = new ManagerAll();

    public static synchronized ManagerAll getInstance() {
        return ourInstance;
    }

    public Call<List<Data>> getDatas() {
        Call<List<Data>> call = getRestApiClient().dataGetter();
        return call;
    }
    public Call<List<Result>> managerGetResult(String name) {
        Call<List<Result>> call = getRestApiClient().getResult(name);
        return call;
    }

}
