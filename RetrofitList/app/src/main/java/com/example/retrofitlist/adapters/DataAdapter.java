package com.example.retrofitlist.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.retrofitlist.Models.Data;
import com.example.retrofitlist.R;

import java.util.List;

public class DataAdapter extends BaseAdapter {
    List<Data> list;
    Context context;

    public DataAdapter(List<Data> list, Context context) {
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
        convertView = LayoutInflater.from(context).inflate(R.layout.layout, parent, false);
        TextView name = (TextView) convertView.findViewById(R.id.name);
        TextView realname = (TextView) convertView.findViewById(R.id.realname);
        TextView team = (TextView) convertView.findViewById(R.id.team);
        TextView firstappearance = (TextView) convertView.findViewById(R.id.firstappearance);
        TextView createdby = (TextView) convertView.findViewById(R.id.createdby);
        TextView publisher = (TextView) convertView.findViewById(R.id.publisher);
        TextView bio = (TextView) convertView.findViewById(R.id.bio);

        name.setText(list.get(position).getName());
        realname.setText(list.get(position).getRealname());
        team.setText(list.get(position).getTeam());
        firstappearance.setText(list.get(position).getFirstappearance());
        createdby.setText(list.get(position).getCreatedby());
        publisher.setText(list.get(position).getPublisher());
        bio.setText(list.get(position).getBio());

        return convertView;
    }
}
