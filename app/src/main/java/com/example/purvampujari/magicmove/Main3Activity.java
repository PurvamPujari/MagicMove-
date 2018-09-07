package com.example.purvampujari.magicmove;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class Main3Activity extends AppCompatActivity {
ImageView imageViewp,imageView;
    CountDownTimer cd,ppp;
    long k=1000000,p=1000000,i=0,j=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE);
        imageViewp = (ImageView) findViewById(R.id.imageViewp);
        imageView = (ImageView) findViewById(R.id.imageView);
        ppp= new CountDownTimer(p, 10) {

            @Override
            public void onTick(long millisUntilFinished) {
                imageView.setRotation(imageView.getRotation()+1);
            }

            @Override
            public void onFinish() {
p=100000;
            }
        }.start();
       cd= new CountDownTimer(k, 350) {

            public void onTick(long millisUntilFinished) {
                switch ((int) (millisUntilFinished / 350) % 5) {
                    case 0: {
                        imageViewp.setImageResource(R.drawable.rockt);

                        break;
                    }

                    case 1: {
                        imageViewp.setImageResource(R.drawable.spockt);
                        break;
                    }
                    case 2: {
                        imageViewp.setImageResource(R.drawable.papert);
                        break;
                    }
                    case 3: {
                        imageViewp.setImageResource(R.drawable.lizardt);
                        break;
                    }
                    case 4: {
                        imageViewp.setImageResource(R.drawable.scissorst);
                        break;
                    }
                }
            }
            public void onFinish() {
                k=1000000;
cd.start();
            }
        };
        cd.start();
    }
    public void stop_flip(View view){if(j==1) {j=0;cd.start();}
    else if(j==0) {j=1;cd.cancel();}
    }
    public void stop_rot(View view){if(i==1) {i=0;ppp.start();}
        else if(i==0) {i=1;ppp.cancel();}
    }
    public void typ(View view){
        Intent intent = new Intent(this,Main11Activity.class);
        startActivity(intent);
    }

    public void tuto(View view){
        Intent intent = new Intent(this,Main9Activity.class);
        startActivity(intent);
    }
    public void tu(View view){
        Intent intent = new Intent(this,Main12Activity.class);
        startActivity(intent);
    }
}
