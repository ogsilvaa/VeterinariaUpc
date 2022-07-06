package com.upc.puppiesvet;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

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
    public void onBindViewHolder(@NonNull AdaptadorPersonalizadoMascotas.MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.fila_NombreMascota.setText(listaMascotas.get(position).getNombre()+"");
        holder.fila_TipoMascota.setText(listaMascotas.get(position).getTipo()+"");
        holder.fila_GeneroMascota.setText(listaMascotas.get(position).getGenero()+"");
        holder.fila_EdadMascota.setText(listaMascotas.get(position).getEdad()+"");
        holder.fila_Mascota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,MascotaActivity.class);
                intent.putExtra("parametroID",listaMascotas.get(position).getIdMascota()+"");
                intent.putExtra("parametroNombre",listaMascotas.get(position).getNombre()+"");
                intent.putExtra("parametroTipo",listaMascotas.get(position).getTipo()+"");
                intent.putExtra("parametroGenero",listaMascotas.get(position).getGenero()+"");
                intent.putExtra("parametroEdad",listaMascotas.get(position).getEdad()+"");
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listaMascotas.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView fila_NombreMascota,fila_TipoMascota,fila_GeneroMascota,fila_EdadMascota;
        LinearLayout fila_Mascota;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            fila_NombreMascota = itemView.findViewById(R.id.fila_NombreMascota);
            fila_TipoMascota= itemView.findViewById(R.id.fila_TipoMascota);
            fila_GeneroMascota= itemView.findViewById(R.id.fila_GeneroMascota);
            fila_EdadMascota= itemView.findViewById(R.id.fila_EdadMascota);
            fila_Mascota = itemView.findViewById(R.id.fila_Mascota);

        }
    }
}
