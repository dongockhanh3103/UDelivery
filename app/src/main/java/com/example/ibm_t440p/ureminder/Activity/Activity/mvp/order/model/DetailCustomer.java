package com.example.ibm_t440p.ureminder.Activity.Activity.mvp.order.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Ngoc Khanh on 6/19/2018.
 */

public class DetailCustomer {
  @SerializedName("UsernameCustomer")
  @Expose
  public String usernameCustomer;
  @SerializedName("FullnameCustomer")
  @Expose
  public String fullnameCustomer;
  @SerializedName("AddressCustomer")
  @Expose
  public String addressCustomer;
  @SerializedName("PhoneCustomer")
  @Expose
  public String phoneCustomer;
  @SerializedName("_id")
  @Expose
  public String id;

}
