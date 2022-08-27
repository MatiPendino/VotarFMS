package com.eddd.votarfms.dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.fragment.app.DialogFragment;

import com.eddd.votarfms.modes.IncrementalMode;
import com.eddd.votarfms.R;
import com.eddd.votarfms.modes.EasyMode;
import com.eddd.votarfms.modes.RandomMode;
import com.eddd.votarfms.modes.ThemesMode;

public class DialogNewVotation extends DialogFragment {

    Spinner spinnerLeague, spinnerOne, spinnerTwo;
    public static String firstMcSelected, secondMcSelected, leagueSelected;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        //creo el AlertDialog, e inflo la alerta con el LayoutInflater, con el getLayoutInflater(), y obteniendo la actividad
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        //defino qué voy a inflar (una View) y cuál vista voy a inflar, en este caso será la dialog_new_votation
        View dialogView = inflater.inflate(R.layout.dialog_new_votation, null);

        spinnerLeague = dialogView.findViewById(R.id.spinner_league);
        spinnerOne = dialogView.findViewById(R.id.spinner_mcOne);
        spinnerTwo = dialogView.findViewById(R.id.spinner_mcTwo);
        final Button btn_cancel = dialogView.findViewById(R.id.btn_cancel);
        final Button btn_vote = dialogView.findViewById(R.id.btn_goToVote);
        final Button btn_applySelection = dialogView.findViewById(R.id.btn_apply_selection);

        //coloco el título del fragmento
        builder.setView(dialogView).setMessage("Puntuar Nueva Batalla");

        //inicio con los dos spinner desactivados, y los dos botones de abajo invisibles
        spinnerOne.setEnabled(false);
        spinnerTwo.setEnabled(false);
        btn_cancel.setVisibility(View.INVISIBLE);
        btn_vote.setVisibility(View.INVISIBLE);

        //creo el Array para las ligas, y creo un adapter para colocar ese array en el spinner
        String[] optionsLeagues = {"Todas", "FMS Argentina", "FMS Chile", "FMS Colombia", "FMS España", "FMS México", "FMS Perú",
                "Inter Clasificatoria", "Inter Octavos", "Inter Cuartos", "Inter Semis", "Inter Final"};
        ArrayAdapter<String> adapterLeagues = new ArrayAdapter<>(getActivity().getApplicationContext(),
                android.R.layout.simple_spinner_dropdown_item, optionsLeagues);
        spinnerLeague.setAdapter(adapterLeagues);


        //si el usuario presiona aplicar selección, muestro los mcs de la liga seleccionada y los dos botones de abajo,
        //pongo invisible el primer botón de cancelar, y cambió el texto del botón de aplicar selección a actualizar selección
        btn_applySelection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //creo un string al cual le asigno la opción seleccionada en el Spinner
                leagueSelected = spinnerLeague.getSelectedItem().toString();

                //activo los dos spinners que estaban deshabilitados
                spinnerOne.setEnabled(true);
                spinnerTwo.setEnabled(true);

                //pongo visibles los botones de abajo, pongo invisible el primer cancelae y cambio el texto a actualizar seleccion
                btn_cancel.setVisibility(View.VISIBLE);
                btn_vote.setVisibility(View.VISIBLE);
                btn_applySelection.setText(R.string.actualizar_seleccion);

