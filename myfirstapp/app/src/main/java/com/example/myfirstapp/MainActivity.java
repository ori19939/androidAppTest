package com.example.myfirstapp;

import android.content.Context;
import android.os.Handler;
import android.support.annotation.IdRes;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.format.Time;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    @BindView(R.id.search) Button search;
    @BindView(R.id.searchresoult) RecyclerView searchresoult;
    @BindView(R.id.inserted_query) EditText insert;
    RecycleSearchProductsAdapater adapter;
    List<String> data_resoults;
    ArrayList<Product> products_results;
    RecyclerView.LayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        products_results =new ArrayList<Product>();
        GetData();
        bindUI();
    }
    public void GetData() {
        String json = null;
        try {
            InputStream is = getResources().openRawResource(R.raw.search_json);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
            JSONObject obj = new JSONObject(json);
            JSONArray productList =  obj.getJSONArray("products");
            for(int i = 0; i < productList.length(); i++){
                try {
                    JSONObject value = (JSONObject) productList.get(i);
                    Product item = new Product();
                    item.Product_name = value.get("name").toString();
                    item.Description = value.get("description").toString();
                    item.Price = value.get("price").toString();
                    item.Image_URL = value.get("imageUrl").toString();
                    products_results.add(item);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            int a = 5;
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    private void bindUI()
    {
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String query = insert.getText().toString();
//                data_resoults = Collections.nCopies(70, query);
//                showResultsInListView(data_resoults);
                showProductListView(products_results);
            }
        });
    }
    private void showProductListView(ArrayList<Product> products_results)
    {
        adapter = new RecycleSearchProductsAdapater(this,products_results);
        layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        searchresoult.setAdapter(adapter);
        searchresoult.setLayoutManager(layoutManager);

        if(adapter==null)
        {
            adapter = new RecycleSearchProductsAdapater(this,products_results);
            layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
            searchresoult.setAdapter(adapter);
            searchresoult.setLayoutManager(layoutManager);
        }
        else {
            adapter.setResoult(products_results);
            adapter.notifyDataSetChanged();
        }
    }
//    private void showResultsInListView(List<String> data_resoults)
//    {
//        adapter = new RecycleSearchResultsAdapater(data_resoults);
//        layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
//        searchresoult.setAdapter(adapter);
//        searchresoult.setLayoutManager(layoutManager);
//
//        if(adapter==null)
//        {
//            adapter = new RecycleSearchResultsAdapater(data_resoults);
//            layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
//            searchresoult.setAdapter(adapter);
//            searchresoult.setLayoutManager(layoutManager);
//        }
//        else {
//            adapter.setResoult(data_resoults);
//            adapter.notifyDataSetChanged();
//        }
//    }
}
