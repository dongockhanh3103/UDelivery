package com.udelivery.zions.delivery.Activity.Activity.mvp.ui;

import android.Manifest.permission;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;

import android.widget.EditText;
import android.widget.Toast;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.udelivery.zions.delivery.Activity.Activity.base.BaseActivity;
import com.udelivery.zions.delivery.Activity.Activity.mvp.model.Route;
import com.udelivery.zions.delivery.Activity.Activity.mvp.module.DirectorFinder;
import com.udelivery.zions.delivery.Activity.Activity.mvp.module.DirectorFinder.FinderListener;
import com.udelivery.zions.delivery.Activity.Activity.mvp.module.GPSTracker;
import com.udelivery.zions.delivery.R;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MapFragment extends Fragment implements OnMapReadyCallback,FinderListener {


  public MapFragment() {
    // Required empty public constructor
  }


  GoogleMap mGoogleMap;
  View mView;
  EditText edtDestination;
  private List<Marker> originMarkers = new ArrayList<>();
  private List<Marker> destinationMarkers = new ArrayList<>();
  private List<Polyline> polylinePaths = new ArrayList<>();

  // TODO: Rename and change types and number of parameters
  public static MapFragment newInstance(String customerAddress) {
    MapFragment fragment = new MapFragment();
    Bundle args = new Bundle();
    if(customerAddress!=null) {
      args.putString("CUSTOMER_ADDRESS", customerAddress);
    }
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
    edtDestination = mView.findViewById(R.id.edt_destination);
    SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager()
        .findFragmentById(R.id.google_map_fragment);
    mapFragment.getMapAsync(this);

 //   Log.d("address", "onMapReady: " + getAddress(37.4220, -122.0840));

    edtDestination.setOnKeyListener(new OnKeyListener() {
      @Override
      public boolean onKey(View v, int keyCode, KeyEvent event) {
        if(event.getAction() == KeyEvent.ACTION_DOWN
            && event.getKeyCode() ==KeyEvent.KEYCODE_ENTER){
          sendRequest();
          return false;
        }
        return false;
      }
    });
    return mView;
  }

  @Override
  public void onStart() {
    super.onStart();
    if(getArguments().getString("CUSTOMER_ADDRESS")!=null && getArguments().getString("CUSTOMER_ADDRESS")!=""){
      edtDestination.setText(getArguments().getString("CUSTOMER_ADDRESS"));
      sendRequest();
    }
  }

  @Override
  public void onMapReady(GoogleMap googleMap) {
    mGoogleMap = googleMap;
    mGoogleMap.getUiSettings().setZoomControlsEnabled(true);
    mGoogleMap.getUiSettings().setRotateGesturesEnabled(true);
    mGoogleMap.getUiSettings().setScrollGesturesEnabled(true);
    mGoogleMap.getUiSettings().setTiltGesturesEnabled(true);

    if (ActivityCompat
        .checkSelfPermission(getActivity().getApplicationContext(), permission.ACCESS_FINE_LOCATION)
        != PackageManager.PERMISSION_GRANTED
        && ActivityCompat.checkSelfPermission(getActivity().getApplicationContext(),
        permission.ACCESS_COARSE_LOCATION)
        != PackageManager.PERMISSION_GRANTED) {
      // TODO: Consider calling
      return;
    }

    GPSTracker gpsTracker = new GPSTracker(getContext().getApplicationContext());
    LatLng currentLocation = new LatLng(gpsTracker.getLocation().getLatitude(),
        gpsTracker.getLocation().getLongitude());

    mGoogleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(currentLocation, 18));

    googleMap.addMarker(new MarkerOptions()
        .position(currentLocation)
        .title(getAddress(currentLocation.latitude, currentLocation.longitude))).showInfoWindow();
    mGoogleMap.setMyLocationEnabled(true);
    mGoogleMap.animateCamera( CameraUpdateFactory.zoomTo( 17.0f ) );

 //   sendRequest();

  }

  private void sendRequest() {
    GPSTracker gpsTracker = new GPSTracker(getContext().getApplicationContext());
    LatLng currentLocation = new LatLng(gpsTracker.getLocation().getLatitude(),
        gpsTracker.getLocation().getLongitude());


   String origin = getAddress(currentLocation.latitude,currentLocation.longitude);
   // String origin = "Bien Hoa";
    String destination =edtDestination.getText().toString();
    if (origin.isEmpty()) {
      Toast.makeText(getActivity(), "Please enter origin address!", Toast.LENGTH_SHORT).show();
      return;
    }
    if (destination.isEmpty()) {
      Toast.makeText(getActivity(), "Please enter destination address!", Toast.LENGTH_SHORT).show();
      return;
    }

    try {
      new DirectorFinder(this, origin, destination).execute();
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }
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


  @Override
  public void onDirectionFinderStart() {
    ((BaseActivity)getActivity()).onShowProgressBar(true);

    if (originMarkers != null) {
      for (Marker marker : originMarkers) {
        marker.remove();
      }
    }

    if (destinationMarkers != null) {
      for (Marker marker : destinationMarkers) {
        marker.remove();
      }
    }

    if (polylinePaths != null) {
      for (Polyline polyline : polylinePaths) {
        polyline.remove();
      }
    }
  }

  @Override
  public void onDirectionFinderSuccess(List<Route> routes) {
    ((BaseActivity)getActivity()).onShowProgressBar(false);
    polylinePaths = new ArrayList<>();
    originMarkers = new ArrayList<>();
    destinationMarkers = new ArrayList<>();

    for (Route route : routes) {
      mGoogleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(route.startLocation, 16));

      originMarkers.add(mGoogleMap.addMarker(new MarkerOptions()
          .icon(BitmapDescriptorFactory.fromResource(R.drawable.originn))
          .title(route.startAddress)
          .position(route.startLocation)));
      destinationMarkers.add(mGoogleMap.addMarker(new MarkerOptions()
          .icon(BitmapDescriptorFactory.fromResource(R.drawable.des))
          .title(route.endAddress)
          .position(route.endLocation)));

      PolylineOptions polylineOptions = new PolylineOptions().
          geodesic(true).
          color(Color.RED).
          width(10);

      for (int i = 0; i < route.points.size(); i++)
        polylineOptions.add(route.points.get(i));

      polylinePaths.add(mGoogleMap.addPolyline(polylineOptions));
    }
  }
}
