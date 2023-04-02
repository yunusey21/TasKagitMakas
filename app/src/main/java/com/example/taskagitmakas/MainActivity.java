package com.example.taskagitmakas;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView pcfoto,sizfoto;
    Button tas,kagit,makas;
    TextView skoreText;

    int pcskor;
    int playerskore;

    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pcfoto = findViewById(R.id.pcfoto);
        sizfoto = findViewById(R.id.sizfoto);

        skoreText=findViewById(R.id.skore);

        tas=findViewById(R.id.tas);
        kagit=findViewById(R.id.kagit);
        makas=findViewById(R.id.makas);


        tas.setOnClickListener(v -> {
            sizfoto.setBackground(getResources().getDrawable(R.drawable.tas));
            durum Durum = calculatedurum(secim.Tas,pcsecim());

            guncelskore(Durum);});



        makas.setOnClickListener(v -> {
            sizfoto.setBackground(getResources().getDrawable(R.drawable.makas));
            durum Durum = calculatedurum(secim.Makas,pcsecim());
            guncelskore(Durum);
        });
        kagit.setOnClickListener(v -> {
            sizfoto.setBackground(getResources().getDrawable(R.drawable.paper));
            durum Durum = calculatedurum(secim.Kagit,pcsecim());
            guncelskore(Durum);
        });



    }


    @SuppressLint("SetTextI18n")
    public void guncelskore(durum Durum){
        if(Durum.equals(durum.Kazan)){
            playerskore++;
        }else if(durum.Kaybetti.equals(Durum)){
            pcskor++;
        }
        skoreText.setText("PC: "+pcskor+"SIZ: "+playerskore);
    }


    public durum calculatedurum(secim sizsecim, secim pcsecim){
        if(sizsecim.equals(pcsecim)){
            return durum.Berabere;
        }
        else if ( (sizsecim.equals(secim.Tas) && pcsecim.equals(secim.Makas)) ||
                (sizsecim.equals(secim.Kagit) && pcsecim.equals(secim.Tas)) ||
                (sizsecim.equals(secim.Makas) && pcsecim.equals(secim.Kagit))) {
            return durum.Kazan;
        }
        else {
            return durum.Kaybetti;
        }

    }


    @SuppressLint("UseCompatLoadingForDrawables")
    public secim pcsecim(){
        int random = new Random().nextInt(3);
        if(random==0){
            pcfoto.setBackground(getResources().getDrawable(R.drawable.tas));
            return secim.Tas;
        }
        else if(random==1){
            pcfoto.setBackground(getResources().getDrawable(R.drawable.paper));
            return secim.Kagit;
        }
        else{
            pcfoto.setBackground(getResources().getDrawable(R.drawable.makas));
            return secim.Makas;
        }
    }


}