package com.eddd.votarfms.modes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.eddd.votarfms.R;
import com.eddd.votarfms.activities.MainActivity;
import com.eddd.votarfms.dialogs.DialogNewVotation;
import com.eddd.votarfms.models.Batalla;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class FinalResult extends Activity {

    private TextView tvFirstMc, tvSecondMc, fmEasy, fmHard, fmThemes, fmRandom, fmBlood, fmDeluxe, fmTotal, smEasy, smHard, smThemes, smRandom, smBlood,
            smDeluxe,smTotal, tv_winner;
    private String firstMc, secondMc, winner ,leagueSelected;
    private float pointsFirstEasy, pointsSecondEasy, pointsSecondHard, pointsFirstHard, pointsFirstThemes, pointsSecondThemes, pointsSecondThemes2, pointsFirstThemes2,
            pointsFirstRandom, pointsSecondRandom, pointsSecondBlood, pointsFirstBlood, pointsFirstBlood2, pointsSecondBlood2, pointsSecondDeluxe, pointsFirstDeluxe;
    private float totalFirstThemes, totalSecondThemes, totalFirstBlood, totalSecondBlood;
    private float finalResultFirst, finalResultSecond;



    private TextView tvEasy, tvHard, tvThemes, tvRandom, tvBlood, tvDeluxe;
    private float pointsFirstIncremental, pointsSecondIncremental, pointsFirstSecond, pointsSecondSecond;
    private float pointsFirstObjects, pointsSecondObjects;

    private Button btn_save;

    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.final_result);

        tvFirstMc = findViewById(R.id.texto_firstMc);
        tvSecondMc = findViewById(R.id.texto_secondMc);
        fmEasy = findViewById(R.id.tv_firstEasy);
        fmHard = findViewById(R.id.textView16);
        fmThemes = findViewById(R.id.textView17);
        fmRandom = findViewById(R.id.textView18);
        fmBlood = findViewById(R.id.textView19);
        fmDeluxe = findViewById(R.id.textView20);
        fmTotal =findViewById(R.id.textView21);

        smEasy = findViewById(R.id.textView15);
        smHard = findViewById(R.id.textView22);
        smThemes = findViewById(R.id.textView23);
        smRandom = findViewById(R.id.textView24);
        smBlood = findViewById(R.id.textView25);
        smDeluxe = findViewById(R.id.textView26);
        smTotal = findViewById(R.id.textView27);

        tvEasy = findViewById(R.id.textEasy);
        tvHard = findViewById(R.id.textHard);
        tvThemes = findViewById(R.id.textThemes);
        tvRandom = findViewById(R.id.textRandom);
        tvBlood = findViewById(R.id.textBlood);
        tvDeluxe = findViewById(R.id.textDeluxe);

        btn_save = findViewById(R.id.button7);

        tv_winner = findViewById(R.id.textView28);

        //obtengo los nombres de los mcs seleccionados
        firstMc = DialogNewVotation.firstMcSelected;
        secondMc = DialogNewVotation.secondMcSelected;
        leagueSelected = DialogNewVotation.leagueSelected;
        pointsFirstEasy = EasyMode.totalFirstMcEasy;
        pointsSecondEasy = EasyMode.totalSecondMcEasy;
        pointsSecondHard = HardMode.totalSecondMcHard;
        pointsFirstHard = HardMode.totalFirstMcHard;
        pointsFirstThemes = ThemesMode.totalFirstMcThemes;
        pointsSecondThemes = ThemesMode.totalSecondMcThemes;
        pointsSecondThemes2 = ThemesMode2.totalSecondMcThemes2;
        pointsFirstThemes2 = ThemesMode2.totalFirstMcThemes2;
        pointsFirstRandom = RandomMode.totalFirstMcRandom;
        pointsSecondRandom = RandomMode.totalSecondMcRandom;
        pointsSecondBlood = BloodMode.totalSecondMcBlood;
        pointsFirstBlood = BloodMode.totalFirstMcBlood;
        pointsFirstBlood2 = BloodMode2.totalFirstMcBlood2;
        pointsSecondBlood2 = BloodMode2.totalSecondMcBlood2;
        pointsSecondDeluxe = Deluxe.totalSecondMcDeluxe;
        pointsFirstDeluxe = Deluxe.totalFirstMcDeluxe;

        pointsFirstIncremental = IncrementalMode.totalFirstMcIncremental;
        pointsSecondIncremental = IncrementalMode.totalSecondMcIncremental;
        pointsFirstSecond = SegundoRound.totalFirstMcSecond;
        pointsSecondSecond = SegundoRound.totalSecondMcSecond;

        pointsFirstObjects = ObjetosFinalMode.totalFirstMcObjects;
        pointsSecondObjects = ObjetosFinalMode.totalSecondMcObjects;

        totalFirstThemes = pointsFirstThemes + pointsFirstThemes2;
        totalSecondThemes = pointsSecondThemes + pointsSecondThemes2;
        totalFirstBlood = pointsFirstBlood + pointsFirstBlood2;
        totalSecondBlood = pointsSecondBlood + pointsSecondBlood2;

        applyPunctuationsAndNames();
        plusAndShowFinalResult(pointsFirstEasy, pointsFirstHard, totalFirstThemes, pointsFirstRandom, totalFirstBlood, pointsFirstDeluxe,
                                pointsSecondEasy, pointsSecondHard, totalSecondThemes, pointsSecondRandom, totalSecondBlood, pointsSecondDeluxe,
                pointsFirstIncremental, pointsFirstSecond, pointsSecondIncremental, pointsSecondSecond, pointsFirstObjects, pointsSecondObjects);


        decideWinner();


        //saveBattleDetails();

        changeButtonText();

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(leagueSelected.equals("FMS Argentina") || leagueSelected.equals("FMS España") || leagueSelected.equals("FMS Perú") ||
                leagueSelected.equals("Todas") || leagueSelected.equals("FMS Chile") || leagueSelected.equals("FMS México")){
                    Toast.makeText(getApplicationContext(), "Puntuación guardada correctamente", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);

                    Batalla mBattle = new Batalla(firstMc, secondMc,leagueSelected, winner, pointsFirstEasy, pointsFirstHard, totalFirstThemes, pointsFirstRandom, totalFirstBlood,
                            pointsFirstDeluxe, finalResultFirst, pointsSecondEasy, pointsSecondHard, totalSecondThemes, pointsSecondRandom, totalSecondBlood,
                            pointsSecondDeluxe, finalResultSecond);

                    intent.putExtra("batalla", mBattle);

                    startActivity(intent);
                } else {
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                }

            }
        });

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


   /* public void saveBattleDetails(){

        //guardo los nombres de los mcs y todos los puntajes en el objeto mBattle de la instancia Batalla
        mBattle.setFirstMc(firstMc);
        mBattle.setSecondMc(secondMc);
        mBattle.setPointsFMEasyMode(pointsFirstEasy);
        mBattle.setPointsFMHardMode(pointsFirstHard);
        mBattle.setPointsFMThemes(totalFirstThemes);
        mBattle.setPointsFMRandomMode(pointsFirstRandom);
        mBattle.setPointsFMBloodMode(totalFirstBlood);
        mBattle.setPointsFMDeluxeMode(pointsFirstDeluxe);
        mBattle.setTotalPointsFM(finalResultFirst);

        mBattle.setPointsSMEasyMode(pointsSecondEasy);
        mBattle.setPointsSMHardMode(pointsSecondHard);
        mBattle.setPointsSMThemes(totalSecondThemes);
        mBattle.setPointsSMRandomMode(pointsSecondRandom);
        mBattle.setPointsSMBloodMode(totalSecondBlood);
        mBattle.setPointsSMDeluxeMode(pointsSecondDeluxe);
        mBattle.setTotalPointsSM(finalResultSecond);

    }*/

    public void applyPunctuationsAndNames(){
        tvFirstMc.setText(firstMc);
        tvSecondMc.setText(secondMc);

        if(leagueSelected.equals("FMS Argentina") || leagueSelected.equals("FMS España") || leagueSelected.equals("FMS Perú") || leagueSelected.equals("FMS México")
        || leagueSelected.equals("FMS Chile") || leagueSelected.equals("Todas")){
            fmEasy.setText(String.valueOf(pointsFirstEasy));
            fmHard.setText(String.valueOf(pointsFirstHard));
            fmThemes.setText(String.valueOf(totalFirstThemes));
            fmRandom.setText(String.valueOf(pointsFirstRandom));
            fmBlood.setText(String.valueOf(totalFirstBlood));
            fmDeluxe.setText(String.valueOf(pointsFirstDeluxe));

            smEasy.setText(String.valueOf(pointsSecondEasy));
            smHard.setText(String.valueOf(pointsSecondHard));
            smThemes.setText(String.valueOf(totalSecondThemes));
            smRandom.setText(String.valueOf(pointsSecondRandom));
            smBlood.setText(String.valueOf(totalSecondBlood));
            smDeluxe.setText(String.valueOf(pointsSecondDeluxe));
        } else if (leagueSelected.equals("Inter Clasificatoria")){
            fmEasy.setText(String.valueOf(pointsFirstIncremental));
            fmHard.setText(String.valueOf(pointsFirstSecond));
            smEasy.setText(String.valueOf(pointsSecondIncremental));
            smHard.setText(String.valueOf(pointsSecondSecond));

            tvEasy.setText("Incremental");
            tvHard.setText("8x8 120s");
            tvThemes.setText("");
            tvRandom.setText("");
            tvBlood.setText("");
            tvDeluxe.setText("");
            fmThemes.setText("");
            fmRandom.setText("");
            fmBlood.setText("");
            fmDeluxe.setText("");
            smDeluxe.setText("");
            smBlood.setText("");
            smThemes.setText("");
            smRandom.setText("");
        } else if(leagueSelected.equals("Inter Octavos")){
            fmEasy.setText(String.valueOf(pointsFirstEasy));
            fmBlood.setText(String.valueOf(totalFirstBlood));
            smEasy.setText(String.valueOf(pointsSecondEasy));
            smBlood.setText(String.valueOf(totalSecondBlood));

            tvHard.setText("");
            tvThemes.setText("");
            tvRandom.setText("");
            tvDeluxe.setText("");
            fmHard.setText("");
            fmThemes.setText("");
            fmRandom.setText("");
            fmDeluxe.setText("");
            smHard.setText("");
            smThemes.setText("");
            smRandom.setText("");
            smDeluxe.setText("");
        } else if (leagueSelected.equals("Inter Cuartos")){
            fmThemes.setText(String.valueOf(totalFirstThemes));
            fmRandom.setText(String.valueOf(pointsFirstRandom));
            fmDeluxe.setText(String.valueOf(pointsFirstDeluxe));
            smThemes.setText(String.valueOf(totalSecondThemes));
            smRandom.setText(String.valueOf(pointsSecondRandom));
            smDeluxe.setText(String.valueOf(pointsSecondDeluxe));

            tvEasy.setText("");
            tvHard.setText("");
            tvBlood.setText("");
            fmEasy.setText("");
            fmHard.setText("");
            fmBlood.setText("");
            smEasy.setText("");
            smHard.setText("");
            smBlood.setText("");
        } else if(leagueSelected.equals("Inter Semis")){
            fmRandom.setText(String.valueOf(pointsFirstRandom));
            fmBlood.setText(String.valueOf(totalFirstBlood));
            fmDeluxe.setText(String.valueOf(pointsFirstDeluxe));
            smRandom.setText(String.valueOf(pointsSecondRandom));
            smBlood.setText(String.valueOf(totalSecondBlood));
            smDeluxe.setText(String.valueOf(pointsSecondDeluxe));

            tvEasy.setText("");
            tvHard.setText("");
            tvThemes.setText("");
            fmEasy.setText("");
            fmHard.setText("");
            fmThemes.setText("");
            smEasy.setText("");
            smHard.setText("");
            smThemes.setText("");
        } else if(leagueSelected.equals("Inter Final")){
            fmEasy.setText(String.valueOf(pointsFirstEasy));
            fmHard.setText(String.valueOf(pointsFirstHard));
            fmThemes.setText(String.valueOf(totalFirstThemes));
            fmRandom.setText(String.valueOf(pointsFirstObjects));
            fmBlood.setText(String.valueOf(totalFirstBlood));
            fmDeluxe.setText(String.valueOf(pointsFirstDeluxe));
            smEasy.setText(String.valueOf(pointsSecondEasy));
            smHard.setText(String.valueOf(pointsSecondHard));
            smThemes.setText(String.valueOf(totalSecondThemes));
            smRandom.setText(String.valueOf(pointsSecondObjects));
            smBlood.setText(String.valueOf(totalSecondBlood));
            smDeluxe.setText(String.valueOf(pointsSecondDeluxe));

            tvRandom.setText("Objetos");
        }


    }

    public void plusAndShowFinalResult(float firstEasy, float firstHard, float firstThemes, float firstRandom, float firstBlood, float firstDeluxe,
                                       float secondEasy, float secondHard, float secondThemes, float secondRandom, float secondBlood, float secondDeluxe,
                                       float firstIncremental, float firstSecond, float secondIncremental, float secondSecond, float firstObjects,
                                       float secondObjects){

        finalResultFirst = firstEasy+firstHard+firstThemes+firstRandom+firstBlood+firstDeluxe + firstIncremental + firstSecond + firstObjects;
        finalResultSecond = secondEasy+secondHard+secondThemes+secondRandom+secondBlood+secondDeluxe + secondIncremental + secondSecond + secondObjects;

        fmTotal.setText(String.valueOf(finalResultFirst));
        smTotal.setText(String.valueOf(finalResultSecond));
    }


    public void decideWinner(){

        if(leagueSelected.equals("FMS Argentina") || leagueSelected.equals("FMS España") || leagueSelected.equals("FMS Perú") || leagueSelected.equals("FMS México")
                || leagueSelected.equals("FMS Chile") || leagueSelected.equals("Todas") || leagueSelected.equals("Inter Final")){
            if (finalResultFirst > finalResultSecond+5){
                tv_winner.setText("Ganador: " + firstMc);
                winner = firstMc;
            } else if (finalResultSecond > finalResultFirst+5){
                tv_winner.setText("Ganador: " +secondMc);
                winner = secondMc;
            } else {
                tv_winner.setText("Réplica");
                winner = "Réplica";
            }
        } else if(leagueSelected.equals("Inter Clasificatoria") || leagueSelected.equals("Inter Octavos")){
            if (finalResultFirst > finalResultSecond+2){
                tv_winner.setText("Ganador: " + firstMc);
                winner = firstMc;
            } else if (finalResultSecond > finalResultFirst+2){
                tv_winner.setText("Ganador: " +secondMc);
                winner = secondMc;
            } else {
                tv_winner.setText("Réplica");
                winner = "Réplica";
            }
        } else if(leagueSelected.equals("Inter Cuartos") || leagueSelected.equals("Inter Semis")){
            if (finalResultFirst > finalResultSecond+3){
                tv_winner.setText("Ganador: " + firstMc);
                winner = firstMc;
            } else if (finalResultSecond > finalResultFirst+3){
                tv_winner.setText("Ganador: " +secondMc);
                winner = secondMc;
            } else {
                tv_winner.setText("Réplica");
                winner = "Réplica";
            }
        }

    }

   /* public void savePunctuation(View view){

        //guardo los nombres de los mcs y todos los puntajes en el objeto mBattle de la instancia Batalla
        mBattle.setFirstMc(firstMc);
        mBattle.setSecondMc(secondMc);
        mBattle.setPointsFMEasyMode(pointsFirstEasy);
        mBattle.setPointsFMHardMode(pointsFirstHard);
        mBattle.setPointsFMThemes(totalFirstThemes);
        mBattle.setPointsFMRandomMode(pointsFirstRandom);
        mBattle.setPointsFMBloodMode(totalFirstBlood);
        mBattle.setPointsFMDeluxeMode(pointsFirstDeluxe);
        mBattle.setTotalPointsFM(finalResultFirst);

        mBattle.setPointsSMEasyMode(pointsSecondEasy);
        mBattle.setPointsSMHardMode(pointsSecondHard);
        mBattle.setPointsSMThemes(totalSecondThemes);
        mBattle.setPointsSMRandomMode(pointsSecondRandom);
        mBattle.setPointsSMBloodMode(totalSecondBlood);
        mBattle.setPointsSMDeluxeMode(pointsSecondDeluxe);
        mBattle.setTotalPointsSM(finalResultSecond);


        Toast.makeText(this, "Puntuación guardada correctamente", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, ListOfBattles.class);
        startActivity(intent);


    }*/

   public void changeButtonText(){
       if(leagueSelected.equals("Inter Clasificatoria") || leagueSelected.equals("Inter Octavos") || leagueSelected.equals("Inter Cuartos") ||
               leagueSelected.equals("Inter Semis") || leagueSelected.equals("Inter Final")){
           btn_save.setText("Finalizar Puntuación");
       }
   }

}