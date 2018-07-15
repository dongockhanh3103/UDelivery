package com.udelivery.zions.delivery.Activity.Activity.application.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Ngoc Khanh on 7/14/2018.
 */

public class Customer {

  @SerializedName("Username")
  @Expose
  private String username;
  @SerializedName("Password")
  @Expose
  private String password;
  @SerializedName("Fullname")
  @Expose
  private String fullname;
  @SerializedName("Birthday")
  @Expose
  private String birthday;
  @SerializedName("Gender")
  @Expose
  private Boolean gender;
  @SerializedName("Address")
  @Expose
  private String address;
  @SerializedName("PhoneNum")
  @Expose
  private String phoneNum;
  @SerializedName("FillCyrcleDay")
  @Expose
  private Integer fillCyrcleDay;
  @SerializedName("RegStore")
  @Expose
  private String regStore;

  @SerializedName("RegDefaultOrder")
  @Expose
  private String regDefaultOrder;

  public Customer() {
  }

  public Customer(String username, String password, String fullname, String birthday, Boolean gender, String address, String phoneNum) {
    this.username = username;
    this.password = password;
    this.fullname = fullname;
    this.birthday = birthday;
    this.gender = gender;
    this.address = address;
    this.phoneNum = phoneNum;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getFullname() {
    return fullname;
  }

  public void setFullname(String fullname) {
    this.fullname = fullname;
  }

  public String getBirthday() {
    return birthday;
  }

  public void setBirthday(String birthday) {
    this.birthday = birthday;
  }

  public Boolean getGender() {
    return gender;
  }

  public void setGender(Boolean gender) {
    this.gender = gender;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getPhoneNum() {
    return phoneNum;
  }

  public void setPhoneNum(String phoneNum) {
    this.phoneNum = phoneNum;
  }

  public Integer getFillCyrcleDay() {
    return fillCyrcleDay;
  }

  public void setFillCyrcleDay(Integer fillCyrcleDay) {
    this.fillCyrcleDay = fillCyrcleDay;
  }

  public String getRegStore() {
    return regStore;
  }

  public void setRegStore(String regStore) {
    this.regStore = regStore;
  }

  public String getRegDefaultOrder() {
    return regDefaultOrder;
  }

  public void setRegDefaultOrder(String regDefaultOrder) {
    this.regDefaultOrder = regDefaultOrder;
  }


}
