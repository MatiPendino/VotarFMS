package com.eddd.votarfms.dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.DialogFragment;

import com.eddd.votarfms.models.Batalla;
import com.eddd.votarfms.R;

public class DialogShowBattle extends DialogFragment {

    Batalla mBattle;

    public void sendBattleSelected(Batalla batalla){
        this.mBattle = batalla;
    }


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        //el getActivity se utiliza para activar la actividad que ha sido llamada
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();

        //creamos la vista para el layout
        View dialogView = inflater.inflate(R.layout.dialog_show_battle, null);

        //instanciamos todos los widgets del layout
        TextView firstMc, secondMc, firstEasy, firstHard, firstThemes, firstRandom, firstBlood, firstDeluxe, firstTotal, secondEasy, secondHard,
                secondThemes, secondRandom, secondBlood, secondDeluxe, secondTotal, winner;
        Button btn_ok;

        firstMc = dialogView.findViewById(R.id.txt_first);
        secondMc = dialogView.findViewById(R.id.txt_second);
        firstEasy = dialogView.findViewById(R.id.txt_firstEasy);
        firstHard = dialogView.findViewById(R.id.txt_firstHard);
        firstThemes = dialogView.findViewById(R.id.txt_firstThemes);
        firstRandom = dialogView.findViewById(R.id.txt_firstRandom);
        firstBlood = dialogView.findViewById(R.id.txt_firstBlood);
        firstDeluxe = dialogView.findViewById(R.id.txt_firstDeluxe);
        firstTotal = dialogView.findViewById(R.id.txt_firstTotal);
        secondEasy = dialogView.findViewById(R.id.txt_secondEasy);
        secondHard = dialogView.findViewById(R.id.txt_secondHard);
        secondThemes = dialogView.findViewById(R.id.txt_secondThemes);
        secondRandom = dialogView.findViewById(R.id.txt_secondRandom);
        secondBlood = dialogView.findViewById(R.id.txt_secondBlood);
        secondDeluxe= dialogView.findViewById(R.id.txt_secondDeluxe);
        secondTotal = dialogView.findViewById(R.id.txt_secondTotal);
        winner = dialogView.findViewById(R.id.txt_winner);
        btn_ok = dialogView.findViewById(R.id.btnOk);

        //una vez instanciados, coloco los datos de la batalla en cuestión en cada una de las TextViews
        firstMc.setText(mBattle.getFirstMc());
        secondMc.setText(mBattle.getSecondMc());

        firstEasy.setText(String.valueOf(mBattle.getPointsFMEasyMode()));
        firstHard.setText(String.valueOf(mBattle.getPointsFMHardMode()));
        firstThemes.setText(String.valueOf(mBattle.getPointsFMThemes()));
        firstRandom.setText(String.valueOf(mBattle.getPointsFMRandomMode()));
        firstBlood.setText(String.valueOf(mBattle.getPointsFMBloodMode()));
        firstDeluxe.setText(String.valueOf(mBattle.getPointsFMDeluxeMode()));
        firstTotal.setText(String.valueOf(mBattle.getTotalPointsFM()));

        secondEasy.setText(String.valueOf(mBattle.getPointsSMEasyMode()));
        secondHard.setText(String.valueOf(mBattle.getPointsSMHardMode()));
        secondThemes.setText(String.valueOf(mBattle.getPointsSMThemes()));
        secondRandom.setText(String.valueOf(mBattle.getPointsSMRandomMode()));
        secondBlood.setText(String.valueOf(mBattle.getPointsSMBloodMode()));
        secondDeluxe.setText(String.valueOf(mBattle.getPointsSMDeluxeMode()));
        secondTotal.setText(String.valueOf(mBattle.getTotalPointsSM()));

        winner.setText("Ganador: " + mBattle.getWinner());

        //para que la vista sea visible, hay que colocarla
        builder.setView(dialogView);
        //coloco el título del diálogo
        //builder.setMessage("Mostrar Batalla");

        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        return builder.create();
    }

}
