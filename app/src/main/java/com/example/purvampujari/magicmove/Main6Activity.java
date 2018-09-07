package com.example.purvampujari.magicmove;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Random;

import static com.example.purvampujari.magicmove.R.id.textView2;

public class Main6Activity extends AppCompatActivity {
  static int p9=100;
    ImageView imageView[] = new ImageView[8];
    TextView textView01, textView02, textView03, textView04;
    ImageView imageView01,imageView02,imageView03,imageView04;
    ImageView imageButton[] = new ImageView[8];
    LinearLayout ll[] = new LinearLayout[8];
    LinearLayout lll;
    TextView sc[] = new TextView[8];
    TextView textView[] = new TextView[8];
    TextView round,tt2,timer,ttt1;
    String str;
    Button disapp;
    String player_name[] = new String[8];
    CountDownTimer mCountDownTimer;
    int comp_number[] = new int[8];
    int score[] = new int[8];
    int s, i, r, no_of_rounds = 1, p, st, ed, opt = -1, de, de1 = 0, de2 = 0, de3 = 0, de4 = 0, de0 = 0, elixir_count, jinx_count, felicis_count, kronos_count, e = 0, player_key, jinx_player = 2, j = 0, f = 0;
    static int pp0=0,p0=0;

    long countdownPeriod = 4000,mn=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE);
        p = getIntent().getIntExtra("bot_player", 1);
        r = getIntent().getIntExtra("bot_rounds", 3);
        round = (TextView) findViewById(R.id.round);
        disapp=(Button)findViewById(R.id.disapp);
        imageView01 = (ImageView) findViewById(R.id.imageView01);
        imageView02 = (ImageView) findViewById(R.id.imageView02);
        imageView03 = (ImageView) findViewById(R.id.imageView03);
        imageView04 = (ImageView) findViewById(R.id.imageView04);
        imageView[1] = (ImageView) findViewById(R.id.imageView1);
        imageView[2] = (ImageView) findViewById(R.id.imageView2);
        imageView[3] = (ImageView) findViewById(R.id.imageView3);
        imageView[4] = (ImageView) findViewById(R.id.imageView4);
        imageView[5] = (ImageView) findViewById(R.id.imageView5);
        imageView[6] = (ImageView) findViewById(R.id.imageView6);
        imageView[7] = (ImageView) findViewById(R.id.imageView7);
        tt2 = (TextView) findViewById(R.id.tt2);
        timer = (TextView) findViewById(R.id.timer);
        textView01 = (TextView) findViewById(R.id.textView01);
        textView02 = (TextView) findViewById(R.id.textView02);
        textView03 = (TextView) findViewById(R.id.textView03);
        textView04 = (TextView) findViewById(R.id.textView04);
        textView[1] = (TextView) findViewById(R.id.textView1);
        textView[2] = (TextView) findViewById(textView2);
        textView[3] = (TextView) findViewById(R.id.textView3);
        textView[4] = (TextView) findViewById(R.id.textView4);
        textView[5] = (TextView) findViewById(R.id.textView5);
        textView[6] = (TextView) findViewById(R.id.textView6);
        textView[7] = (TextView) findViewById(R.id.textView7);
        sc[1] = (TextView) findViewById(R.id.s1);
        sc[2] = (TextView) findViewById(R.id.s2);
        sc[3] = (TextView) findViewById(R.id.s3);
        sc[4] = (TextView) findViewById(R.id.s4);
        sc[5] = (TextView) findViewById(R.id.s5);
        sc[6] = (TextView) findViewById(R.id.s6);
        sc[7] = (TextView) findViewById(R.id.s7);
        imageButton[1] = (ImageView) findViewById(R.id.imageButton1);
        imageButton[2] = (ImageView) findViewById(R.id.imageButton2);
        imageButton[3] = (ImageView) findViewById(R.id.imageButton3);
        imageButton[4] = (ImageView) findViewById(R.id.imageButton4);
        imageButton[0] = (ImageView) findViewById(R.id.imageButton0);
        lll = (LinearLayout) findViewById(R.id.lll);
        ll[1] = (LinearLayout) findViewById(R.id.ll1);
        ll[2] = (LinearLayout) findViewById(R.id.ll2);
        ll[3] = (LinearLayout) findViewById(R.id.ll3);
        ll[4] = (LinearLayout) findViewById(R.id.ll4);
        ll[5] = (LinearLayout) findViewById(R.id.ll5);
        ll[6] = (LinearLayout) findViewById(R.id.ll6);
        ll[7] = (LinearLayout) findViewById(R.id.ll7);
        imageView01.setEnabled(false);
        imageView02.setEnabled(false);
        imageView03.setEnabled(false);
        imageView04.setEnabled(false);
        SharedPreferences sharedPreferences =getSharedPreferences("mydata", Context.MODE_PRIVATE);
        de=sharedPreferences.getInt("default_opt",0);
        elixir_count =sharedPreferences.getInt("elixir",15);
        jinx_count =sharedPreferences.getInt("jinx",15);
        kronos_count =sharedPreferences.getInt("kronos",110);
        felicis_count =sharedPreferences.getInt("felicis",15);
        player_name[0] =sharedPreferences.getString("username","");
        player_name[1] = "GIDEON";
        player_name[2] = "UNICRON";
        player_name[3] = "MELISSA";
        player_name[4] = "ALFIE";
        player_name[5] = "ADAM";
        player_name[6] = "PERCY";
        player_name[7] = "LEGION";
        for (int n = 0; n <= 7; n++)
            score[n] = -1;
        if (p % 2 == 1) {
            ll[1].setVisibility(View.GONE);
            st = 2;
            ed = p;
        } else {
            st = 1;
            ed = p - 1;
        }
        score[0] = (p - 1) * r;
        str = "" + score[0];
        tt2.setText(str);
        for (i = st; i <= ed; i++)
            score[i] = (p - 1) * r;
        for (i = st; i <= ed; i++) {
            str = "" + score[i];
            sc[i].setText(str);
        }
        i = 7;
        while (i >= p && p % 2 == 0) {
            ll[i].setVisibility(View.GONE);
            i--;
        }
        while (i > p && p % 2 == 1) {
            ll[i].setVisibility(View.GONE);
            i--;
        }
        for (i = st; i <= ed; i++) {
            ll[i].setBackgroundResource(R.drawable.roundback);
            sc[i].setBackgroundColor(0xff066420);
            textView[i].setBackgroundColor(0xff066420);
            imageView[i].setImageResource(R.drawable.male);}
        for (i = st; i <= ed; i++)
            ll[i].setEnabled(false);
        str = " x" + felicis_count + " ";
        textView02.setText(str);
        str = " x" + elixir_count + " ";
        textView01.setText(str);
        str = " x" + kronos_count + " ";
        textView03.setText(str);
        str = " x" + jinx_count + " ";
        textView04.setText(str);
        for (i = 0; i <= 4; i++)imageButton[i].setPadding(0,0,0,0);
    }
