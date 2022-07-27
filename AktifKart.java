package com.example.mobil_kart_oyunu;

//üçüncü ve dördüncü tur dönüldüğünde son ikikart harici tutulmuyhor bunları da tut bir yerde
public class AktifKart {
    Buton onceki_kart;
    Buton mevcut_kart;
    Buton [] tur_kartlari;
    int ortadaki_kart_sayisi = 0;
    double savas_gucu;

    AktifKart(Buton baslangic_karti){
        this.mevcut_kart = baslangic_karti;
        tur_kartlari[ortadaki_kart_sayisi] = baslangic_karti;
        ortadaki_kart_sayisi++;
    }

    void kart_atildi(Buton atilan_kart){
        tur_kartlari[ortadaki_kart_sayisi] = atilan_kart;
        ortadaki_kart_sayisi++;
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