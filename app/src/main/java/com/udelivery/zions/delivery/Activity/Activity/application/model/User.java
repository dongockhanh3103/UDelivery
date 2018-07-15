package com.udelivery.zions.delivery.Activity.Activity.application.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Ngoc Khanh on 7/14/2018.
 */

public class User {
  @SerializedName("status")
  @Expose
  private Integer status;
  @SerializedName("msg")
  @Expose
  private String msg;
  @SerializedName("token")
  @Expose
  private Token token;
  @SerializedName("customerInfo")
  @Expose
  private Customer customer;

  public Customer getCustomer() {
    return customer;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }

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
