package com.upc.puppiesvet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ListarMascotasActivity extends AppCompatActivity {

    FloatingActionButton fb_agregarMascota;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_mascotas);

        fb_agregarMascota=(FloatingActionButton)findViewById(R.id.fb_agregarMascota);
        fb_agregarMascota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListarMascotasActivity.this,MascotaActivity.class);
                startActivity(intent);
            }
        });
    }
}