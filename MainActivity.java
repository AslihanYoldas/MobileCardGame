package com.example.mobilkartoyunu_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //Tanımlamalar

    KarakterKarti beyaz = new KarakterKarti("beyaz",2,2,1);
    KarakterKarti sari = new KarakterKarti("sari",1,2,1);
    KarakterKarti yesil = new KarakterKarti("yesil",3,3,3);
    KarakterKarti pembe = new KarakterKarti("pembe",5,7,7);
    KarakterKarti mavi = new KarakterKarti("mavi",8,6,9);
    KarakterKarti kirmizi = new KarakterKarti("kirmizi",5,4,10);
    KarakterKarti lacivert = new KarakterKarti("lacivert",10,3,6);
    KarakterKarti siyah = new KarakterKarti("siyah",4,10,7);


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

    Buton beyaz_buton_guc=new Buton(1,beyaz,2);
    Buton sari_buton_guc=new Buton(2,sari,2);
    Buton yesil_buton_guc=new Buton(3,yesil,2);
    Buton pembe_buton_guc=new Buton(4,pembe,2);
    Buton mavi_buton_guc=new Buton(5,mavi,2);
    Buton kirmizi_buton_guc=new Buton(6,kirmizi,2);
    Buton lacivert_buton_guc=new Buton(7,lacivert,2);
    Buton siyah_buton_guc=new Buton(8,siyah,2);
    Buton beyaz_buton_buyu=new Buton(1,beyaz,1);
    Buton sari_buton_buyu=new Buton(2,sari,1);
    Buton yesil_buton_buyu=new Buton(3,yesil,1);
    Buton pembe_buton_buyu=new Buton(4,pembe,1);
    Buton mavi_buton_buyu=new Buton(5,mavi,1);
    Buton kirmizi_buton_buyu=new Buton(6,kirmizi,1);
    Buton lacivert_buton_buyu=new Buton(7,lacivert,1);
    Buton siyah_buton_buyu=new Buton(8,siyah,3);
    Buton beyaz_buton_ikna=new Buton(1,beyaz,3);
    Buton sari_buton_ikna=new Buton(2,sari,3);
    Buton yesil_buton_ikna=new Buton(3,yesil,3);
    Buton pembe_buton_ikna=new Buton(4,pembe,3);
    Buton mavi_buton_ikna=new Buton(5,mavi,3);
    Buton kirmizi_buton_ikna=new Buton(6,kirmizi,3);
    Buton lacivert_buton_ikna=new Buton(7,lacivert,3);
    Buton siyah_buton_ikna=new Buton(8,siyah,3);

    Buton[]  Butonlar={beyaz_buton_guc,beyaz_buton_buyu,beyaz_buton_ikna,sari_buton_buyu,sari_buton_guc,
            sari_buton_ikna,yesil_buton_buyu,yesil_buton_guc,yesil_buton_ikna,pembe_buton_buyu,
            pembe_buton_guc,pembe_buton_ikna, mavi_buton_buyu,mavi_buton_guc,mavi_buton_ikna,
            kirmizi_buton_buyu,kirmizi_buton_guc,kirmizi_buton_ikna,lacivert_buton_buyu,lacivert_buton_guc,
            lacivert_buton_ikna,siyah_buton_buyu,siyah_buton_guc,siyah_buton_ikna
    };
    ImageButton[] image_Butonlar={beyaz_imagebuton_guc,beyaz_imagebuton_buyu,beyaz_imagebuton_ikna,sari_imagebuton_buyu,sari_imagebuton_guc,
            sari_imagebuton_ikna,yesil_imagebuton_buyu,yesil_imagebuton_guc,yesil_imagebuton_ikna,pembe_imagebuton_buyu,
            pembe_imagebuton_guc,pembe_imagebuton_ikna, mavi_imagebuton_buyu,mavi_imagebuton_guc,mavi_imagebuton_ikna,
            kirmizi_imagebuton_buyu,kirmizi_imagebuton_guc,kirmizi_imagebuton_ikna,lacivert_imagebuton_buyu,lacivert_imagebuton_guc,
            lacivert_imagebuton_ikna,siyah_imagebuton_buyu,siyah_imagebuton_guc,siyah_imagebuton_ikna};
    TextView[] Metin_Kutulari={
            (TextView) findViewById(R.id.textView),(TextView) findViewById(R.id.textView2), (TextView) findViewById(R.id.textView3),
            (TextView) findViewById(R.id.textView5),(TextView) findViewById(R.id.textView4),(TextView) findViewById(R.id.textView6),
            (TextView) findViewById(R.id.textView8),(TextView) findViewById(R.id.textView7),(TextView) findViewById(R.id.textView9),
            (TextView) findViewById(R.id.textView11),(TextView) findViewById(R.id.textView10),(TextView) findViewById(R.id.textView12),
            (TextView) findViewById(R.id.textView14),(TextView) findViewById(R.id.textView13),(TextView) findViewById(R.id.textView15),
            (TextView) findViewById(R.id.textView17),(TextView) findViewById(R.id.textView16),(TextView) findViewById(R.id.textView18),
            (TextView) findViewById(R.id.textView20),(TextView) findViewById(R.id.textView19),(TextView) findViewById(R.id.textView21),
            (TextView) findViewById(R.id.textView23),(TextView) findViewById(R.id.textView22),(TextView) findViewById(R.id.textView24)
    };
    TextView tv_metin;
    Buton secilen_hamle; // sonrdan global olarak tanımlanabilir Tıklanan butonu tutan değişken
    AktifKart aktif_kart = new AktifKart(secilen_hamle);//buton etkilesimi ile secilen karti temsil ediyor "secilen_kart"
    Oyuncu oyuncu1 = new Oyuncu();//oyuncu
    Oyuncu oyuncu2 = new Oyuncu();//bilgisayar
    Buton kazanan_kart;
    boolean oyun_sirasi = true;//true iken oyuncu 1 de false iken oyuncu2 de

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

        //OYUN BASLANGICI
        // rastgele kart dagitimi
        //oyuncu 1 icin baslangic kart dagitimi
        for(int i=0; i<4; i++){
            oyuncu1.kart_al();
        }
        //oyuncu2(bilgisayar) kartları dagitildi
        for(int l=0; l<9 ;l++){//burada "l" aday kart no'yu temsil ediyor
            for(int f=0; f<5 ;f++){
                if(oyuncu1.kartlar[f] != l){
                    oyuncu2.kart_ayarla(l, true);//1,4,8,7
                }
            }
        }
        butonlari_aktif_etme(false,oyuncu2.kartlar);

        // oyun dongusu
        Random rastgelelik_bilg= new Random();
        Buton secilen_hamle_bilg=null;
        int uretilen_indeks;
        int uretilen_tur;
        int secilen_kart;
        while(oyuncu1.kart_sayisi == 0 || oyuncu2.kart_sayisi == 0){
            //sira karsidakine gecti
            if(oyun_sirasi == true && secilen_hamle!= null )
                aktif_kart.kart_atildi(secilen_hamle);
		    else if (oyun_sirasi == false) {
                uretilen_indeks = rastgelelik_bilg.nextInt(oyuncu2.kart_sayisi);//hangi renk kart oldugu belirlendi
                uretilen_tur=rastgelelik_bilg.nextInt(3);//belirlenen kartin hangi alt oz.i oldugu belirlendi
                secilen_kart = oyuncu2.kartlar[uretilen_indeks];
                for(int h=0;h<24;h++){
                if (Butonlar[h].id == secilen_kart && Butonlar[h].tur == uretilen_tur)
                    secilen_hamle_bilg = Butonlar[h];
                }
                aktif_kart.kart_atildi(secilen_hamle_bilg);
            }
            savas();
            if(kazanan_kart == null)
                tv_metin.setText("Berabere");
            else{
                tv_metin.setText("Kazanan :" + kazanan_kart.k.get_karakter_adi() );
            }

            //kazanan kart oyuncu1 in ise oyuncu 2 nin kartını oyuncu1 de görünür olması
            //kazanan kart oyuncu 2 nin ise oyuncu birin kartı görünmez yapılmalı
        }
    }


    public void  butonlari_gorunur_gorunmez_yapma( boolean tercih , int indeks) {//Dizinin içindeki görünmesi gereken kartlarin id lerini alıp o kartları arayüzde görünür yapıp diğerlerini görünmez yapmalı
        TextView tv1;
        TextView tv2;
        TextView tv3;
            tv1 = Metin_Kutulari[indeks];
            tv2 = Metin_Kutulari[indeks + 1];
            tv3 = Metin_Kutulari[indeks + 2];
            if (tercih == false) {//Görünmez yapma için
                image_Butonlar[indeks].setVisibility(View.INVISIBLE);
                image_Butonlar[indeks + 1].setVisibility(View.INVISIBLE);
                image_Butonlar[indeks + 2].setVisibility(View.INVISIBLE);
                tv1.setVisibility(View.INVISIBLE);
                tv2.setVisibility(View.INVISIBLE);
                tv3.setVisibility(View.INVISIBLE);
            } else if (tercih == true) {//Görünür yapma için
                image_Butonlar[indeks].setVisibility(View.VISIBLE);
                image_Butonlar[indeks + 1].setVisibility(View.VISIBLE);
                image_Butonlar[indeks + 2].setVisibility(View.VISIBLE);
                tv1.setVisibility(View.VISIBLE);
                tv2.setVisibility(View.VISIBLE);
                tv3.setVisibility(View.VISIBLE);
            }
        }

    public void butonlari_aktif_etme(boolean tercih, int k[]) {
        int id;

        for (int i = 0; i < k.length; i++) {
            id = k[i];
            //id den hangi butona ulaşacağımızı bulmalıyız
            if (id == 1) {
                butonlari_gorunur_gorunmez_yapma(tercih, 0);
            } else if (id == 2) {
                butonlari_gorunur_gorunmez_yapma(tercih, 3);
            } else if (id == 3) {
                butonlari_gorunur_gorunmez_yapma(tercih, 6);
            } else if (id == 4) {
                butonlari_gorunur_gorunmez_yapma(tercih, 9);
            } else if (id == 5) {
                butonlari_gorunur_gorunmez_yapma(tercih, 12);
            } else if (id == 6) {
                butonlari_gorunur_gorunmez_yapma(tercih, 15);
            } else if (id == 7) {
                butonlari_gorunur_gorunmez_yapma(tercih, 18);
            } else if (id == 8) {
                butonlari_gorunur_gorunmez_yapma(tercih, 21);

            }
        }
    }
    void savas(){
        double savas_gucu1= aktif_kart.get_savas_gucu(secilen_hamle);
        double savas_gucu2= aktif_kart.get_savas_gucu(aktif_kart.onceki_kart);
        if (savas_gucu1 > savas_gucu2){//oyuncu1'in kazandigi
            kazanan_kart = aktif_kart.mevcut_kart;
            oyuncu1.kart_ayarla(kazanan_kart.id, true);
            butonlari_aktif_etme(true, oyuncu1.kartlar);
        }
        else if (savas_gucu1 < savas_gucu2){//oyuncu2'in kazandigi
            kazanan_kart = aktif_kart.onceki_kart;
            oyuncu2.kart_ayarla(kazanan_kart.id, true);
            butonlari_aktif_etme(false, oyuncu2.kartlar);
            oyuncu1.kart_ayarla(kazanan_kart.id, false);
        }
		else {
            kazanan_kart=null;
            return;
        }
    }


    @Override
    public void onClick(View v){//Sıra kontrol edilmeli sıra oyuncu 1 de değilse butonlara basılmamalı
        for(int i=0; i< image_Butonlar.length;i++)
            if(v.getId()== image_Butonlar[i].getId() && oyun_sirasi==true){
                secilen_hamle= Butonlar[i];
        }

    }



}