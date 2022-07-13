package com.upc.puppiesvet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    Button btn_Ingresar;
    TextView tv_Registrarse, tv_OlvidoPassword;
    EditText et_CorreoUsuario,et_Password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        tv_OlvidoPassword=(TextView)findViewById(R.id.tv_OlvidoPassword);
        tv_OlvidoPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(LoginActivity.this, RecuperarPasswordActivity.class);
                startActivity(intent);
            }
        });

        btn_Ingresar=(Button)findViewById(R.id.btn_Ingresar);
        btn_Ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(et_CorreoUsuario.getText().toString().isEmpty() && !et_Password.getText().toString().isEmpty()){
                    FirebaseAuth.getInstance().signInWithEmailAndPassword(et_CorreoUsuario.getText().toString(),et_Password.getText().toString())
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if(task.isSuccessful()){
                                        AlertDialog.Builder ventana =new AlertDialog.Builder(LoginActivity.this);
                                        ventana.setTitle("Bienvenido a Puppies Vet");
                                        //ventana.setMessage("Se ha registrado al usuario.");
                                        ventana.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                Intent intent= new Intent(LoginActivity.this,InicioActivity.class);
                                                startActivity(intent);
                                            }
                                        });
                                        ventana.create().show();
                                    }else{
                                        Toast.makeText(LoginActivity.this,"Si olvidaste tu contraseña selecciona la opción para recuperarla",Toast.LENGTH_LONG).show();
                                    }
                                }
                            });
                }
            }
        });

        tv_Registrarse=(TextView)findViewById(R.id.tv_Registrarse);
        tv_Registrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(LoginActivity.this, UsuarioActivity.class);
                startActivity(intent);
            }
        });

    };

}