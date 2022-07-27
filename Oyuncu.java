package com.example.mobilkartoyunu_2;

import java.util.Arrays;
import java.util.Random;

public class Oyuncu {
    int kart_sayisi;
    int[] kartlar= {0,0,0,0,0,0,0,0};//2,5,6,3

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
        while(kartlar[k] != 0){//dort farkli kart uretildiginden emin olmak icin
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

    void kart_ayarla(int kart_no, boolean art_azalt){
        if (art_azalt == true){
            kartlar[kart_sayisi-1] = kart_no;
            set_kart_sayisi(this.kart_sayisi + 1);}
        else if (art_azalt == false){
            int indeks=Arrays.asList(kartlar).indexOf(kart_no);
            kartlar[indeks] = 0;
            set_kart_sayisi(this.kart_sayisi - 1);
        }
    }
}


