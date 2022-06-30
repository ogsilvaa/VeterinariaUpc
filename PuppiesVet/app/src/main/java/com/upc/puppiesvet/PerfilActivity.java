package com.upc.puppiesvet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PerfilActivity extends AppCompatActivity {

    Button btn_RegistrarPerfil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
        asignarReferencias();
    }

    private void asignarReferencias() {
        btn_RegistrarPerfil=findViewById(R.id.btn_RegistrarPerfil);
        btn_RegistrarPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(PerfilActivity.this,PerfilActivity.class);
                startActivity(intent);
            }
        });
    }
}