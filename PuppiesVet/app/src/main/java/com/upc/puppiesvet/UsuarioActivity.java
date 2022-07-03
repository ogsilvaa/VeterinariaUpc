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
import com.upc.puppiesvet.entidad.Usuario;

import java.util.UUID;


public class UsuarioActivity extends AppCompatActivity {

    Button btn_RegistrarUsuario;
    EditText et_Nombres, et_Apellidos,et_Correo, et_Celular, et_Direccion, et_PasswordPerfil;

    FirebaseDatabase database;
    DatabaseReference reference;
    Usuario usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario);

        asignarReferencias();
        inicializarFirebase();

    }

    private void asignarReferencias(){
        et_Nombres= findViewById(R.id.et_Nombres);
        et_Apellidos= findViewById(R.id.et_Apellidos);
        et_Correo= findViewById(R.id.et_Correo);
        et_Celular= findViewById(R.id.et_Celular);
        et_Direccion= findViewById(R.id.et_Direccion);
        et_PasswordPerfil= findViewById(R.id.et_PasswordPerfil);

        btn_RegistrarUsuario=findViewById(R.id.btn_RegistrarUsuario);
        btn_RegistrarUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(capturarDatos()){
                    reference.child("Usuario").child(usuario.getIdUsuario()).setValue(usuario);
                    AlertDialog.Builder ventana =new AlertDialog.Builder(UsuarioActivity.this);
                    ventana.setTitle("Usuario registrado");
                    ventana.setMessage("Se ha registrado al usuario.");
                    ventana.setPositiveButton("OK",null);
                    ventana.create().show();
                }
            }
        });
    }

    private void inicializarFirebase() {
        FirebaseApp.initializeApp(this);
        database=FirebaseDatabase.getInstance();
        reference =database.getReference();
    }

    private boolean capturarDatos(){
        String nombres=et_Nombres.getText().toString();
        String apellidos=et_Apellidos.getText().toString();
        String correo=et_Correo.getText().toString();
        String celular=et_Celular.getText().toString();
        String direccion=et_Direccion.getText().toString();
        String password=et_PasswordPerfil.getText().toString();

        boolean valida = true;

        if(nombres.equals("")){
            et_Nombres.setError("Nombres obligatorios");
            valida = false;
        }

        if(apellidos.equals("")){
            et_Apellidos.setError("Apellidos obligatorios");
            valida = false;
        }

        if(correo.equals("")){
            et_Correo.setError("Correo obligatorio");
            valida = false;
        }

        if(celular.equals("")){
            et_Celular.setError("Celular obligatorio");
            valida = false;
        }

        if(direccion.equals("")){
            et_Direccion.setError("Dirección obligatoria");
            valida = false;
        }

        if(et_PasswordPerfil.equals("")){
            et_Nombres.setError("Contraseña obligatoria");
            valida = false;
        }

        if(valida){
            usuario = new Usuario();
            usuario.setIdUsuario(UUID.randomUUID().toString());
            usuario.setNombres(nombres);
            usuario.setApellidos(apellidos);
            usuario.setCorreo(correo);
            usuario.setCelular(celular);
            usuario.setDireccion(direccion);
            usuario.setPassword(password);
        }
        return valida;

    }

}