package com.example.mobilkartoyunu_2;

public class Buton {

    int id;//1=beyaz,2=sari,3=yesil,4=pembe,5=mavi,6=kırmızı,7=lacivert,8=siyah
    int tur;//1=buyu,2=guc,3=ikna
    double deger;
    KarakterKarti k;
    String renk;
    String yazi;



    public Buton(int id,KarakterKarti k,int  tur) {
        this.tur=tur;
        this.k=k;
        this.renk=k.karakter_adi;
        this.yazi = tur +"  "+ deger;
        if (tur==1)
            this.deger =k.buyuGucu;
        else if(tur==2)
            this.deger=k.fizikselGuc;
        else if(tur==3)
            this.deger=k.iknaGucu;

    }



    public String getYazi() {
        return yazi;
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