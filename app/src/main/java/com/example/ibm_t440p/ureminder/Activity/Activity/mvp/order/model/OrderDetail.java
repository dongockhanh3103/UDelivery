package com.example.ibm_t440p.ureminder.Activity.Activity.mvp.order.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Ngoc Khanh on 6/4/2018.
 */

public class OrderDetail {
  @SerializedName("Quantiny")
  @Expose
  public Integer quantiny;
  @SerializedName("Price")
  @Expose
  public Integer price;
  @SerializedName("Cost")
  @Expose
  public Integer cost;
  @SerializedName("_id")
  @Expose
  public String id;
  @SerializedName("IDProd")
  @Expose
  public String iDProd;

}
