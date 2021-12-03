package com.eddd.votarfms.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.eddd.votarfms.R;
import com.eddd.votarfms.models.SpainMC;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

//por ser una RecyclerView que se comunica con Firebase, hay que extender de FirestoreRecyclerAdapter, si fuese
// una RecyclerView que no se comunicase con Firebase extendería de RecyclerView.Adapter (y se le pasaría únicamente
// el adaptador del ViewHolder
public class SpainLeagueAdapter extends FirestoreRecyclerAdapter<SpainMC, SpainLeagueAdapter.ViewHolder> {


    /**
     * Create a new RecyclerView adapter that listens to a Firestore Query.  See {@link
     * FirestoreRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public SpainLeagueAdapter( FirestoreRecyclerOptions<SpainMC> options) {
        super(options);

    }


    @Override
    public ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {  //con este método se crea la vista sin personalizar

        //inflamos el modelo de una posición de la tabla, y lo guardamos en un objeto View
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_liga_spain, parent, false);

        //devolvemos un ViewHolder, y por parámetro le pasamos la vista creada anteriormente (esto nos va a permitir personzalizar esta vista en
        //el método onBindViewHolder
        return new ViewHolder(view);
    }


    @Override
    protected void onBindViewHolder( ViewHolder holder, int position, SpainMC model) {

        //ahora personalizamos los elementos, colocando como texto el valor que obtuvo el modelo SpainMC de la base de Firebase
        holder.tv_name.setText(model.getName());
        holder.tv_position.setText(String.valueOf(model.getPosition()));
        holder.tv_points.setText(String.valueOf(model.getPoints()));
        holder.tv_punctuation.setText(String.valueOf(model.getPunctuation()));
    }


    //esta es la clase ViewHolder, donde se encuentran los elementos a personalizar
    class ViewHolder extends RecyclerView.ViewHolder{

        TextView tv_name, tv_position, tv_points, tv_punctuation;

        public ViewHolder(View itemView) {
            super(itemView);

            tv_name = itemView.findViewById(R.id.tv_mcNameSpain);
            tv_position = itemView.findViewById(R.id.tv_positionSpain);
            tv_points = itemView.findViewById(R.id.tv_pointsSpain);
            tv_punctuation = itemView.findViewById(R.id.tv_punctuationSpain);
        }

    }

}