public void startme (View view){
        disapp.setVisibility(View.GONE);
    tm.start();
}
    @Override
    public void onBackPressed() {
        return;
    }


    CountDownTimer tm=  new CountDownTimer(5210, 1300) {

        @Override
        public void onTick(long millisUntilFinished) {
            String h = millisUntilFinished / 1300 + "";
            timer.setText(h);
        }

        @Override
        public void onFinish() {
            timer.setText(" - ");
            if (opt == -1) {
                opt = de;
                for (i = 0; i <= 4; i++)
                {
                    if(i!=de){
                        int dimensionInDp = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 53, getResources().getDisplayMetrics());

                        RelativeLayout.LayoutParams layoutparams = (RelativeLayout.LayoutParams) imageButton[i].getLayoutParams();
                        layoutparams.height = dimensionInDp;
                        layoutparams.width = dimensionInDp;
                        imageButton[i].setLayoutParams(layoutparams);
                        imageButton[i].setScaleType(ImageView.ScaleType.FIT_XY);
                        imageButton[i].setPadding(0,0,0,0);
                    }
                    else{
                        int dimensionInDp = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 68, getResources().getDisplayMetrics());
                        RelativeLayout.LayoutParams layoutparams = (RelativeLayout.LayoutParams) imageButton[i].getLayoutParams();
                        layoutparams.height = dimensionInDp;
                        layoutparams.width = dimensionInDp;
                        imageButton[i].setLayoutParams(layoutparams);
                        imageButton[i].setScaleType(ImageView.ScaleType.FIT_XY);
                        int padInDp = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 4, getResources().getDisplayMetrics());
                        imageButton[i].setPadding(padInDp,padInDp,padInDp,padInDp);
                    }
                }

            }
            start1();
        }
    };

    public void start1() {
tm.cancel();
        round.setVisibility(View.INVISIBLE);
        no_of_rounds++;
        for (i = 0; i <= 4; i++)
            imageButton[i].setEnabled(false);
        cd.start();
    }

    CountDownTimer cd=new CountDownTimer(2300, 200) {

        public void onTick(long millisUntilFinished) {
            switch ((int) (millisUntilFinished / 200) % 5) {
                case 0: {
                    for (i = st; i <= ed; i++)
                        imageView[i].setImageResource(R.drawable.rockt);
                    break;
                }

                case 1: {
                    for (i = st; i <= ed; i++)
                        imageView[i].setImageResource(R.drawable.spockt);
                    break;
                }
                case 2: {
                    for (i = st; i <= ed; i++)
                        imageView[i].setImageResource(R.drawable.papert);
                    break;
                }
                case 3: {
                    for (i = st; i <= ed; i++)
                        imageView[i].setImageResource(R.drawable.lizardt);
                    break;
                }
                case 4: {
                    for (i = st; i <= ed; i++)
                        imageView[i].setImageResource(R.drawable.scissorst);
                    break;
                }
            }
        }

        public void onFinish() {
            get_data();
            set_pics();
            player_key = opt;
            lll.setBackgroundColor(0xffdebf1b);
            timer.setTextColor(0xffdebf1b);
            imageView01.setEnabled(true);
            imageView02.setEnabled(true);
            imageView03.setEnabled(true);
            imageView04.setEnabled(true);
            callc();
        }
    };
    void callc(){
        cd.cancel();countdownPeriod=4500;upd();
    }
    public void c0(View view) {
        de0++;
        for (i = 0; i <= 4; i++)
        {
            if(i!=0){
                int dimensionInDp = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 53, getResources().getDisplayMetrics());

                RelativeLayout.LayoutParams layoutparams = (RelativeLayout.LayoutParams) imageButton[i].getLayoutParams();
                layoutparams.height = dimensionInDp;
                layoutparams.width = dimensionInDp;
                imageButton[i].setLayoutParams(layoutparams);
                imageButton[i].setScaleType(ImageView.ScaleType.FIT_XY);
                imageButton[i].setPadding(0,0,0,0);
            }
            else{
                int dimensionInDp = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 68, getResources().getDisplayMetrics());
                RelativeLayout.LayoutParams layoutparams = (RelativeLayout.LayoutParams) imageButton[i].getLayoutParams();
                layoutparams.height = dimensionInDp;
                layoutparams.width = dimensionInDp;
                imageButton[i].setLayoutParams(layoutparams);
                imageButton[i].setScaleType(ImageView.ScaleType.FIT_XY);
                int padInDp = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 4, getResources().getDisplayMetrics());
                imageButton[i].setPadding(padInDp,padInDp,padInDp,padInDp);
            }
        }
        opt = 0;
        de2 = 0;
        de3 = 0;
        de4 = 0;
        de1 = 0;
        if (de0 == 3)
            de = 0;
        if (e == 1)
            player_key = 0;
        if (f == 1) {
            player_key = 0;
            imageButton[0].setBackgroundColor(0xffdebf1b);
            imageView[jinx_player].setImageResource(R.drawable.rockt);
        }
    }
    public void c2(View view) {
        de2++;
        for (i = 0; i <= 4; i++)
        {
            if(i!=2){
                int dimensionInDp = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 53, getResources().getDisplayMetrics());

                RelativeLayout.LayoutParams layoutparams = (RelativeLayout.LayoutParams) imageButton[i].getLayoutParams();
                layoutparams.height = dimensionInDp;
                layoutparams.width = dimensionInDp;
                imageButton[i].setLayoutParams(layoutparams);
                imageButton[i].setScaleType(ImageView.ScaleType.FIT_XY);
                imageButton[i].setPadding(0,0,0,0);
            }
            else{
                int dimensionInDp = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 68, getResources().getDisplayMetrics());
                RelativeLayout.LayoutParams layoutparams = (RelativeLayout.LayoutParams) imageButton[i].getLayoutParams();
                layoutparams.height = dimensionInDp;
                layoutparams.width = dimensionInDp;
                imageButton[i].setLayoutParams(layoutparams);
                imageButton[i].setScaleType(ImageView.ScaleType.FIT_XY);
                int padInDp = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 4, getResources().getDisplayMetrics());
                imageButton[i].setPadding(padInDp,padInDp,padInDp,padInDp);
            }
        }
        opt = 2;
        de1 = 0;
        de3 = 0;
        de4 = 0;
        de0 = 0;
        if (de2 == 3)
            de = 2;
        if (e == 1)
            player_key = 2;
        if (f == 1) {
            player_key = 2;
            imageButton[2].setBackgroundColor(0xffdebf1b);
            imageView[jinx_player].setImageResource(R.drawable.papert);
        }
    }
    public void c4(View view) {
        de4++;
        for (i = 0; i <= 4; i++)
        {
            if(i!=4){
                int dimensionInDp = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 53, getResources().getDisplayMetrics());

                RelativeLayout.LayoutParams layoutparams = (RelativeLayout.LayoutParams) imageButton[i].getLayoutParams();
                layoutparams.height = dimensionInDp;
                layoutparams.width = dimensionInDp;
                imageButton[i].setLayoutParams(layoutparams);
                imageButton[i].setScaleType(ImageView.ScaleType.FIT_XY);
                imageButton[i].setPadding(0,0,0,0);
            }
            else{
                int dimensionInDp = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 68, getResources().getDisplayMetrics());
                RelativeLayout.LayoutParams layoutparams = (RelativeLayout.LayoutParams) imageButton[i].getLayoutParams();
                layoutparams.height = dimensionInDp;
                layoutparams.width = dimensionInDp;
                imageButton[i].setLayoutParams(layoutparams);
                imageButton[i].setScaleType(ImageView.ScaleType.FIT_XY);
                int padInDp = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 4, getResources().getDisplayMetrics());
                imageButton[i].setPadding(padInDp,padInDp,padInDp,padInDp);
            }
        }
        opt = 4;
        de2 = 0;
        de1 = 0;
        de3 = 0;
        de0 = 0;
        if (de4 == 3)
            de = 4;
        if (e == 1)
            player_key = 4;
        if (f == 1) {
            player_key = 4;
            imageButton[4].setBackgroundColor(0xffdebf1b);
            imageView[jinx_player].setImageResource(R.drawable.scissorst);
        }
    }
    public void c3(View view) {
        de3++;
        for (i = 0; i <= 4; i++)
        {
            if(i!=3){
                int dimensionInDp = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 53, getResources().getDisplayMetrics());
                RelativeLayout.LayoutParams layoutparams = (RelativeLayout.LayoutParams) imageButton[i].getLayoutParams();
                layoutparams.height = dimensionInDp;
                layoutparams.width = dimensionInDp;
                imageButton[i].setLayoutParams(layoutparams);
                imageButton[i].setScaleType(ImageView.ScaleType.FIT_XY);
                imageButton[i].setPadding(0,0,0,0);
            }
            else{
                int dimensionInDp = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 68, getResources().getDisplayMetrics());
                RelativeLayout.LayoutParams layoutparams = (RelativeLayout.LayoutParams) imageButton[i].getLayoutParams();
                layoutparams.height = dimensionInDp;
                layoutparams.width = dimensionInDp;
                imageButton[i].setLayoutParams(layoutparams);
                imageButton[i].setScaleType(ImageView.ScaleType.FIT_XY);
                int padInDp = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 4, getResources().getDisplayMetrics());
                imageButton[i].setPadding(padInDp,padInDp,padInDp,padInDp);
            }
        }
        opt = 3;
        de2 = 0;
        de4 = 0;
        de1 = 0;
        de0 = 0;
        if (de3 == 3)
            de = 3;
        if (e == 1)
            player_key = 3;
        if (f == 1) {
            player_key = 3;
            for (i = 0; i <= 4; i++)
            {
                if(i!=3){
                    int dimensionInDp = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 53, getResources().getDisplayMetrics());
                    RelativeLayout.LayoutParams layoutparams = (RelativeLayout.LayoutParams) imageButton[i].getLayoutParams();
                    layoutparams.height = dimensionInDp;
                    layoutparams.width = dimensionInDp;
                    imageButton[i].setLayoutParams(layoutparams);
                    imageButton[i].setScaleType(ImageView.ScaleType.FIT_XY);
                    imageButton[i].setPadding(0,0,0,0);
                }
                else{
                    int dimensionInDp = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 68, getResources().getDisplayMetrics());
                    RelativeLayout.LayoutParams layoutparams = (RelativeLayout.LayoutParams) imageButton[i].getLayoutParams();
                    layoutparams.height = dimensionInDp;
                    layoutparams.width = dimensionInDp;
                    imageButton[i].setLayoutParams(layoutparams);
                    imageButton[i].setScaleType(ImageView.ScaleType.FIT_XY);
                    int padInDp = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 4, getResources().getDisplayMetrics());
                    imageButton[i].setPadding(padInDp,padInDp,padInDp,padInDp);
                }
            }
            imageView[jinx_player].setImageResource(R.drawable.lizardt);
        }
    }
    public void c1(View view) {
        de1++;
        for (i = 0; i <= 4; i++)
        {
            if(i!=1){
                int dimensionInDp = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 53, getResources().getDisplayMetrics());
                RelativeLayout.LayoutParams layoutparams = (RelativeLayout.LayoutParams) imageButton[i].getLayoutParams();
                layoutparams.height = dimensionInDp;
                layoutparams.width = dimensionInDp;
                imageButton[i].setLayoutParams(layoutparams);
                imageButton[i].setScaleType(ImageView.ScaleType.FIT_XY);
                imageButton[i].setPadding(0,0,0,0);
            }
            else{
                int dimensionInDp = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 68, getResources().getDisplayMetrics());
                RelativeLayout.LayoutParams layoutparams = (RelativeLayout.LayoutParams) imageButton[i].getLayoutParams();
                layoutparams.height = dimensionInDp;
                layoutparams.width = dimensionInDp;
                imageButton[i].setLayoutParams(layoutparams);
                imageButton[i].setScaleType(ImageView.ScaleType.FIT_XY);
                int padInDp = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 4, getResources().getDisplayMetrics());
                imageButton[i].setPadding(padInDp,padInDp,padInDp,padInDp);
            }
        }
        opt = 1;
        de2 = 0;
        de3 = 0;
        de4 = 0;
        de0 = 0;
        if (de1 == 3)
            de = 1;
        if (e == 1)
            player_key = 1;
        if (f == 1) {
            player_key = 1;
            imageButton[1].setBackgroundColor(0xffdebf1b);
            imageView[jinx_player].setImageResource(R.drawable.spockt);
        }
    }
    public void get_data() {
        Random rand = new Random();
        for (i = st; i <= ed; i++)
            comp_number[i] = rand.nextInt(5);
    }
    public void set_pics() {
        for (i = st; i <= ed; i++) {
            switch (comp_number[i]) {
                case 0: {
                    imageView[i].setImageResource(R.drawable.rockt);
                    break;
                }

                case 1: {
                    imageView[i].setImageResource(R.drawable.spockt);
                    break;
                }
                case 2: {
                    imageView[i].setImageResource(R.drawable.papert);
                    break;
                }
                case 3: {
                    imageView[i].setImageResource(R.drawable.lizardt);
                    break;
                }
                case 4: {
                    imageView[i].setImageResource(R.drawable.scissorst);
                    break;
                }
            }
        }
    }

    public void calc(int player_number) {
        comp_number[0] = player_number;
        for (int k = 0; k <= ed; k++) {
            for (i = 0; i <= ed; i++) {
                if (f == 1)
                    comp_number[jinx_player] = player_key;
                if (j == 1) {
                    if (i == jinx_player)
                        continue;
                    if (k == jinx_player)
                        continue;
                }
                if (i == k) {
                    if (i == 0)
                        i = st - 1;
                    else
                        continue;
                } else {
                    if (comp_number[i] == comp_number[k])
                        score[k]++;
                    else if (((comp_number[i] + 1) % 5 == comp_number[k]) ||((comp_number[i] + 2) % 5 == comp_number[k]))
                        score[k] += 2;
                    else
                        score[k]--;
                    if (i == 0)
                        i = st - 1;
                    if (k == 0 && i == ed)
                        k = st - 1;
                }
            }
        }
        for (i = st; i <= ed; i++) {
            str = "" + score[i];
            sc[i].setText(str);
        }
        str = "" + score[0];
        tt2.setText(str);
    }

    public void elixir_call(View view) {
        if (elixir_count > 0) {
            p0++; mCountDownTimer.cancel();countdownPeriod +=4800;upd();
            imageView01.setEnabled(false);
            imageView02.setEnabled(false);
            imageView04.setEnabled(false);
            e = 1;
            elixir_count--;
            str = " x" + elixir_count + " ";
            textView01.setText(str);
            for(i=0;i<=4;i++)
                imageButton[i].setEnabled(true);
        }
    }
    public void felicis_call(View view) {
        if (felicis_count > 0) {
            p0++;mCountDownTimer.cancel();countdownPeriod +=4800;upd();
            imageView01.setEnabled(false);
            imageView02.setEnabled(false);
            imageView04.setEnabled(false);
            f = 1;
            felicis_count--;
            str = " x" + felicis_count + " ";
            textView02.setText(str);
            for (i = st; i <= ed; i++)
                ll[i].setEnabled(true);
        }
    }
    public void kronos_call(View view) {
        if (kronos_count > 0) {
            p0++;mCountDownTimer.cancel();countdownPeriod +=9800;upd();
            kronos_count--;
            str = " x" + kronos_count + " ";
            textView03.setText(str);
        }
    }
    public void jinx_call(View view) {
        if (jinx_count > 0) {
            p0++;mCountDownTimer.cancel();countdownPeriod +=4800;upd();
            imageView01.setEnabled(false);
            imageView02.setEnabled(false);
            j = 1;
            jinx_count--;
            str = " x" + jinx_count + " ";
            textView04.setText(str);
            for (i = st; i <= ed; i++)
                ll[i].setEnabled(true);
        }
    }
    public void call_ll1(View view) {
        ll[1].setBackgroundResource(R.drawable.roundbackgold);
        sc[1].setBackgroundColor(0xffdebf1b);
        textView[1].setBackgroundColor(0xffdebf1b);
        for (i = st; i <= ed; i++)
            ll[i].setEnabled(false);
        if (j == 1) {jinx_player = 1;
            imageView[1].setImageResource(R.drawable.jinxt);
        }
        if (f == 1) {jinx_player = 1;
            imageView[1].setImageResource(R.drawable.zenix);
            for (i = 0; i <= 4; i++)
                imageButton[i].setEnabled(true);
        }
    }
    public void call_ll2(View view) {
        ll[2].setBackgroundResource(R.drawable.roundbackgold);
        sc[2].setBackgroundColor(0xffdebf1b);
        textView[2].setBackgroundColor(0xffdebf1b);
        for (i = st; i <= ed; i++)
            ll[i].setEnabled(false);
        jinx_player = 2;
        if (j == 1)
            imageView[2].setImageResource(R.drawable.jinxt);
        if (f == 1) {
            imageView[2].setImageResource(R.drawable.zenix);
            for (i = 0; i <= 4; i++)
                imageButton[i].setEnabled(true);
        }
    }
    public void call_ll3(View view) {
        ll[3].setBackgroundResource(R.drawable.roundbackgold);
        sc[3].setBackgroundColor(0xffdebf1b);
        textView[3].setBackgroundColor(0xffdebf1b);
        for (i = st; i <= ed; i++)
            ll[i].setEnabled(false);
        jinx_player = 3;
        if (j == 1)
            imageView[3].setImageResource(R.drawable.jinxt);
        if (f == 1) {
            imageView[3].setImageResource(R.drawable.zenix);
            for (i = 0; i <= 4; i++)
                imageButton[i].setEnabled(true);
        }
    }
    public void call_ll4(View view) {
        ll[4].setBackgroundResource(R.drawable.roundbackgold);
        sc[4].setBackgroundColor(0xffdebf1b);
        textView[4].setBackgroundColor(0xffdebf1b);
        for (i = st; i <= ed; i++)
            ll[i].setEnabled(false);
        jinx_player = 4;
        if (j == 1)
            imageView[4].setImageResource(R.drawable.jinxt);
        if (f == 1) {
            imageView[4].setImageResource(R.drawable.zenix);
            for (i = 0; i <= 4; i++)
                imageButton[i].setEnabled(true);
        }
    }
    public void call_ll5(View view) {
        ll[5].setBackgroundResource(R.drawable.roundbackgold);
        sc[5].setBackgroundColor(0xffdebf1b);
        textView[5].setBackgroundColor(0xffdebf1b);
        for (i = st; i <= ed; i++)
            ll[i].setEnabled(false);
        jinx_player = 5;
        if (j == 1)
            imageView[5].setImageResource(R.drawable.jinxt);
        if (f == 1) {
            imageView[5].setImageResource(R.drawable.zenix);
            for (i = 0; i <= 4; i++)
                imageButton[i].setEnabled(true);
        }
    }
    public void call_ll6(View view) {
        ll[6].setBackgroundResource(R.drawable.roundbackgold);
        sc[6].setBackgroundColor(0xffdebf1b);
        textView[6].setBackgroundColor(0xffdebf1b);
        for (i = st; i <= ed; i++)
            ll[i].setEnabled(false);
        jinx_player = 6;
        if (j == 1)
            imageView[6].setImageResource(R.drawable.jinxt);
        if (f == 1) {
            imageView[6].setImageResource(R.drawable.zenix);
            for (i = 0; i <= 4; i++)
                imageButton[i].setEnabled(true);
        }
    }
    public void call_ll7(View view) {
        ll[7].setBackgroundResource(R.drawable.roundbackgold);
        sc[7].setBackgroundColor(0xffdebf1b);
        textView[7].setBackgroundColor(0xffdebf1b);
        for (i = st; i <= ed; i++)
            ll[i].setEnabled(false);
        jinx_player = 7;
        if (j == 1)
            imageView[7].setImageResource(R.drawable.jinxt);
        if (f == 1) {
            imageView[7].setImageResource(R.drawable.zenix);
            for (i = 0; i <= 4; i++)
                imageButton[i].setEnabled(true);
        }
    }

    void nextfin(){

            timer.setText(" " );
            calc(player_key);
            if (no_of_rounds == r + 1) { pp0++;
                ccallend();
            } else {
                for (i = st; i <= ed; i++) {
                    ll[i].setBackgroundResource(R.drawable.roundback);
                    sc[i].setBackgroundColor(0xff066420);
                    textView[i].setBackgroundColor(0xff066420);
                    imageView[i].setImageResource(R.drawable.male);
                }
                for (i = 0; i <= 4; i++)
                {
                    int dimensionInDp = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 68, getResources().getDisplayMetrics());

                    RelativeLayout.LayoutParams layoutparams = (RelativeLayout.LayoutParams) imageButton[i].getLayoutParams();
                    layoutparams.height = dimensionInDp;
                    layoutparams.width = dimensionInDp;
                    imageButton[i].setLayoutParams(layoutparams);
                    imageButton[i].setScaleType(ImageView.ScaleType.FIT_XY);
                    imageButton[i].setPadding(0,0,0,0);
                    imageButton[i].setEnabled(true);
                }
                final Intent intent2 = new Intent(this, Main10Activity.class);
                intent2.putExtra("rou", no_of_rounds);
                //    startActivity(intent2);
                str = "ROUND  :  " + no_of_rounds;
                if (no_of_rounds != r + 1)
                    round.setText(str);
                round.setVisibility(View.VISIBLE);
                opt = -1;
                e = 0;
                j = 0;
                f = 0;
                imageView01.setEnabled(false);
                imageView02.setEnabled(false);
                imageView03.setEnabled(false);
                imageView04.setEnabled(false);
                lll.setBackgroundColor(0xff066420);
                timer.setTextColor(0xffec4c4c);
                repagain();
            }
    }
    void ccallend(){
        mCountDownTimer.cancel();
        final Intent intent = new Intent(this, Main8Activity.class);
        SharedPreferences sharedPreferences = getSharedPreferences("mydata", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("default_opt", de);
        editor.putInt("elixir", elixir_count);
        editor.putInt("felicis", felicis_count);
        editor.putInt("jinx", jinx_count);
        editor.putInt("kronos", kronos_count);
        editor.commit();
        intent.putExtra("player0", score[0]);
        intent.putExtra("player1", score[1]);
        intent.putExtra("player2", score[2]);
        intent.putExtra("player3", score[3]);
        intent.putExtra("player4", score[4]);
        intent.putExtra("player5", score[5]);
        intent.putExtra("player6", score[6]);
        intent.putExtra("player7", score[7]);
        intent.putExtra("bot_player", p);
        startActivity(intent);
        finish();
    }
    void repagain(){
        mCountDownTimer.cancel();tm.start();
    }
    void upd(){
        mCountDownTimer = new CountDownTimer(countdownPeriod, 900) {

            public void onTick(long millisUntilFinished) {
                timer.setText(" " + millisUntilFinished/900);
                countdownPeriod = millisUntilFinished;
            }
            public void onFinish() {
                nextfin();
            }
        }.start();
    }


}