package com.upc.puppiesvet;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DatabaseReference;
import com.upc.puppiesvet.entidad.Mascota;

import java.util.ArrayList;
import java.util.List;

public class AdaptadorPersonalizadoMascotas extends RecyclerView.Adapter<AdaptadorPersonalizadoMascotas.MyViewHolder> {

    private Context context;
    private List<Mascota>listaMascotas = new ArrayList<>();
    DatabaseReference reference;
    Mascota mascota;


    public AdaptadorPersonalizadoMascotas(Context context, List<Mascota> listaMascotas, DatabaseReference reference){
        this.context = context;
        this.listaMascotas=listaMascotas;
        this.reference= reference;
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

        holder.fila_Eliminarmascota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder ventana = new AlertDialog.Builder(context);
                ventana.setTitle("¿Deseas eliminar a la mascota?");
                ventana.setMessage("Si deseas proceder, da click en OK.");
                ventana.setNegativeButton("CANCELAR", null);
                ventana.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        reference.child("Mascota").child(listaMascotas.get(position).getIdMascota()).removeValue();
                        Toast.makeText(context, "Se eliminó a la mascota seleccionada.", Toast.LENGTH_LONG).show();
                    }
                });
                ventana.create().show();
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
        ImageButton fila_Eliminarmascota;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            fila_NombreMascota = itemView.findViewById(R.id.fila_NombreMascota);
            fila_TipoMascota= itemView.findViewById(R.id.fila_TipoMascota);
            fila_GeneroMascota= itemView.findViewById(R.id.fila_GeneroMascota);
            fila_EdadMascota= itemView.findViewById(R.id.fila_EdadMascota);
            fila_Mascota = itemView.findViewById(R.id.fila_Mascota);
            fila_Eliminarmascota= itemView.findViewById(R.id.ib_Eliminarmascota);

        }
    }
}
