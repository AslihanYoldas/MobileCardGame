package com.example.mobilkartoyunu3;

public class AktifKart {
    Buton onceki_kart = new Buton();
    Buton mevcut_kart;
    Buton [] tur_kartlari = {null,null,null,null,null,null,null,null};
    int ortadaki_kart_sayisi = 0;
    double savas_gucu;

    AktifKart(){
        this.onceki_kart.setRenk("Boş Kart");
        this.onceki_kart.setDeger(0);
        this.onceki_kart.setTur(1);
    }

    void kart_atildi(Buton atilan_kart){
        tur_kartlari[ortadaki_kart_sayisi] = atilan_kart;
        ortadaki_kart_sayisi++;
        this.onceki_kart = this.mevcut_kart;
        this.mevcut_kart = atilan_kart;
    }

    double get_savas_gucu(Buton kart){
        double savas_gucu=0;

        if (kart.tur == 1) {//buyu
            savas_gucu = 0.3 * kart.deger;
        }
        else if(this.mevcut_kart.tur == 2) {//guc
            savas_gucu = 0.2 * kart.deger;
        }
        else if(this.mevcut_kart.tur == 3) {//ikna
            savas_gucu = 0.1 * kart.deger;
        }
        return savas_gucu;
    }

}