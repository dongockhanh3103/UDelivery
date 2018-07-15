package com.udelivery.zions.delivery.Activity.Activity.mvp.login.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Ngoc Khanh on 6/18/2018.
 */

public class Token {

  @SerializedName("_id")
  @Expose
  private String id;
  @SerializedName("Token")
  @Expose
  private String token;
  private Integer createTime;
  private Integer expriedTime;
  @SerializedName("__v")
  @Expose
  private Integer v;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  public Integer getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Integer createTime) {
    this.createTime = createTime;
  }

  public Integer getExpriedTime() {
    return expriedTime;
  }

  public void setExpriedTime(Integer expriedTime) {
    this.expriedTime = expriedTime;
  }

  public Integer getV() {
    return v;
  }

  public void setV(Integer v) {
    this.v = v;
  }

}