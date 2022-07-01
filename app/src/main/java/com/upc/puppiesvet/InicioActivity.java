package com.upc.puppiesvet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class InicioActivity extends AppCompatActivity {

    Button btn_Perfil, btn_Mascota;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        btn_Perfil=(Button)findViewById(R.id.btn_Perfil);
        btn_Mascota=(Button)findViewById(R.id.btn_Mascota);

        btn_Perfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InicioActivity.this, PerfilActivity.class);
                startActivity(intent);
            }
        });

        btn_Mascota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InicioActivity.this, ListarMascotasActivity.class);
                startActivity(intent);
            }
        });
    }
}