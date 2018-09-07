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

public class Main2Activity extends AppCompatActivity {
EditText editText;
    String hi ="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE);
        editText =(EditText)findViewById(R.id.editText);
    }
    public void sho(View view){
        if(hi.equals(editText.getText().toString()))
            Toast.makeText(this,"enter username",Toast.LENGTH_SHORT).show();
        else {
            SharedPreferences sharedPreferences = getSharedPreferences("mydata", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            String st = editText.getText().toString();
            editor.putString("username", st);
            editor.putInt("err",1);
            editor.commit();
            Intent intent = new Intent(this, Main11Activity.class);
            startActivity(intent);
            finish();
        }
    }
}
