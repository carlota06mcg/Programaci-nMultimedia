package com.example.listaoptimizada;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PosterAdapter extends RecyclerView.Adapter<PosterAdapter.PostersViewHolder>
{

    private Posters[] listaPosters;

    public PosterAdapter(Posters[] listaPosters)
    {
        this.listaPosters = listaPosters;
    }

    public static class PostersViewHolder extends RecyclerView.ViewHolder {
        public TextView tituloView;
        public ImageView portadaView;
        private Context context;
        public PostersViewHolder(View view, Context context) {
            super(view);
            this.context = context;

            tituloView = view.findViewById(R.id.tituloView);
            portadaView = view.findViewById(R.id.imagenView);
        }

        public void BindPosters(Posters posters) {
            tituloView.setText(posters.getTitle());
            portadaView.setImageResource(
                    context.getResources()
                            .getIdentifier(posters.getImage(),
                                    "drawable",
                                    "com.example.ListaOptimizada"));
        }
    }

    @NonNull
    @Override
    public PostersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.posters_item, parent, false);
        return new PostersViewHolder(view, parent.getContext());
    }

    @Override
    public void onBindViewHolder(@NonNull PostersViewHolder holder, int position) {
        holder.BindPosters(this.listaPosters[position]);
    }

    @Override
    public int getItemCount() {
        return listaPosters.length;
    }
}
