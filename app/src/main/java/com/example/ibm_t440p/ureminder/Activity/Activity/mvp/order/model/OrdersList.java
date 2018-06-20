package com.example.ibm_t440p.ureminder.Activity.Activity.mvp.order.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * Created by Ngoc Khanh on 6/19/2018.
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
  @SerializedName("CurrentOrderStatus")
  @Expose
  public Integer currentOrderStatus;
  @SerializedName("DetailCustomer")
  @Expose
  public List<DetailCustomer> detailCustomer = null;
  @SerializedName("DetailStore")
  @Expose
  public List<DetailStore> detailStore = null;
  @SerializedName("DetailShipper")
  @Expose
  public List<DetailShipper> detailShipper = null;
  @SerializedName("OrderDetail")
  @Expose
  public List<OrderDetail> orderDetail = null;
  @SerializedName("OrderStatus")
  @Expose
  public List<Orderstatus> orderStatus = null;
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
  public Long purchaseDate;
  @SerializedName("__v")
  @Expose
  public Integer v;

}
