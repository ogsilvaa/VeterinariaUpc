package com.upc.puppiesvet;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class PerfilActivity extends AppCompatActivity {

    EditText et_Nombres,et_Apellidos,et_Correo, et_Celular,et_Direccion,et_PasswordPerfil;
    Button btn_RegistrarPerfil;

    FirebaseDatabase database;
    DatabaseReference reference;

    EntidadPerfil entidadPerfil;


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
        et_Correo= findViewById(R.id.et_Correo);
        et_Celular = findViewById(R.id.et_Celular);
        et_Direccion = findViewById(R.id.et_Direccion);
        et_PasswordPerfil = findViewById(R.id.et_PasswordPerfil);
        btn_RegistrarPerfil=findViewById(R.id.btn_RegistrarPerfil);
        btn_RegistrarPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(capturarDatosPerfil()){
                    reference.child("Perfil").child(entidadPerfil.getId()).setValue(entidadPerfil);
                    AlertDialog.Builder ventana = new AlertDialog.Builder(PerfilActivity.this);
                    ventana.setTitle("¡Listo!");
                    ventana.setMessage("Se regitró el perfil");
                    ventana.setPositiveButton("OK", null);
                    ventana.create().show();
                }
            }
        });
    }

    private void inicializarFirebase(){
        FirebaseApp.initializeApp(this);
        database= FirebaseDatabase.getInstance();
        reference = database.getReference();
    }

    private boolean capturarDatosPerfil(){
        String nombres = et_Nombres.getText().toString();
        String apellidos = et_Apellidos.getText().toString();
        String correo = et_Correo.getText().toString();
        String celular = et_Celular.getText().toString();
        String direccion = et_Direccion.getText().toString();
        String passwordPerfil = et_PasswordPerfil.getText().toString();

        boolean valida = true;

        if (nombres.equals("")){
            et_Nombres.setError("Nombres son obligatorios");
            valida= false;
        }

        if (apellidos.equals("")){
            et_Apellidos.setError("Apellidos son obligatorios");
            valida= false;
        }

        if (correo.equals("")){
            et_Correo.setError("Correo es obligatorio");
            valida= false;
        }

        if (celular.equals("")){
            et_Celular.setError("Celular es obligatorio");
            valida= false;
        }

        if (direccion.equals("")){
            et_Direccion.setError("Dirección es obligatoria");
            valida= false;
        }

        if (passwordPerfil.equals("")){
            et_PasswordPerfil.setError("Contraseña es obligatoria");
            valida= false;
        }

        if(valida){
            entidadPerfil = new EntidadPerfil(nombres,apellidos,correo,celular,direccion,passwordPerfil);

        }

        return valida;

    }

}