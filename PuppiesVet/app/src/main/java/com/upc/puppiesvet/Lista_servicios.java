package com.upc.puppiesvet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class Lista_servicios extends AppCompatActivity {


    CheckBox emergencia_veterinaria,consulta_veterinaria,aseo_y_corte,hospedaje_temporal,adoptar_mascota;
    TextView txt_emergencia_veterinaria,txt_consulta_veterinaria,txt_aseo_y_corte,txt_hospedaje_temporal,txt_adoptar_mascota;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_servicios);
        // CheckBox
        emergencia_veterinaria=(CheckBox) findViewById(R.id.check_emergencia_veterinaria);
        consulta_veterinaria=(CheckBox)findViewById(R.id.check_consulta_veterinaria);
        aseo_y_corte=(CheckBox)findViewById(R.id.check_aseo_y_corte);
        hospedaje_temporal=(CheckBox)findViewById(R.id.check_hospedaje_temporal);
        adoptar_mascota=(CheckBox)findViewById(R.id.check_adoptar_mascota);

        // TextView
        txt_emergencia_veterinaria=(TextView) findViewById(R.id.txt_emergencia_veterinaria);
        txt_consulta_veterinaria=(TextView) findViewById(R.id.txt_consulta_veterinaria);
        txt_aseo_y_corte=(TextView) findViewById(R.id.txt_aseo_y_corte);
        txt_hospedaje_temporal=(TextView) findViewById(R.id.txt_hospedaje_temporal);
        txt_adoptar_mascota=(TextView) findViewById(R.id.txt_adoptar_mascota);

    }


    public void onclick(View view){
        if (view.getId() ==R.id.btn_siguiente ) {
            validar();
        }
    }


    private void validar(){
    String cadena="Seleccionado \n";

        if(emergencia_veterinaria.isChecked()){cadena+=txt_emergencia_veterinaria.getText();}

        if(consulta_veterinaria.isChecked()){cadena+=txt_consulta_veterinaria.getText();}

        if(aseo_y_corte.isChecked()){cadena+=txt_aseo_y_corte.getText();}

        if(hospedaje_temporal.isChecked()){cadena+=txt_hospedaje_temporal.getText();}

        if(adoptar_mascota.isChecked()){cadena+=txt_adoptar_mascota.getText();}

        if( !emergencia_veterinaria.isChecked() && !consulta_veterinaria.isChecked() && !aseo_y_corte.isChecked() && !hospedaje_temporal.isChecked() && !adoptar_mascota.isChecked())
        {
            cadena="Por favor seleccione una opción";
        }

        Toast.makeText(getApplicationContext(),cadena,Toast.LENGTH_SHORT).show();
    }
}