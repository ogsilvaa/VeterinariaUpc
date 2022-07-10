package com.upc.puppiesvet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.upc.puppiesvet.entidad.Mascota;

import java.util.ArrayList;
import java.util.List;

public class ListarMascotasActivity extends AppCompatActivity {

    FloatingActionButton fb_agregarMascota;
    RecyclerView rv_Mascotas;
    FirebaseDatabase database;
    DatabaseReference reference;
    private List<Mascota> listaMascotas = new ArrayList<>();
    AdaptadorPersonalizadoMascotas adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_mascotas);
        rv_Mascotas = findViewById(R.id.rv_Mascotas);
        asignarReferencias();
        inicializarFirebase();
        mostrarMascotas();

    }

    private void asignarReferencias() {
        fb_agregarMascota=(FloatingActionButton)findViewById(R.id.fb_agregarMascota);
        fb_agregarMascota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListarMascotasActivity.this,MascotaActivity.class);
                startActivity(intent);
            }
        });
    }

    private void inicializarFirebase() {
        FirebaseApp.initializeApp(this);
        database=FirebaseDatabase.getInstance();
        reference =database.getReference();
    }

    private void mostrarMascotas() {
        reference.child("Mascota").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                listaMascotas.clear();
                for(DataSnapshot item:snapshot.getChildren()){
                    Mascota mascota = item.getValue(Mascota.class);
                    listaMascotas.add(mascota);
                }
                adaptador = new AdaptadorPersonalizadoMascotas(ListarMascotasActivity.this,listaMascotas,reference);
                rv_Mascotas.setAdapter(adaptador);
                rv_Mascotas.setLayoutManager(new LinearLayoutManager(ListarMascotasActivity.this));
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }



}