package com.example.ibm_t440p.ureminder.Activity.Activity.mvp.order.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * Created by Ngoc Khanh on 6/4/2018.
 */

public class OrdersList {
  @SerializedName("SumCost")
  @Expose
  public Integer sumCost;
  @SerializedName("Discount")
  @Expose
  public Integer discount;
  @SerializedName("TotalCost")
  @Expose
  public Integer totalCost;
  @SerializedName("OrderStatus")
  @Expose
  public Integer orderStatus;
  @SerializedName("OrderDetail")
  @Expose
  public List<OrderDetail> orderDetail = null;
  @SerializedName("_id")
  @Expose
  public String id;
  @SerializedName("IDCustomer")
  @Expose
  public String iDCustomer;
  @SerializedName("IDStore")
  @Expose
  public String iDStore;
  @SerializedName("IDShipper")
  @Expose
  public String iDShipper;
  @SerializedName("PurchaseDate")
  @Expose
  public Integer purchaseDate;
  @SerializedName("__v")
  @Expose
  public Integer v;

}
