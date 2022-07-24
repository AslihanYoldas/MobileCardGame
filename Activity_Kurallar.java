package com.example.mobilkartoyunu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Activity_Kurallar extends AppCompatActivity implements View.OnClickListener {

    Button b_basla;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kurallar);
        b_basla=(Button)findViewById(R.id.button_basla);
        b_basla.setOnClickListener(this);
    }
    @Override
    public void onClick(View v){
        Intent i=new Intent(Activity_Kurallar.this,MainActivity.class);
        startActivity(i);
    }
}