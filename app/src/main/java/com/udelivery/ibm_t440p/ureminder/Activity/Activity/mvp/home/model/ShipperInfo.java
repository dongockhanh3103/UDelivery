package com.udelivery.ibm_t440p.ureminder.Activity.Activity.mvp.home.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Ngoc Khanh on 6/19/2018.
 */

public class ShipperInfo {
  @SerializedName("_id")
  @Expose
  private String id;
  @SerializedName("Username")
  @Expose
  private String username;
  @SerializedName("PhoneNum")
  @Expose
  private String phoneNum;
  @SerializedName("Fullname")
  @Expose
  private String fullname;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPhoneNum() {
    return phoneNum;
  }

  public void setPhoneNum(String phoneNum) {
    this.phoneNum = phoneNum;
  }

  public String getFullname() {
    return fullname;
  }

  public void setFullname(String fullname) {
    this.fullname = fullname;
  }

}
