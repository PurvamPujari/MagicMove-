package com.example.purvampujari.magicmove;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE);
        TextView bol = (TextView) findViewById(R.id.textView);
        Animation anim = new AlphaAnimation(0.0f, 1.0f);
        anim.setDuration(450); //You can manage the blinking time with this parameter
        anim.setStartOffset(20);
        anim.setRepeatMode(Animation.REVERSE);
        anim.setRepeatCount(Animation.INFINITE);
        bol.startAnimation(anim);
    }
    public void reg(View view){
        SharedPreferences sharedPreferences = getSharedPreferences("mydata", Context.MODE_PRIVATE);
        if(sharedPreferences.getBoolean("activity_executed", false)){
            Intent intent = new Intent(this,Main3Activity.class);
            startActivity(intent);
            finish();
        } else {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean("activity_executed", true);
            editor.putInt("money",100);
            editor.commit();
            Intent intent = new Intent(this,Main2Activity.class);
            startActivity(intent);
            finish();
        }

    }
}
