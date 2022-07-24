package com.example.mobilkartoyunu;

import android.content.Context;


public class Buton extends androidx.appcompat.widget.AppCompatButton {

    int id;
    int tur;//1=buyu,2=guc,3=ikna
    double deger;
    KarakterKarti k;
    String renk;
    String yazi;



    public Buton(Context context,KarakterKarti k,int  tur) {
        super(context);
        this.tur=tur;
        this.k=k;
        this.renk=k.karakter_adi;
        String s= tur +"  "+ deger;
        setYazi(s);
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
           setBackground(getResources().getDrawable(R.drawable.beyaz));
        else if(renk=="sari")
            setBackground(getResources().getDrawable(R.drawable.sari));
        else if(renk=="yesil")
            setBackground(getResources().getDrawable(R.drawable.yesil));
        else if(renk=="pembe")
            setBackground(getResources().getDrawable(R.drawable.pembe));
        else if(renk=="mavi")
            setBackground(getResources().getDrawable(R.drawable.mavi));
        else if(renk=="kirmizi")
            setBackground(getResources().getDrawable(R.drawable.kirmizi));
        else if(renk=="lacivert")
            setBackground(getResources().getDrawable(R.drawable.lacivert));
        else if(renk=="siyah")
            setBackground(getResources().getDrawable(R.drawable.siyah));

    }

    public String getYazi() {
        return yazi;
    }

    public void setYazi(String yazi) {
        this.yazi = yazi;
        setText(yazi);
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
