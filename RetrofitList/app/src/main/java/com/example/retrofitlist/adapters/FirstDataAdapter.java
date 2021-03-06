package com.example.retrofitlist.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.retrofitlist.Models.Data;
import com.example.retrofitlist.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class FirstDataAdapter extends BaseAdapter {
    List<Data> list;
    Context context;

    public FirstDataAdapter(List<Data> list, Context context) {
        this.list = list;
        this.context = context;
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);

    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.firstlayout, parent, false);
        TextView name = (TextView) convertView.findViewById(R.id.name);
        name.setText(list.get(position).getName());


        ImageView imageView =  (ImageView) convertView.findViewById(R.id.imageurl);
        Picasso.with(context).load(list.get(position).getImageurl()).into(imageView);



        return convertView;
    }
}
