package com.example.mobilkartoyunu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //karakterler
    KarakterKarti beyaz = new KarakterKarti("beyaz",2,2,1);
    KarakterKarti sari = new KarakterKarti("sari",1,2,1);
    KarakterKarti yesil = new KarakterKarti("yesil",3,3,3);
    KarakterKarti pembe = new KarakterKarti("pembe",5,7,7);
    KarakterKarti mavi = new KarakterKarti("mavi",8,6,9);
    KarakterKarti kirmizi = new KarakterKarti("kirmizi",5,4,10);
    KarakterKarti lacivert = new KarakterKarti("lacivert",10,3,6);
    KarakterKarti siyah = new KarakterKarti("siyah",4,10,7);
    Buton buton_sari_buyu = new Buton(this, sari,1 );
    GridLayout kartlar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        kartlar=(GridLayout) findViewById(R.id.GridLayout_kartlar);
        kartlar.addView(buton_sari_buyu);
    }
    @Override
    public void onClick(View v){

    }


}