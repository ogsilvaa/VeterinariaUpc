package com.upc.puppiesvet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

public class Service_mascot extends AppCompatActivity {

    private RecyclerView rvServicios;
    private ServicioAdaptador adaptador;
    private List<serviciosList> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servicios_mascotas);

        initViews();
        initValues();
    }

    private void initViews(){
        rvServicios = findViewById(R.id.rvServicios);
    }

    private void initValues(){
        LinearLayoutManager manager = new LinearLayoutManager( this);
        rvServicios.setLayoutManager(manager);

        items = getItems();
        adaptador =  new ServicioAdaptador(items);
        rvServicios.setAdapter(adaptador);
    }

    private List<serviciosList> getItems(){
        List<serviciosList> itemLists = new ArrayList<>();
        itemLists.add(new serviciosList("Emergencias",R.drawable.emergencia));
        return itemLists;
    }
}