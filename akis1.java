package com.example.kart_oyunu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Context;

import java.util.Random;


class KarakterKarti{
    String karakter_adi;//nesnenin id'si gibi dusunulebilir(gelistiriciler tarafindan belirlenmis sabit sekiz karakter oldugu icin)
    double fizikselGuc;
    double buyuGucu;
    double iknaGucu;

    KarakterKarti(String renk,double oz1, double oz2, double oz3){
        set_karakter_adi(renk);
        set_fizikselGuc(oz1);
        set_buyuGucu(oz2);
        set_iknaGucu(oz3);
    }

    //get-set fonksiyonlari
    String get_karakter_adi(){
        return this.karakter_adi;
    }
    void set_karakter_adi(String ad){
        this.karakter_adi = ad;
    }

    double get_fizikselGuc(){
        return this.fizikselGuc;
    }
    void set_fizikselGuc(double yeni_fizikselGuc){
        this.fizikselGuc = yeni_fizikselGuc;
    }

    double get_buyuGucu(){
        return this.buyuGucu;
    }
    void set_buyuGucu(double yeni_buyuGucu){
        this.buyuGucu = yeni_buyuGucu;
    }

    double get_iknaGucu(){
        return this.iknaGucu;
    }
    void set_iknaGucu(double yeni_iknaGucu){
        this.iknaGucu = yeni_iknaGucu;
    }
}


public class Buton extends androidx.appcompat.widget.AppCompatButton {

    int id;//0-8 numaralndirilmis id atanacak
    int tur;//1=buyu,2=guc,3=ikna
    double deger;
    KarakterKarti k;
    String renk;



    public Buton(Context context,KarakterKarti k,int  tur) {
        super(context);
        this.tur=tur;
        this.k=k;
        this.renk=k.karakter_adi;
        if (tur==1)
            this.deger =k.buyuGucu;
        else if(tur==2)
            this.deger=k.fizikselGuc;
        else if(tur==3)
            this.deger=k.iknaGucu;
        set_renk();
    }

    private void set_renk() {
        if(renk=="beyaz")
            setBackground(R.drawable.beyaz);
        else if(renk=="sari")
            setBackground(R.drawable.sari);
        else if(renk=="yesil")
            setBackground(R.drawable.yesil);
        else if(renk=="pembe")
            setBackground(R.drawable.pembe);
        else if(renk=="mavi")
            setBackground(R.drawable.mavi);
        else if(renk=="kirmizi")
            setBackground(R.drawable.kirmizi);
        else if(renk=="lacivert")
            setBackground(R.drawable.lacivert);
        else if(renk=="siyah")
            setBackground(R.drawable.siyah);
    }

    public int getTur() {
        return tur;
    }

    public void setTur(int tur) {
        this.tur = tur;
    }

    public KarakterKarti getK() {
        return k;
    }

    public void setK(KarakterKarti k) {
        this.k = k;
    }

    public String getRenk() {
        return renk;
    }

    public void setRenk(String renk) {
        this.renk = renk;
    }
}

class AktifKart {
    Buton onceki_kart;
    Buton mevcut_kart;
    double savas_gucu;

    AktifKart(Buton baslangic_karti){
        this.mevcut_kart = baslangic_karti;
    }

    void kart_atildi(Buton atilan_kart){
        this.onceki_kart = this.mevcut_kart;
        this.mevcut_kart = atilan_kart;
    }
    double get_savas_gucu(Buton buton){
        if (buton.tur == 1) {
			savas_gucu = 0.2 * buton.deger;
        }

    }
}


class Oyuncu{
	int kart_sayisi;
	KarakterKarti [] kartlar;//2,5,6,3
	
    Oyuncu(){
        this.kart_sayisi = 0;
    }

    //get-set fonksiyonlari
    int get_kart_sayisi(){
        return this.kart_sayisi;
    }
    void set_kart_sayisi(int guncel_kart_sayisi){
        this.kart_sayisi = guncel_kart_sayisi;
    }
	
	void kart_al(){
		Random rastgelelik = new Random();
		int uretilen_kart_no = rastgelelik.nextInt(9);;//0 ile 9 arasindaki sayilari ureten satir
		int k = 0;
		while(kartlar[k] != null){//dort farkli kart uretildiginden emin olmak icin
			if (uretilen_kart_no == kartlar[k]){
				uretilen_kart_no = rastgelelik.nextInt(9);
				k = 0;
			}
			else{
				k++;
			}
		}
		kartlar[kart_sayisi-1] = uretilen_kart_no;
		set_kart_sayisi(this.kart_sayisi + 1);
	}
	
