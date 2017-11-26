package com.gdghamburg.foodkart;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.gdghamburg.foodkart.model.Foodkarts;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by KSH on 2017-11-26.
 */

public class MapActivity extends AppCompatActivity implements OnMapReadyCallback {
   // private static String mBundleName = "foodkarts";
   // private List<Foodkarts> mFoodKarts;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_maps);
        SupportMapFragment mapFragment = (SupportMapFragment)getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        //mFoodKarts = getIntent().getParcelableArrayListExtra(mBundleName);

        //DatabaseReference ref = FirebaseDatabase.getInstance().getReference("foodkarts");
 /*   GeoFire geoFire = new GeoFire(ref);

    geoFire.getLocation("firebase-hq", new LocationCallback() {
        @Override
        public void onLocationResult(String key, GeoLocation location) {
            if(location != null){
                Log.d("Map", String.format("The location for key %s is [%f,%f]", key, location.latitude, location.longitude));
            }else{
                Log.d("Map", String.format(String.format("There is no location for key %s in GeoFire", key)));
            }
        }

        @Override
        public void onCancelled(DatabaseError databaseError) {
            Log.e("map", "There was an error getting the GeoFire location: " + databaseError);
        }
    });*/
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        updateLocationUI(googleMap);
    }

    private void updateLocationUI(GoogleMap map) {
        if (map == null) {
            return;
        }

       // LatLngBounds.Builder builder = new LatLngBounds.Builder();
        ArrayList<Food> foods = new ArrayList<>();

        Food food1 = new Food();
        food1.setPoint(new LatLng(53.551086, 9.993682));
        food1.setName("FirePizza");

        Food food2 = new Food();
        food2.setPoint(new LatLng(53.562546, 9.9598649));
        food2.setName("Eat together");

        foods.add(0, food1);
        foods.add(1, food2);

        for(int i=0; i<foods.size(); i++){
            String name = foods.get(i).getName();
            LatLng latLng = foods.get(i).getPoint();
       //     builder.include(latLng);
            map.addMarker(new MarkerOptions().position(latLng).title(name));
        }

       // map.moveCamera(CameraUpdateFactory.newLatLng(builder.build().getCenter()));
       // map.moveCamera(CameraUpdateFactory.newLatLng(food1.point));
    }

    private class Food{
        private LatLng point;
        private String name;

        public LatLng getPoint() {
            return point;
        }

        public void setPoint(LatLng point) {
            this.point = point;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
