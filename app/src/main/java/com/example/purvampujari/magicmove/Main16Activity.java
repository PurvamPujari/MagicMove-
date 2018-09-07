package com.example.purvampujari.magicmove;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class Main16Activity extends AppCompatActivity {
    ImageView imageView[] = new ImageView[8];
    TextView textView01, textView02, textView03, textView04,add,sub;
    ImageView imageView01,imageView02,imageView03,imageView04;
    ImageView imageButton[] = new ImageView[8];
    LinearLayout ll[] = new LinearLayout[8];String nam,pass;
    LinearLayout lll;
    private FirebaseDatabase fd;
    private FirebaseAuth fa;
    private FirebaseAuth.AuthStateListener asl;
    private DatabaseReference dr,fr;
    Button disapp;
    private String mUsername;
    ValueEventListener cel;
    TextView sc[] = new TextView[8];
    TextView textView[] = new TextView[8];
    TextView round,tt2,timer;
    String str,user;
    String player_name[] = new String[8];
    int comp_number[] = new int[8];
    int score[] = new int[8];
    int rotf, i, r, no_of_rounds = 1, p, st, ed, opt = -1, de, de1 = 0, de2 = 0, de3 = 0, de4 = 0, de0 = 0, elixir_count, jinx_count, felicis_count, kronos_count, e = 0, player_key, jinx_player = 2, j = 0, f = 0;
    HashMap<String, Integer> playmap = new HashMap<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main16);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE);
        p = getIntent().getIntExtra("bot_player", 2);
        r = getIntent().getIntExtra("bot_rounds", 3);
        round = (TextView) findViewById(R.id.round);
        disapp=(Button)findViewById(R.id.disapp);
        imageView[1] = (ImageView) findViewById(R.id.imageView1);
        imageView[2] = (ImageView) findViewById(R.id.imageView2);
        imageView[3] = (ImageView) findViewById(R.id.imageView3);
        imageView[4] = (ImageView) findViewById(R.id.imageView4);
        imageView[5] = (ImageView) findViewById(R.id.imageView5);
        imageView[6] = (ImageView) findViewById(R.id.imageView6);
        imageView[7] = (ImageView) findViewById(R.id.imageView7);
        tt2 = (TextView) findViewById(R.id.tt2);
        timer = (TextView) findViewById(R.id.timer);
        textView[1] = (TextView) findViewById(R.id.textView1);
        textView[2] = (TextView) findViewById(R.id.textView2);
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
        fd = FirebaseDatabase.getInstance();
        fa = FirebaseAuth.getInstance();
        dr = fd.getReference().child("db");
        SharedPreferences sharedPreferences =getSharedPreferences("mydata", Context.MODE_PRIVATE);
        de=sharedPreferences.getInt("default_opt",0);
        user=sharedPreferences.getString("username","");
        nam=getIntent().getStringExtra("nam");
        pass=getIntent().getStringExtra("pass");
        player_name[0] =getIntent().getStringExtra("player_name[0]");
        player_name[1] = getIntent().getStringExtra("player_name[1]");
        player_name[2] = getIntent().getStringExtra("player_name[2]");
        player_name[3] = getIntent().getStringExtra("player_name[3]");
        player_name[4] = getIntent().getStringExtra("player_name[4]");
        player_name[5] = getIntent().getStringExtra("player_name[5]");
        player_name[6] = getIntent().getStringExtra("player_name[6]");
        player_name[7] = getIntent().getStringExtra("player_name[7]");
        for (i = 0; i <= p-1; i++){ if(user.equals(player_name[i])) {player_name[i]=player_name[0]; player_name[0]=user; break;} }
        if(p%2==1){player_name[p]=player_name[1];player_name[1]="";}
        else {player_name[p]="";}
      //  for(i=0;i<=7;i++){add.append(i+" -"+player_name[i]+" ");}
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
            textView[i].setText(player_name[i]);
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
        for (i = st; i <= ed; i++)
            ll[i].setEnabled(false);
    }
    public void ready(View view){
        disapp.setVisibility(View.GONE);
        dr.child(nam).child(pass).child("ready").child(user).setValue("start");
        fr = fd.getReference().child("db").child(nam).child(pass).child("ready");
        cel = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if( dataSnapshot.getChildrenCount()==p) {
                    cd.start();
                }}
            @Override
            public void onCancelled(DatabaseError databaseError) {}};
        fr.addValueEventListener(cel);
    }
    @Override
    public void onBackPressed() {
        return;
    }
    CountDownTimer cd=new CountDownTimer(6590, 1300) {
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
            start1(opt);
        }
    };

    public void start1(final int player_number) {
        cd.cancel();
        no_of_rounds++;
        for (i = 0; i <= 4; i++)
            imageButton[i].setEnabled(false);
        cdt.start();
        cdtt.start();
    }

    CountDownTimer cdtt=  new CountDownTimer(1600, 200) {
        public void onTick(long millisUntilFinished) { }
        public void onFinish() {
            get_data();
        }
    };

    CountDownTimer cdt=  new CountDownTimer(30000, 200) {
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
        }
    };
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
    }

    public void get_data() {
        cdtt.cancel();
        dr.child(nam).child(pass).child("round"+no_of_rounds).child(user).setValue(opt);
        fr = fd.getReference().child("db").child(nam).child(pass).child("round"+no_of_rounds);
        cel = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if( dataSnapshot.getChildrenCount()==p) {
                    for (DataSnapshot userDetails : dataSnapshot.getChildren()) {
                        String pname= userDetails.getKey();
                        int pval = userDetails.getValue(Integer.class);
                        playmap.put(pname,pval);
                        }
                        cdt.cancel();
                    set_pics();
                    player_key = opt;
                    calc(opt);
                }}
            @Override
            public void onCancelled(DatabaseError databaseError) {}};
        fr.addValueEventListener(cel);
    }
    public void set_pics() {
        for (i = st; i <= ed; i++) {
            comp_number[i]=playmap.get(player_name[i]);
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
                if (i == k) {
                    if (i == 0)
                        i = st - 1;
                    else
                        continue;
                } else {
                    if (comp_number[i] == comp_number[k])
                        score[k]++;
                    else if ((comp_number[i] + 1) % 5 == comp_number[k] || (comp_number[i] + 2) % 5 == comp_number[k])
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
        mCountDownTimer.start();
    }
    void nextact(){
        mCountDownTimer.cancel();
        SharedPreferences sharedPreferences = getSharedPreferences("mydata", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("default_opt", de);
        editor.commit();
        final Intent intent = new Intent(this, Main18Activity.class);
        intent.putExtra("player0", score[0]);
        intent.putExtra("player1", score[1]);
        intent.putExtra("player2", score[2]);
        intent.putExtra("player3", score[3]);
        intent.putExtra("player4", score[4]);
        intent.putExtra("player5", score[5]);
        intent.putExtra("player6", score[6]);
        intent.putExtra("player7", score[7]);
        intent.putExtra("player_name[0]", player_name[0]);
        intent.putExtra("player_name[1]", player_name[1]);
        intent.putExtra("player_name[2]", player_name[2]);
        intent.putExtra("player_name[3]", player_name[3]);
        intent.putExtra("player_name[4]", player_name[4]);
        intent.putExtra("player_name[5]", player_name[5]);
        intent.putExtra("player_name[6]", player_name[6]);
        intent.putExtra("player_name[7]", player_name[7]);
        intent.putExtra("bot_player", p);
        startActivity(intent);
        finish();
    }
void rep(){
    mCountDownTimer.cancel();
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
    str = "ROUND  :  " + no_of_rounds;
    if (no_of_rounds != r + 1)
        round.setText(str);
    round.setVisibility(View.VISIBLE);
    opt = -1;
    timer.setTextColor(0xffec4c4c);
    cd.start();
}
        CountDownTimer mCountDownTimer = new CountDownTimer(3000, 900) {
            public void onTick(long millisUntilFinished) {
                timer.setText(" " + millisUntilFinished / 900);
            }
            public void onFinish() {
                timer.setText(" ");
                if (no_of_rounds >= r + 1) {
                    nextact();
                }
                else if(no_of_rounds < r + 1) {
                    rep();
                }
            }
        };
}