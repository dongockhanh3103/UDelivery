package com.example.ibm_t440p.ureminder.Activity.Activity.mvp.order.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * Created by Ngoc Khanh on 6/4/2018.
 */

public class CustomerOrder {
  @SerializedName("status")
  @Expose
  public Integer status;
  @SerializedName("msg")
  @Expose
  public String msg;
  @SerializedName("ordersList")
  @Expose
  public List<OrdersList> ordersList = null;

}
