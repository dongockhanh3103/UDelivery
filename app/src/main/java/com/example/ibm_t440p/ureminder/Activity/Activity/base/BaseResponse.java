package com.example.ibm_t440p.ureminder.Activity.Activity.base;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Ngoc Khanh on 3/24/2018.
 */

public class BaseResponse {
  @SerializedName("errors")
  @Expose
  String errs;

  public String getErrors(){
    return this.errs;
  }
}
