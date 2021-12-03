package com.eddd.votarfms.modes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.eddd.votarfms.R;
import com.eddd.votarfms.dialogs.DialogNewVotation;
import com.eddd.votarfms.modes.FinalResult;
import com.eddd.votarfms.modes.ThemesMode;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class SegundoRound extends AppCompatActivity {

    private Button fm1, fm2, fm3, fm4, fm5, fm6, sm1, sm2, sm3, sm4, sm5, sm6, fmScene, fmFlow, fmSkills, smScene, smFlow, smSkills;
    private Button btn_nextRound;
    private TextView tv_firstMc, tv_secondMc;
    private String firstMc, secondMc;

    private float pointsFm1, pointsFm2, pointsFm3, pointsFm4, pointsFm5, pointsFm6, pointsFmScene, pointsFmFlow, pointsFmSkills;
    private float pointsSm1, pointsSm2, pointsSm3, pointsSm4, pointsSm5, pointsSm6, pointsSmScene, pointsSmFlow, pointsSmSkills;

    public static float totalFirstMcSecond, totalSecondMcSecond;

    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segundo_round);

        fm1 = findViewById(R.id.et_sm1);
        fm2 = findViewById(R.id.et_sm2);
        fm3 = findViewById(R.id.et_sm3);
        fm4 = findViewById(R.id.et_sm4);
        fm5 = findViewById(R.id.et_sm5);
        fm6 = findViewById(R.id.et_sm6);
        fmScene = findViewById(R.id.et_smScene);
        fmFlow = findViewById(R.id.et_smFlow);
        fmSkills = findViewById(R.id.et_smSkills);
        sm1 = findViewById(R.id.et_fm1);
        sm2 = findViewById(R.id.et_fm2);
        sm3 = findViewById(R.id.et_fm3);
        sm4 = findViewById(R.id.et_fm4);
        sm5 = findViewById(R.id.et_fm5);
        sm6 = findViewById(R.id.et_fm6);
        smScene = findViewById(R.id.et_fmScene);
        smFlow = findViewById(R.id.et_fmFlow);
        smSkills = findViewById(R.id.et_fmSkills);
        tv_secondMc = findViewById(R.id.texto_secondMcHard);
        tv_firstMc = findViewById(R.id.texto_firstMcHard);
        btn_nextRound = findViewById(R.id.btn_nextRound);

        //obtengo los nombres de los mcs seleccionados
        firstMc = DialogNewVotation.firstMcSelected;
        secondMc = DialogNewVotation.secondMcSelected;


        //coloco los nombres de los mcs en las TextViews
        tv_firstMc.setText(firstMc);
        tv_secondMc.setText(secondMc);

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
        fmScene.setText(String.valueOf(pointsFmScene));
        fmFlow.setText(String.valueOf(pointsFmFlow));
        fmSkills.setText(String.valueOf(pointsFmSkills));
        sm1.setText(String.valueOf(pointsSm1));
        sm2.setText(String.valueOf(pointsSm2));
        sm3.setText(String.valueOf(pointsSm3));
        sm4.setText(String.valueOf(pointsSm4));
        sm5.setText(String.valueOf(pointsSm5));
        sm6.setText(String.valueOf(pointsSm6));
        smScene.setText(String.valueOf(pointsSmScene));
        smFlow.setText(String.valueOf(pointsSmFlow));
        smSkills.setText(String.valueOf(pointsSmSkills));
    }

    private void nextRound(){

        //si el usuario presiona el boton siguiente ronda, paso al ThemeMode, solamente si todos los campos están rellenos
        btn_nextRound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                totalFirstMcSecond = pointsFm1 + pointsFm2 + pointsFm3 + pointsFm4
                        + pointsFm5 + pointsFm6 + pointsFmScene + pointsFmFlow + pointsFmSkills;
                totalSecondMcSecond = pointsSm1 + pointsSm2 + pointsSm3 + pointsSm4
                        + pointsSm5 + pointsSm6 + pointsSmScene + pointsSmFlow + pointsSmSkills;

                Intent intent = new Intent(getApplicationContext(), FinalResult.class);

                startActivity(intent);

            }
        });

    }
}