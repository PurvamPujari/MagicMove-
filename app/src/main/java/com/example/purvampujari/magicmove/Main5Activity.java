package com.example.purvampujari.magicmove;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main5Activity extends AppCompatActivity {int i=2,j=3,in;
Button bbp[]=new Button[10];
    Button bbr[]=new Button[16];
    TextView tt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE);
        in=getIntent().getIntExtra("in",1);
        tt=(TextView)findViewById(R.id.tt);
        bbp[2]=(Button)findViewById(R.id.bbp2);
        bbp[3]=(Button)findViewById(R.id.bbp3);
        bbp[4]=(Button)findViewById(R.id.bbp4);
        bbp[5]=(Button)findViewById(R.id.bbp5);
        bbp[6]=(Button)findViewById(R.id.bbp6);
        bbp[7]=(Button)findViewById(R.id.bbp7);
        bbp[8]=(Button)findViewById(R.id.bbp8);
        if(in==2){
            tt.setText("PLAYERS  IN  A  GAME ");
            bbp[2].setText("2");
            bbp[3].setText("3");
            bbp[4].setText("4");
            bbp[5].setText("5");
            bbp[6].setText("6");
            bbp[7].setText("7");
            bbp[8].setText("8");
        }
        bbr[3]=(Button)findViewById(R.id.bbr3);
        bbr[5]=(Button)findViewById(R.id.bbr5);
        bbr[7]=(Button)findViewById(R.id.bbr7);
        bbr[10]=(Button)findViewById(R.id.bbr10);
        bbr[15]=(Button)findViewById(R.id.bbr15);
        SharedPreferences sharedPreferences = getSharedPreferences("mydata", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("err",1);
        editor.commit();
    }
    public void bp2(View view){ bbp[i].setTextColor(0xfff5890d);i=2;bbp[i].setTextColor(0xffffd700);}
    public void bp3(View view){ bbp[i].setTextColor(0xfff5890d);i=3;bbp[i].setTextColor(0xffffd700);}
    public void bp4(View view){ bbp[i].setTextColor(0xfff5890d);i=4;bbp[i].setTextColor(0xffffd700);}
    public void bp5(View view){ bbp[i].setTextColor(0xfff5890d);i=5;bbp[i].setTextColor(0xffffd700);}
    public void bp6(View view){ bbp[i].setTextColor(0xfff5890d);i=6;bbp[i].setTextColor(0xffffd700);}
    public void bp7(View view){ bbp[i].setTextColor(0xfff5890d);i=7;bbp[i].setTextColor(0xffffd700);}
    public void bp8(View view){ bbp[i].setTextColor(0xfff5890d);i=8;bbp[i].setTextColor(0xffffd700);}
    public void br3(View view){bbr[j].setTextColor(0xff19b1f7);j=3;bbr[j].setTextColor(0xffffd700);}
    public void br5(View view){ bbr[j].setTextColor(0xff19b1f7);j=5;bbr[j].setTextColor(0xffffd700);}
    public void br7(View view){ bbr[j].setTextColor(0xff19b1f7);j=7;bbr[j].setTextColor(0xffffd700);}
    public void br10(View view){bbr[j].setTextColor(0xff19b1f7);j=10;bbr[j].setTextColor(0xffffd700);}
    public void br15(View view){bbr[j].setTextColor(0xff19b1f7);j=15;bbr[j].setTextColor(0xffffd700);}
    public void next(View view){if(in==1){
        Intent intent = new Intent(this, Main6Activity.class);
        intent.putExtra("bot_player",i);
        intent.putExtra("bot_rounds",j);
        startActivity(intent);
        finish();}
        if(in==2){
            Intent intent = new Intent(this,bic.class);
            intent.putExtra("bot_player",i);
            intent.putExtra("bot_rounds",j);
            startActivity(intent);
            finish();
        }
    }
    }

