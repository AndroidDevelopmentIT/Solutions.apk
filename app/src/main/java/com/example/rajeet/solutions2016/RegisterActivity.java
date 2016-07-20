package com.example.rajeet.solutions2016;

import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    private Spinner spinner;
    private String SPARK[] = new String[]{"IC MANIA,AUTOCAD,VULCAN,JUNKYARD,CONTRAPTION"};
    private String PURSUE[] = new String[]{"NAND IT,IMPEDANCE,EMBEDDED MINES,PCB DESIGNING"};
    private String ACHIEVE[] = new String[]{"SYNOPSIS,HACKATHON,CODE RED,DEBUGGING,BLIND CODING"};
    private String COMPETE[] = new String[]{"RAMANUJAN,TECH SUDUKO,CASE STUDY,ROBO RACE,LINE TRACER,PICK N PLACE"};
    private String EXCEL[] = new String[]{"MOVIE MAKING,PHOTOGRAPHY,TECH SNAPHUNT,GAMING EVENTS"};
    ArrayAdapter<String> arrayAdapter;
    private int a[]={200,300,400,500,600};

    public void initSpinner(){
        spinner = (Spinner)findViewById(R.id.spinner);
        arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item);
        int ch=6;
        ch=ch%5;
        switch (ch){
            case 0:
                arrayAdapter.addAll(SPARK);break;
            case 1:
                arrayAdapter.addAll(PURSUE);break;
            case 2:
                arrayAdapter.addAll(ACHIEVE);break;
            case 3:
                arrayAdapter.addAll(COMPETE);break;
            case 4:
                arrayAdapter.addAll(EXCEL);break;
        }
        spinner.setAdapter(arrayAdapter);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initSpinner();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this,"You have to pay Rs "+a[position],Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
