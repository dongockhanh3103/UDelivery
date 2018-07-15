package com.udelivery.zions.delivery.Activity.Activity.application.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Ngoc Khanh on 7/14/2018.
 */

public class Token {

  @SerializedName("_id")
  @Expose
  private String id;
  @SerializedName("Token")
  @Expose
  private String token;
  @SerializedName("CreateTime")
  @Expose
  private Long createTime;
  @SerializedName("ExpriedTime")
  @Expose
  private Long expriedTime;
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

  public Long getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Long createTime) {
    this.createTime = createTime;
  }

  public Long getExpriedTime() {
    return expriedTime;
  }

  public void setExpriedTime(Long expriedTime) {
    this.expriedTime = expriedTime;
  }

  public Integer getV() {
    return v;
  }

  public void setV(Integer v) {
    this.v = v;
  }


}
