package com.example.ibm_t440p.ureminder.Activity.Activity.mvp.ui;

import android.Manifest.permission;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.EditText;
import android.widget.Toast;
import com.example.ibm_t440p.ureminder.Activity.Activity.mvp.home.MainActivity;
import com.example.ibm_t440p.ureminder.Activity.Activity.mvp.module.GPSTracker;
import com.example.ibm_t440p.ureminder.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class MapFragment extends Fragment implements OnMapReadyCallback {


  public MapFragment() {
    // Required empty public constructor
  }


  GoogleMap mGoogleMap;
  MapView mapView;
  View mView;
  EditText edtDestination;

  // TODO: Rename and change types and number of parameters
  public static MapFragment newInstance() {
    MapFragment fragment = new MapFragment();
    Bundle args = new Bundle();
    fragment.setArguments(args);
    return fragment;
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    mView = inflater.inflate(R.layout.fragment_map, container, false);
    mapView = (MapView) mView.findViewById(R.id.map);
    edtDestination = mapView.findViewById(R.id.edt_destination);
    if (mapView != null) {
      mapView.onCreate(null);
      mapView.onResume();
      mapView.getMapAsync(this);
    }

    Log.d("address", "onMapReady: " + getAddress(10.851067, 106.772356));
    return mView;
  }

  @Override
  public void onMapReady(GoogleMap googleMap) {
    mGoogleMap = googleMap;

    if (ActivityCompat
        .checkSelfPermission(getActivity().getApplicationContext(), permission.ACCESS_FINE_LOCATION)
        != PackageManager.PERMISSION_GRANTED
        && ActivityCompat.checkSelfPermission(getActivity().getApplicationContext(),
        permission.ACCESS_COARSE_LOCATION)
        != PackageManager.PERMISSION_GRANTED) {
      // TODO: Consider calling
      return;
    }

    // mGoogleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(ute, 18));
    mGoogleMap.setMyLocationEnabled(true);


  }


  private String getAddress(double latitude, double longitude) {
    StringBuilder result = new StringBuilder();
    try {
      Geocoder geocoder = new Geocoder(getActivity().getApplicationContext(), Locale.getDefault());
      List<Address> addresses = geocoder.getFromLocation(latitude, longitude, 1);
      if (addresses.size() > 0) {
        Address address = addresses.get(0);
        result.append(address.getAddressLine(0)).append("\n");

      }
    } catch (IOException e) {
      Log.e("tag", e.getMessage());
    }

    return result.toString();
  }


}
