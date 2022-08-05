package com.example.mobilkartoyunu3;

public class Buton {
    public double id;//1=beyaz,2=sari,3=yesil,4=pembe,5=mavi,6=kırmızı,7=lacivert,8=siyah
    public String tur;//1=buyu,2=guc,3=ikna
    public double deger;
    public KarakterKarti k;
    String renk;


    public Buton() {
    }

    public Buton(Object kart, double  id, String tur) {
        this.id=id;
        this.tur=tur;
        this.k=(KarakterKarti) kart;
        this.renk=k.karakter_adi;
        if (tur=="1")
            this.deger =k.buyuGucu;
        else if(tur=="2")
            this.deger=k.fizikselGuc;
        else if(tur=="3")
            this.deger=k.iknaGucu;

    }


    public double getId() {
        return id;
    }

    public void setId(double id) {
        this.id = id;
    }

    public double getDeger() {
        return deger;
    }

    public void setDeger(double deger) {
        this.deger = deger;
    }

    public String getTur() {
        return tur;
    }

    public void setTur(String tur) {
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

    @Override
    public String toString() {
        return "Buton{" +
                "id='" + id + '\'' +
                ", tur='" + tur + '\'' +
                ", deger=" + deger +
                ", k=" + k +
                ", renk='" + renk + '\'' +
                '}';
    }
}