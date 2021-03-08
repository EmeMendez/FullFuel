package com.fuel.fullfuel;

import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
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
        String id = (String) getIntent().getSerializableExtra("id");

        Double latitud = (Double) getIntent().getSerializableExtra("latitud");
        Double longitud = (Double) getIntent().getSerializableExtra("longitud");

        int icono = R.drawable.marcador_rojo;
        for(int i = 0 ; i < gasolineras.size() ; i++) {
            if(gasolineras.get(i).getId().equalsIgnoreCase(id)){
                System.out.println(id);
                icono = R.drawable.marcador_verde;
            }else{
                icono = R.drawable.marcador_rojo;
            }
           // createMarker(gasolineras.get(i).getUbicacion().getLatitud(), gasolineras.get(i).getUbicacion().getLongitud(), markersArray.get(i).getTitle(), markersArray.get(i).getSnippet(), markersArray.get(i).getIconResID());
            createMarker(gasolineras.get(i).getUbicacion().getLatitud(), gasolineras.get(i).getUbicacion().getLongitud(), gasolineras.get(i).getDistribuidor().getNombre(), "", icono);

        }


        // Add a marker in Sydney and move the camera.
        // --LatLng marcador = new LatLng(-29.93627640771, -71.260730624199);
        //mMap.animateCamera(myLocation);
        //mMap.setMinZoomPreference(6.0f);
        //mMap.setMaxZoomPreference(20.0f);
        String nombre = (String) getIntent().getSerializableExtra("nombre");
       //-- mMap.moveCamera(CameraUpdateFactory.newLatLng(marcador));


        LatLng foco_gasolinera = new LatLng(latitud, longitud);
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(foco_gasolinera, 13.0f));

    }



    protected Marker createMarker(double latitude, double longitude, String title, String snippet, int icono) {
        return mMap.addMarker(new MarkerOptions()
                .position(new LatLng(latitude, longitude))
                //.anchor(0.5f, 0.5f)
                .title(title)
                .icon(BitmapDescriptorFactory.fromResource(icono))
                .snippet(snippet));

    }
    public Bitmap resizeMapIcons(String iconName, int width, int height){
        Bitmap imageBitmap = BitmapFactory.decodeResource(getResources(),getResources().getIdentifier(iconName, "drawable", getPackageName()));
        Bitmap resizedBitmap = Bitmap.createScaledBitmap(imageBitmap, width, height, false);
        return resizedBitmap;
    }

}
