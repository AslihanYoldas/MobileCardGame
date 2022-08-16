package com.example.mobil_kart_oyunu;

import java.util.Arrays;
import java.util.Random;

public class Oyuncu {
    int kart_sayisi;
    int[] kartlar= {0,0,0,0,0,0,0,0};

    Oyuncu(){
        this.kart_sayisi = 0;

    }

    //get-set fonksiyonlari
    int get_kart_sayisi(){
        return this.kart_sayisi;
    }
    void set_kart_sayisi(int guncel_kart_sayisi){
        if(guncel_kart_sayisi < 0 || guncel_kart_sayisi > 7){
            return;
        }
        this.kart_sayisi = guncel_kart_sayisi;
    }

    double kart_al(){
        Random rastgelelik = new Random();

        int low = 1;
        int high = 8;
        int uretilen_kart_no = rastgelelik.nextInt(high-low) + low;

        int k = 0;
        while(this.kartlar[k] != 0){//dort farkli kart uretildiginden emin olmak icin
            if (uretilen_kart_no == kartlar[k]){
                uretilen_kart_no = rastgelelik.nextInt(high-low) + low;
                k = 0;
            }
            else{
                k++;
            }
        }
        this.kartlar[this.kart_sayisi ] = uretilen_kart_no;
        set_kart_sayisi(this.kart_sayisi + 1);
        return (double) uretilen_kart_no;
    }

    int kacinci_sirada(int kart_no){
        for(int x=0;x<=7;x++){
            if (this.kartlar[x] == kart_no)
                return x;
        }
        return -1; //bulamadi demek
    }

    void kart_ayarla(int kart_no, boolean art_azalt){
        int indeks;
        if (art_azalt){
            indeks = kacinci_sirada(kart_no);
            if (indeks!=-1)//aynı kartı eklemesini engellemek için
                return;
            this.kartlar[this.kart_sayisi ] = kart_no;
            set_kart_sayisi(this.kart_sayisi + 1);}
        else{
            indeks= kacinci_sirada(kart_no);
            if(indeks==-1)//olmayan kartı çıkarma durumunu engelliyoruz
                return;
            this.kartlar[indeks] = 0;
            set_kart_sayisi(this.kart_sayisi - 1);
        }
    }
}