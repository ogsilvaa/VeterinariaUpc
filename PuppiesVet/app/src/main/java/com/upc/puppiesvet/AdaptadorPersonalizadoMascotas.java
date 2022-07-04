package com.upc.puppiesvet;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.upc.puppiesvet.entidad.Mascota;

import java.util.ArrayList;
import java.util.List;

public class AdaptadorPersonalizadoMascotas extends RecyclerView.Adapter<AdaptadorPersonalizadoMascotas.MyViewHolder> {

    private Context context;
    private List<Mascota>listaMascotas = new ArrayList<>();

    public AdaptadorPersonalizadoMascotas(Context context, List<Mascota> listaMascotas){
        this.context = context;
        this.listaMascotas=listaMascotas;
    }


    @NonNull
    @Override
    public AdaptadorPersonalizadoMascotas.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater= LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.fila_mascotas,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorPersonalizadoMascotas.MyViewHolder holder, int position) {
        holder.fila_NombreMascota.setText(listaMascotas.get(position).getNombre()+"");
        holder.fila_TipoMascota.setText(listaMascotas.get(position).getTipo()+"");
        holder.fila_GeneroMascota.setText(listaMascotas.get(position).getGenero()+"");
        holder.fila_EdadMascota.setText(listaMascotas.get(position).getEdad()+"");
    }

    @Override
    public int getItemCount() {
        return listaMascotas.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView fila_NombreMascota,fila_TipoMascota,fila_GeneroMascota,fila_EdadMascota;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            fila_NombreMascota = itemView.findViewById(R.id.fila_NombreMascota);
            fila_TipoMascota= itemView.findViewById(R.id.fila_TipoMascota);
            fila_GeneroMascota= itemView.findViewById(R.id.fila_GeneroMascota);
            fila_EdadMascota= itemView.findViewById(R.id.fila_EdadMascota);

        }
    }
}
