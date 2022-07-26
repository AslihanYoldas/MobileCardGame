package com.example.mobilkartoyunu_2;

public class AktifKart {
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
        if (buton.tur == 1) {//buyu
            savas_gucu = 0.3 * buton.deger;
        }
        else if(buton.tur == 2) {//guc
            savas_gucu = 0.2 * buton.deger;
        }
       else if(buton.tur == 3) {//ikna
           savas_gucu = 0.1 * buton.deger;
       }

       return savas_gucu;
    }
}