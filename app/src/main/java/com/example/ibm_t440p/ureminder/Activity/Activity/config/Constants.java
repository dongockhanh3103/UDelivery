package com.example.ibm_t440p.ureminder.Activity.Activity.config;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ngoc Khanh on 6/3/2018.
 */

public class Constants {
  public  final static String SERVER_END_POINT="https://maps.googleapis.com/maps/api/directions/json?";
  public final static String ACCESS_TOKEN="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI1YWM5ZWFiMDk1ZDg5ODIwMzgxMTBiNjgiLCJVc2VybmFtZSI6ImFkbWluMSIsIkZ1bGxuYW1lIjoiQ2FyYm9uIiwiUm9sZSI6ImFkbWluIiwiaWF0IjoxNTIzMTgyODgwfQ.fFqejz7NxTYyoTOqc6bazs_ukMxIZCUPOXqYC6U8ykE";
  public final static String UGAO_END_POINT= "https://ugao-server.herokuapp.com/";

  public final static String BUNDLE_KEY="order_detail";
  public final static String CUSTOMER_DETAIL_KEY="customer_detail_key";
  public final static String SHIPPER_DETAIL_KEY="shipper_detail_key";
  public final static String ORDER_DETAIL_KEY="order_detail_key";
  public final static String ORDER_STATUS_KEY="order_status_key";
  public final static String DATETIME_PATTERN="dd/MM/yyyy";

  public static String getOrderStatus(Integer currentStatus){
    Map<Integer,String> status = new HashMap<>();
    status.put(-2,"ĐÃ HỦY");
    status.put(-1,"ĐANG CHỜ HỦY");
    status.put(0,"MỚI");
    status.put(1,"ĐANG GIAO");
    status.put(2,"ĐÃ GIAO");
    status.put(3,"TẠM HOÃN");
    return status.get(currentStatus);
  }



}
