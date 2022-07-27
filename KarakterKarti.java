package com.example.mobilkartoyunu_2;

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