package com.udelivery.ibm_t440p.ureminder.Activity.Activity.mvp.order.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/**
 * Created by Ngoc Khanh on 6/19/2018.
 */

public class DetailShipper implements Serializable{
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
