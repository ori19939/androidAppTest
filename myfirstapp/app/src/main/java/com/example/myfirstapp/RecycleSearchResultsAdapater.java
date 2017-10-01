package com.example.myfirstapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by ori on 9/17/2017.
 */
public class RecycleSearchResultsAdapater extends RecyclerView.Adapter<RecycleSearchResultsAdapater.ViewHolder> {
    List<String> query_data;
    public RecycleSearchResultsAdapater(List<String> query_data)
    {
        this.query_data = query_data;
    }
    public void setResoult(List<String> query_data)
    {
        this.query_data = query_data;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View root = LayoutInflater.from(parent.getContext()).inflate(R.layout.resoult,parent,false);
        ImageView imageView =(ImageView) root.findViewById(R.id.iv_image);
        Picasso.with(parent.getContext()).load("http://i.imgur.com/DvpvklR.png").into(imageView);
        return new ViewHolder(root);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(query_data.get(position));
    }

    @Override
    public int getItemCount() {
        return query_data  == null ? 0 :query_data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.tv_resoult);
        }
        public void bind(String resoult_data){
            textView.setText(resoult_data);
        }
    }
}


