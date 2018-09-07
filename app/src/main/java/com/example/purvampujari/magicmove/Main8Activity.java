package com.example.purvampujari.magicmove;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Main8Activity extends AppCompatActivity {
    LinearLayout ll[] =new LinearLayout[9];
    LinearLayout ll9;
    TextView ttt[]=new TextView[9];
    TextView tt[][]=new TextView[9][3],tt9,money;
    int player[][]= new int[9][3];
    int t,g,mon,marvel;
    String play[] =new String[8],ss;
    int p=0,st,ed,i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE);
        ll[1]=(LinearLayout)findViewById(R.id.ll1);
        ll[2]=(LinearLayout)findViewById(R.id.ll2);
        ll[3]=(LinearLayout)findViewById(R.id.ll3);
        ll[4]=(LinearLayout)findViewById(R.id.ll4);
        ll[5]=(LinearLayout)findViewById(R.id.ll5);
        ll[6]=(LinearLayout)findViewById(R.id.ll6);
        ll[7]=(LinearLayout)findViewById(R.id.ll7);
        ll[8]=(LinearLayout)findViewById(R.id.ll8);
        ttt[1]=(TextView)findViewById(R.id.tt1) ;
        ttt[2]=(TextView)findViewById(R.id.tt2) ;
        ttt[3]=(TextView)findViewById(R.id.tt3) ;
        ttt[4]=(TextView)findViewById(R.id.tt4) ;
        ttt[5]=(TextView)findViewById(R.id.tt5) ;
        ttt[6]=(TextView)findViewById(R.id.tt6) ;
        ttt[7]=(TextView)findViewById(R.id.tt7) ;
        ttt[8]=(TextView)findViewById(R.id.tt8) ;
        tt[1][2]=(TextView)findViewById(R.id.textView12) ;
        tt[2][2]=(TextView)findViewById(R.id.textView22) ;
        tt[3][2]=(TextView)findViewById(R.id.textView32) ;
        tt[4][2]=(TextView)findViewById(R.id.textView42) ;
        tt[5][2]=(TextView)findViewById(R.id.textView52) ;
        tt[6][2]=(TextView)findViewById(R.id.textView62) ;
        tt[7][2]=(TextView)findViewById(R.id.textView72) ;
        tt[8][2]=(TextView)findViewById(R.id.textView82) ;
        tt[1][1]=(TextView)findViewById(R.id.textView11) ;
        tt[2][1]=(TextView)findViewById(R.id.textView21) ;
        tt[3][1]=(TextView)findViewById(R.id.textView31) ;
        tt[4][1]=(TextView)findViewById(R.id.textView41) ;
        tt[5][1]=(TextView)findViewById(R.id.textView51) ;
        tt[6][1]=(TextView)findViewById(R.id.textView61) ;
        tt[7][1]=(TextView)findViewById(R.id.textView71) ;
        tt[8][1]=(TextView)findViewById(R.id.textView81) ;
        tt9=(TextView)findViewById(R.id.textView9) ;
        money=(TextView)findViewById(R.id.money) ;
        p=getIntent().getIntExtra("bot_player",1);
        for(int z=p+1;z<=8;z++) ttt[z].setVisibility(View.GONE);
        SharedPreferences sharedPreferences =getSharedPreferences("mydata", Context.MODE_PRIVATE);
        marvel=sharedPreferences.getInt("money",100);
        play[0]=sharedPreferences.getString("username","");
        play[1]="GIDEON";
        play[2]="UNICORN";
        play[3]="MELISSA";
        play[4]="ALFIE";
        play[5]="ADAM";
        play[6]="PERCY";
        play[7]="LEGION";
        player[0][1]=0;
        player[1][1]=1;
        player[2][1]=2;
        player[3][1]=3;
        player[4][1]=4;
        player[5][1]=5;
        player[6][1]=6;
        player[7][1]=7;
        player[0][2]=getIntent().getIntExtra("player0",0);
        player[1][2]=getIntent().getIntExtra("player1",0);
        player[2][2]=getIntent().getIntExtra("player2",0);
        player[3][2]=getIntent().getIntExtra("player3",0);
        player[4][2]=getIntent().getIntExtra("player4",0);
        player[5][2]=getIntent().getIntExtra("player5",0);
        player[6][2]=getIntent().getIntExtra("player6",0);
        player[7][2]=getIntent().getIntExtra("player7",0);
        for(int h=0;h<=6;h++){
            for(int b=0;b<=6;b++){
                if(player[b][2]<player[b+1][2]){
                    t=player[b][2];
                    player[b][2]=player[b+1][2];
                    player[b+1][2]=t;
                    g=player[b][1];
                    player[b][1]=player[b+1][1];
                    player[b+1][1]=g;
                }
            }
        }
        i=8;
        while(i>p) {
            ll[i].setVisibility(View.GONE);
            i--;
        }
        for(i=1;i<=p;i++) {
            ss = "" + player[i-1][2];
            tt[i][2].setText(ss);
        }
        for(i=1;i<=p;i++) {
            tt[i][1].setText( play[player[i-1][1]]);
            if( play[player[i-1][1]].equals(play[0]))
            {
                ss="YOUR  RANK  IS  "+i;
                tt9.setText(ss);
                    mon=player[i-1][2];
                ss=""+mon;
                money.setText(ss);
                marvel=marvel+mon;
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("money", marvel);
                editor.commit();

            }
        }

    }

    @Override
    public void onBackPressed() {
        return;
    }

    public void done(View view) {
        finishAffinity();

    }
    public void play(View view) {
        Intent intent = new Intent(this, Main4Activity.class);
        startActivity(intent);
        finish();
    }
}

