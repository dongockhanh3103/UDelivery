package com.example.ibm_t440p.ureminder.Activity.Activity.mvp.order.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Ngoc Khanh on 6/19/2018.
 */

public class Orderstatus {
  @SerializedName("_id")
  @Expose
  public String id;
  @SerializedName("Status")
  @Expose
  public Integer status;
  @SerializedName("Note")
  @Expose
  public String note;

}
