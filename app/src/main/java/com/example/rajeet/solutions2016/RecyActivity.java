package com.example.rajeet.solutions2016;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class RecyActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private String nm,co,ev,em,ph;

    ArrayList<MainImages> arrayList;

    public void initViews()
    {

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView1);

        SharedPreferences sharedPreferences = getSharedPreferences("Registrations Data", Context.MODE_PRIVATE);
        nm = sharedPreferences.getString("NAME","");
        co = sharedPreferences.getString("COLLEGE","");
        ev = sharedPreferences.getString("EVENT","");
        em = sharedPreferences.getString("EMAIL ID","");
        ph = sharedPreferences.getString("PHONE NUMBER","");
        MainImages obj1 = new MainImages(nm,co,ev,em,ph);

        arrayList = new ArrayList<>();
        arrayList.add(obj1);


        LinearLayoutManager llm = new LinearLayoutManager(this);
        //GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(llm);
        ImageAdapter imageAdapter = new ImageAdapter(this, arrayList);
        recyclerView.setAdapter(imageAdapter);


    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recy);

        initViews();
        onBackPressed();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(this,EventsActivity.class));
    }
}
