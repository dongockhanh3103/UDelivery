package com.udelivery.zions.delivery.Activity.Activity.constant;


import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Ngoc Khanh on 6/19/2018.
 */

public class SavedCache {
  private static final String PREFS_NAME = "UDelivery";
  private static SavedCache memoryCache;
  private SharedPreferences preferences;
  private static final String SHIPPER_TOKEN = "SHIPPER_TOKEN";



  private static final String IS_LOGIN = "isLogin";


  private SavedCache() {
    preferences = App.self().getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
  }
  public synchronized static SavedCache getInstance() {
    if (memoryCache == null) {
      memoryCache = new SavedCache();
    }
    return memoryCache;
  }

  public String getAccessToken(){
    return preferences.getString(SHIPPER_TOKEN, "");
  }

  public void setShipperToken(String token) {
    preferences.edit().putString(SHIPPER_TOKEN, token).apply();
  }

  public  boolean isLogin() {
    return preferences.getBoolean(IS_LOGIN,false);
  }

  public void setIsLogin(boolean isLogin){
    preferences.edit().putBoolean(IS_LOGIN,isLogin).apply();
  }



}
