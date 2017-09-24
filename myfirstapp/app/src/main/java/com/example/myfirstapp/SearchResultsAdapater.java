package com.example.myfirstapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ori on 9/17/2017.
 */
public class SearchResultsAdapater extends BaseAdapter {

    List<String> resoults;
    LayoutInflater layoutInflater;


    public SearchResultsAdapater(Context context, List<String> results) {
        this.resoults = results;
        layoutInflater = LayoutInflater.from(context);
    }
    public void setResoult(List<String> results)
    {
        this.resoults = results;
    }
    @Override
    public int getCount() {
        return resoults == null ? 0 : resoults.size();
    }

    @Override
    public Object getItem(int position)
    {
        return resoults == null ? null : resoults.get(position);
    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
//        View root = layoutInflater.inflate(R.layout.resoult,parent,false);
//        TextView textViewRow = (TextView) root.findViewById(R.id.tv_resoult);
//        String title = (String) getItem(position);
//        textViewRow.setText(title);
//        return root;
        ViewHolder holder;

        if(convertView == null)
        {
            holder = new ViewHolder();
            convertView = layoutInflater.inflate(R.layout.resoult,parent,false);
            holder.textView = (TextView) convertView.findViewById(R.id.tv_resoult);
            convertView.setTag(holder);
        }
        else
        {
            holder = (ViewHolder) convertView.getTag();
        }
        String item = resoults.get(position);
        holder.textView.setText(item + " " + position);
        return convertView;
    }
    public class ViewHolder
    {
        TextView textView;
    }
}

