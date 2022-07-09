package com.upc.puppiesvet;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ServicioAdaptador extends RecyclerView.Adapter<ServicioAdaptador.RecyclerHolder> {
    private List<serviciosList>items;

    public ServicioAdaptador(List<serviciosList> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public RecyclerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view   = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_servicios_mascota, parent, false);
        return new RecyclerHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerHolder holder, int position) {
        serviciosList item = items.get(position);
        holder.imgItem.setImageResource(item.getImgResource());
        holder.tvServicio.setText(item.getNom_servicio());
    }


    @Override
    public int getItemCount() {
        return items.size();
    }


    public static class RecyclerHolder extends RecyclerView.ViewHolder{
        private ImageView imgItem;
        private TextView tvServicio;

        public RecyclerHolder(@NonNull View itemView){
            super (itemView);
            imgItem = itemView.findViewById(R.id.imgItem);
            tvServicio = itemView.findViewById(R.id.tvServicio);


        }
    }
}
