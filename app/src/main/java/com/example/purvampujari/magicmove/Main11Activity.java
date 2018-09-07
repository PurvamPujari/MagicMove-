package com.example.purvampujari.magicmove;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class Main11Activity extends AppCompatActivity {
    TextView textView,textView1,textView2,textView3,textView4,money;
    int co =1;
    String t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main11);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE);
        textView =(TextView)findViewById(R.id.textView);
        textView1 =(TextView)findViewById(R.id.textView1);
        textView2 =(TextView)findViewById(R.id.textView2);
        textView3 =(TextView)findViewById(R.id.textView3);
        textView4 =(TextView)findViewById(R.id.textView4);
        money =(TextView)findViewById(R.id.money);
        SharedPreferences sharedPreferences = getSharedPreferences("mydata", Context.MODE_PRIVATE);
        String st =sharedPreferences.getString("username","");
        int marvel =sharedPreferences.getInt("money",100);
        int elixir =sharedPreferences.getInt("elixir",15);
        int jinx =sharedPreferences.getInt("jinx",15);
        int kronos =sharedPreferences.getInt("kronos",110);
        int felicis =sharedPreferences.getInt("felicis",15);
        textView.setText(st);
        t=""+marvel;
        money.setText(t);
        t=" x"+elixir+" ";
        textView1.setText(t);
        t=" x"+jinx+" ";
        textView2.setText(t);
        t=" x"+kronos+" ";
        textView3.setText(t);
        t=" x"+felicis+" ";
        textView4.setText(t);
    }
    public void hi(View view){
        Intent intent = new Intent(this,Main4Activity.class);
        startActivity(intent);
        finish();
    }
    public void nex(View view){
        Intent intent = new Intent(this,Main4Activity.class);
        startActivity(intent);
        finish();
    }
    public void con(View view) {
        co++;
        if (co == 4) {
            Intent intent = new Intent(this, Main2Activity.class);
            startActivity(intent);
            finish();
        }
    }
}
