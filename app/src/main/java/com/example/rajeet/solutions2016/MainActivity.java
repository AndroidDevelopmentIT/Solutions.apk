package com.example.rajeet.solutions2016;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Thread timer=new Thread(){
            public void run(){
                try{
                    sleep(2500);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                finally {
                    Intent openLogin = new Intent(MainActivity.this,LoginActivity.class);
                    startActivity(openLogin);
                }
            }
        };
        timer.start();
    }
}
