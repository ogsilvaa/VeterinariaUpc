package com.upc.puppiesvet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.upc.puppiesvet.ui.navheader.InicioFragment;

public class MainActivity extends AppCompatActivity {

    Button btn_Bienvenida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        asignarReferencias();
    }

    private void asignarReferencias() {

        btn_Bienvenida =findViewById(R.id.btn_Bienvenida);

        btn_Bienvenida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PerfilActivity.class);
                startActivity(intent);
            }
        });
    }
}