	void kart_ayarla(yeni_kart_no){
		kartlar[kart_sayisi-1] = yeni_kart_no;
		set_kart_sayisi(this.kart_sayisi + 1);
	}
}

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
	@Override
    public void onClick(View v){
        ...
		//butonlar ekranda gozukuyor mu?
    }
    //karakterler
    KarakterKarti beyaz = new KarakterKarti("beyaz",2,2,1);
    KarakterKarti sari = new KarakterKarti("sari",1,2,1);
    KarakterKarti yesil = new KarakterKarti("yesil",3,3,3);
    KarakterKarti pembe = new KarakterKarti("pembe",5,7,7);
    KarakterKarti mavi = new KarakterKarti("mavi",8,6,9);
    KarakterKarti kirmizi = new KarakterKarti("kirmizi",5,4,10);
    KarakterKarti lacivert = new KarakterKarti("lacivert",10,3,6);
    KarakterKarti siyah = new KarakterKarti("siyah",4,10,7);

    //oyun basi

    //her bir butonu temsil eden Buton sınıfından olusmus nesneler yaratılacak
    Buton buton_beyaz_buyu = new Buton(this, beyaz,1 );
	buton_beyaz_buyu.setOnClickListener(this);
    Buton buton_beyaz_guc = new Buton(this, beyaz,2 );
	buton_beyaz_guc.setOnClickListener(this);
    Buton buton_beyaz_ikna = new Buton(this, beyaz,3 );
	buton_beyaz_ikna.setOnClickListener(this);
	
    Buton buton_sari_buyu = new Buton(this, sari,1 );
    Buton buton_sari_guc = new Buton(this, sari,2 );
    Buton buton_sari_ikna = new Buton(this, sari,3 );
	Buton buton_yesil_buyu = new Buton(this, yesil,1 );
    Buton buton_yesil_guc = new Buton(this, yesil,2 );
    Buton buton_yesil_ikna = new Buton(this, yesil,3 );
	//...
    Buton secilen_hamle = ... // sonrdan global olarak tanımlanabilir
    AktifKart aktif_kart = new AktifKart(secilen_hamle);//buton etkilesimi ile secilen karti temsil ediyor "secilen_kart"
	
	Oyuncu oyuncu1 = new Oyuncu();//oyuncu
	Oyuncu oyuncu2 = new Oyuncu();//bilgisayar
	//rastgele kart dagitimi
	//oyuncu 1 icin baslangic kart dagitimi
	for (int i=0; i<4; i++){
		
		oyuncu1.kart_al();
	}
	//oyuncu2(bilgisayar) kartları dagitildi
	for(int l=0; l<9 ;l++){//burada "l" aday kart no'yu temsil ediyor
		for(int f=0; f<5 ;f++){//"f" oyuncu1'in indeksini tutor
			if(oyuncu1.kartlar[f] != l){
				oyuncu2.kart_ayarla(l);//1,4,8,7
			}
		}
	}
	...//rastgele dagitilan kartlarin butonlari aktif edildi
	void savas(){
		double savas_gucu1= aktif_kart.get_savas_gucu(secilen_hamle);
		double savas_gucu2= aktif_kart.get_savas_gucu(aktif_kart.onceki_kart);
		if (savas_gucu1 > savas_gucu2){
			kazanan_kart = aktif_kart.mevcut_kart; 
			//Burada layout'a onceki kart eklenecek (visible)
		}
		else if (savas_gucu1 < savas_gucu2)){
			kazanan_kart = aktif_kart.onceki_kart;
			//Burada layout'tan invisible yapılacak
		}
		else {
			contuinue;
		}
	}
	
    //oyuncu 1 oyun dongusu
	while(oyuncu1.kart_sayisi == 0 || oyuncu2.kart_sayisi == 0){
	    //sira karsidakine gecti
		if(oyuncu1)
			Buton secilen_hamle = ...
		else if (oyuncu2)
			//random kart sec(karsi tarafta olmayan kartlara sahip!)
		
		aktif_kart.kart_atildi(secilen_hamle);
		savas();
	}
	
}
