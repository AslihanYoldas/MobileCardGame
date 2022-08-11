package com.example.mobil_kart_oyunu;

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

    boolean get_savas_gucu(){
        double savas_gucu1=0;
        double savas_gucu2=0;

        if (this.mevcut_kart.tur == 1) {//buyu
            savas_gucu1 = 0.3 * this.mevcut_kart.deger;
        }
        else if(this.mevcut_kart.tur == 2) {//guc
            savas_gucu1 = 0.2 * this.mevcut_kart.deger;
        }
        else if(this.mevcut_kart.tur == 3) {//ikna
            savas_gucu1 = 0.1 * this.mevcut_kart.deger;
        }
        if (this.onceki_kart.tur == 1) {//buyu
            savas_gucu2 = 0.3 * this.onceki_kart.deger;
        }
        else if(this.onceki_kart.tur == 2) {//guc
            savas_gucu2 = 0.2 * this.onceki_kart.deger;
        }
        else if(this.onceki_kart.tur == 3) {//ikna
            savas_gucu2 = 0.1 * this.onceki_kart.deger;
        }
        return savas_gucu1>savas_gucu2;
    }

}