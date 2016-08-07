package com.example.rajeet.solutions2016;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MyRegistrationsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter recyclerViewAdapter;
    private RecyclerView.LayoutManager recyclerViewManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_registrations);

        recyclerView = (RecyclerView) findViewById(R.id.SVTotal);
        recyclerView.setHasFixedSize(true);

        recyclerViewManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(recyclerViewManager);

        String[] myDataset= {"Sample"};
      /*  recyclerViewAdapter = new MyAdapter(myDataset);
        recyclerView.setAdapter(recyclerViewAdapter);*/

    }

}
