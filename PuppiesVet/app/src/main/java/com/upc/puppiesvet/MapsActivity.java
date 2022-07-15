package com.upc.puppiesvet;

import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;

import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.upc.puppiesvet.databinding.ActivityMapsBinding;

import java.io.IOException;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;
    private Geocoder geocoder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        geocoder = new Geocoder(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng veterinaria = new LatLng(-12.087403, -77.050229);
        mMap.addMarker(new MarkerOptions().position(veterinaria).title("Marker in Vet"));
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(veterinaria));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(veterinaria, 16));

        mMap.setOnMapClickListener(latLng -> {
            try {
                List<Address> listaDirecciones = geocoder.getFromLocation(latLng.latitude, latLng.longitude, 1);
                if (listaDirecciones.size() > 0) {
                    Address direccion = listaDirecciones.get(0);
                    String nombre = direccion.getAddressLine(0);
                    mMap.addMarker(new MarkerOptions().position(latLng).title(nombre));
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        });
    }
}