package com.example.retrofitlist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.retrofitlist.Models.Data;
import com.example.retrofitlist.RestApi.ManagerAll;
import com.example.retrofitlist.adapters.DataAdapter;
import com.example.retrofitlist.adapters.FirstDataAdapter;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Welcome extends AppCompatActivity {
    List<Data> list;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        FVBI();
        getImage();

    }

    private void getDetail() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(Welcome.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }


    public void FVBI() {
        listView = (ListView) findViewById(R.id.list_first_view);

    }

    public void getImage() {


        list = new ArrayList<>();
        Call<List<Data>> dataList = ManagerAll.getInstance().getDatas();
        dataList.enqueue(new Callback<List<Data>>() {
            @Override
            public void onResponse(Call<List<Data>> call, Response<List<Data>> response) {
                if (response.isSuccessful()) {
                    list = response.body();
                    FirstDataAdapter firstDataAdapter = new FirstDataAdapter(list, getApplicationContext(),Welcome.this);
                    listView.setAdapter(firstDataAdapter);
                }
            }

            @Override
            public void onFailure(Call<List<Data>> call, Throwable t) {

            }
        });

    }
}
