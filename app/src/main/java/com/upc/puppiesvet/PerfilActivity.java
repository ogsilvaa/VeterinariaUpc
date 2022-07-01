package com.upc.puppiesvet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class PerfilActivity extends AppCompatActivity {

    EditText et_Nombres,et_Apellidos, et_Correo, et_Celular ,et_Direccion ,et_PasswordPerfil;
    Button btn_RegistrarPerfil;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        asignarReferencias();
        inicializarFirebase();
    }

    private void asignarReferencias() {
        et_Nombres = findViewById(R.id.et_Nombres);
        et_Apellidos = findViewById(R.id.et_Apellidos);
        et_Correo = findViewById(R.id.et_Correo);
        et_Celular = findViewById(R.id.et_Celular);
        et_Direccion = findViewById(R.id.et_Direccion);
        et_PasswordPerfil = findViewById(R.id.et_PasswordPerfil);
        btn_RegistrarPerfil  = findViewById(R.id.btn_RegistrarPerfil);
    }

    private void inicializarFirebase(){

    }
}