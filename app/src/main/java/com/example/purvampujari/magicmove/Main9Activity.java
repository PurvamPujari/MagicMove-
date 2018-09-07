package com.example.purvampujari.magicmove;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class Main9Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main9);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE);
    }
    public void bbsi(View view){
        Toast.makeText(this," S C I S S O R S ",Toast.LENGTH_SHORT).show();
    }
    public void bbl(View view){
        Toast.makeText(this," L I Z A R D ",Toast.LENGTH_SHORT).show();
    }
    public void bbsp(View view){
        Toast.makeText(this," S P O C K ",Toast.LENGTH_SHORT).show();
    }
    public void bbr(View view){
        Toast.makeText(this," R O C K ",Toast.LENGTH_SHORT).show();
    }
    public void bbp(View view){
        Toast.makeText(this," P A P E R ",Toast.LENGTH_SHORT).show();
    }
}
