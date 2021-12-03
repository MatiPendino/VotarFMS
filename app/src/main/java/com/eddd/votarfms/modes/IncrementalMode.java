package com.eddd.votarfms.modes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.eddd.votarfms.R;
import com.eddd.votarfms.dialogs.DialogNewVotation;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class IncrementalMode extends AppCompatActivity {

    private Button btn_nextRound;
    private TextView text_firstMc, text_secondMc;
    private String firstMc, secondMc;
    private Button fm1, fm2, fm3, fm4, fm5, fm6, fm7, fm8, fm9, fmScene, fmFlow, fmSkills;
    private Button sm1, sm2, sm3, sm4, sm5, sm6, sm7, sm8, sm9, smScene, smFlow, smSkills;

    private float pointsFm1, pointsFm2, pointsFm3, pointsFm4, pointsFm5, pointsFm6, pointsFm7, pointsFm8, pointsFm9, pointsFmScene, pointsFmFlow, pointsFmSkills;
    private float pointsSm1, pointsSm2, pointsSm3, pointsSm4, pointsSm5, pointsSm6, pointsSm7, pointsSm8, pointsSm9, pointsSmScene, pointsSmFlow, pointsSmSkills;

    public static float totalFirstMcIncremental, totalSecondMcIncremental;

    private AdView mAdView;
    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_incremental_mode);

        fm1 = findViewById(R.id.et_fm1);
        fm2 = findViewById(R.id.et_fm2);
        fm3 = findViewById(R.id.et_fm3);
        fm4 = findViewById(R.id.et_fm4);
        fm5 = findViewById(R.id.et_fm5);
        fm6 = findViewById(R.id.et_fm6);
        fm7 = findViewById(R.id.et_fm7);
        fm8 = findViewById(R.id.et_fm8);
        fm9 = findViewById(R.id.et_fm9);
        fmScene = findViewById(R.id.et_fmScene);
        fmFlow = findViewById(R.id.et_fmFlow);
        fmSkills = findViewById(R.id.et_fmSkills);
        sm1 = findViewById(R.id.et_sm1);
        sm2 = findViewById(R.id.et_sm2);
        sm3 = findViewById(R.id.et_sm3);
        sm4 = findViewById(R.id.et_sm4);
        sm5 = findViewById(R.id.et_sm5);
        sm6 = findViewById(R.id.et_sm6);
        sm7 = findViewById(R.id.et_sm7);
        sm8 = findViewById(R.id.et_sm8);
        sm9 = findViewById(R.id.et_sm9);
        smScene = findViewById(R.id.et_smScene);
        smFlow = findViewById(R.id.et_smFlow);
        smSkills = findViewById(R.id.et_smSkills);
        text_firstMc = findViewById(R.id.txt_firstMc);
        text_secondMc = findViewById(R.id.txt_secondMc);
        btn_nextRound = findViewById(R.id.btn_nextRound);

        //obtengo los nombres de los mcs seleccionados y la liga
        firstMc = DialogNewVotation.firstMcSelected;
        secondMc = DialogNewVotation.secondMcSelected;

        //coloco los nombres de los mcs en las TextViews
        text_firstMc.setText(firstMc);
        text_secondMc.setText(secondMc);


        //Mostrar el 0 en todos los puntajes al inicio
        putZerosInFields();

        //OnClicklListener en cada puntaje, para sumar 0.5 hasta 4
        sumPoints();

        //OnLongClickListener en cada puntaje, para poder reiniciar la puntuación a 0
        resetPoints();

        //Pasar de ronda apretando botón
        nextRound();

        //Anuncios
        startBannerAd();
        startInterstitialAd();
    }

    public void startBannerAd(){
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }

    public void startInterstitialAd(){

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-3984939241340358/3936422848");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());

        mInterstitialAd.setAdListener(new AdListener(){
            public void onAdLoaded() {
                displayInterstitial();
            }
        });
    }

    public void displayInterstitial() {
// If Ads are loaded, show Interstitial else show nothing.
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        }
    }

    private void sumPoints(){

        fm1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pointsFm1 < 4){
                    pointsFm1 += 0.5;
                }
                fm1.setText(String.valueOf(pointsFm1));
            }
        });

        fm2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pointsFm2 < 4){
                    pointsFm2 += 0.5;
                }
                fm2.setText(String.valueOf(pointsFm2));
            }
        });

        fm3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pointsFm3 < 4){
                    pointsFm3 += 0.5;
                }
                fm3.setText(String.valueOf(pointsFm3));
            }
        });

        fm4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pointsFm4 < 4){
                    pointsFm4 += 0.5;
                }
                fm4.setText(String.valueOf(pointsFm4));
            }
        });

        fm5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pointsFm5 < 4){
                    pointsFm5 += 0.5;
                }
                fm5.setText(String.valueOf(pointsFm5));
            }
        });

        fm6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pointsFm6 < 4){
                    pointsFm6 += 0.5;
                }
                fm6.setText(String.valueOf(pointsFm6));
            }
        });

        fm9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pointsFm9 < 4){
                    pointsFm9 += 0.5;
                }
                fm9.setText(String.valueOf(pointsFm9));
            }
        });

        fm7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pointsFm7 < 4){
                    pointsFm7 += 0.5;
                }
                fm7.setText(String.valueOf(pointsFm7));
            }
        });

        fm8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pointsFm8 < 4){
                    pointsFm8 += 0.5;
                }
                fm8.setText(String.valueOf(pointsFm8));
            }
        });

        fmScene.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pointsFmScene < 4){
                    pointsFmScene += 0.5;
                }
                fmScene.setText(String.valueOf(pointsFmScene));
            }
        });

        fmFlow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pointsFmFlow < 4){
                    pointsFmFlow += 0.5;
                }
                fmFlow.setText(String.valueOf(pointsFmFlow));
            }
        });

        fmSkills.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pointsFmSkills < 4){
                    pointsFmSkills += 0.5;
                }
                fmSkills.setText(String.valueOf(pointsFmSkills));
            }
        });

        sm1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pointsSm1 < 4){
                    pointsSm1 += 0.5;
                }
                sm1.setText(String.valueOf(pointsSm1));
            }
        });

        sm2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pointsSm2 < 4){
                    pointsSm2 += 0.5;
                }
                sm2.setText(String.valueOf(pointsSm2));
            }
        });

        sm3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pointsSm3 < 4){
                    pointsSm3 += 0.5;
                }
                sm3.setText(String.valueOf(pointsSm3));
            }
        });

        sm4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pointsSm4 < 4){
                    pointsSm4 += 0.5;
                }
                sm4.setText(String.valueOf(pointsSm4));
            }
        });

        sm5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pointsSm5 < 4){
                    pointsSm5 += 0.5;
                }
                sm5.setText(String.valueOf(pointsSm5));
            }
        });

        sm6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pointsSm6 < 4){
                    pointsSm6 += 0.5;
                }
                sm6.setText(String.valueOf(pointsSm6));
            }
        });

        sm7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pointsSm7 < 4){
                    pointsSm7 += 0.5;
                }
                sm7.setText(String.valueOf(pointsSm7));
            }
        });

        sm8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pointsSm8 < 4){
                    pointsSm8 += 0.5;
                }
                sm8.setText(String.valueOf(pointsSm8));
            }
        });

        sm9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pointsSm9 < 4){
                    pointsSm9 += 0.5;
                }
                sm9.setText(String.valueOf(pointsSm9));
            }
        });

        smScene.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pointsSmScene < 4){
                    pointsSmScene += 0.5;
                }
                smScene.setText(String.valueOf(pointsSmScene));
            }
        });

        smFlow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pointsSmFlow < 4){
                    pointsSmFlow += 0.5;
                }
                smFlow.setText(String.valueOf(pointsSmFlow));
            }
        });

        smSkills.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pointsSmSkills < 4){
                    pointsSmSkills += 0.5;
                }
                smSkills.setText(String.valueOf(pointsSmSkills));
            }
        });

    }

    private void resetPoints(){

        fm1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                pointsFm1 = 0;
                fm1.setText(String.valueOf(pointsFm1));

                return true;
            }
        });

        fm2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                pointsFm2 = 0;
                fm2.setText(String.valueOf(pointsFm2));

                return true;
            }
        });

        fm3.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                pointsFm3 = 0;
                fm3.setText(String.valueOf(pointsFm3));

                return true;
            }
        });

        fm4.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                pointsFm4 = 0;
                fm4.setText(String.valueOf(pointsFm4));

                return true;
            }
        });

        fm5.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                pointsFm5 = 0;
                fm5.setText(String.valueOf(pointsFm5));

                return true;
            }
        });

        fm6.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                pointsFm6 = 0;
                fm6.setText(String.valueOf(pointsFm6));

                return true;
            }
        });

        fm7.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                pointsFm7 = 0;
                fm7.setText(String.valueOf(pointsFm7));

                return true;
            }
        });

        fm8.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                pointsFm8 = 0;
                fm8.setText(String.valueOf(pointsFm8));

                return true;
            }
        });

        fm9.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                pointsFm9 = 0;
                fm9.setText(String.valueOf(pointsFm9));

                return true;
            }
        });

        fmScene.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                pointsFmScene = 0;
                fmScene.setText(String.valueOf(pointsFmScene));

                return true;
            }
        });

        fmSkills.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                pointsFmSkills = 0;
                fmSkills.setText(String.valueOf(pointsFmSkills));

                return true;
            }
        });

        fmFlow.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                pointsFmFlow = 0;
                fmFlow.setText(String.valueOf(pointsFmFlow));

                return true;
            }
        });

        sm1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                pointsSm1 = 0;
                sm1.setText(String.valueOf(pointsSm1));

                return true;
            }
        });

        sm2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                pointsSm2 = 0;
                sm2.setText(String.valueOf(pointsSm2));

                return true;
            }
        });

        sm3.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                pointsSm3 = 0;
                sm3.setText(String.valueOf(pointsSm3));

                return true;
            }
        });

        sm4.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                pointsSm4 = 0;
                sm4.setText(String.valueOf(pointsSm4));

                return true;
            }
        });

        sm5.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                pointsSm5 = 0;
                sm5.setText(String.valueOf(pointsSm5));

                return true;
            }
        });

        sm6.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                pointsSm6 = 0;
                sm6.setText(String.valueOf(pointsSm6));

                return true;
            }
        });

        sm7.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                pointsSm7 = 0;
                sm7.setText(String.valueOf(pointsSm7));

                return true;
            }
        });

        sm8.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                pointsSm8 = 0;
                sm8.setText(String.valueOf(pointsSm8));

                return true;
            }
        });

        sm9.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                pointsSm9 = 0;
                sm9.setText(String.valueOf(pointsSm9));

                return true;
            }
        });

        smScene.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                pointsSmScene = 0;
                smScene.setText(String.valueOf(pointsSmScene));

                return true;
            }
        });

        smSkills.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                pointsSmSkills = 0;
                smSkills.setText(String.valueOf(pointsSmSkills));

                return true;
            }
        });

        smFlow.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                pointsSmFlow = 0;
                smFlow.setText(String.valueOf(pointsSmFlow));

                return true;
            }
        });

    }

    private void putZerosInFields(){
        fm1.setText(String.valueOf(pointsFm1));
        fm2.setText(String.valueOf(pointsFm2));
        fm3.setText(String.valueOf(pointsFm3));
        fm4.setText(String.valueOf(pointsFm4));
        fm5.setText(String.valueOf(pointsFm5));
        fm6.setText(String.valueOf(pointsFm6));
        fm7.setText(String.valueOf(pointsFm7));
        fm8.setText(String.valueOf(pointsFm8));
        fm9.setText(String.valueOf(pointsFm9));
        fmScene.setText(String.valueOf(pointsFmScene));
        fmFlow.setText(String.valueOf(pointsFmFlow));
        fmSkills.setText(String.valueOf(pointsFmSkills));
        sm1.setText(String.valueOf(pointsSm1));
        sm2.setText(String.valueOf(pointsSm2));
        sm3.setText(String.valueOf(pointsSm3));
        sm4.setText(String.valueOf(pointsSm4));
        sm5.setText(String.valueOf(pointsSm5));
        sm6.setText(String.valueOf(pointsSm6));
        sm8.setText(String.valueOf(pointsSm8));
        sm7.setText(String.valueOf(pointsSm7));
        sm9.setText(String.valueOf(pointsSm9));
        smScene.setText(String.valueOf(pointsSmScene));
        smFlow.setText(String.valueOf(pointsSmFlow));
        smSkills.setText(String.valueOf(pointsSmSkills));
    }

    private void nextRound(){

        //si el usuario presiona el boton siguiente ronda, paso al HardMode, solamente si todos los campos están rellenos
        btn_nextRound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //ahora guardo el puntaje total de cada ronda de ambos mcs
                totalFirstMcIncremental = pointsFm1 + pointsFm2 + pointsFm3 + pointsFm4
                        + pointsFm5 + pointsFm6 + pointsFm7 + pointsFm8 + pointsFm9 + pointsFmScene + pointsFmFlow + pointsFmSkills;
                totalSecondMcIncremental = pointsSm1 + pointsSm2 + pointsSm3 + pointsSm4
                        + pointsSm5 + pointsSm6 + + pointsSm7 + pointsSm8 + pointsSm9 + pointsSmScene + pointsSmFlow + pointsSmSkills;

                Intent intent = new Intent(getApplicationContext(), SegundoRound.class);
                startActivity(intent);
            }
        });
    }



}