package com.udelivery.ibm_t440p.ureminder.Activity.Activity.base;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Ngoc Khanh on 3/24/2018.
 */

public class BaseResponse{
  @SerializedName("status")
  @Expose
  private Integer status;
  @SerializedName("msg")
  @Expose
  private String msg;



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


}
