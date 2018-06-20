package com.example.ibm_t440p.ureminder.Activity.Activity.mvp.home.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Ngoc Khanh on 6/19/2018.
 */

public class ShipperResponse {

  @SerializedName("status")
  @Expose
  private Integer status;
  @SerializedName("msg")
  @Expose
  private String msg;
  @SerializedName("shipperInfo")
  @Expose
  private ShipperInfo shipperInfo;

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public String getMsg() {
    return msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }

  public ShipperInfo getShipperInfo() {
    return shipperInfo;
  }

  public void setShipperInfo(ShipperInfo shipperInfo) {
    this.shipperInfo = shipperInfo;
  }

}
