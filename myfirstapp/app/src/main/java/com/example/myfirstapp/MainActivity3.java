package com.example.myfirstapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity3 extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    @BindView(R.id.search) Button search;
    @BindView(R.id.searchresoult) RecyclerView searchresoult;
    @BindView(R.id.inserted_query) EditText insert;
    RecycleSearchResultsAdapater adapter;
    List<String> data_resoults;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        bindUI();
    }
    private void bindUI()
    {
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                CharSequence text = "Sending Query...";
//                int duration = Toast.LENGTH_SHORT;
//                Toast.makeText(MainActivity.this, text, duration).show();
//                new Handler().postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
                String query = insert.getText().toString();
                data_resoults = Collections.nCopies(70, query);
                showResultsInListView(data_resoults);
//                    }
//                }, 1000);
//                Log.d(TAG, "onClick: search");
//            }
//        });

            }
        });
    }
    private void showResultsInListView(List<String> data_resoults)
    {
        adapter = new RecycleSearchResultsAdapater(data_resoults);
        layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        searchresoult.setAdapter(adapter);
        searchresoult.setLayoutManager(layoutManager);

        if(adapter==null)
        {
            adapter = new RecycleSearchResultsAdapater(data_resoults);
            layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
            searchresoult.setAdapter(adapter);
            searchresoult.setLayoutManager(layoutManager);
        }
        else {
            adapter.setResoult(data_resoults);
            adapter.notifyDataSetChanged();
        }
    }
}
