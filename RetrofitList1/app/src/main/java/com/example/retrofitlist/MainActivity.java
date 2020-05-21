package com.example.retrofitlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import com.example.retrofitlist.Models.Data;
import com.example.retrofitlist.Models.Result;
import com.example.retrofitlist.RestApi.ManagerAll;
import com.example.retrofitlist.adapters.DataAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    List<Result> list;
    ListView listView;
    String namee;
    int positionn;
    TextView name, realname, team, firstappearance, createdby, publisher, bio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);
        FVBI();
        get();
        gett();
    }

    public void gett() {
        Bundle bundle = getIntent().getExtras();

        namee = bundle.getString("namee");
        positionn = bundle.getInt("position");
        Log.i("alll", "namee  " + namee);
    }

    public void FVBI() {
        listView = (ListView) findViewById(R.id.list_view);
        name = (TextView) findViewById(R.id.name);
        realname = (TextView) findViewById(R.id.realname);
        team = (TextView) findViewById(R.id.team);
        firstappearance = findViewById(R.id.firstappearance);
        publisher = findViewById(R.id.publisher);
        createdby = findViewById(R.id.createdby);
        bio = findViewById(R.id.bio);

    }

    public void set(List<Result> list, int positionn) {
        name.setText(list.get(positionn).getName());
        realname.setText(list.get(positionn).getRealname());
        team.setText(list.get(positionn).getTeam());
        firstappearance.setText(list.get(positionn).getFirstappearance());
        publisher.setText(list.get(positionn).getPublisher());
        createdby.setText(list.get(positionn).getCreatedby());
        bio.setText(list.get(positionn).getBio());

    }

    public void get() {
        list = new ArrayList<>();
        Call<List<Result>> dataList = ManagerAll.getInstance().managerGetResult(namee);
        dataList.enqueue(new Callback<List<Result>>() {
            @Override
            public void onResponse(Call<List<Result>> call, Response<List<Result>> response) {
                if (response.isSuccessful()) {
                    list = response.body();
                    set(list, positionn);
                }
            }

            @Override
            public void onFailure(Call<List<Result>> call, Throwable t) {

            }
        });


    }

}
