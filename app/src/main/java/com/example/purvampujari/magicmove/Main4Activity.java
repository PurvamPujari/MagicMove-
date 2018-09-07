package com.example.purvampujari.magicmove;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Main4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE);
    }

    public void bot(View view) {
        Intent intent2 = new Intent(this, Main5Activity.class);
        intent2.putExtra("in",1);
        startActivity(intent2);
    }
    public void net(View view) {
        Intent intent = new Intent(this, Main5Activity.class);
        intent.putExtra("in",2);
        startActivity(intent);
    }
}
