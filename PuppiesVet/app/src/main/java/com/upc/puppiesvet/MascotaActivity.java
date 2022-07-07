package com.upc.puppiesvet;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.upc.puppiesvet.entidad.Mascota;

import java.util.HashMap;
import java.util.UUID;

public class MascotaActivity extends AppCompatActivity {

    EditText et_NombreMascota,et_TipoMascota,et_GeneroMascota,et_EdadMascota;
    Button btn_RegistrarMascota;
    TextView tv_EliminarMascota;

    FirebaseDatabase database;
    DatabaseReference reference;

    Mascota mascota;
    boolean registra = true;
    HashMap map =new HashMap();
    String idMascota;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mascota);

        asignarReferencias();
        obtenerDatosMascota();
        inicializarFirebase();
        eliminarMascota();
    }

    private void eliminarMascota() {
        tv_EliminarMascota=findViewById(R.id.tv_EliminarMascota);
        tv_EliminarMascota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eliminarMascotaFragment();
            }
        });
    }

    private void eliminarMascotaFragment(){
        EliminarMascotaFragment eliminarMascotaFragment = new EliminarMascotaFragment();
        eliminarMascotaFragment.show(getSupportFragmentManager(),"Eliminar Mascota");
    }



    private void obtenerDatosMascota() {
        if(getIntent().hasExtra("parametroID")){
            registra=false;
            idMascota = getIntent().getStringExtra("parametroID");
            et_NombreMascota.setText(getIntent().getStringExtra("parametroNombre"));
            et_TipoMascota.setText(getIntent().getStringExtra("parametroTipo"));
            et_GeneroMascota.setText(getIntent().getStringExtra("parametroGenero"));
            et_EdadMascota.setText(getIntent().getStringExtra("parametroEdad"));
        }
    }

    private void asignarReferencias() {
        et_NombreMascota= findViewById(R.id.et_NombreMascota);
        et_TipoMascota= findViewById(R.id.et_TipoMascota);
        et_GeneroMascota= findViewById(R.id.et_GeneroMascota);
        et_EdadMascota= findViewById(R.id.et_EdadMascota);

        btn_RegistrarMascota=findViewById(R.id.btn_RegistrarMascota);
        btn_RegistrarMascota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(capturarDatos()){

                    String mensaje ="";

                    if(registra){
                        reference.child("Mascota").child(mascota.getIdMascota()).setValue(mascota);
                        mensaje="Se ha registrado a tu mascota.";
                    }else {
                        reference.child("Mascota").child(idMascota).updateChildren(map);
                        mensaje="Se editaron los datos de tu mascota.";
                    }

                    AlertDialog.Builder ventana =new AlertDialog.Builder(MascotaActivity.this);
                    ventana.setTitle("Mascota registrada");
                    ventana.setMessage(mensaje);
                    ventana.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    });
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
        String nombreMascota=et_NombreMascota.getText().toString();
        String tipoMascota=et_TipoMascota.getText().toString();
        String generoMascota=et_GeneroMascota.getText().toString();
        String edadMascota=et_EdadMascota.getText().toString();

        boolean valida = true;

        if(nombreMascota.equals("")){
            et_NombreMascota.setError("Nombre obligatorio");
            valida = false;
        }

        if(tipoMascota.equals("")){
            et_TipoMascota.setError("Tipo de mascota es obligatorio");
            valida = false;
        }

        if(generoMascota.equals("")){
            et_GeneroMascota.setError("Tipo de mascota es obligatorio");
            valida = false;
        }

        if(edadMascota.equals("")){
            et_EdadMascota.setError("Indica la edad de tu mascota");
            valida = false;
        }


        if(valida){
            if(registra){
                mascota = new Mascota();
                mascota.setIdMascota(UUID.randomUUID().toString());
                mascota.setNombre(nombreMascota);
                mascota.setTipo(tipoMascota);
                mascota.setGenero(generoMascota);
                mascota.setEdad(edadMascota);
            }else {
                map.put("nombre",nombreMascota);
                map.put("tipo",tipoMascota);
                map.put("genero",generoMascota);
                map.put("edad",edadMascota);
            }
        }
        return valida;

    }

}