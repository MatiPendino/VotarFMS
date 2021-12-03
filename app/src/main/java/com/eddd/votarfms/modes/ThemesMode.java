package com.eddd.votarfms.modes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.eddd.votarfms.R;
import com.eddd.votarfms.dialogs.DialogNewVotation;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class ThemesMode extends Activity {

    private Button fm1, fm2, fm3, fm4, sm1, sm2, sm3, sm4, fmScene, fmFlow, fmSkills, smScene, smFlow, smSkills;
    private Button btn_nextRound;
    private TextView txt_firstMc, txt_secondMc;
    private String firstMc, secondMc;

    private float pointsFm1, pointsFm2, pointsFm3, pointsFm4, pointsFmScene, pointsFmFlow, pointsFmSkills;
    private float pointsSm1, pointsSm2, pointsSm3, pointsSm4, pointsSmScene, pointsSmFlow, pointsSmSkills;

    public static float totalFirstMcThemes, totalSecondMcThemes;

    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.themes_mode);

        fm1 = findViewById(R.id.et_fm1);
        fm2 = findViewById(R.id.et_fm2);
        fm3 = findViewById(R.id.et_fm3);
        fm4 = findViewById(R.id.et_fm4);
        fmScene = findViewById(R.id.et_fmScene);
        fmFlow = findViewById(R.id.et_fmFlow);
        fmSkills = findViewById(R.id.et_fmSkills);
        sm1 = findViewById(R.id.et_sm1);
        sm2 = findViewById(R.id.et_sm2);
        sm3 = findViewById(R.id.et_sm3);
        sm4 = findViewById(R.id.et_sm4);
        smScene = findViewById(R.id.et_smScene);
        smFlow = findViewById(R.id.et_smFlow);
        smSkills = findViewById(R.id.et_smSkills);
        txt_firstMc = findViewById(R.id.tv_firstMcThemes);
        txt_secondMc = findViewById(R.id.tv_secondMcThemes);
        btn_nextRound = findViewById(R.id.btn_nextRound);

        //obtengo los nombres de los mcs seleccionados
        firstMc = DialogNewVotation.firstMcSelected;
        secondMc = DialogNewVotation.secondMcSelected;

        //coloco los nombres de los mcs en las TextViews
        txt_firstMc.setText(firstMc);
        txt_secondMc.setText(secondMc);

        putZerosInFields();

        sumPoints();

        resetPoints();

        nextRound();

        startBannerAd();
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
        fmScene.setText(String.valueOf(pointsFmScene));
        fmFlow.setText(String.valueOf(pointsFmFlow));
        fmSkills.setText(String.valueOf(pointsFmSkills));
        sm1.setText(String.valueOf(pointsSm1));
        sm2.setText(String.valueOf(pointsSm2));
        sm3.setText(String.valueOf(pointsSm3));
        sm4.setText(String.valueOf(pointsSm4));
        smScene.setText(String.valueOf(pointsSmScene));
        smFlow.setText(String.valueOf(pointsSmFlow));
        smSkills.setText(String.valueOf(pointsSmSkills));
    }


    private void nextRound(){

        //si el usuario presiona el boton siguiente ronda, paso al ThemeMode, solamente si todos los campos están rellenos
        btn_nextRound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    //ahora guardo el puntaje total de cada ronda de ambos mcs
                    totalFirstMcThemes = pointsFm1 + pointsFm2 + pointsFm3 + pointsFm4 + pointsFmScene + pointsFmFlow + pointsFmSkills;
                    totalSecondMcThemes = pointsSm1 + pointsSm2 + pointsSm3 + pointsSm4 + pointsSmScene + pointsSmFlow + pointsSmSkills;

                    Intent intent = new Intent(getApplicationContext(), ThemesMode2.class);
                    startActivity(intent);

            }
        });
    }

}