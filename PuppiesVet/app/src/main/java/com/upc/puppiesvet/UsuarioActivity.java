package com.upc.puppiesvet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.upc.puppiesvet.utilidades.PuppiesVetBD;
import com.upc.puppiesvet.utilidades.Utilidades;

public class UsuarioActivity extends AppCompatActivity {

    EditText et_Nombres,et_Apellidos,et_Correo,et_Celular,et_Direccion,et_PasswordPerfil;
    Button btn_RegistrarUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario);

        et_Nombres= (EditText)findViewById(R.id.et_Nombres);
        et_Apellidos=(EditText)findViewById(R.id.et_Apellidos);
        et_Correo=(EditText)findViewById(R.id.et_Correo);
        et_Celular=(EditText)findViewById(R.id.et_Celular);
        et_Direccion=(EditText)findViewById(R.id.et_Direccion);
        et_PasswordPerfil=(EditText)findViewById(R.id.et_Password);

        btn_RegistrarUsuario=(Button) findViewById(R.id.btn_RegistrarUsuario);
        btn_RegistrarUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrarUsuarios();
            }
        });
    }


    private void registrarUsuarios(){

        PuppiesVetBD conn= new PuppiesVetBD(this,"PuppiesVetBD",null,1);
        SQLiteDatabase db= conn.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Utilidades.CAMPO_NOMBRES,et_Nombres.getText().toString());
        values.put(Utilidades.CAMPO_APELLIDOS,et_Apellidos.getText().toString());
        values.put(Utilidades.CAMPO_CORREO,et_Correo.getText().toString());
        values.put(Utilidades.CAMPO_CELULAR,et_Celular.getText().toString());
        values.put(Utilidades.CAMPO_DIRECCION,et_Direccion.getText().toString());
        values.put(Utilidades.CAMPO_PASSWORD,et_PasswordPerfil.getText().toString());

        Long idResultante = db.insert(Utilidades.TABLA_USUARIO,Utilidades.CAMPO_NOMBRES,values);

        Toast.makeText(getApplicationContext(),"Nombre registrado: "+idResultante,Toast.LENGTH_SHORT).show();
        db.close();

    }

}