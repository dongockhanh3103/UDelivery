package com.udelivery.zions.delivery.Activity.Activity.mvp.module;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.widget.Toast;

/**
 * Created by Ngoc Khanh on 6/3/2018.
 */

public class GPSTracker implements android.location.LocationListener {

  Context context;

  public GPSTracker(Context context) {
    this.context = context;
  }

  public Location getLocation() {

    if (ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) !=
        PackageManager.PERMISSION_GRANTED) {
      Toast.makeText(context, "Permission not granted", Toast.LENGTH_SHORT).show();
      return null;
    }

    LocationManager lm = (LocationManager) context.getSystemService(context.LOCATION_SERVICE);
    boolean isGPSEnabled = lm.isProviderEnabled(LocationManager.GPS_PROVIDER);
    if (isGPSEnabled) {
      lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 0, this);
      Location l = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
      return l;
    } else {
      Toast.makeText(context, "Please enable GPS", Toast.LENGTH_SHORT).show();

    }

    return null;
  }

  @Override
  public void onLocationChanged(Location location) {

  }

  @Override
  public void onStatusChanged(String provider, int status, Bundle extras) {

  }

  @Override
  public void onProviderEnabled(String provider) {

  }

  @Override
  public void onProviderDisabled(String provider) {

  }
}