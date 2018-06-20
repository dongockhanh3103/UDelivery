package com.example.ibm_t440p.ureminder.Activity.Activity.mvp.order.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Ngoc Khanh on 6/19/2018.
 */

public class DetailStore {
  @SerializedName("UsernameStore")
  @Expose
  public String usernameStore;
  @SerializedName("AddressStore")
  @Expose
  public String addressStore;
  @SerializedName("PhoneStore")
  @Expose
  public String phoneStore;
  @SerializedName("_id")
  @Expose
  public String id;

}
