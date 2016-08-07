package com.example.rajeet.solutions2016;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {

    private Spinner spinner;
    private int ch;

    private String name;
    private String college;
    private String phone;
    private String email;
    private String event;


    EditText tname;
    EditText tcollege;
    EditText tphone;
    EditText temail;
    Button buttonConfirm;

    private boolean fat = false;

    private DatabaseReference mDatabase;
    private DatabaseReference mUser;
    private DatabaseReference mContestant;

    private FirebaseAuth mFirebaseAuth;
    private FirebaseUser mFirebaseUser;

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonConfirm: {
                getValues();

                mContestant = mUser.child(name);
                mContestant.child("Name").setValue(name);
                mContestant.child("College").setValue(college);
                mContestant.child("Phone Number").setValue(phone);
                mContestant.child("Email ID").setValue(email);
                mContestant.child("Event").setValue(event);

                addData();
               // key = mContestant.push().setValue("Full Name").toString();
               // Values v = new Values(name,college,phone,email,event);


                Toast.makeText(this, "Successfully Registered " + name + " for Solutions 2017", Toast.LENGTH_LONG).show();
                startActivity(new Intent(this, RecyActivity.class));
            }
        }
    }

    private String SPARK[] = new String[]{"IC MANIA","AUTOCAD","VULCAN","JUNKYARD","CONTRAPTION"};
    private String PURSUE[] = new String[]{"NAND IT","IMPEDANCE","EMBEDDED MINES","PCB DESIGNING"};
    private String ACHIEVE[] = new String[]{"SYNOPSIS","HACKATHON","CODE RED","DEBUGGING","BLIND CODING"};
    private String COMPETE[] = new String[]{"RAMANUJAN","TECH SUDUKO","CASE STUDY","ROBO RACE","LINE TRACER","PICK N PLACE"};
    private String EXCEL[] = new String[]{"MOVIE MAKING","PHOTOGRAPHY","TECH SNAPHUNT","GAMING EVENTS"};
    ArrayAdapter<String> arrayAdapter;
    private int a[]={200,300,400,500,600};

    public void initSpinner(){
        spinner = (Spinner)findViewById(R.id.spinner);
        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item);
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
      //  Toast.makeText(this,"here",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Bundle bundle = getIntent().getExtras();
        buttonConfirm = (Button) findViewById(R.id.buttonConfirm);
        buttonConfirm.setOnClickListener(this);

        ch = bundle.getInt("K");

        tname = (EditText) findViewById(R.id.textName);
        tcollege = (EditText) findViewById(R.id.textCollege);
        tphone = (EditText) findViewById(R.id.textphone);
        temail = (EditText) findViewById(R.id.textemail);

        mFirebaseAuth = FirebaseAuth.getInstance();
        mFirebaseUser = mFirebaseAuth.getCurrentUser();

        mDatabase = FirebaseDatabase.getInstance().getReference();
       // mUser = mDatabase.push().child(mFirebaseUser.getDisplayName());
        mUser = mDatabase.child(mFirebaseUser.getDisplayName());


        initSpinner();
    }

    private void getValues() {
        name = tname.getText().toString();
        college = tcollege.getText().toString();
        phone = tphone.getText().toString();
        email = temail.getText().toString();
        int i;
        for(i = 0; i < email.length();i++)
        {
            if(email.charAt(i)=='@')
            {
                fat = true;
            }
            /*
            if(email.charAt(i)=='.')
                break;*/
        }
        if(!fat)
        {
            Toast.makeText(this, "Invalid Email Address",Toast.LENGTH_LONG).show();
            temail.setText("");
            temail.requestFocus();
        }
        /*
        if(email.length()-i<2 || fat == false)
        {
            Toast.makeText(this, "Invalid Email Address",Toast.LENGTH_LONG).show();
            temail.setText("");
            temail.requestFocus();
        }*/
        event = spinner.getSelectedItem().toString();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this,"You have to pay Rs "+a[position],Toast.LENGTH_LONG).show();
        event = spinner.getSelectedItem().toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void addData(){
        SharedPreferences sharedPreferences = getSharedPreferences("Registrations Data", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();


        editor.putString("NAME",name);
        editor.putString("COLLEGE",college);
        editor.putString("EVENT",event);
        editor.putString("EMAIL ID",email);
        editor.putString("PHONE NUMBER",phone);

        editor.apply();
    }
}
