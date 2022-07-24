package com.example.mobilkartoyunu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Activity_Sonuc extends AppCompatActivity implements View.OnClickListener {

    Button b_tekraroyna;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sonc);
        b_tekraroyna=(Button)findViewById(R.id.button_tekraroyna);
        b_tekraroyna.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        Intent i=new Intent(Activity_Sonuc.this,MainActivity.class);//intent yeni bir obje oluşturur. Main activityden game activitye geçiyorum
        startActivity(i);
    }
}