package com.eddd.votarfms.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.eddd.votarfms.R;
import com.eddd.votarfms.models.MexicoMC;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

public class MexicoLeagueAdapter extends FirestoreRecyclerAdapter<MexicoMC, MexicoLeagueAdapter.ViewHolder> {


    /**
     * Create a new RecyclerView adapter that listens to a Firestore Query.  See {@link
     * FirestoreRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public MexicoLeagueAdapter(@NonNull FirestoreRecyclerOptions<MexicoMC> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, int position, @NonNull MexicoMC model) {

        //ahora personalizamos los elementos, colocando como texto el valor que obtuvo el modelo SpainMC de la base de Firebase
        holder.tv_name.setText(model.getName());
        holder.tv_position.setText(String.valueOf(model.getPosition()));
        holder.tv_points.setText(String.valueOf(model.getPoints()));
        holder.tv_punctuation.setText(String.valueOf(model.getPunctuation()));
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_liga_mexico, parent, false);

        return new ViewHolder(view);
    }

    //esta es la clase ViewHolder, donde se encuentran los elementos a personalizar
    class ViewHolder extends RecyclerView.ViewHolder{

        TextView tv_name, tv_position, tv_points, tv_punctuation;

        public ViewHolder(View itemView) {
            super(itemView);

            tv_name = itemView.findViewById(R.id.tv_mcNameMexico);
            tv_position = itemView.findViewById(R.id.tv_positionMexico);
            tv_points = itemView.findViewById(R.id.tv_pointsMexico);
            tv_punctuation = itemView.findViewById(R.id.tv_punctuationMexico);
        }

    }

}
