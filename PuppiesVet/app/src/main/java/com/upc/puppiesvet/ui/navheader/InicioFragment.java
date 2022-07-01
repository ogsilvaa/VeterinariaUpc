package com.upc.puppiesvet.ui.navheader;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.upc.puppiesvet.R;

public class InicioFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_inicio, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button btn_Perfil = view.findViewById(R.id.btn_Perfil);
        Button btn_Mascota= view.findViewById(R.id.btn_Mascota);
        btn_Perfil.setOnClickListener(v -> {
            NavHostFragment.findNavController(InicioFragment.this).navigate(R.id.perfilActivity);
        });
        btn_Mascota.setOnClickListener(v -> {
            NavHostFragment.findNavController(InicioFragment.this).navigate(R.id.listarMascotas);
        });
    }


}