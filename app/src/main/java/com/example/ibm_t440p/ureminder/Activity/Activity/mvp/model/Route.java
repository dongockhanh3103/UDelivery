package com.example.ibm_t440p.ureminder.Activity.Activity.mvp.model;

import com.google.android.gms.maps.model.LatLng;
import java.util.List;

/**
 * Created by Ngoc Khanh on 6/3/2018.
 */

public class Route {
  public Distance distance;
  public Duration duration;
  public String endAddress;
  public LatLng endLocation;
  public String startAddress;
  public LatLng startLocation;

  public List<LatLng> points;

}
