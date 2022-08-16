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
import java.util.logging.Level;
import java.util.logging.Logger;

//berabere kalındığında oyuncu1 in kartlarından azalsın önceki attığı kart
//kazandığında geri gelsin kaybettiğinde zaten gitti

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

    double[] aitlik ={0,0,0,0,0,0,0,0};

    TextView tv_metin;
    TextView tv_sag;
    TextView tv_sag_alt;
    TextView tv_sol;
    TextView tv_sol_alt;
    Buton secilen_hamle; // sonrdan global olarak tanımlanabilir Tıklanan butonu tutan değişken
    AktifKart aktif_kart = new AktifKart();//buton etkilesimi ile secilen karti temsil ediyor "secilen_kart"
    Oyuncu oyuncu1 = new Oyuncu();//oyuncu
    Oyuncu oyuncu2 = new Oyuncu();//bilgisayar
    Buton kazanan_kart=new Buton();
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

                vb_yaz(kartlar.get(0),1,2);
                vb_yaz(kartlar.get(0),1,1);
                vb_yaz(kartlar.get(0),1,3);

                vb_yaz(kartlar.get(1),2,1);
                vb_yaz(kartlar.get(1),2,2);
                vb_yaz(kartlar.get(1),2,3);

                vb_yaz(kartlar.get(2),3,1);
                vb_yaz(kartlar.get(2),3,2);
                vb_yaz(kartlar.get(2),3,3);

                vb_yaz(kartlar.get(3),4,1);
                vb_yaz(kartlar.get(3),4,2);
                vb_yaz(kartlar.get(3),4,3);

                vb_yaz(kartlar.get(4),5,1);
                vb_yaz(kartlar.get(4),5,2);
                vb_yaz(kartlar.get(4),5,3);

                vb_yaz(kartlar.get(5),6,1);
                vb_yaz(kartlar.get(5),6,2);
                vb_yaz(kartlar.get(5),6,3);

                vb_yaz(kartlar.get(6),7,1);
                vb_yaz(kartlar.get(6),7,2);
                vb_yaz(kartlar.get(6),7,3);

                vb_yaz(kartlar.get(7),8,1);
                vb_yaz(kartlar.get(7),8,2);
                vb_yaz(kartlar.get(7),8,3);
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

    public void  butonlari_gorunur_gorunmez_yapma( boolean tercih , ImageButton b1,ImageButton b2,ImageButton b3,TextView tv1,TextView tv2,TextView tv3) {//Dizinin içindeki görünmesi gereken kartlarin id lerini alıp o kartları arayüzde görünür yapıp diğerlerini görünmez yapmalı
        if(b1!=null && tv1!=null) {
            if (tercih == false) {//Görünmez yapma için
                b1.setVisibility(View.INVISIBLE);
                b2.setVisibility(View.INVISIBLE);
                b3.setVisibility(View.INVISIBLE);
                tv1.setVisibility(View.INVISIBLE);
                tv2.setVisibility(View.INVISIBLE);
                tv3.setVisibility(View.INVISIBLE);
            } else if (tercih == true) {//Görünür yapma için
                b1.setVisibility(View.VISIBLE);
                b2.setVisibility(View.VISIBLE);
                b3.setVisibility(View.VISIBLE);
                tv1.setVisibility(View.VISIBLE);
                tv2.setVisibility(View.VISIBLE);
                tv3.setVisibility(View.VISIBLE);
            }
        }
    }

    public void butonlari_aktif_etme(boolean tercih, @NonNull int id) {
        TextView tv1=null;
        TextView tv2=null;
        TextView tv3=null;
        ImageButton b1=null;
        ImageButton b2=null;
        ImageButton b3=null;

        //id den hangi butona ulaşacağımızı bulmalıyız
        if (id == 1) {

            tv1 = (TextView) findViewById(R.id.textView);
            tv2 = (TextView) findViewById(R.id.textView2);
            tv3 = (TextView) findViewById(R.id.textView3);
            b1=beyaz_imagebuton_guc;
            b2=beyaz_imagebuton_buyu;
            b3=beyaz_imagebuton_ikna;


        }
        else if (id == 2) {

            tv1 = (TextView) findViewById(R.id.textView5);
            tv2 = (TextView) findViewById(R.id.textView4);
            tv3 = (TextView) findViewById(R.id.textView6);
            b1=sari_imagebuton_guc;
            b2=sari_imagebuton_buyu;
            b3=sari_imagebuton_ikna;


        } else if (id == 3) {

            tv1 = (TextView) findViewById(R.id.textView8);
            tv2 = (TextView) findViewById(R.id.textView7);
            tv3 = (TextView) findViewById(R.id.textView9);
            b1=yesil_imagebuton_guc;
            b2=yesil_imagebuton_buyu;
            b3=yesil_imagebuton_ikna;


        } else if (id == 4) {

            tv1 = (TextView) findViewById(R.id.textView11);
            tv2 = (TextView) findViewById(R.id.textView10);
            tv3 = (TextView) findViewById(R.id.textView12);
            b1=pembe_imagebuton_guc;
            b2=pembe_imagebuton_buyu;
            b3=pembe_imagebuton_ikna;


        } else if (id == 5) {

            tv1 = (TextView) findViewById(R.id.textView14);
            tv2 = (TextView) findViewById(R.id.textView13);
            tv3 = (TextView) findViewById(R.id.textView15);
            b1=mavi_imagebuton_guc;
            b2=mavi_imagebuton_buyu;
            b3=mavi_imagebuton_ikna;

        } else if (id == 6) {

            tv1 = (TextView) findViewById(R.id.textView17);
            tv2 = (TextView) findViewById(R.id.textView16);
            tv3 = (TextView) findViewById(R.id.textView18);
            b1=kirmizi_imagebuton_guc;
            b2=kirmizi_imagebuton_buyu;
            b3=kirmizi_imagebuton_ikna;


        } else if (id == 7) {

            tv1 = (TextView) findViewById(R.id.textView20);
            tv2 = (TextView) findViewById(R.id.textView19);
            tv3 = (TextView) findViewById(R.id.textView21);
            b1=lacivert_imagebuton_guc;
            b2=lacivert_imagebuton_buyu;
            b3=lacivert_imagebuton_ikna;


        } else if (id == 8) {

            tv1 = (TextView) findViewById(R.id.textView23);
            tv2 = (TextView) findViewById(R.id.textView22);
            tv3 = (TextView) findViewById(R.id.textView24);
            b1=siyah_imagebuton_guc;
            b2=siyah_imagebuton_buyu;
            b3=siyah_imagebuton_ikna;


        }
        try {
            butonlari_gorunur_gorunmez_yapma(tercih, b1,b2,b3,tv1,tv2,tv3);
        } catch (Exception ex) {
            Logger.getLogger(MainActivity.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void onClick(@NonNull View v){

        for(int i=0; i< image_Butonlar.length;i++) {
            if (v.getId() == image_Butonlar[i].getId() && oyun_sirasi == true) {
                secilen_hamle = (Buton) butonlar.get(i);
                break;
            }
        }

        oyun_dongusu();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbref_kart = FirebaseDatabase.getInstance().getReference().child("kartlar");
        dbref_buton = FirebaseDatabase.getInstance().getReference().child("butonlar");
        vb_oku_buton();

        //vb_oku_kart();
        tv_metin=(TextView) findViewById(R.id.textView_bilgilendirme);
        tv_sag=(TextView) findViewById(R.id.ortadaki_kart);
        tv_sag_alt=(TextView) findViewById(R.id.ortadaki_kart2);
        tv_sol=(TextView) findViewById(R.id.ortadaki_kart_eski);
        tv_sol_alt=(TextView) findViewById(R.id.ortadaki_kart_eski2);
        //kartlarin arayuz karsiliklari olan butonlarin tanimlamalari
        beyaz_imagebuton_guc = (ImageButton) findViewById(R.id.imageButton2);
        image_Butonlar[0]=beyaz_imagebuton_guc ;
        beyaz_imagebuton_guc.setOnClickListener(this);
        beyaz_imagebuton_buyu = (ImageButton) findViewById(R.id.imageButton3);
        image_Butonlar[1]=beyaz_imagebuton_buyu ;
        beyaz_imagebuton_buyu.setOnClickListener(this);
        beyaz_imagebuton_ikna = (ImageButton) findViewById(R.id.imageButton4);
        image_Butonlar[2]=beyaz_imagebuton_ikna ;
        beyaz_imagebuton_ikna.setOnClickListener(this);

        mavi_imagebuton_guc = (ImageButton) findViewById(R.id.imageButton5);
        image_Butonlar[12]=mavi_imagebuton_guc ;
        mavi_imagebuton_guc.setOnClickListener(this);
        mavi_imagebuton_buyu = (ImageButton) findViewById(R.id.imageButton6);
        image_Butonlar[13]=mavi_imagebuton_buyu ;
        mavi_imagebuton_buyu.setOnClickListener(this);
        mavi_imagebuton_ikna = (ImageButton) findViewById(R.id.imageButton7);
        image_Butonlar[14]=mavi_imagebuton_ikna ;
        mavi_imagebuton_ikna.setOnClickListener(this);

        sari_imagebuton_guc = (ImageButton) findViewById(R.id.imageButton8);
        image_Butonlar[3]= sari_imagebuton_guc ;
        sari_imagebuton_guc.setOnClickListener(this);
        sari_imagebuton_buyu = (ImageButton) findViewById(R.id.imageButton9);
        image_Butonlar[4]= sari_imagebuton_buyu ;
        sari_imagebuton_buyu.setOnClickListener(this);
        sari_imagebuton_ikna = (ImageButton) findViewById(R.id.imageButton10);
        image_Butonlar[5]= sari_imagebuton_ikna ;
        sari_imagebuton_ikna.setOnClickListener(this);

        yesil_imagebuton_guc = (ImageButton) findViewById(R.id.imageButton11);
        image_Butonlar[6]= yesil_imagebuton_guc ;
        yesil_imagebuton_guc.setOnClickListener(this);
        yesil_imagebuton_buyu = (ImageButton) findViewById(R.id.imageButton12);
        image_Butonlar[7]= yesil_imagebuton_buyu ;
        yesil_imagebuton_buyu.setOnClickListener(this);
        yesil_imagebuton_ikna = (ImageButton) findViewById(R.id.imageButton13);
        image_Butonlar[8]= yesil_imagebuton_ikna ;
        yesil_imagebuton_ikna.setOnClickListener(this);

        pembe_imagebuton_guc = (ImageButton) findViewById(R.id.imageButton14);
        image_Butonlar[9]= pembe_imagebuton_guc ;
        pembe_imagebuton_guc.setOnClickListener(this);
        pembe_imagebuton_buyu = (ImageButton) findViewById(R.id.imageButton15);
        image_Butonlar[10]= pembe_imagebuton_buyu ;
        pembe_imagebuton_buyu.setOnClickListener(this);
        pembe_imagebuton_ikna = (ImageButton) findViewById(R.id.imageButton16);
        image_Butonlar[11]= pembe_imagebuton_ikna ;
        pembe_imagebuton_ikna.setOnClickListener(this);

        kirmizi_imagebuton_guc = (ImageButton) findViewById(R.id.imageButton17);
        image_Butonlar[15]= kirmizi_imagebuton_guc ;
        kirmizi_imagebuton_guc.setOnClickListener(this);
        kirmizi_imagebuton_buyu = (ImageButton) findViewById(R.id.imageButton18);
        image_Butonlar[16]= kirmizi_imagebuton_buyu ;
        kirmizi_imagebuton_buyu.setOnClickListener(this);
        kirmizi_imagebuton_ikna = (ImageButton) findViewById(R.id.imageButton19);
        image_Butonlar[17]= kirmizi_imagebuton_ikna ;
        kirmizi_imagebuton_ikna.setOnClickListener(this);

        lacivert_imagebuton_guc = (ImageButton) findViewById(R.id.imageButton20);
        image_Butonlar[18]= lacivert_imagebuton_guc ;
        lacivert_imagebuton_guc.setOnClickListener(this);
        lacivert_imagebuton_buyu = (ImageButton) findViewById(R.id.imageButton21);
        image_Butonlar[19]= lacivert_imagebuton_buyu ;
        lacivert_imagebuton_buyu.setOnClickListener(this);
        lacivert_imagebuton_ikna = (ImageButton) findViewById(R.id.imageButton22);
        image_Butonlar[20]= lacivert_imagebuton_ikna ;
        lacivert_imagebuton_ikna.setOnClickListener(this);

        siyah_imagebuton_guc = (ImageButton) findViewById(R.id.imageButton23);
        image_Butonlar[21]= siyah_imagebuton_guc ;
        siyah_imagebuton_guc.setOnClickListener(this);
        siyah_imagebuton_buyu = (ImageButton) findViewById(R.id.imageButton24);
        image_Butonlar[22]= siyah_imagebuton_buyu ;
        siyah_imagebuton_buyu.setOnClickListener(this);
        siyah_imagebuton_ikna = (ImageButton) findViewById(R.id.imageButton25);
        image_Butonlar[23]= siyah_imagebuton_ikna ;
        siyah_imagebuton_ikna.setOnClickListener(this);



        //OYUN BASLANGICI
        // rastgele kart dagitimi
        //oyuncu 1 icin baslangic kart dagitimi
        boolean var_mi= false;
        for(int i=0; i<4; i++){
            double ait=oyuncu1.kart_al();
            aitlik[(int)ait-1]=1;
        }
        //oyuncu2(bilgisayar) kartları dagitildi
        for(int l=1; l<9 ;l++){//burada "l" aday kart no'yu temsil ediyor
            for(int f=0; f<5 ;f++){
                if(oyuncu1.kartlar[f] == l) {
                    var_mi = false;
                    break;
                }else{
                    var_mi = true;
                }
            }
            if(var_mi) {
                butonlari_aktif_etme(false,l);
                oyuncu2.kart_ayarla(l, true);
                aitlik[l-1]=2;

                var_mi = false;
            }
        }

    }

    void savas_sonu(double kazanan_oyuncu_no ){
        Oyuncu kazanan;
        Oyuncu kaybeden;
        Buton ortadaki_kart;
        boolean tercih;
        if(kazanan_oyuncu_no==1){kazanan=oyuncu1;kaybeden=oyuncu2; tercih = true;}
        else{kazanan=oyuncu2; kaybeden =oyuncu1; tercih=false;}
        for (int i = 0; i <aktif_kart.ortadaki_kart_sayisi;i++) {
                ortadaki_kart = aktif_kart.tur_kartlari[i];//tur_kartlari dizisindeki

            try {
                Thread.sleep(1000);
            } catch (Exception ex) {
                Logger.getLogger(MainActivity.class.getName()).log(Level.SEVERE, null, ex);
            }
            kazanan.kart_ayarla((int) ortadaki_kart.id, true);
            aitlik[(int)ortadaki_kart.getId()-1]=kazanan_oyuncu_no;
            kaybeden.kart_ayarla((int) ortadaki_kart.id, false);
            butonlari_aktif_etme(tercih, (int)ortadaki_kart.getId());
            aktif_kart.tur_kartlari[i]=null;
        }
    }

    double kime_ait(Buton kart){
        return  aitlik[(int)kart.getId()-1];
    }

    void savas(){
        double savas_gucu_mevcut = aktif_kart.get_savas_gucu(aktif_kart.mevcut_kart);
        double savas_gucu_onceki = aktif_kart.get_savas_gucu(aktif_kart.onceki_kart);

        if (savas_gucu_onceki>savas_gucu_mevcut && kime_ait(aktif_kart.onceki_kart) == 1) {
            savas_sonu(1);// true=onceki,false=mevcut (kazananin kim oldughunu bildiren parametre)
            kazanan_kart = aktif_kart.onceki_kart;
        }
        else if(savas_gucu_onceki<savas_gucu_mevcut && kime_ait(aktif_kart.onceki_kart) == 1){
            savas_sonu(2);
            kazanan_kart = aktif_kart.mevcut_kart;;
        }
        else if(savas_gucu_onceki>savas_gucu_mevcut && kime_ait(aktif_kart.onceki_kart) == 2){
            savas_sonu(2);
            kazanan_kart = aktif_kart.onceki_kart;
        }
        else if(savas_gucu_onceki<savas_gucu_mevcut && kime_ait(aktif_kart.onceki_kart) == 2){
            savas_sonu(1);
            kazanan_kart = aktif_kart.mevcut_kart;
        }
        else {
            kazanan_kart=null;
            return;
        }
    }

    void oyun_dongusu(){
        // oyun dongusu
        Random rastgelelik_bilg= new Random();
        Buton secilen_hamle_bilg=null;
        int uretilen_indeks;
        int uretilen_tur;
        int secilen_kart;
        if(oyuncu1.kart_sayisi != 0 || oyuncu2.kart_sayisi != 0){
            //sira karsidakine gecti
            if(secilen_hamle!= null){
                tv_sag.setText(secilen_hamle.getRenk());
                tv_sag_alt.setText(secilen_hamle.getTur()+":"+(int) secilen_hamle.getDeger());
                tv_sol.setText(aktif_kart.onceki_kart.getRenk());
                tv_sol_alt.setText(aktif_kart.onceki_kart.getTur()+":"+(int) aktif_kart.onceki_kart.getDeger());
                aktif_kart.kart_atildi(secilen_hamle);//oyuncu1 kart attı

                int low = 1;
                int high = 3;
                uretilen_tur = rastgelelik_bilg.nextInt(high-low) + low;//belirlenen kartin hangi alt oz.i oldugu belirlendi
                low = 1;
                high = 8;
                uretilen_indeks = rastgelelik_bilg.nextInt(high-low) + low;//hangi renk kart oldugu belirlendi
                secilen_kart = oyuncu2.kartlar[uretilen_indeks];
                while(secilen_kart == 0){
                    uretilen_indeks = rastgelelik_bilg.nextInt(high-low) + low;//hangi renk kart oldugu belirlendi
                    secilen_kart = oyuncu2.kartlar[uretilen_indeks];
                }
                Buton temp;
                for (int h = 0; h < 24; h++) {
                    temp = (Buton) butonlar.get(h);
                    if (temp.id == secilen_kart && temp.tur == uretilen_tur) {
                        secilen_hamle_bilg = (Buton) butonlar.get(h);
                        break;
                    }
                }
                aktif_kart.kart_atildi(secilen_hamle_bilg);//oyuncu2 kart atti

                tv_sag.setText(aktif_kart.mevcut_kart.getRenk());
                tv_sag_alt.setText(aktif_kart.mevcut_kart.getTur()+":"+(int) aktif_kart.mevcut_kart.getDeger());
                tv_sol.setText(aktif_kart.onceki_kart.getRenk());
                tv_sol_alt.setText(aktif_kart.onceki_kart.getTur()+":"+(int) aktif_kart.onceki_kart.getDeger());

                if(secilen_hamle!= null)
                    savas();
                if(kazanan_kart == null){
                    tv_metin.setText("Berabere");
                    return;}
                else{
                    tv_metin.setText("Kazanan :" + kazanan_kart.k.get_karakter_adi() );
                }
                aktif_kart.ortadaki_kart_sayisi = 0;
            }
        }
    }

}