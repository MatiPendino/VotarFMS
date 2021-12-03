package com.eddd.votarfms.tables;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.eddd.votarfms.R;
import com.eddd.votarfms.adapters.PeruLeagueAdapter;
import com.eddd.votarfms.models.PeruMC;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class PeruTable extends AppCompatActivity {

    private FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
    private CollectionReference mCollection = firebaseFirestore.collection("PeruTable");

    private PeruLeagueAdapter mAdapter;

    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.peru_table);

        setUpRecyclerView();
        startBannerAd();
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


    private void setUpRecyclerView(){

        Query query = mCollection.orderBy("position", Query.Direction.ASCENDING);

        FirestoreRecyclerOptions<PeruMC> options = new FirestoreRecyclerOptions.Builder<PeruMC>()
                                                    .setQuery(query, PeruMC.class)
                                                    .build();

        mAdapter = new PeruLeagueAdapter(options);

        RecyclerView recyclerViewPeru = findViewById(R.id.recyclerViewPeru);
        recyclerViewPeru.setHasFixedSize(true);
        recyclerViewPeru.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewPeru.setAdapter(mAdapter);
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