package com.eddd.votarfms.dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import androidx.fragment.app.DialogFragment;

import com.eddd.votarfms.models.Batalla;
import com.eddd.votarfms.adapters.ListOfBattles;
import com.eddd.votarfms.R;

public class DialogDeleteBattle extends DialogFragment {

    Batalla mBattle;
    Button btn_cancel, btn_accept;

    public void sendBattleSelected(Batalla batalla){

        this.mBattle = batalla;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();

        View dialogView = inflater.inflate(R.layout.dialog_delete_battle, null);

        builder.setView(dialogView);

        btn_accept = dialogView.findViewById(R.id.btn_aceptar);
        btn_cancel = dialogView.findViewById(R.id.btn_cancelar);

        //si el usuario presiona cancelar, se cierra el fragmento
        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        //si el usuario presiona aceptar, se eliminar la batalla seleccionada
        btn_accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ListOfBattles list = (ListOfBattles) getActivity();
                list.deleteBattle(mBattle);
                dismiss();
            }
        });


        return builder.create();
    }
}
