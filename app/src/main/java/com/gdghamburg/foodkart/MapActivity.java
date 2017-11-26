package com.gdghamburg.foodkart;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.gdghamburg.foodkart.model.Foodkarts;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;

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

        List<Food> foods = new List<Food>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @NonNull
            @Override
            public Iterator<Food> iterator() {
                return null;
            }

            @NonNull
            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @NonNull
            @Override
            public <T> T[] toArray(@NonNull T[] a) {
                return null;
            }

            @Override
            public boolean add(Food food) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(@NonNull Collection<?> c) {
                return false;
            }

            @Override
            public boolean addAll(@NonNull Collection<? extends Food> c) {
                return false;
            }

            @Override
            public boolean addAll(int index, @NonNull Collection<? extends Food> c) {
                return false;
            }

            @Override
            public boolean removeAll(@NonNull Collection<?> c) {
                return false;
            }

            @Override
            public boolean retainAll(@NonNull Collection<?> c) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public Food get(int index) {
                return null;
            }

            @Override
            public Food set(int index, Food element) {
                return null;
            }

            @Override
            public void add(int index, Food element) {

            }

            @Override
            public Food remove(int index) {
                return null;
            }

            @Override
            public int indexOf(Object o) {
                return 0;
            }

            @Override
            public int lastIndexOf(Object o) {
                return 0;
            }

            @NonNull
            @Override
            public ListIterator<Food> listIterator() {
                return null;
            }

            @NonNull
            @Override
            public ListIterator<Food> listIterator(int index) {
                return null;
            }

            @NonNull
            @Override
            public List<Food> subList(int fromIndex, int toIndex) {
                return null;
            }
        };

        Food food1 = new Food();
        food1.setPoint(new LatLng(53.551086, 9.993682));
        food1.setName("FirePizza");

        Food food2 = new Food();
        food2.setPoint(new LatLng(53.562546, 9.9598649));
        food2.setName("Eat together");

        foods.add(food1);
        foods.add(food2);

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
