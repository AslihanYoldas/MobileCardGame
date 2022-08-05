package com.example.mobil_kart_oyunu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    DatabaseReference dbref_kart;
    DatabaseReference dbref_buton;
    ArrayList kartlar=new ArrayList<>();
    ArrayList butonlar=new ArrayList<>();

    ImageButton beyaz_imagebuton_guc;
    ImageButton sari_imagebuton_guc;
    ImageButton yesil_imagebuton_guc;
    ImageButton pembe_imagebuton_guc;
    ImageButton mavi_imagebuton_guc;
    ImageButton kirmizi_imagebuton_guc;
    ImageButton lacivert_imagebuton_guc;
    ImageButton siyah_imagebuton_guc;
    ImageButton beyaz_imagebuton_buyu;
    ImageButton sari_imagebuton_buyu;
    ImageButton yesil_imagebuton_buyu;
    ImageButton pembe_imagebuton_buyu;
    ImageButton mavi_imagebuton_buyu;
    ImageButton kirmizi_imagebuton_buyu;
    ImageButton lacivert_imagebuton_buyu;
    ImageButton siyah_imagebuton_buyu;
    ImageButton beyaz_imagebuton_ikna;
    ImageButton sari_imagebuton_ikna;
    ImageButton yesil_imagebuton_ikna;
    ImageButton pembe_imagebuton_ikna;
    ImageButton mavi_imagebuton_ikna;
    ImageButton kirmizi_imagebuton_ikna;
    ImageButton lacivert_imagebuton_ikna;
    ImageButton siyah_imagebuton_ikna;

    ImageButton[] image_Butonlar={beyaz_imagebuton_guc,beyaz_imagebuton_buyu,beyaz_imagebuton_ikna,sari_imagebuton_buyu,sari_imagebuton_guc,
            sari_imagebuton_ikna,yesil_imagebuton_buyu,yesil_imagebuton_guc,yesil_imagebuton_ikna,pembe_imagebuton_buyu,
            pembe_imagebuton_guc,pembe_imagebuton_ikna, mavi_imagebuton_buyu,mavi_imagebuton_guc,mavi_imagebuton_ikna,
            kirmizi_imagebuton_buyu,kirmizi_imagebuton_guc,kirmizi_imagebuton_ikna,lacivert_imagebuton_buyu,lacivert_imagebuton_guc,
            lacivert_imagebuton_ikna,siyah_imagebuton_buyu,siyah_imagebuton_guc,siyah_imagebuton_ikna};

    TextView tv_metin;
    Buton secilen_hamle; // sonrdan global olarak tanımlanabilir Tıklanan butonu tutan değişken
    AktifKart aktif_kart = new AktifKart();//buton etkilesimi ile secilen karti temsil ediyor "secilen_kart"
    Oyuncu oyuncu1 = new Oyuncu();//oyuncu
    Oyuncu oyuncu2 = new Oyuncu();//bilgisayar
    Buton kazanan_kart;
    boolean oyun_sirasi = true;//true iken oyuncu 1 de false iken oyuncu2 de


    void vb_yaz(String renk,double oz1,double oz2, double oz3 ){
        KarakterKarti kart=new KarakterKarti(renk,oz1,oz2,oz3);
        dbref_kart.push().setValue(kart);
    }

    void vb_yaz( Object k, double  id,double tur){

        Buton buton=new Buton(k,id,tur);
        dbref_buton.push().setValue(buton);
    }

    void vb_oku_kart() {
        dbref_kart.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot kartDatasnap : snapshot.getChildren()) {
                    KarakterKarti k = kartDatasnap.getValue(KarakterKarti.class);
                    kartlar.add(k);
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    void vb_oku_buton() {
        dbref_buton.addValueEventListener(new ValueEventListener(){
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot butonDatasnap : snapshot.getChildren()) {
                    Buton b = butonDatasnap.getValue(Buton.class);
                    butonlar.add(b);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    public void  butonlari_gorunur_gorunmez_yapma( boolean tercih , int indeks) {//Dizinin içindeki görünmesi gereken kartlarin id lerini alıp o kartları arayüzde görünür yapıp diğerlerini görünmez yapmalı

        if (tercih == false) {//Görünmez yapma için
            image_Butonlar[indeks].setVisibility(View.INVISIBLE);
            image_Butonlar[indeks + 1].setVisibility(View.INVISIBLE);
            image_Butonlar[indeks + 2].setVisibility(View.INVISIBLE);
        } else if (tercih == true) {//Görünür yapma için
            image_Butonlar[indeks].setVisibility(View.VISIBLE);
            image_Butonlar[indeks + 1].setVisibility(View.VISIBLE);
            image_Butonlar[indeks + 2].setVisibility(View.VISIBLE);
        }
    }

    public void butonlari_aktif_etme(boolean tercih, int k[]) {
        int id;

        for (int i = 0; i < k.length; i++) {
            id = k[i];
            //id den hangi butona ulaşacağımızı bulmalıyız
            if (id == 1) {
                butonlari_gorunur_gorunmez_yapma(tercih, 0);
                if (tercih == false) {
                    findViewById(R.id.textView).setVisibility(View.INVISIBLE);
                    findViewById(R.id.textView2).setVisibility(View.INVISIBLE);
                    findViewById(R.id.textView3).setVisibility(View.INVISIBLE);
                }else {
                    findViewById(R.id.textView).setVisibility(View.VISIBLE);
                    findViewById(R.id.textView2).setVisibility(View.VISIBLE);
                    findViewById(R.id.textView3).setVisibility(View.VISIBLE);
                }
            } else if (id == 2) {
                butonlari_gorunur_gorunmez_yapma(tercih, 3);
                if (tercih == false) {
                    findViewById(R.id.textView5).setVisibility(View.INVISIBLE);
                    findViewById(R.id.textView4).setVisibility(View.INVISIBLE);
                    findViewById(R.id.textView6).setVisibility(View.INVISIBLE);
                }else {
                    findViewById(R.id.textView5).setVisibility(View.VISIBLE);
                    findViewById(R.id.textView4).setVisibility(View.VISIBLE);
                    findViewById(R.id.textView6).setVisibility(View.VISIBLE);
                }
            } else if (id == 3) {
                butonlari_gorunur_gorunmez_yapma(tercih, 6);
                if (tercih == false) {
                    findViewById(R.id.textView8).setVisibility(View.INVISIBLE);
                    findViewById(R.id.textView7).setVisibility(View.INVISIBLE);
                    findViewById(R.id.textView9).setVisibility(View.INVISIBLE);
                }else {
                    findViewById(R.id.textView8).setVisibility(View.VISIBLE);
                    findViewById(R.id.textView7).setVisibility(View.VISIBLE);
                    findViewById(R.id.textView9).setVisibility(View.VISIBLE);
                }
            } else if (id == 4) {
                butonlari_gorunur_gorunmez_yapma(tercih, 9);
                if (tercih == false) {
                    findViewById(R.id.textView11).setVisibility(View.INVISIBLE);
                    findViewById(R.id.textView10).setVisibility(View.INVISIBLE);
                    findViewById(R.id.textView12).setVisibility(View.INVISIBLE);
                }else {
                    findViewById(R.id.textView11).setVisibility(View.VISIBLE);
                    findViewById(R.id.textView10).setVisibility(View.VISIBLE);
                    findViewById(R.id.textView12).setVisibility(View.VISIBLE);
                }
            } else if (id == 5) {
                butonlari_gorunur_gorunmez_yapma(tercih, 12);
                if (tercih == false) {
                    findViewById(R.id.textView14).setVisibility(View.INVISIBLE);
                    findViewById(R.id.textView13).setVisibility(View.INVISIBLE);
                    findViewById(R.id.textView15).setVisibility(View.INVISIBLE);
                }else {
                    findViewById(R.id.textView14).setVisibility(View.VISIBLE);
                    findViewById(R.id.textView13).setVisibility(View.VISIBLE);
                    findViewById(R.id.textView15).setVisibility(View.VISIBLE);
                }
            } else if (id == 6) {
                butonlari_gorunur_gorunmez_yapma(tercih, 15);
                if (tercih == false) {
                    findViewById(R.id.textView17).setVisibility(View.INVISIBLE);
                    findViewById(R.id.textView16).setVisibility(View.INVISIBLE);
                    findViewById(R.id.textView18).setVisibility(View.INVISIBLE);
                }else {
                    findViewById(R.id.textView17).setVisibility(View.VISIBLE);
                    findViewById(R.id.textView16).setVisibility(View.VISIBLE);
                    findViewById(R.id.textView18).setVisibility(View.VISIBLE);
                }
            } else if (id == 7) {
                butonlari_gorunur_gorunmez_yapma(tercih, 18);
                if (tercih == false) {
                    findViewById(R.id.textView20).setVisibility(View.INVISIBLE);
                    findViewById(R.id.textView19).setVisibility(View.INVISIBLE);
                    findViewById(R.id.textView21).setVisibility(View.INVISIBLE);
                }else {
                    findViewById(R.id.textView20).setVisibility(View.VISIBLE);
                    findViewById(R.id.textView19).setVisibility(View.VISIBLE);
                    findViewById(R.id.textView21).setVisibility(View.VISIBLE);
                }
            } else if (id == 8) {
                butonlari_gorunur_gorunmez_yapma(tercih, 21);
                if (tercih == false) {
                    findViewById(R.id.textView23).setVisibility(View.INVISIBLE);
                    findViewById(R.id.textView22).setVisibility(View.INVISIBLE);
                    findViewById(R.id.textView24).setVisibility(View.INVISIBLE);
                }else {
                    findViewById(R.id.textView23).setVisibility(View.VISIBLE);
                    findViewById(R.id.textView22).setVisibility(View.VISIBLE);
                    findViewById(R.id.textView24).setVisibility(View.VISIBLE);
                }
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbref_kart = FirebaseDatabase.getInstance().getReference().child("kartlar");
        dbref_buton = FirebaseDatabase.getInstance().getReference().child("butonlar");

        tv_metin=(TextView) findViewById(R.id.textView_bilgilendirme);
        //kartlarin arayuz karsiliklari olan butonlarin tanimlamalari
        beyaz_imagebuton_guc = (ImageButton) findViewById(R.id.imageButton2);
        beyaz_imagebuton_guc.setOnClickListener(this);
        beyaz_imagebuton_buyu = (ImageButton) findViewById(R.id.imageButton3);
        beyaz_imagebuton_buyu.setOnClickListener(this);
        beyaz_imagebuton_ikna = (ImageButton) findViewById(R.id.imageButton4);
        beyaz_imagebuton_ikna.setOnClickListener(this);

        mavi_imagebuton_guc = (ImageButton) findViewById(R.id.imageButton5);
        mavi_imagebuton_guc.setOnClickListener(this);
        mavi_imagebuton_buyu = (ImageButton) findViewById(R.id.imageButton6);
        mavi_imagebuton_buyu.setOnClickListener(this);
        mavi_imagebuton_ikna = (ImageButton) findViewById(R.id.imageButton7);
        mavi_imagebuton_ikna.setOnClickListener(this);

        sari_imagebuton_guc = (ImageButton) findViewById(R.id.imageButton8);
        sari_imagebuton_guc.setOnClickListener(this);
        sari_imagebuton_buyu = (ImageButton) findViewById(R.id.imageButton9);
        sari_imagebuton_buyu.setOnClickListener(this);
        sari_imagebuton_ikna = (ImageButton) findViewById(R.id.imageButton10);
        sari_imagebuton_ikna.setOnClickListener(this);

        yesil_imagebuton_guc = (ImageButton) findViewById(R.id.imageButton11);
        yesil_imagebuton_guc.setOnClickListener(this);
        yesil_imagebuton_buyu = (ImageButton) findViewById(R.id.imageButton12);
        yesil_imagebuton_buyu.setOnClickListener(this);
        yesil_imagebuton_ikna = (ImageButton) findViewById(R.id.imageButton13);
        yesil_imagebuton_ikna.setOnClickListener(this);

        pembe_imagebuton_guc = (ImageButton) findViewById(R.id.imageButton14);
        pembe_imagebuton_guc.setOnClickListener(this);
        pembe_imagebuton_buyu = (ImageButton) findViewById(R.id.imageButton15);
        pembe_imagebuton_buyu.setOnClickListener(this);
        pembe_imagebuton_ikna = (ImageButton) findViewById(R.id.imageButton16);
        pembe_imagebuton_ikna.setOnClickListener(this);

        kirmizi_imagebuton_guc = (ImageButton) findViewById(R.id.imageButton17);
        kirmizi_imagebuton_guc.setOnClickListener(this);
        kirmizi_imagebuton_buyu = (ImageButton) findViewById(R.id.imageButton18);
        kirmizi_imagebuton_buyu.setOnClickListener(this);
        kirmizi_imagebuton_ikna = (ImageButton) findViewById(R.id.imageButton19);
        kirmizi_imagebuton_ikna.setOnClickListener(this);

        lacivert_imagebuton_guc = (ImageButton) findViewById(R.id.imageButton20);
        lacivert_imagebuton_guc.setOnClickListener(this);
        lacivert_imagebuton_buyu = (ImageButton) findViewById(R.id.imageButton21);
        lacivert_imagebuton_buyu.setOnClickListener(this);
        lacivert_imagebuton_ikna = (ImageButton) findViewById(R.id.imageButton22);
        lacivert_imagebuton_ikna.setOnClickListener(this);

        siyah_imagebuton_guc = (ImageButton) findViewById(R.id.imageButton23);
        siyah_imagebuton_guc.setOnClickListener(this);
        siyah_imagebuton_buyu = (ImageButton) findViewById(R.id.imageButton24);
        siyah_imagebuton_buyu.setOnClickListener(this);
        siyah_imagebuton_ikna = (ImageButton) findViewById(R.id.imageButton25);
        siyah_imagebuton_ikna.setOnClickListener(this);

        vb_oku_kart();
        vb_oku_buton();

        //OYUN BASLANGICI
        // rastgele kart dagitimi
        //oyuncu 1 icin baslangic kart dagitimi
        for(int i=0; i<4; i++){
            oyuncu1.kart_al();
        }
        //oyuncu2(bilgisayar) kartları dagitildi
        for(int l=1; l<9 ;l++){//burada "l" aday kart no'yu temsil ediyor
            for(int f=0; f<5 ;f++){
                if(oyuncu1.kartlar[f] != l) {
                    oyuncu2.kart_ayarla(l, true);
                }
                break;
            }
        }

        //butonlari_aktif_etme(false,oyuncu2.kartlar);
    }


    @Override
    public void onClick(View v){

    }



}