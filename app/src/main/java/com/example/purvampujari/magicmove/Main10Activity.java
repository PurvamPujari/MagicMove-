package com.example.purvampujari.magicmove;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Main10Activity extends AppCompatActivity {
TextView round;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main10);
        round=(TextView)findViewById(R.id.round);
        int rou=getIntent().getIntExtra("rou",1);
        String r=" R O U N D  :  "+rou+"  ";
        round.setText(r);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE);
        Thread timerThread = new Thread(){
            public void run(){
                try{
                    sleep(2200);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }finally{
                    finish();
                }
            }
        };
        timerThread.start();
    }}