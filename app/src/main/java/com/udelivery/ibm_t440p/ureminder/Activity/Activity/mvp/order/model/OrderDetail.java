package com.udelivery.ibm_t440p.ureminder.Activity.Activity.mvp.order.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/**
 * Created by Ngoc Khanh on 6/19/2018.
 */

public class OrderDetail implements Serializable {
  @SerializedName("ProdName")
  @Expose
  public String prodName;
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
