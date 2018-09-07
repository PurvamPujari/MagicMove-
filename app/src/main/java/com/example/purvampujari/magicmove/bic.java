package com.example.purvampujari.magicmove;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class bic extends AppCompatActivity {
    int rounds,player,ro=-1,pl=-1,ppp=-1;
    private FirebaseDatabase fd;
    private FirebaseAuth fa;  String nam,pass;
    private FirebaseAuth.AuthStateListener asl;
    private DatabaseReference dr,fr;
    private String mUsername;
    ValueEventListener cel;
    EditText editText2,editText3;
    String player_name[] = new String[8];
    String user,move="1";
    int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bic);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE);
        player_name[0] ="ME";
        player_name[1] = "GIDEON";
        player_name[2] = "UNICRON";
        player_name[3] = "MELISSA";
        player_name[4] = "ALFIE";
        player_name[5] = "ADAM";
        player_name[6] = "PERCY";
        player_name[7] = "LEGION";
        SharedPreferences sharedPreferences =getSharedPreferences("mydata", Context.MODE_PRIVATE);
        editText2=(EditText)findViewById(R.id.editText2);
        editText3=(EditText)findViewById(R.id.editText3);
        user=sharedPreferences.getString("username","");
        player = getIntent().getIntExtra("bot_player", 2);
        rounds = getIntent().getIntExtra("bot_rounds", 3);
        fd = FirebaseDatabase.getInstance();
        fa = FirebaseAuth.getInstance();
        dr = fd.getReference().child("db");
    }
    public void ok1(View view) {
        nam= editText2.getText().toString();
        pass= editText3.getText().toString();
        dr.child(nam).child(pass).child("user").child(user).setValue("p_create");
        dr.child(nam).child(pass).child("rounds").setValue(rounds);
        dr.child(nam).child(pass).child("players").setValue(player);
        crep();
        fr = fd.getReference().child("db").child(nam).child(pass).child("user");
        DatabaseReference playdr = dr.child(nam).child(pass).child("players");
        playdr.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                pl  = dataSnapshot.getValue(Integer.class);
                DatabaseReference rounddr = dr.child(nam).child(pass).child("rounds");
                rounddr.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        ro  = dataSnapshot.getValue(Integer.class); rounds=ro;player=pl;
                        cel = new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                if( dataSnapshot.getChildrenCount()==pl) {i=0;
                                    for (DataSnapshot userDetails : dataSnapshot.getChildren()) {
                                        player_name[i] = userDetails.getKey();
                                     //   textView1.append(" "+i+" -"+player_name[i]+"- ");
                                   if(i==pl-1)  {l();break;
                                   }       i++;
                                         } }}
                            @Override
                            public void onCancelled(DatabaseError databaseError) {}};
                        fr.addValueEventListener(cel);

                    }
                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                    }  });
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }  });
    }
    public void ok(View view) {
        nam= editText2.getText().toString();
        pass= editText3.getText().toString();
        dr.child(nam).child(pass).child("user").child(user).setValue("p_join");
        fr = fd.getReference().child("db").child(nam).child(pass).child("user");
        joip();
        DatabaseReference playdr = dr.child(nam).child(pass).child("players");
        playdr.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                pl  = dataSnapshot.getValue(Integer.class);
                DatabaseReference rounddr = dr.child(nam).child(pass).child("rounds");
                rounddr.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        ro  = dataSnapshot.getValue(Integer.class); rounds=ro;player=pl;
                        cel = new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                if( dataSnapshot.getChildrenCount()==pl) {i=0;
                                    for (DataSnapshot userDetails : dataSnapshot.getChildren()) {
                                        player_name[i] = userDetails.getKey();
                                        if(i==pl-1)  {
                                      l();break;
                                        }       i++;
                                    } }}
                            @Override
                            public void onCancelled(DatabaseError databaseError) {}};
                        fr.addValueEventListener(cel);

                    }
                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                    }  });
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }  });


    }
void crep(){
    Toast.makeText(this," Created a team ! ",Toast.LENGTH_SHORT).show();
    Toast.makeText(this," Waiting for the rest of the players to join ...",Toast.LENGTH_SHORT).show();
}
    void joip(){
        Toast.makeText(this," Joined to the team ! ",Toast.LENGTH_SHORT).show();
        Toast.makeText(this," Waiting for the rest of the players to join ...",Toast.LENGTH_SHORT).show();
    }
    public void l(){
        Intent intent = new Intent(this,Main16Activity.class);
        intent.putExtra("player_name[0]",player_name[0]);
        intent.putExtra("player_name[1]",player_name[1]);
        intent.putExtra("player_name[2]",player_name[2]);
        intent.putExtra("player_name[3]",player_name[3]);
        intent.putExtra("player_name[4]",player_name[4]);
        intent.putExtra("player_name[5]",player_name[5]);
        intent.putExtra("player_name[6]",player_name[6]);
        intent.putExtra("player_name[7]",player_name[7]);
        intent.putExtra("bot_rounds",rounds);
        intent.putExtra("bot_player",player);
        intent.putExtra("nam",nam);
        intent.putExtra("pass",pass);
        startActivity(intent);
        finish();
    }
/* void   j(){
  new CountDownTimer(2000,200){
      @Override
      public void onTick(long millisUntilFinished) {
      }
      @Override
      public void onFinish() {
textView2.setText("hi");
          for(i=0;i<=7;i++) {textView2.append(i+" -"+player_name[i]+" ");}
      }
  }    .start();
    }
    */
}
