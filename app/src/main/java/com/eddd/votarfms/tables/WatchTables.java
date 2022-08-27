package com.eddd.votarfms.tables;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.eddd.votarfms.R;
import com.eddd.votarfms.tables.ArgentinaTable;
import com.eddd.votarfms.tables.ChileTable;
import com.eddd.votarfms.tables.MexicoTable;
import com.eddd.votarfms.tables.PeruTable;
import com.eddd.votarfms.tables.SpainTable;

public class WatchTables extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.watch_tables);
    }

    public void seeArgentina(View view){

        Intent intent = new Intent(this, ArgentinaTable.class);
        startActivity(intent);
    }

    public void seeChile(View view){

        Intent intent = new Intent(this, ChileTable.class);
        startActivity(intent);
    }

    public void seeSpain(View view){

        Intent intent = new Intent(this, SpainTable.class);
        startActivity(intent);
    }

    public void seeMexico(View view){

        Intent intent = new Intent(this, MexicoTable.class);
        startActivity(intent);
    }

    public void seePeru(View view){

        Intent intent = new Intent(this, PeruTable.class);
        startActivity(intent);
    }

    public void seeColombia(View view){
        Intent intent = new Intent(this, ColombiaTable.class);
        startActivity(intent);
    }

}