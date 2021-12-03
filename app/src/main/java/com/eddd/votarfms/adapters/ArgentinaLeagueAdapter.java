package com.eddd.votarfms.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.eddd.votarfms.R;
import com.eddd.votarfms.models.ArgentinaMC;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

public class ArgentinaLeagueAdapter extends FirestoreRecyclerAdapter<ArgentinaMC, ArgentinaLeagueAdapter.ViewHolder> {


    /**
     * Create a new RecyclerView adapter that listens to a Firestore Query.  See {@link
     * FirestoreRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public ArgentinaLeagueAdapter(@NonNull FirestoreRecyclerOptions<ArgentinaMC> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder( ViewHolder holder, int position, ArgentinaMC model) {

        holder.tv_name.setText(model.getName());
        holder.tv_position.setText(String.valueOf(model.getPosition()));
        holder.tv_points.setText(String.valueOf(model.getPoints()));
        holder.tv_punctuation.setText(String.valueOf(model.getPunctuation()));
    }


    @Override
    public ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_liga_argentina, parent, false);

        return new ViewHolder(view);
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        TextView tv_name, tv_position, tv_points, tv_punctuation;

        public ViewHolder(View itemView) {
            super(itemView);

            tv_name = itemView.findViewById(R.id.tv_mcName);
            tv_position = itemView.findViewById(R.id.tv_position);
            tv_points = itemView.findViewById(R.id.tv_points);
            tv_punctuation = itemView.findViewById(R.id.tv_punctuation);
        }

}



}
