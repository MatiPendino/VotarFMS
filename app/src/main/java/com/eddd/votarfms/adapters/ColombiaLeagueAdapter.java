package com.eddd.votarfms.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.eddd.votarfms.R;
import com.eddd.votarfms.models.ColombiaMC;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

public class ColombiaLeagueAdapter extends FirestoreRecyclerAdapter<ColombiaMC, ColombiaLeagueAdapter.ViewHolder> {


    /**
     * Create a new RecyclerView adapter that listens to a Firestore Query.  See {@link
     * FirestoreRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public ColombiaLeagueAdapter(@NonNull FirestoreRecyclerOptions<ColombiaMC> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, int position, @NonNull ColombiaMC model) {

        holder.tv_name.setText(model.getName());
        holder.tv_position.setText(String.valueOf(model.getPosition()));
        holder.tv_points.setText(String.valueOf(model.getPoints()));
        holder.tv_punctuation.setText(String.valueOf(model.getPunctuation()));
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_liga_colombia, parent, false);

        return new ViewHolder(view);
    }

    static class ViewHolder extends RecyclerView.ViewHolder{

        TextView tv_name, tv_position, tv_points, tv_punctuation;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_name = itemView.findViewById(R.id.tv_mcNameColombia);
            tv_position = itemView.findViewById(R.id.tv_positionColombia);
            tv_points = itemView.findViewById(R.id.tv_pointsColombia);
            tv_punctuation = itemView.findViewById(R.id.tv_punctuationColombia);
        }

    }

}
