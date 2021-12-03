package com.eddd.votarfms.adapters;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.eddd.votarfms.models.Batalla;
import com.eddd.votarfms.R;
import com.eddd.votarfms.dialogs.DialogDeleteBattle;
import com.eddd.votarfms.dialogs.DialogShowBattle;
import com.eddd.votarfms.serializer.JSONSerializer;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

import java.util.ArrayList;
import java.util.List;

public class ListOfBattles extends AppCompatActivity {

    private BattlesAdapter mBattlesAdapter;
    private ListView listView;
    private Batalla mBattle;

    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);

        mBattlesAdapter = new BattlesAdapter();
        listView = findViewById(R.id.listView);

        listView.setAdapter(mBattlesAdapter);

        mBattle = getIntent().getParcelableExtra("batalla");


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //recupero la batalla de la posición pulsada por el usuario
                Object tempBattle = mBattlesAdapter.getItem(position);

                //creo una instancia con el diálogo a mostrar
                DialogShowBattle dialogShowBattle = new DialogShowBattle();

                //envío la batalla seleccionada por argumento
                dialogShowBattle.sendBattleSelected((Batalla)tempBattle);

                //muestro el fragmento utilizando el FragmentManager por defecto del sistema
                dialogShowBattle.show(getSupportFragmentManager(), "");
            }
        });

        listView.setLongClickable(true);

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                Object battleToDelete = mBattlesAdapter.getItem(position);

                DialogDeleteBattle dialogDeleteBattle = new DialogDeleteBattle();
                dialogDeleteBattle.sendBattleSelected((Batalla) battleToDelete);

                dialogDeleteBattle.show(getSupportFragmentManager(), "");

                return true;
            }
        });

        if (mBattle != null){
            createNewBattle(mBattle);
        }

        startInterstitialAd();
    }

    public void startInterstitialAd(){

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-3984939241340358/5047026552");
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

    public void createNewBattle(Batalla newBattle){

        //este método recibirá (mediante el parámetro) los datos de una nueva batalla creada
        mBattlesAdapter.addBattle(newBattle);

    }

    public void deleteBattle(Batalla battleToDelete){

        //este método recibirá mediante el parámetro la batalla a eliminar
        mBattlesAdapter.removeBattle(battleToDelete);
    }

    @Override
    protected void onPause() {
        super.onPause();

        mBattlesAdapter.saveBattles();
    }

    public class BattlesAdapter extends BaseAdapter{

        List<Batalla> myBattles = new ArrayList<>();

        //utilizaremos un objeto de la clase JSONSerializer creada con anterioridad
        private JSONSerializer mSerializer;

        public BattlesAdapter(){

            //creamos el objeto JSONSerializer y le pasamos los argumentos filename y context
            mSerializer = new JSONSerializer("MyBattles.json", ListOfBattles.this.getApplicationContext());

            //realizamos la carga de las notas guardadas en el fichero, con el método Load creado en el JSONSerializer
            //al poder arrojar excepciones IOException y JSONException lo rodeamos de un try catch
            try {

                myBattles = mSerializer.Load();
            }catch (Exception e){
                e.printStackTrace();
            }

        }

        //guardamos las batalas creadas en un fichero, con el método Save creado en el JSONSerializer
        public void saveBattles(){

            //al poder arrojar excepciones, lo rodeamos de un try catch
            try {

                mSerializer.Save(myBattles);
            } catch (Exception e){
                e.printStackTrace();
            }

        }

        @Override
        public int getCount() {
            return myBattles.size();
        }

        @Override
        public Object getItem(int position) {
            return myBattles.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            //en este método voy a programar la lógica de las celdas de la View

            //la vista no ha sido accedida anteriormente, por lo que hay que inflarla a través de un layout
            if (convertView == null){

                LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.list_item, parent, false);
            }

            //if (mBattle!=null){
                //una vez está la lista definida,es momento de cargar todos los widgets y layouts
                TextView tv_firstMc = convertView.findViewById(R.id.firstMcItem);
                TextView tv_secondMc = convertView.findViewById(R.id.secondMcItem);
                TextView tv_pointsFirstMc = convertView.findViewById(R.id.firstMcItemPoints);
                TextView tv_pointsSecondMc = convertView.findViewById(R.id.secondMcItemPoints);
                TextView tv_winner = convertView.findViewById(R.id.tv_winnerItem);
                ImageView iv_league = convertView.findViewById(R.id.imageView2);

                //coloco nombres de mcs, puntajes y ganador en las TextViews
                Batalla currentBattle = myBattles.get(position);

                tv_firstMc.setText(currentBattle.getFirstMc());
                tv_secondMc.setText(currentBattle.getSecondMc());
                tv_pointsFirstMc.setText(String.valueOf(currentBattle.getTotalPointsFM()));
                tv_pointsSecondMc.setText(String.valueOf(currentBattle.getTotalPointsSM()));
                tv_winner.setText("Ganador: " + currentBattle.getWinner());

                if (currentBattle.getLeague().equals("Todas")){
                    iv_league.setImageResource(R.drawable.fms_todas);
                }else if (currentBattle.getLeague().equals("FMS Argentina")){
                    iv_league.setImageResource(R.drawable.fms_argentina);
                } else if (currentBattle.getLeague().equals("FMS Chile")){
                    iv_league.setImageResource(R.drawable.fms_chile);
            } else if (currentBattle.getLeague().equals("FMS España")){
                    iv_league.setImageResource(R.drawable.fms_espania);
                } else if (currentBattle.getLeague().equals("FMS México")){
                    iv_league.setImageResource(R.drawable.fms_mexico);
                } else if (currentBattle.getLeague().equals("FMS Perú")){
                    iv_league.setImageResource(R.drawable.fms_peru);
                }
           // }

            return convertView;
        }

        public void removeBattle(Batalla batalla){

            myBattles.remove(batalla);
            notifyDataSetChanged();
        }

        public void addBattle(Batalla batalla){

            myBattles.add(batalla);
            notifyDataSetChanged();
        }

    }


}
