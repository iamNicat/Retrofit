package com.example.retrofitlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.example.retrofitlist.Models.Data;
import com.example.retrofitlist.RestApi.ManagerAll;
import com.example.retrofitlist.adapters.DataAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    List<Data> list;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FVBI();
        get();
    }
    public  void FVBI(){
        listView =(ListView)findViewById(R.id.list_view);

    }

    public void get() {
        list = new ArrayList<>();
        Call<List<Data>> dataList = ManagerAll.getInstance().getDatas();
        dataList.enqueue(new Callback<List<Data>>() {
            @Override
            public void onResponse(Call<List<Data>> call, Response<List<Data>> response) {
                if(response.isSuccessful()){
                list = response.body();
                    DataAdapter dataAdapter = new DataAdapter(list,getApplicationContext());
                    listView.setAdapter(dataAdapter);
            }}

            @Override
            public void onFailure(Call<List<Data>> call, Throwable t) {

            }
        });


    }
}
