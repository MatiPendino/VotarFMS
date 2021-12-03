package com.eddd.votarfms.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.eddd.votarfms.R;
import com.eddd.votarfms.adapters.ListOfBattles;
import com.eddd.votarfms.dialogs.DialogNewVotation;
import com.eddd.votarfms.models.Batalla;
import com.eddd.votarfms.tables.WatchTables;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class MainActivity extends AppCompatActivity {

    private Batalla mBattle;

    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBattle = getIntent().getParcelableExtra("batalla");

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


    public void newPunctuation(View view){

        DialogNewVotation newVotation = new DialogNewVotation();

        newVotation.show(getSupportFragmentManager(), "");
    }

    public void seeLastElections(View view){

        Intent intent = new Intent(this, ListOfBattles.class);
        intent.putExtra("batalla", mBattle);
        startActivity(intent);

    }

    public void watchTables(View view){

        Intent intent = new Intent(this, WatchTables.class);
        startActivity(intent);

    }

    public void rateUs(View view){

        Uri uri = Uri.parse("https://play.google.com/store/apps/details?id=com.eddd.votarfms&hl=es_419");

        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void removeAds(View view){


    }


}