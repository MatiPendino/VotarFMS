package com.eddd.votarfms.tables;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.eddd.votarfms.R;
import com.eddd.votarfms.adapters.ArgentinaLeagueAdapter;
import com.eddd.votarfms.adapters.SpainLeagueAdapter;
import com.eddd.votarfms.models.ArgentinaMC;
import com.eddd.votarfms.models.SpainMC;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class SpainTable extends AppCompatActivity {

    private FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
    private CollectionReference mCollection = firebaseFirestore.collection("SpainTable");

    private SpainLeagueAdapter mAdapter;

    private AdView mAdView;
    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spain_table);

        setUpRecyclerView();
        startBannerAd();
        startInterstitialAd();
    }

    private void startBannerAd(){
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
        mInterstitialAd.setAdUnitId("ca-app-pub-3984939241340358/8209549975");
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


    private void setUpRecyclerView(){

        Query query = mCollection.orderBy("position", Query.Direction.ASCENDING);

        FirestoreRecyclerOptions<SpainMC> options = new FirestoreRecyclerOptions.Builder<SpainMC>()
                .setQuery(query, SpainMC.class)
                .build();

        mAdapter = new SpainLeagueAdapter(options);

        RecyclerView recyclerViewSpain = findViewById(R.id.recyclerViewSpain);
        recyclerViewSpain.setHasFixedSize(true);
        recyclerViewSpain.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewSpain.setAdapter(mAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();

        mAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();

        mAdapter.stopListening();
    }

}