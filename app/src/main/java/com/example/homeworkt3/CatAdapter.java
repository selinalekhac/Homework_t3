package com.example.homeworkt3;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CatAdapter extends RecyclerView.Adapter<CatAdapter.ViewHolder> {
    private Context context;
    private ArrayList<Cats> list;

//    public void setData(ArrayList<Cats>)

    public CatAdapter(Context context, ArrayList<Cats> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.singlecat, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Cats cats = list.get(position);
        holder.textBreed.setText(cats.getBreed());
        holder.textDescription.setText(cats.getDescription());
        holder.textWeight.setText(String.valueOf(cats.getWeight()));
        holder.textTemperament.setText(cats.getTemperament());
        holder.textOrigin.setText(cats.getOrigin());
        holder.textLifespan.setText(String.valueOf(cats.getLifespan()));
        holder.textWikipedia.setText(cats.getWikipedia());
        holder.textDogFriendlinesslevel.setText(String.valueOf(cats.getDogfriendlinesslevel()));

        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = view.getContext();
                final Cats cats = new Cats();
                Intent intent = new Intent(context, CatDetails.class);
                intent.putExtra("breed", cats.getBreed());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textBreed, textDescription, textWeight, textTemperament, textOrigin, textLifespan, textWikipedia, textDogFriendlinesslevel;
        public View view;

        public ViewHolder(View itemView) {
            super(itemView);

            textBreed = itemView.findViewById(R.id.CatBreed_id);
            textDescription = itemView.findViewById(R.id.CatDescription_id);
            textWeight = itemView.findViewById(R.id.CatWeight_id);
            textTemperament = itemView.findViewById(R.id.CatTemp_id);
            textOrigin = itemView.findViewById(R.id.CatOrigin_id);
            textLifespan = itemView.findViewById(R.id.CatLifeSpan_id);
            textWikipedia = itemView.findViewById(R.id.CatWiki_id);
            textDogFriendlinesslevel = itemView.findViewById(R.id.CatDogFriendliness_id);


        }
    }
}
