package com.upc.puppiesvet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class RecuperarPasswordActivity extends AppCompatActivity {

    Button btn_RecuperarPSW;
    TextView tv_Registrarse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recuperar_password);

        btn_RecuperarPSW=(Button) findViewById(R.id.btn_RecuperarPSW);
        btn_RecuperarPSW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(RecuperarPasswordActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });

        tv_Registrarse=(TextView)findViewById(R.id.tv_Registrarse);
        tv_Registrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(RecuperarPasswordActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}