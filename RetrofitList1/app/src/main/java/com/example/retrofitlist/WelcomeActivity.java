package com.example.retrofitlist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.retrofitlist.Models.Data;
import com.example.retrofitlist.RestApi.ManagerAll;
import com.example.retrofitlist.adapters.AdapterRecyclerView;
import com.example.retrofitlist.adapters.FirstDataAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WelcomeActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private AdapterRecyclerView adapterRecyclerView;
    List<Data> list;
    //ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        FVBI();
        getImage();

    }


    public void FVBI() {
        //listView = (ListView) findViewById(R.id.list_first_view);
        recyclerView = (RecyclerView) findViewById(R.id.card_recycler_view);
        recyclerView.setHasFixedSize(true);
    }

    public void getImage() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        //list = new ArrayList<>();
        Call<List<Data>> dataList = ManagerAll.getInstance().getDatas();
        dataList.enqueue(new Callback<List<Data>>() {
            @Override
            public void onResponse(Call<List<Data>> call, Response<List<Data>> response) {
                if (response.isSuccessful()) {
                    list = response.body();
                    AdapterRecyclerView adapterRecyclerView = new AdapterRecyclerView((ArrayList<Data>) list, getApplicationContext(), WelcomeActivity.this);
                    recyclerView.setAdapter(adapterRecyclerView);
                }
            }

            @Override
            public void onFailure(Call<List<Data>> call, Throwable t) {

            }
        });

    }
}
