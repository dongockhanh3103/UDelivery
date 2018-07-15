package com.udelivery.zions.delivery.Activity.Activity.mvp.login.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Ngoc Khanh on 6/18/2018.
 */

public class LoginResponse {

  @SerializedName("status")
  @Expose
  private Integer status;
  @SerializedName("msg")
  @Expose
  private String msg;
  @SerializedName("token")
  @Expose
  private Token token;

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

  public Token getToken() {
    return token;
  }

  public void setToken(Token token) {
    this.token = token;
  }

}