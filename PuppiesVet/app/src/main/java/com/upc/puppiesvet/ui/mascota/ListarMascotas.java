package com.upc.puppiesvet.ui.mascota;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.upc.puppiesvet.R;

public class ListarMascotas extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_listarmascotas, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        FloatingActionButton fb_agregarMascota = view.findViewById(R.id.fb_agregarMascota);
        fb_agregarMascota.setOnClickListener(v -> {
            NavHostFragment.findNavController(ListarMascotas.this).navigate(R.id.mascotaActivity);
        });
    }
}