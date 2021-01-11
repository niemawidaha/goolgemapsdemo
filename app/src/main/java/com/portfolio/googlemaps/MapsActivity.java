package com.portfolio.googlemaps;

import android.os.Bundle;
import android.widget.Button;

import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import static com.google.android.gms.maps.model.BitmapDescriptorFactory.HUE_AZURE;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private Button mButton; // startsLocationService

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
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

        // Convert map from plain to satellite:
        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);

        // Creating new location:
        LatLng spacexHeadquarters = new LatLng(33.92083242989701, -118.32827930186276);

        // Create a new camera
        mMap.addMarker(new MarkerOptions().position(spacexHeadquarters).title("SpaceX Headquarters").icon(BitmapDescriptorFactory.defaultMarker(HUE_AZURE)));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(spacexHeadquarters,10));

    }
}