package com.example.mobil_kart_oyunu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SonucActivity extends AppCompatActivity implements View.OnClickListener {

    Button b_tekraroyna;
    TextView tv_sonuc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sonuc);
        b_tekraroyna=(Button)findViewById(R.id.button_tekraroyna);
        b_tekraroyna.setOnClickListener(this);
        tv_sonuc=(TextView)findViewById(R.id.textView_sonuc);
        Intent i=getIntent();
        String kazanan =i.getStringExtra("kazanan");
        if(kazanan.equals("1")){
            tv_sonuc.setText("Kazanan: Oyuncu1 TEBRİKLER KAZANDINIZ");//KAZANAN: OYUNCU1 TEBRİKLER KAZANDINIZ
        }
        else if (kazanan.equals("2")){
            tv_sonuc.setText("Kazanan: Oyuncu2 KAYBETTİNİZ");//KAZANAN: OYUNCU2 KAYBETTİNİZ
        }
    }

    @Override
    public void onClick(View v){
        Intent i=new Intent(SonucActivity.this,MainActivity.class);
        startActivity(i);
    }
}