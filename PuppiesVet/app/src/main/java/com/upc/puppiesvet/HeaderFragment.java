package com.upc.puppiesvet.ui.navheader;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

<<<<<<<< HEAD:PuppiesVet/app/src/main/java/com/upc/puppiesvet/HeaderFragment.java
public class HeaderFragment extends Fragment {
========
import com.upc.puppiesvet.R;


public class HeaderFragment extends Fragment {


>>>>>>>> origin/Alonso:PuppiesVet/app/src/main/java/com/upc/puppiesvet/ui/navheader/HeaderFragment.java

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_header, container, false);
    }
}