                //asigno a los otros dos spinners los MCs según la liga escogida
                if (leagueSelected.equals("Todas")){
                    String[] fmsTodasMcs= {"Acertijo", "Aczino","Airon", "Anubis","Basek", "Arkano", "Big Killah", "Blon","Black Code", "Bnet","BTA",
                            "B.One", "Cacha", "Carpediem", "Chang", "Choque", "Chuty", "Dani", "Dante", "Diego MC", "Drose", "Dtoke", "Elekipo",
                            "Elevn",  "El Menor", "Enzo", "Errecé", "Erreka", "Esezeta", "Filósofo", "Force", "Garza", "Gaviria", "Gazir", "Ghost",
                            "Hander", "Invert", "Jack","Jair Wong", "Jaze", "JNO", "Jony B", "Jokker", "Joquer", "Jota", "Kaiser", "Katra", "Khan",
                            "KIAN", "Klan","Lancer Lirical", "Larrix", "Letra", "Litzen", "Lobo Estepario", "Lokillo", "Mcklopedia", "Mecha",
                            "Metalinguistica", "MKS", "Mnak","MP", "Mr. Ego", "Nacho", "Naista", "Nekroos", "New Era", "Nitro", "ÑKO", "Papo", "Pepe Grillo",
                            "Potencia","Ramses", "RBN", "RC", "Replik", "Ricto", "Rodamiento", "Sara Socas", "Skill", "Skiper", "Skone","Stick",
                            "Stigma", "Strike", "Stuart", "SUB", "SweetPain", "Tata", "Teorema", "Tirpa", "Tom Crawley",
                            "Trueno", "Vijay Kesh", "Walls", "Wolf", "Wos", "Yoiker", "Zaina", "Zasko", "Zika", "Zticma"};

                    ArrayAdapter<String> adapterAll = new ArrayAdapter<>(getActivity().getApplicationContext(),
                    android.R.layout.simple_spinner_dropdown_item, fmsTodasMcs);

                    spinnerOne.setAdapter(adapterAll);
                    spinnerTwo.setAdapter(adapterAll);

                    firstMcSelected = spinnerOne.getSelectedItem().toString();
                    secondMcSelected = spinnerTwo.getSelectedItem().toString();
                }
                if (leagueSelected.equals("FMS Argentina")){

                    String[] fmsArgentinaMcs = {"Cacha", "Dani", "Dtoke","Katra", "Klan", "Larrix", "Mecha", "MKS", "MP",
                            "Nacho","Naista", "Papo", "Replik", "Stuart", "SUB", "Tata", "Trueno", "Wolf", "Wos", "Zaina"};
                    ArrayAdapter<String> adapterArg = new ArrayAdapter<>(getActivity().getApplicationContext(),
                            android.R.layout.simple_spinner_dropdown_item, fmsArgentinaMcs);

                    spinnerOne.setAdapter(adapterArg);
                    spinnerTwo.setAdapter(adapterArg);

                    firstMcSelected = spinnerOne.getSelectedItem().toString();
                    secondMcSelected = spinnerTwo.getSelectedItem().toString();

                }
                if (leagueSelected.equals("FMS Chile")){

                    //activo los dos spinners que estaban deshabilitados
                    spinnerOne.setEnabled(true);
                    spinnerTwo.setEnabled(true);

                    String[] fmsChileMcs = {"Acertijo", "Anubis", "Basek", "Drose", "El Menor", "Erreka", "Esezeta", "JNO", "Jokker", "Joquer",
                            "Kaiser", "Metalinguistica", "Nitro", "Pepe Grillo", "Ricto", "Rodamiento", "Stigma", "Teorema", "Tom Crawley"};
                    ArrayAdapter<String> adapterChile = new ArrayAdapter<>(getActivity().getApplicationContext(),
                            android.R.layout.simple_spinner_dropdown_item, fmsChileMcs);
                    spinnerOne.setAdapter(adapterChile);
                    spinnerTwo.setAdapter(adapterChile);

                    firstMcSelected = spinnerOne.getSelectedItem().toString();
                    secondMcSelected = spinnerTwo.getSelectedItem().toString();

                }
                if (leagueSelected.equals("FMS España")){

                    spinnerOne.setEnabled(true);
                    spinnerTwo.setEnabled(true);

                    String[] fmsSpainMcs = {"Arkano", "Blon", "Bnet", "BTA", "Chuty", "Elekipo", "Errecé",
                            "Force", "Gazir", "Hander", "Invert", "Khan", "Mnak", "Mr. Ego", "Sara Socas",
                            "Skone", "Sweetpain", "Tirpa", "Walls", "Zasko"};
                    ArrayAdapter<String> adapterSpain = new ArrayAdapter<>(getActivity().getApplicationContext(),
                            android.R.layout.simple_spinner_dropdown_item, fmsSpainMcs);

                    spinnerOne.setAdapter(adapterSpain);
                    spinnerTwo.setAdapter(adapterSpain);

                    firstMcSelected = spinnerOne.getSelectedItem().toString();
                    secondMcSelected = spinnerTwo.getSelectedItem().toString();
                }
                if (leagueSelected.equals("FMS México")){

                    spinnerOne.setEnabled(true);
                    spinnerTwo.setEnabled(true);

                    String[] fmsMexicoMcs = {"Aczino", "B.One", "Dante", "Garza", "Jack", "Jony", "Lancer Lirical",
                            "Lobo Estepario", "Mcklopedia", "Potencia", "Rapder", "RC", "Skiper", "Yoiker", "Zticma"};
                    ArrayAdapter<String> adapterMex = new ArrayAdapter<>(getActivity().getApplicationContext(),
                            android.R.layout.simple_spinner_dropdown_item, fmsMexicoMcs);

                    spinnerOne.setAdapter(adapterMex);
                    spinnerTwo.setAdapter(adapterMex);

                    firstMcSelected = spinnerOne.getSelectedItem().toString();
                    secondMcSelected = spinnerTwo.getSelectedItem().toString();
                }
                if (leagueSelected.equals("FMS Perú")){

                    spinnerOne.setEnabled(true);
                    spinnerTwo.setEnabled(true);

                    String[] fmsPeruMcs = {"Black Code", "Choque", "Diego MC", "Enzo", "Ghost", "Jair Wong", "Jaze", "Jota", "KIAN", "Litzen","Nekroos", "New Era",
                            "Ramses", "Skill", "Stick", "Strike", "Vijay Kesh", "Zika"};
                    ArrayAdapter<String> adapterPeru = new ArrayAdapter<>(getActivity().getApplicationContext(),
                            android.R.layout.simple_spinner_dropdown_item, fmsPeruMcs);

                    spinnerOne.setAdapter(adapterPeru);
                    spinnerTwo.setAdapter(adapterPeru);
                }
                if (leagueSelected.equals("FMS Colombia")){
                    spinnerOne.setEnabled(true);
                    spinnerTwo.setEnabled(true);

                    String[] fmsColombiaMcs = {"Airon", "Big Killah", "Carpediem", "Chang", "Elevn","Filósofo", "Gaviria", "Letra",
                            "Lokillo", "ÑKO", "RBN", "Valles T"};
                    ArrayAdapter<String> adapterColombia = new ArrayAdapter<>(getActivity().getApplicationContext(),
                            android.R.layout.simple_spinner_dropdown_item, fmsColombiaMcs);
                    spinnerOne.setAdapter(adapterColombia);
                    spinnerTwo.setAdapter(adapterColombia);
                }

