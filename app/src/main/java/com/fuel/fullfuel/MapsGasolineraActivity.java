package com.fuel.fullfuel;

import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.fuel.fullfuel.clases.Gasolinera;
import com.fuel.fullfuel.ui.home.HomeFragment;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class MapsGasolineraActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps_gasolinera);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);

        mapFragment.getMapAsync(this);
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


        ArrayList<Gasolinera> gasolineras = HomeFragment.gasolineras;


        for(int i = 0 ; i < gasolineras.size() ; i++) {

           // createMarker(gasolineras.get(i).getUbicacion().getLatitud(), gasolineras.get(i).getUbicacion().getLongitud(), markersArray.get(i).getTitle(), markersArray.get(i).getSnippet(), markersArray.get(i).getIconResID());
            createMarker(gasolineras.get(i).getUbicacion().getLatitud(), gasolineras.get(i).getUbicacion().getLongitud(), gasolineras.get(i).getDistribuidor().getNombre(), "", 1);

        }


        // Add a marker in Sydney and move the camera.
        // --LatLng marcador = new LatLng(-29.93627640771, -71.260730624199);
        //mMap.animateCamera(myLocation);
        //mMap.setMinZoomPreference(6.0f);
        //mMap.setMaxZoomPreference(20.0f);
        String nombre = (String) getIntent().getSerializableExtra("nombre");
       //-- mMap.moveCamera(CameraUpdateFactory.newLatLng(marcador));


        LatLng laserena = new LatLng(-29.90453, -71.24894);
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(laserena, 13.0f));

    }



    protected Marker createMarker(double latitude, double longitude, String title, String snippet, int iconResID) {

        return mMap.addMarker(new MarkerOptions()
                .position(new LatLng(latitude, longitude))
                //.anchor(0.5f, 0.5f)
                .title(title)
                .snippet(snippet));
                //.icon(BitmapDescriptorFactory.fromResource(iconResID)));
    }

}
