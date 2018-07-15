package com.udelivery.zions.delivery.Activity.Activity.utils;

import android.annotation.TargetApi;
import android.os.Build.VERSION_CODES;
import java.lang.reflect.Field;
import java.util.Comparator;

/**
 * Created by Ngoc Khanh on 6/19/2018.
 */

public class SortUtils<T> implements Comparator<T> {

  String fieldName;
  public SortUtils(String fieldName){
    this.fieldName = fieldName;
  }
  private double parseStringToDouble(String strValue){
    return Double.parseDouble(strValue);
  }

  private static boolean isNumberic(String stringChecking){
    return stringChecking.matches("-?\\d+(\\.\\d+)?");
  }

  @TargetApi(VERSION_CODES.KITKAT)
  @Override
  public int compare(T o1, T o2) {
    if (o1==null && o2==null) {
      return 0;
    }
    if(o1==null){
      return -1;
    }
    if(o2==null){
      return 1;
    }
    try {
      Field field1 = o1.getClass().getDeclaredField(this.fieldName);
      Field field2 = o2.getClass().getDeclaredField(this.fieldName);
      field1.setAccessible(true);
      field2.setAccessible(true);
      if(isNumberic(field1.get(o1).toString())){
        return Double.compare(parseStringToDouble(field1.get(o1).toString())
            ,parseStringToDouble(field2.get(o2).toString()));
      }
      else {
        return field1.get(01).toString().compareTo(field2.get(o2).toString());
      }

    }
    catch (NoSuchFieldException | IllegalAccessException e) {
      e.printStackTrace();
    }
    return 0;
  }
}
