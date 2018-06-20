package com.example.ibm_t440p.ureminder.Activity.Activity.mvp.order.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Ngoc Khanh on 6/19/2018.
 */

public class DetailShipper {
  @SerializedName("UsernameShipper")
  @Expose
  public String usernameShipper;
  @SerializedName("FullnameShipper")
  @Expose
  public String fullnameShipper;
  @SerializedName("PhoneShipper")
  @Expose
  public String phoneShipper;
  @SerializedName("_id")
  @Expose
  public String id;

}