                //Internacional
                //Declaro un array con todos los participantes posibles
                String[] fmsInter = {"Acertijo", "Aczino", "Bnet", "Garza", "Gazir", "Jaze", "Jokker", "Joqqer", "Jota", "Klan", "Lobo Estepario",
                "Mecha", "Mnak", "Nacho", "Nekroos", "Nitro", "Papo", "Pepe Grillo", "Rapder", "RC", "Ricto","Skill", "Skiper","Stick","Strike", "Stuart",
                        "SweetPain", "Tirpa", "Wolf", "Yoiker", "Zasko"};
                if(leagueSelected.equals("Inter Clasificatoria")){
                    spinnerOne.setEnabled(true);
                    spinnerTwo.setEnabled(true);

                    ArrayAdapter<String> adapterInter = new ArrayAdapter<>(getActivity().getApplicationContext(),
                            android.R.layout.simple_spinner_dropdown_item, fmsInter);

                    spinnerOne.setAdapter(adapterInter);
                    spinnerTwo.setAdapter(adapterInter);
                }
                if(leagueSelected.equals("Inter Octavos")){
                    spinnerOne.setEnabled(true);
                    spinnerTwo.setEnabled(true);

                    ArrayAdapter<String> adapterOct = new ArrayAdapter<>(getActivity().getApplicationContext(),
                            android.R.layout.simple_spinner_dropdown_item, fmsInter);
                    spinnerOne.setAdapter(adapterOct);
                    spinnerTwo.setAdapter(adapterOct);
                }
                if(leagueSelected.equals("Inter Cuartos")){
                    spinnerOne.setEnabled(true);
                    spinnerTwo.setEnabled(true);

                    ArrayAdapter<String> adapterQuart = new ArrayAdapter<>(getActivity().getApplicationContext(),
                            android.R.layout.simple_spinner_dropdown_item, fmsInter);
                    spinnerOne.setAdapter(adapterQuart);
                    spinnerTwo.setAdapter(adapterQuart);
                }
                if(leagueSelected.equals("Inter Semis")){
                    spinnerOne.setEnabled(true);
                    spinnerTwo.setEnabled(true);

                    ArrayAdapter<String> adapterSemi = new ArrayAdapter<>(getActivity().getApplicationContext(),
                            android.R.layout.simple_spinner_dropdown_item, fmsInter);
                    spinnerOne.setAdapter(adapterSemi);
                    spinnerTwo.setAdapter(adapterSemi);
                }
                if(leagueSelected.equals("Inter Final")){
                    spinnerOne.setEnabled(true);
                    spinnerTwo.setEnabled(true);

                    ArrayAdapter<String> adapterFinal = new ArrayAdapter<>(getActivity().getApplicationContext(),
                            android.R.layout.simple_spinner_dropdown_item, fmsInter);
                    spinnerOne.setAdapter(adapterFinal);
                    spinnerTwo.setAdapter(adapterFinal);
                }

            }
        });


        //si el usuario presiona cancelar, se cierra el diálogo
        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        //si el usuario presiona Ir a votar, se lo envía al EasyMode mediante un Intent
        btn_vote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    firstMcSelected = spinnerOne.getSelectedItem().toString();
                    secondMcSelected = spinnerTwo.getSelectedItem().toString();
                    leagueSelected = spinnerLeague.getSelectedItem().toString();

                    if(leagueSelected.equals("FMS Argentina") || leagueSelected.equals("FMS España") || leagueSelected.equals("FMS Perú") ||
                    leagueSelected.equals("FMS México") || leagueSelected.equals("FMS Chile") || leagueSelected.equals("FMS Colombia") ||
                            leagueSelected.equals("Todas")){
                        Intent intent = new Intent(getContext(), EasyMode.class);
                        startActivity(intent);
                    } else if (leagueSelected.equals("Inter Clasificatoria")){
                        Intent intent = new Intent(getContext(), IncrementalMode.class);
                        startActivity(intent);
                    } else if (leagueSelected.equals("Inter Octavos")){
                        Intent intent = new Intent(getContext(), EasyMode.class);
                        startActivity(intent);
                    } else if(leagueSelected.equals("Inter Cuartos")){
                        Intent intent = new Intent(getContext(), ThemesMode.class);
                        startActivity(intent);
                    } else if(leagueSelected.equals("Inter Semis")){
                        Intent intent = new Intent(getContext(), RandomMode.class);
                        startActivity(intent);
                    } else if (leagueSelected.equals("Inter Final")){
                        Intent intent = new Intent(getContext(), EasyMode.class);
                        startActivity(intent);
                    }

                    dismiss();

            }
        });

        return  builder.create();
    }


}
